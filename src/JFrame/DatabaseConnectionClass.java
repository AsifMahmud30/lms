/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JFrame;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.*; //cont aints classes and interfaces for JDBC API

public class DatabaseConnectionClass {
    
    static Connection connection=null;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_ds","root","");   
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
