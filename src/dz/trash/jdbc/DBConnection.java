package dz.trash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection connection = null;

    public static Connection getDBConnection(){
        if(connection == null){
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:XE","TrashAdmin","trashadmin"
                );
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}
