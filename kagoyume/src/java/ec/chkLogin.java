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
        //直前のページ名を取得
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
        //データベースに接続してID PASSがあるか確認する。
        UserDataDAO userDao = new UserDataDAO().getInstance();
        
        //ユーザーデータ
        
        try
        {   
            
            UserDataDTO  userData = new UserDataDTO();
            
            int idNum = Integer.valueOf(id);
            userData.setUserID(idNum);
            
            UserDataDTO  chkData = userDao.searchByID(userData);
            
            if(chkData.getUserID() == idNum 
                    && chkData.getPass().equals(pass) 
                    && chkData.getDeleteFlg() == 0 )        //deleteFlgが1の場合は削除されている意味
            {
                //ログイン成功
                session.setAttribute("LoginUser", chkData);
                
                //直前まで表示していたページへ移動
                if(pageName.equals("login"))pageName = "top";
                
                pageName = "/" + pageName + ".jsp";
                request.getRequestDispatcher(pageName).forward(request, response);
            }
            else
            {
                //ログイン失敗
                String msg = "ログインに失敗しました<br>"
                           + "IDまたはパスワードを確認してください<br>";
                
                session.setAttribute("ErrStat",msg);
                request.getRequestDispatcher("/err.jsp").forward(request, response);
            }
            
           
        }
        catch(SQLException e)
        {
            //ログイン失敗
            String msg = "データベースの接続に失敗しました<br>";
                
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
