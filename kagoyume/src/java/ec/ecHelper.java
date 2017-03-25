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
public class ecHelper 
{
    //トップへのリンクを定数として設定
    private final String homeURL = "top.jsp";
    
    public static ecHelper getInstance()
    {
        return new ecHelper();
    }
    
    //トップへのリンクを返却
    public String home()
    {
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    
    
}
