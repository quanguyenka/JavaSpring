

package itsol.nguyen;
import java.sql.*;

public class connectionDB {
    
    static Connection cnn=null;
    public static Connection getConnection(){
        try {
            String uRL="jdbc:sqlserver://127.0.0.1:1433;databaseName=test";
            String user = "sa";
            String pass = "aaa";
          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
            
            cnn = DriverManager.getConnection(uRL,user,pass);
            System.out.println("ket noi thanh cong");
            
        } catch (Exception e) {
            
            System.out.println("ko ket noi duoc");
            e.printStackTrace();
        }
        return cnn;
    }
    
}
