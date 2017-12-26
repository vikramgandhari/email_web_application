/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author vikra
 */
@Named(value = "register")
@RequestScoped
public class Register {
 private String name;
   private String email_id;
   private String password;
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   public String registration(){
   
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (ClassNotFoundException e)
        {
            return ("Internal Error! Please try again later.");
        }
         
         
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
      
        
        try
        {
            final String DATABASE_URL = "jdbc:mysql://";
            
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "", "");   
            statement = connection.createStatement();
            //to search an onlineaccount based on id or ssn
            resultSet = statement.executeQuery("Select * from email_account "
                    + "where email = '" + 
                    email_id + "'" );
            String a="";
            if(resultSet.next())
            {
               return "confirm2";
            }
            else
            {
                int r = statement.executeUpdate("insert into email_account "
                        + "values ('" + name + "', '"+email_id+ "', '" + password + "')" );
                return "confirm1";
                
            }  
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return ("Internal Error! Please try again later.");
             
        }
        finally
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
                
            }
            catch (Exception e)
            {
                 
                e.printStackTrace();
            }
        }
        }
   
    
    
}
