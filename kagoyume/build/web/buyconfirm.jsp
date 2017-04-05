<%-- 
    Document   : buyconfirm
    Created on : 2017/03/27, 14:05:50
    Author     : Choir
 * //buyconfirm
 * 購入確認ページ
 * カートに追加順で商品の名前（リンクなし）金額が表示される
 * 合計金額が表示され、その下に配送方法を選択するラジオボタンがある
 * 「上記の内容で購入する」ボタンと「カートに戻る」ボタンがある
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="ec.itemDataBeans" 
        import="ec.ecHelper"
        import="ec.loginHelper"
        import="ec.UserDataDTO"%>
<%
    ecHelper jumptop = ecHelper.getInstance();
    //セッションスタート
    session = request.getSession();
    
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("cartData");
    //ログインへのリンク
    loginHelper login = new loginHelper();
     
    boolean LogStat = false;
    String loginName = ""; 
    UserDataDTO user = (UserDataDTO)session.getAttribute("LoginUser");
    
    if(user == null)
    {
        LogStat = false;
    }
    else
    {
        LogStat = true;
        loginName = user.getName();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <%if(iDB.getItemCnt() > 0)
        {%>
            <%for(int i=0; i < iDB.getItemCnt();i++)
            {%>

            <p class="title"><%= "品名："+iDB.getName(i) %></p>
            <p class="desc"><%= "価格：" +iDB.getPrice(i) %></p>
   
            <%}%>
        <%}
        else
        {%>
            カートの中身がありません<br>
        <%}%>
    </body>
    合計金額：<%= iDB.getTotalPrice()%>
    
    <h2>配送方法</h2>
    <form name="Send">
    <input type="radio" value="" name="SendType" checked = \"checked\"">まとめて配送<br>
    <input type="radio" value="" name="SendType">個別に配送<br>
    </form>
    <br>
    
    <form action=buycomplete method="GET">
    <input type="submit" name="btnBuy" value="上記の内容で購入する">
    </form>
    <form action=cart method="GET">
    <input type="submit" name="btnCart" value="カートへ戻る"> 
    </form>
</html>
