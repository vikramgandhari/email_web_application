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
@Named(value = "forwardemail")
@RequestScoped
public class forwardemail {

  private String whomtosend;
   
    public String  fwdemail(String email,String message,String subject) {
        
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
        ResultSet resultSet = null;   //set of results
        ResultSet r2=null;
        
        try
        {      
           connection=DriverManager.getConnection(DATABASE_URL,"","");
           statement=connection.createStatement();
           int a=0;
           resultSet=statement.executeQuery("select * from nextaccount");
           if(resultSet.next()){
               a=resultSet.getInt(1);
               
               int c=a+1;
               int b=statement.executeUpdate("update nextaccount set nextaccountnumb='"+c+"' where nextaccountnumb='"+a+"'"); 
           }
           else{
               int f=statement.executeUpdate("insert into nextaccount values('"+a+"')");
           }
         
           String t=dateandtime.DateTime();
           r2=statement.executeQuery("select Name from email_account where email='"+email+"'");
           
           if(r2.next()){
           int d=statement.executeUpdate("insert into email_all values('"+email+"','"+whomtosend+"','"+r2.getString(1)+"','FWD:''"+subject+"','"+message+"','"+t+"','new','"+a+"')");
           
           }
           return "successmesaagesent";
            
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
                resultSet.close();
                statement.close();
                connection.close();
                r2.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();    
            }
        }
    }

    public String getWhomtosend() {
        return whomtosend;
    }

    public void setWhomtosend(String whomtosend) {
        this.whomtosend = whomtosend;
    }

    
}
