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
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Choir
 */
public class search extends HttpServlet 
{

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
        
        String word = request.getParameter("searchtext");
        
        //�Z�b�V�����X�^�[�g
        HttpSession session = request.getSession();
        
        
        try
        {
            //�s���A�N�Z�X�@�ĕ\���h�~
            if(!session.getAttribute("ac").equals("top"))
            {
                throw new Exception("�s���ȃA�N�Z�X�ł�");
            }
            
            //��ʃX�e�[�^�X�̐ݒ�
            if(word.equals(null) || word.equals(""))
            {
                //��ʃX�e�[�^�X�̐ݒ�-Err
                session.setAttribute("ac", "Err");
                session.setAttribute("ErrStat", "�������[�h����͂��Ă�������");
                request.getRequestDispatcher("/err.jsp").forward(request, response);
            }
            else
            {
                //��ʃX�e�[�^�X�̐ݒ�
                session.setAttribute("ac", "Search");

                ControlYahoo conYahoo = new ControlYahoo(); 
                itemDataBeans listIDB = conYahoo.search(word);

                //�������ʂ����炤�EsetAttribute����]
                request.setAttribute("SearchWord",word);


                session.removeAttribute("searchData");

                //�����f�[�^���Z�b�V�����ɕۑ��@���̌������ɔp�������B�܂���top��ʂɖ߂�����
                session.setAttribute("searchData",listIDB);

                request.getRequestDispatcher("/search.jsp").forward(request, response);
            }
        }
        catch(Exception e)
        {
            //��ʃX�e�[�^�X�̐ݒ�-Err
            session.setAttribute("ac", "Err");
            //session.setAttribute("ErrStat", "�s���A�N�Z�X�ł�");
            
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
            throws ServletException, IOException 
    {    
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
