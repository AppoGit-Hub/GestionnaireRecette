package dataAccess;

import exception.CreatePeriodException;
import exception.SearchDietException;
import interfaceAccess.SearchDataAcces;
import model.Complexity;
import model.Period;
import model.SearchDietResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchDataBaseAccess implements SearchDataAcces {
    @Override
    public ArrayList<SearchDietResult> searchDiet(int diet) throws SearchDietException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query =
                """
                SELECT
                    recipe.code,
                    recipe.title,
                    recipe.publicationDate,
                    recipe.numberPeople,
                    recipe.complexityLevel,
                    person.firstname,
                    person.lastname
                FROM
                    recipe
                        INNER JOIN
                    person ON person.id = recipe.author
                WHERE
                    recipe.code IN (SELECT
                            rcode
                        FROM
                            (SELECT
                                recipe.code AS rcode, COUNT(ingredient.name) AS du
                            FROM
                                recipe
                            INNER JOIN linerecipe ON recipe.code = linerecipe.recipeOrigin
                            INNER JOIN ingredient ON linerecipe.ingredient = ingredient.name
                            INNER JOIN foodcategory ON ingredient.type = foodcategory.id
                            INNER JOIN restriction ON restriction.foodcategory = foodcategory.id
                            INNER JOIN diet ON restriction.diet = diet.id
                            WHERE
                                diet.id = ?
                            GROUP BY recipe.code) AS leftPart
                                INNER JOIN
                            (SELECT
                                recipe.code AS code, COUNT(ingredient.name) AS d
                            FROM
                                recipe
                            INNER JOIN linerecipe ON recipe.code = linerecipe.recipeOrigin
                            INNER JOIN ingredient ON linerecipe.ingredient = ingredient.name
                            GROUP BY recipe.code) AS rightPart
                        WHERE
                            leftPart.du = rightPart.d)
                ;
                """;
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, diet);
            ResultSet data = statement.executeQuery();
            ArrayList<SearchDietResult> searchDietResults = new ArrayList<>();

            while (data.next()) {
                int recipeCode = data.getInt("code");
                String title = data.getString("title");
                LocalDate publicationDate = data.getDate("publicationDate").toLocalDate();
                int numberPeople = data.getInt("numberPeople");
                Complexity complexity = Complexity.values()[data.getInt("complexityLevel")];
                String personFirstName = data.getString("firstname");
                String personLastName = data.getString("lastname");

                SearchDietResult result = new SearchDietResult(recipeCode, title, publicationDate, numberPeople, complexity, personFirstName, personLastName);
                searchDietResults.add(result);
            }
            return searchDietResults;
        } catch (SQLException exception) {
            throw new SearchDietException();
        }
    }
}
