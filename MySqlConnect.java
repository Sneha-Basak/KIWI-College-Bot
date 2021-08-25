/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Sneha
 */
public class MySqlConnect {
    Connection conn=null;
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kiwi","root","shreya");
            return conn;
        }
catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    return null;
}
    
    }
 }

