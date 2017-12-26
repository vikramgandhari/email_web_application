/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;

/**
 *
 * @author vikra
 */
@Named(value = "login")
@SessionScoped
public class login implements Serializable{
   private int emailIDtoView;
   private int emailIDtoview1;
   private int emailIDtoview2;
   private String email_id;
   private String password;

  private ArrayList<login_account> a2;
  private ArrayList<login_account> a5;  
   private ArrayList<login_account> a9;  
   public String login(){
       a2=new ArrayList<login_account>();
       a5=new ArrayList<login_account>();
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
        
        
        try
        {      
            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "", "");   
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery("Select * from email_account "
                    + "where email= '" + 
                    email_id+ "'" );
            
            if(resultSet.next())
            {
                //id is found
                if(password.equals(resultSet.getString(3)))
                { 
                    
                    welcome a=new welcome(email_id);
                    a2=a.getA1();
                    a5=a.getA4();
                    a9=a.getA9();
                    return "successlogin";
                     
                }
                else
                {
                    email_id = "";
                    password = "";
                    //display loginNotOK.xhtml
                    return "loginnotOk";    
                }
            }
            else
            {
                email_id = "";
                password = "";
                //id is not found, display loginNotOK.xhtml
                return "loginnotOk";
                 
            }
            
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
                 
            }
            catch (Exception e)
            {
                e.printStackTrace();    
            }
        }
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
    public ArrayList<login_account> getA2() {
        return a2;
    }

    public void setA2(ArrayList<login_account> a2) {
        this.a2 = a2;
    }

    public ArrayList<login_account> getA9() {
        return a9;
    }

    public void setA9(ArrayList<login_account> a9) {
        this.a9 = a9;
    }
    
    public String getEmailByID(int i)
    {
         emailIDtoView = i;
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
        ResultSet r4 = null;   //set of results
        ResultSet r5=null;
        ResultSet r6=null;
        ResultSet r7=null;
        
        try
        {     connection = DriverManager.getConnection(DATABASE_URL, 
                    "", "");   
            statement = connection.createStatement();
            String abc="";
            String ab="";
            int a=statement.executeUpdate("update email_all set neworold='' where nextaccountnumb='"+i+"'");
            r5=statement.executeQuery("select * from email_all where nextaccountnumb='"+i+"' ");
            if(r5.next()){
              abc=r5.getString(2);
            }
           r6=statement.executeQuery("select * from email_account where email='"+abc+"' ");
         if(r6.next()){
               ab=r6.getString(1);
           }
            int hojj=0;
            int joos=0;
            r7=statement.executeQuery("select * from nextaccount");
            if(r7.next()){
                hojj=r7.getInt(1);
                joos=hojj+1;
            }
           r4=statement.executeQuery("select * from email_all where remember='true' and nextaccountnumb='"+i+"' ");
           if(r4.next()){
                int d=statement.executeUpdate("insert into email_all values('"+r4.getString(2)+"','"+r4.getString(1)+"','"+ab+"','Notification that person read:''"+r4.getString(4)+"','"+r4.getString(5)+"','"+r4.getString(6)+"','new','"+hojj+"','notify')");
                int k=statement.executeUpdate("update nextaccount set nextaccountnumb='"+joos+"' where nextaccountnumb='"+hojj+"'"); 
           }
            return "viewEmail";  
            
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
                r4.close();
                r5.close();
                r6.close();
                r7.close();
                statement.close();
                connection.close();
                 
            }
            catch (Exception e)
            {
                e.printStackTrace();    
            }
        }
        
               
    
    }
     public String getEmailByID1(int i)
    { emailIDtoview1 = i;
       
         
         return "viewemail1";         
    
    }
    
    public login_account readSelectedEmail()
    {
        for(login_account e: a2)
        {
            if(e.getAccountnum()==emailIDtoView)
            {
                return e;
            }
        }
        
        return null;
    }
       public String getEmailByID2(int i)
    { emailIDtoview2 = i;
       
         
         return "viewemail2";         
    
    }
    
    public login_account readSelectedEmail2()
    {
        for(login_account e: a9)
        {
            if(e.getAccountnum()==emailIDtoview2)
            {
                return e;
            }
        }
                 
        return null;
    }
      public login_account readSelectedEmail1()
    {
        for(login_account e: a5)
        {
            if(e.getAccountnum()==emailIDtoview1)
            {
               
                return e;
            }
        }
        
        return null;
    }

    public ArrayList<login_account> getA5() {
        return a5;
    }

    public void setA5(ArrayList<login_account> a5) {
        this.a5 = a5;
    }
      
}
