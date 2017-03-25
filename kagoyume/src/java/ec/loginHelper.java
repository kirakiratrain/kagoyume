/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec;

/**
 *
 * @author Choir
 */

//ログイン画面のリンクを渡します
public class loginHelper 
{
    //トップへのリンクを定数として設定
    private final String homeURL = "Login.jsp";
    
    public static loginHelper getInstance()
    {
        return new loginHelper();
    }
    
    //トップへのリンクを返却
    public String Login(boolean login ,String Name)
    {
        String strMsg ="ログイン";
        String ret = "";
        if(login)
        {
            ret = "<a href=\""+homeURL+"\">"+"ようこそ"+Name+"さん"+"</a>";
        }
        else
        {
            ret = "<a href=\""+homeURL+"\">ログイン</a>";
        }
        
        return ret;
    }
    
}
