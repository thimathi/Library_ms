/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Thimathi
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    
    static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","root");
        
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}
