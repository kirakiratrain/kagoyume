/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Choir
 */
public class login extends HttpServlet 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * ���O�C�����Ă��Ȃ��ꍇ
    �E�e�y�[�W
      ��login.jsp�i�p�X���[�h���̓y�[�W���V�K����o�^�����N�j
      chkLogin.java�[�����F���O�C���Ǘ��ł���Z�b�V�����ɏ������݁E���O�ŉ{�����Ă����y�[�W�ֈړ�
                                    �[���s�FErr.jsp�ɑJ�ځ[���O�C���Ɏ��s���܂����ƕ\��
     ���O�C�����Ă���ꍇ
     �E�e�y�[�W
       ��loginChk.java-�N�b�L�[�E�Z�b�V�����̔j��

    �E���O�C���Ǘ��y�[�W
    �E�ǂ̃y�[�W������J�ڂł���
    �E���O�C�����Ă��Ȃ���ԂőJ�ڂ��Ă����ꍇ�́A���[�U���ƃp�X���[�h����͂���
      �t�H�[�����\�������B�܂��A�u�V�K����o�^�v�Ƃ��������N���\�������
    �E���O�C���ɐ�������ƁA���̏������O�C���Ǘ��ł���Z�b�V�����ɏ������݁A
      ���̂܂ܒ��O�ŉ{�����Ă����y�[�W�ɑJ�ڂ���B
    �E���O�C�����Ă����ԂŁi�e�y�[�W�́h���O�A�E�g�h�Ƃ��������N����j�J�ڂ��Ă����ꍇ��
      ���O�A�E�g�������s���i�Z�b�V�����̔j���A�N�b�L�[�ɕۑ����ꂽ�Z�b�V����ID��j���j
      ���̌�top��
    �E���[�U�[�f�[�^�̍폜�t���O��1�̏ꍇ�͍폜���ꂽ���[�U�[�Ƃ��ď������邱��
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        UserDataDTO logUser = (UserDataDTO)session.getAttribute("LoginUser");
        
        
        if(logUser == null)
        {
            //���O�C���y�[�W��\��������
            //session.setAttribute("ac","login");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else
        {
           // ���O�A�E�g����-session�̂͂�
           session.removeAttribute("LoginUser");
           request.getRequestDispatcher("/top.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
