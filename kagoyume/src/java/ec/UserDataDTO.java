package ec;

import java.sql.Timestamp;
import java.util.Date;

/**
 * ユーザー�?報を持ちまわるJavaBeans
 * �?ータベ�?�スのカラ�?と型に対応させて�?�?(DTO)。データの挿入、取り�?�しどちらにも便利
 * @version 1.00
 * @author hayashi-s
 */
public class UserDataDTO {
    private int userID;
    private String name;
    private String pass;
    private String mail;
    private String address;
    private int total;
    private Timestamp newDate;
    private int  deleteFlg;
    //ID
    public int getUserID() 
    {
        return userID;
    }
    public void setUserID(int userID) 
    {
        this.userID = userID;
    }
    
    //Name
    public String getName()
    {
        return name;
    }
    public void setName(String val)
    {
        this.name = val;
    }
    
    //Pass
    public String getPass()
    {
        return pass;
    }
    public void setPass(String val)
    {
        this.pass = val;
    }
    
    //Mail
    public String getMail()
    {
        return mail;
    }
    public void setMail(String val)
    {
        this.mail = val;
    }
    
    //Adress
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String val)
    {
        this.address = val;
    } 
    
    //total
    public int getTotal()
    {
        return total;
    }
    public void setTotal(int val)
    {
        this.total = val;
    }
    
    //newDate
    public Timestamp getNewDate()
    {
        return newDate;
    }
    public void setNewDate(Timestamp newDate)
    {
        this.newDate = newDate;
    }
    
    //deleteFlg
    public int getDeleteFlg()
    {
        return deleteFlg;
    }
    public void setDeleteFlg(int val)
    {
        this.deleteFlg = val;
    }

}
