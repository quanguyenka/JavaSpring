

package itsol.nguyen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class run {

    static Connection cn;
    static Statement stm;
    static ResultSet rs;

    public static void main(String[] args) {
        try {
            cn = connectionDB.getConnection();
            
            String sql = "select * from Logn";
            
            stm=cn.createStatement();
            rs=stm.executeQuery(sql);
            
            while (rs.next()) {

                System.out.println("id: "+rs.getString(1)+"user: "+rs.getString(2)+"pass: "+rs.getString(3));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
