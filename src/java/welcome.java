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
import java.util.ArrayList;


/**
 *
 * @author vikra
 */

public class welcome {

   private ArrayList<login_account> a1;
   private ArrayList<login_account> a4;
    private ArrayList<login_account> a9;
      private String emailIDtoView;
      private String see;
    public  welcome(String s) {
        see=s;
      try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (ClassNotFoundException e)
        {
        }
         
         
        Connection connection = null;
        Statement statement = null;
        ResultSet r2 = null;
        ResultSet r3=null;
        ResultSet r4=null;
        try
        {
            final String DATABASE_URL = "jdbc:mysql://";
            
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "", "");   
            statement = connection.createStatement();
            //to search an onlineaccount based on id or ssn
            r2 = statement.executeQuery("Select * from email_all "
                    + "where email_all.to ='" + 
                    s + "' and email_all.neworold !='deleted' order by dateandtime DESC" );
            
            if(r2.next())
            {  a1=new ArrayList<login_account>();
                 for(int i=0;i<r2.getRow();i++){
                     a1.add(new login_account(r2.getString(1),r2.getString(2),r2.getString(3),r2.getString(4),r2.getString(5),r2.getString(6),r2.getString(7),r2.getInt(8)));
                  r2.next();
                 }
                 
                
                
            }
            else{
              
            }
            r3=statement.executeQuery("Select * from email_all "
                    + "where email_all.email ='" + 
                    s + "' order by dateandtime DESC" );
             if(r3.next())
            {  a4=new ArrayList<login_account>();
                 for(int i=0;i<r3.getRow();i++){
                     a4.add(new login_account(r3.getString(1),r3.getString(2),r3.getString(3),r3.getString(4),r3.getString(5),r3.getString(6),r3.getString(7),r3.getInt(8)));
                  r3.next();
                 }
                 
                
                
            }
            else{
            
            }
              r4 = statement.executeQuery("Select * from email_all "
                    + "where email_all.to ='" + 
                    s + "' and email_all.neworold ='deleted' order by dateandtime DESC" );
               if(r4.next())
            {  a9=new ArrayList<login_account>();
                 for(int i=0;i<r4.getRow();i++){
                     a9.add(new login_account(r4.getString(1),r4.getString(2),r4.getString(3),r4.getString(4),r4.getString(5),r4.getString(6),r4.getString(7),r4.getInt(8)));
                  r4.next();
                 }
                 
                
                
            }
            else{
            
            }
        }
        catch (SQLException e)
        {
        }
        finally
        {
            try
            {
                r4.close();
                r3.close();
                r2.close();
                
                statement.close();
                connection.close();
                
            }
            catch (SQLException e)
            {
            }
        }
    }
    

    public ArrayList<login_account> getA1() {
        return a1;
    }

    public void setA1(ArrayList<login_account> a1) {
        this.a1 = a1;
    }

    public ArrayList<login_account> getA4() {
        return a4;
    }

    public void setA4(ArrayList<login_account> a4) {
        this.a4 = a4;
    }

    public ArrayList<login_account> getA9() {
        return a9;
    }

    public void setA9(ArrayList<login_account> a9) {
        this.a9 = a9;
    }
    
    

    public String getSee() {
        return see;
    }

    public void setSee(String see) {
        this.see = see;
    }
    
}
