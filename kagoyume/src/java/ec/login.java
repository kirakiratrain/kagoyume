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
     * ログインしていない場合
    ・各ページ
      →login.jsp（パスワード入力ページ＆新規会員登録リンク）
      chkLogin.javaー成功：ログイン管理できるセッションに書き込み・直前で閲覧していたページへ移動
                                    ー失敗：Err.jspに遷移ーログインに失敗しましたと表示
     ログインしている場合
     ・各ページ
       →loginChk.java-クッキー・セッションの破棄

    ・ログイン管理ページ
    ・どのページからも遷移できる
    ・ログインしていない状態で遷移してきた場合は、ユーザ名とパスワードを入力する
      フォームが表示される。また、「新規会員登録」というリンクも表示される
    ・ログインに成功すると、その情報をログイン管理できるセッションに書き込み、
      そのまま直前で閲覧していたページに遷移する。
    ・ログインしている状態で（各ページの”ログアウト”というリンクから）遷移してきた場合は
      ログアウト処理を行う（セッションの破棄、クッキーに保存されたセッションIDを破棄）
      その後topへ
    ・ユーザーデータの削除フラグが1の場合は削除されたユーザーとして処理すること
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        UserDataDTO logUser = (UserDataDTO)session.getAttribute("LoginUser");
        
        
        if(logUser == null)
        {
            //ログインページを表示させる
            //session.setAttribute("ac","login");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else
        {
           // ログアウト処理-sessionのはき
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
