package lk.ijse.gdse.finalproject.db;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DBConnection {
    private static DBConnection dbConnection;//Property Injection
    private Connection connection;//Property Injection

    private DBConnection()throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivingschool", "root", "Ijse@123");

    }//constructor injection
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dbConnection==null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}

