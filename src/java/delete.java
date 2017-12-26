/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author vikra
 */
@Named(value = "delete")
@RequestScoped
public class delete {

    public String  delemail(int d) {
        
       try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //return to internalError.xhtml
            return ("internalError");
        }
        
        final String DATABASE_URL = "jdbc:mysql://";
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
      //  ResultSet resultSet = null;   //set of results
       // ResultSet r2=null;
        
        try
        {      
           connection=DriverManager.getConnection(DATABASE_URL,"","");
           statement=connection.createStatement();
          
         int a=statement.executeUpdate("update email_all set neworold='deleted' where nextaccountnumb='"+d+"'");
         return "delete";
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return ("internalError");
        }
        finally
        {
            try
            {
              //  resultSet.close();
                statement.close();
                connection.close();
                //r2.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();    
            }
        }
    } 
}
