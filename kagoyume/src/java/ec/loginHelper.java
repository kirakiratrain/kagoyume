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
    public String Login(boolean login ,String Name)
    {
        String strMsg ="���O�C��";
        String ret = "";
        if(login)
        {
            ret = "<a href=\""+homeURL+"\">"+"�悤����"+Name+"����"+"</a>";
        }
        else
        {
            ret = "<a href=\""+homeURL+"\">���O�C��</a>";
        }
        
        return ret;
    }
    
}
