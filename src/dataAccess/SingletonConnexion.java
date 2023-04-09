package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexion {
    private static Connection connection;
    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionnaireRecette", "root", "239a_qtti");
        }
        return connection;
    }
}
