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
    public String Login(boolean login ,String Name,String page)
    {
        String strMsg ="ログイン";
        String ret = "";

        if(login)
        {
            //ret = "<a href=\""+homeURL+"\">"+"ようこそ"+Name+"さん"+"</a>";
            ret = "<form action=\"login\" method=\"POST\">"
                  //+"<a href=\""+homeURL+"\">"+"ようこそ"+Name+"さん"+"</a>"
                  +"<input type=\"submit\" name=\"btnSubmit\" value=\""+"ログアウト\"><br>"
                  +"</form><br>"
                  +"<form action=\"mydata\" method=\"POST\">"
                  +"<input type=\"submit\" name=\"btnSubmit\" value=\""+"ようこそ"+Name+"さん"+"\"><br>"
                  +"<input type=\"hidden\" name=\"pageName\"  value=\""+page+"\">"
                  +"</form><br>"
                  +"<form action=\"cart\" method=\"GET\"><input type=\"submit\" name=\"cart\" value=\"カート\"></form>";
        }
        else
        {
            //ret = "<a href=\""+homeURL+"\">ログイン</a>";
            ret = "<form action=\"login\" method=\"POST\">"
                  //+"<a href=\""+homeURL+"\">ログイン</a>"
                  +"<input type=\"submit\" name=\"btnSubmit\" value=\""+"ログイン\">"
                  +"<input type=\"hidden\" name=\"pageName\"  value=\""+page+"\">"
                  +"</form>";
        }
        
        return ret;
    }
    
}
