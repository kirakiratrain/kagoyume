/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec;

import ec.UserDataDTO;
import java.io.Serializable;
import java.util.Calendar;
/**
 *
 * @author Choir
 
 �T�v�@�t�H�[��������o�͂����f�[�^���i�[����JavaBeans
 �@�@�@DTO����̕ϊ��A�܂���DTO�ւ̋t�ϊ��̃��\�b�h������
 
 */

public class userData implements Serializable
{
    String  userID;
    String  name;
    String  pass;
    String  mail;
    String  address;
    int     total;
    String  newDate;
    boolean deleteFlg;
    
    void userData()
    {
        userID = "";
        name = "";
        pass = "";
        mail = "";
        address = "";
        total = 0;
        newDate = "";
        deleteFlg = false;
    }
    
    //USERID
    public String getUserID()
    {
        return userID;
    }
    
    public void setUserID(String val)
    {
         this.userID = val;
    }
    //NAME        
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    //pass
    public String getPass()
    {
        return pass;
    }
    
    public void setPass(String val)
    {
         this.pass = val;
    }
    
    //mail
    public String getMail()
    {
        return mail;
    }
    
    public void setMail(String val)
    {
         this.mail = val;
    }
    
    //address
    public String getAdress()
    {
        return address;
    }
    
    public void setAdress(String val)
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
    
    public String getNewDate()
    {
        return newDate;
    }
    
    public void setNewDate(String val)
    {
         this.newDate = val;
    }
    
    /*
    �T�v�@UserDataDTO�ɕϊ�����B
    �@�@�@
    */
    public void convertToDTO(UserDataDTO udd)
    {
        
        //UserID
        udd.setUserID(udd.getUserID());
        //Name
        udd.setName(name);
        //pass
        udd.setPass(pass);
        //mail
        udd.setMail(mail);
        //adress
        udd.setAddress(address);
        //Total
        udd.setTotal(total);
        //newDate��Data�x�[�X�ɓo�^���O�ɒl������B
        //udd.setNewDate(newDate);
        
    }
    
    /*
    �T�v�@UserDataDTO��userData�ɕϊ�����B
    �@�@�@
    */
    public void convertUtdToUdb(UserDataDTO udd)
    {
        
        setUserID( String.valueOf(udd.getUserID()) );
        //UserID
        //ud
        //Name
        udd.setName(name);
        //pass
        udd.setPass(pass);
        //mail
        udd.setMail(mail);
        //adress
        udd.setAddress(address);
        //Total
        udd.setTotal(total);
        //newDate��Data�x�[�X�ɓo�^���O�ɒl������B
        //udd.setNewDate(newDate);
        
    }
}
