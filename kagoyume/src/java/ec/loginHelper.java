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

//���O�C����ʂ̃����N��n���܂�
public class loginHelper 
{
    //�g�b�v�ւ̃����N��萔�Ƃ��Đݒ�
    private final String homeURL = "Login.jsp";
    
    public static loginHelper getInstance()
    {
        return new loginHelper();
    }
    
    //�g�b�v�ւ̃����N��ԋp
    public String Login(boolean login ,String Name,String page)
    {
        String strMsg ="���O�C��";
        String ret = "";

        if(login)
        {
            //ret = "<a href=\""+homeURL+"\">"+"�悤����"+Name+"����"+"</a>";
            ret = "<form action=\"login\" method=\"POST\">"
                  //+"<a href=\""+homeURL+"\">"+"�悤����"+Name+"����"+"</a>"
                  +"<input type=\"submit\" name=\"btnSubmit\" value=\""+"���O�A�E�g\"><br>"
                  +"</form><br>"
                  +"<form action=\"mydata\" method=\"POST\">"
                  +"<input type=\"submit\" name=\"btnSubmit\" value=\""+"�悤����"+Name+"����"+"\"><br>"
                  +"<input type=\"hidden\" name=\"pageName\"  value=\""+page+"\">"
                  +"</form><br>"
                  +"<form action=\"cart\" method=\"GET\"><input type=\"submit\" name=\"cart\" value=\"�J�[�g\"></form>";
        }
        else
        {
            //ret = "<a href=\""+homeURL+"\">���O�C��</a>";
            ret = "<form action=\"login\" method=\"POST\">"
                  //+"<a href=\""+homeURL+"\">���O�C��</a>"
                  +"<input type=\"submit\" name=\"btnSubmit\" value=\""+"���O�C��\">"
                  +"<input type=\"hidden\" name=\"pageName\"  value=\""+page+"\">"
                  +"</form>";
        }
        
        return ret;
    }
    
}
