package model;

public class SearchRecipeResult {
    private int recipeCode;
    private String recipetitle;
    private String personFirstName;
    private String personLastName;
    private String countryName;

    public SearchRecipeResult(int recipeCode, String recipetitle, String personFirstName, String personLastName, String countryName) {
        setRecipeCode(recipeCode);
        setRecipetitle(recipetitle);
        setPersonFirstName(personFirstName);
        setPersonLastName(personLastName);
        setCountryName(countryName);
    }

    public int getRecipeCode() {
        return recipeCode;
    }

    public String getRecipetitle() {
        return recipetitle;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setRecipeCode(int recipeCode) {
        this.recipeCode = recipeCode;
    }

    public void setRecipetitle(String recipetitle) {
        this.recipetitle = recipetitle;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
