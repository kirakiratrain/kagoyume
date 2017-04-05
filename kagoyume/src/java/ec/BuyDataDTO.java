/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec;

import java.sql.Timestamp;

/**
 *
 * @author Choir
 */
public class BuyDataDTO 
{

    private int buyID;          //購入ID
    private int userID;         //ユーザーID
    private String itemCode;    //商品コード
    private int type;           //発送方法
    private Timestamp buyDate;  //購入日
 
    //BuyID
    public int getBuyID() 
    {
        return buyID;
    }
    public void setBuyID(int val) 
    {
        this.buyID = val;
    }
    
    //ID
    public int getUserID() 
    {
        return userID;
    }
    public void setUserID(int val) 
    {
        this.userID = val;
    }
    
    //商品コード
    public String getItemCode()
    {
        return itemCode;
    }
    public void setItemCode(String val)
    {
        this.itemCode = val;
    }
    
    //Type
    public int getType() 
    {
        return type;
    }
    public void setType(int val) 
    {
        this.type = val;
    }
    
    //購入日
    public Timestamp getBuyDate()
    {
        return buyDate;
    }
    public void setBuyDate(Timestamp val)
    {
        this.buyDate = val;
    }
    

}
