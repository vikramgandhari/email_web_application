/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vikra
 */
public class login_account {
    private String email_account;
    private String  to;
    private String from;
    private String subject;
    private String message;
    private String datentime;
    private String neworold;
    private int accountnum;

    public login_account(String email_account, String to, String from, String subject, String message, String datentime, String neworold, int accountnum) {
        this.email_account = email_account;
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.message = message;
        this.datentime = datentime;
        this.neworold = neworold;
        this.accountnum = accountnum;
    }

    public String getEmail_account() {
        return email_account;
    }

    public void setEmail_account(String email_account) {
        this.email_account = email_account;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDatentime() {
        return datentime;
    }

    public void setDatentime(String datentime) {
        this.datentime = datentime;
    }

    public String getNeworold() {
        return neworold;
    }

    public void setNeworold(String neworold) {
        this.neworold = neworold;
    }

    public int getAccountnum() {
        return accountnum;
    }

    public void setAccountnum(int accountnum) {
        this.accountnum = accountnum;
    }
    
    
}
