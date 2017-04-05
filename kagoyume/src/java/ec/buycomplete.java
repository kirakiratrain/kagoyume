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
 * //buycomplete
 * �w�������y�[�W
 * 
 * ���w�����z���X�V
 * �w���f�[�^��ۑ�
 * �u�w�����������܂����v�ƕ\��

 */
public class buycomplete extends HttpServlet 
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
        
         HttpSession session = request.getSession();
        try
        {
            //�s���A�N�Z�X�h�~
            if(!session.getAttribute("ac").equals("buyconfirm"))
            {
                throw new Exception("�s���ȃA�N�Z�X�ł�");
            }
            // * ���w�����z���X�V DB user_t

            //�P�J�[�g�̃f�[�^���Z�b�V��������擾
            itemDataBeans iDB = (itemDataBeans)session.getAttribute("cartData");

            //�o�^�Ώۂ̃��[�U�[�f�[�^���擾
            UserDataDTO  userData = (UserDataDTO)session.getAttribute("LoginUser");
        
            //���v���z�̎擾

            //* �w���f�[�^��ۑ� DB
            BuyDataDTO buyData = new BuyDataDTO();

            //buy_t�ւ�DB�ڑ��N���X
            BuyDataDAO buyDao = new BuyDataDAO().getInstance();
            //user_t�ւ�DB�ڑ��N���X
            UserDataDAO userDao = new UserDataDAO().getInstance();
        
            //****buy_t�ւ̓o�^*********
            
             //�w���f�[�^��ǉ�
            //buyData.setBuyID();  BuyID�͎����ō쐬�����
            buyData.setUserID(userData.getUserID()); 
            buyData.setType(0);
            for(int i = 0; i < iDB.getItemCnt();i++)
            {
                //buyData.setUserID(i); UserID�͎����ō쐬�����
                //buyData.setBuyID(i);  BuyID�͎����ō쐬�����  
                buyData.setItemCode(iDB.getProductID(i));
                //buyData.setType(0);   
                buyDao.insert(buyData);
            }
            
            //*****user_t�ւ̓o�^�i�����z�̍X�V�j********
            //�����z���z�̎擾
            int sum = iDB.getTotalPrice() + userData.getTotal();
            userData.setTotal(sum);
            userDao.updateDataAll(userData);
           
            //�J�[�g�f�[�^�̃Z�b�V������j������B
            session.removeAttribute("cartData");
            
        }
        catch(SQLException e)
        {
            //���O�C�����s
            String msg = "�f�[�^�x�[�X�̐ڑ��Ɏ��s���܂���<br>";
                
            session.setAttribute("ErrStat",msg);
            request.getRequestDispatcher("/err.jsp").forward(request, response);
        }
        catch(Exception e)
        {
            session.setAttribute("ErrStat",e.getMessage());
            request.getRequestDispatcher("/err.jsp").forward(request, response);           
        }
        
        request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);
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
