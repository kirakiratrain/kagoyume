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
    //�g�b�v�ւ̃����N��萔�Ƃ��Đݒ�
    private final String homeURL = "top.jsp";
    
    public static ecHelper getInstance()
    {
        return new ecHelper();
    }
    
    //�g�b�v�ւ̃����N��ԋp
    public String home()
    {
        return "<a href=\""+homeURL+"\">�g�b�v�֖߂�</a>";
    }
    
    
}
