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
import java.util.ArrayList;
/**
 *
 * @author Choir
 */
public class mydata extends HttpServlet 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * �T�v�F�w���������[�U�[��񂪉{���ł���
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        session.setAttribute("ac", "mydata");
        //�o�^�Ώۂ̃��[�U�[�f�[�^���擾
        UserDataDTO  userData = (UserDataDTO)session.getAttribute("LoginUser");
                
        //buy_t�ւ�DB�ڑ��N���X
        UserDataDAO userDao = new UserDataDAO().getInstance();
        
        try
        {
            //�w���������擾
            UserDataDTO searchResult = userDao.searchByID(userData); 
            
            //�w�������̓o�^
            session.setAttribute("registUser",searchResult);
           
            request.getRequestDispatcher("/mydata.jsp").forward(request, response);
        }
        catch(SQLException e)
        {
            String msg = "�f�[�^�x�[�X�̐ڑ��Ɏ��s���܂���<br>";
                
            session.setAttribute("ErrStat",e.getMessage());
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