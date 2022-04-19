/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Trong Thinh
 */
public class DBContext {

    private final String severName = "localhost";
    private final String dbName = "dbb";
    private final String portNumbber = "1433";
    private final String instance = "";
    private final String userID = "sa";
    private final String password = "sa";

    public Connection getConnection() throws Exception {
        System.out.println("context.DBContext.getConnection()");
        String url = "jdbc:sqlserver://" + severName + ":" + portNumbber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + severName + ":" + portNumbber + ";databaseName=" + dbName;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

   
}
