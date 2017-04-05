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
 * 購入完了ページ
 * 
 * 総購入金額を更新
 * 購入データを保存
 * 「購入が完了しました」と表示

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
            //不正アクセス防止
            if(!session.getAttribute("ac").equals("buyconfirm"))
            {
                throw new Exception("不正なアクセスです");
            }
            // * 総購入金額を更新 DB user_t

            //１カートのデータをセッションから取得
            itemDataBeans iDB = (itemDataBeans)session.getAttribute("cartData");

            //登録対象のユーザーデータを取得
            UserDataDTO  userData = (UserDataDTO)session.getAttribute("LoginUser");
        
            //合計金額の取得

            //* 購入データを保存 DB
            BuyDataDTO buyData = new BuyDataDTO();

            //buy_tへのDB接続クラス
            BuyDataDAO buyDao = new BuyDataDAO().getInstance();
            //user_tへのDB接続クラス
            UserDataDAO userDao = new UserDataDAO().getInstance();
        
            //****buy_tへの登録*********
            
             //購入データを追加
            //buyData.setBuyID();  BuyIDは自動で作成される
            buyData.setUserID(userData.getUserID()); 
            buyData.setType(0);
            for(int i = 0; i < iDB.getItemCnt();i++)
            {
                //buyData.setUserID(i); UserIDは自動で作成される
                //buyData.setBuyID(i);  BuyIDは自動で作成される  
                buyData.setItemCode(iDB.getProductID(i));
                //buyData.setType(0);   
                buyDao.insert(buyData);
            }
            
            //*****user_tへの登録（総金額の更新）********
            //総金額金額の取得
            int sum = iDB.getTotalPrice() + userData.getTotal();
            userData.setTotal(sum);
            userDao.updateDataAll(userData);
           
            //カートデータのセッションを破棄する。
            session.removeAttribute("cartData");
            
        }
        catch(SQLException e)
        {
            //ログイン失敗
            String msg = "データベースの接続に失敗しました<br>";
                
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
