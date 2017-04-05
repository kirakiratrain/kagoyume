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
public class myupdateResult extends HttpServlet {

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
                        //不正アクセス　再表示防止
            if(!session.getAttribute("ac").equals("myupdate"))
            {
                throw new Exception("不正なアクセスです");
            }
            //表示ページを書き込む
            session.setAttribute("ac","myupdateResult");
            
            String strNAME = request.getParameter("NAME");
            String strPass =request.getParameter("PASS");
            String strMail = request.getParameter("MAIL");
            String strAdr = request.getParameter("ADRESS");
            String strMsg = "";
            //未入力
            if(strNAME.equals(""))
            {
             strMsg += "NAME" + "<br>";   
            }
            if(strPass.equals(""))
            {
                strMsg += "パスワード" +"<br>";
            }
            if(strMail.equals(""))
            {
                strMsg += "メール" +"<br>";
            }
            if(strAdr.equals(""))
            {
                strMsg += "アドレス" +"<br>";
            }
            if(!strMsg.equals(""))
            {
                strMsg += "が未入力です" +"<br>";
                
            }
            UserDataDTO updateData = new UserDataDTO();            
            UserDataDTO logUser = (UserDataDTO)session.getAttribute("LoginUser");
            updateData = UserDataDAO.getInstance().searchByID(logUser);
            
            //updateData.setUserID(logUser.getUserID());
            updateData.setName(strNAME);
            updateData.setPass(strPass);
            updateData.setMail(strMail);
            updateData.setAddress(strAdr);
            
            //updateData.setTotal(logUser.getTotal());    //
            UserDataDAO.getInstance().updateDataAll(updateData);
            
            //登録データをセッションへ
            session.setAttribute("updateData", updateData); 
            session.setAttribute("LoginUser", updateData);      //更新したデータをLoginへ登録
            
            request.getRequestDispatcher("/myupdateResult.jsp").forward(request, response);
            
            
        }
        catch(SQLException e)
        {
            String msg = "データベースの接続に失敗しました<br>";
                
            session.setAttribute("ErrStat",e.getMessage());
            request.getRequestDispatcher("/err.jsp").forward(request, response);

        }
        catch(IOException e)
        {
            session.setAttribute("ErrStat",e.getMessage());
            request.getRequestDispatcher("/err.jsp").forward(request, response);
        }
        catch(Exception e)
        {
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
