/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagmentsystem;

import java.sql.*;

/**
 *
 * @author nehra
 */
public class Conn {
    
    Statement s;
    Connection c;

    public Conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3308/hotel","root","");
           s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
    
    
    
}
