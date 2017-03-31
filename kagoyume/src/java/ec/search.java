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
        
        //セッションスタート
        HttpSession session = request.getSession();
        
        
        try
        {
            //不正アクセス　再表示防止
            if(!session.getAttribute("ac").equals("top"))
            {
                throw new Exception("不正なアクセスです");
            }
            
            //画面ステータスの設定
            if(word.equals(null) || word.equals(""))
            {
                //画面ステータスの設定-Err
                session.setAttribute("ac", "Err");
                session.setAttribute("ErrStat", "検索ワードを入力してください");
                request.getRequestDispatcher("/err.jsp").forward(request, response);
            }
            else
            {
                //画面ステータスの設定
                session.setAttribute("ac", "Search");

                ControlYahoo conYahoo = new ControlYahoo(); 
                itemDataBeans listIDB = conYahoo.search(word);

                //検索結果をもらう・setAttributeする]
                request.setAttribute("SearchWord",word);


                session.removeAttribute("searchData");

                //検索データをセッションに保存　次の検索時に廃棄される。またはtop画面に戻った際
                session.setAttribute("searchData",listIDB);

                request.getRequestDispatcher("/search.jsp").forward(request, response);
            }
        }
        catch(Exception e)
        {
            //画面ステータスの設定-Err
            session.setAttribute("ac", "Err");
            //session.setAttribute("ErrStat", "不正アクセスです");
            
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
