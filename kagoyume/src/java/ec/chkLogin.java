/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Choir
 */
public class chkLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        
        HttpSession session = request.getSession();
        //���O�̃y�[�W�����擾
        String pageName = (String)session.getAttribute("ac");
        
        String id = request.getParameter("ID");
        String pass = request.getParameter("PASS");
        
        if(id == null)
        {
            id ="";
        }
        if(pass == null)
        {
            pass = "";
        }
        //�f�[�^�x�[�X�ɐڑ�����ID PASS�����邩�m�F����B
        UserDataDAO userDao = new UserDataDAO().getInstance();
        
        //���[�U�[�f�[�^
        
        try
        {   
            
            UserDataDTO  userData = new UserDataDTO();
            
            int idNum = Integer.valueOf(id);
            userData.setUserID(idNum);
            
            UserDataDTO  chkData = userDao.searchByID(userData);
            
            if(chkData.getUserID() == idNum 
                    && chkData.getPass().equals(pass) 
                    && chkData.getDeleteFlg() == 0 )        //deleteFlg��1�̏ꍇ�͍폜����Ă���Ӗ�
            {
                //���O�C������
                session.setAttribute("LoginUser", chkData);
                
                //���O�܂ŕ\�����Ă����y�[�W�ֈړ�
                if(pageName.equals("login"))pageName = "top";
                
                pageName = "/" + pageName + ".jsp";
                request.getRequestDispatcher(pageName).forward(request, response);
            }
            else
            {
                //���O�C�����s
                String msg = "���O�C���Ɏ��s���܂���<br>"
                           + "ID�܂��̓p�X���[�h���m�F���Ă�������<br>";
                
                session.setAttribute("ErrStat",msg);
                request.getRequestDispatcher("/err.jsp").forward(request, response);
            }
            
           
        }
        catch(SQLException e)
        {
            //���O�C�����s
            String msg = "�f�[�^�x�[�X�̐ڑ��Ɏ��s���܂���<br>";
                
            session.setAttribute("ErrStat",msg);
            request.getRequestDispatcher("/err.jsp").forward(request, response);
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
