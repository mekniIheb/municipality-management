package service;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.*;

@UtilityClass
public class ConnectionUtils {


    @SneakyThrows
    private Connection getConnection() {
        java.sql.Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "PFA", "Est12345");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("connection succeed");
        return con;
    }

    @SneakyThrows
    public PreparedStatement createPrepareStatement(String sqlQuery){
        return getConnection().prepareStatement(sqlQuery);
    }

    @SneakyThrows
    public void cloneConnection(Connection connection){
        connection.close();
    }
}
