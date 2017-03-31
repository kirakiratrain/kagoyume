<%-- 
    Document   : cart
    Created on : 2017/03/24, 22:32:33
    Author     : Choir
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="ec.itemDataBeans" 
        import="ec.ecHelper"
        import="ec.UserDataDTO"
        import="ec.loginHelper"%>
<%
    ecHelper jumptop = ecHelper.getInstance();
    //セッションスタート
    session = request.getSession();
    
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("cartData");
    //商品画像・商品名と金額を表示する・
    //削除ボタンを実装
    //画面下部に合計金額の表示
 
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
        <div class="menu">
        <h1>カートの中身</h1>
        <%if(iDB != null)
        {%>
            <%for(int i=0; i < iDB.getItemCnt();i++)
            {%>
            
            <a href="item?ItemIndex=<%=i %>">
            <img src=<%= iDB.getImageURL(i) %> alt="">
            <p class="title"><%= "品名："+iDB.getName(i) %></p>
            <p class="desc"><%= "価格：" +iDB.getPrice(i) %></p>
            </a>
            <form action=deleteItem method="GET">
            <input type="submit" name="btnDelete" value="削除">
            <input type="hidden" name="deleteIndex"  value="<%=i%>">
            </form>
            <%}%>
            <form action=buyconfirm method="GET">
            <input type="submit" name="btnBuy" value="購入"> 
            </form>
            合計金額：<%= iDB.getTotalPrice() %><br>
        <%}
        else
        {%>
            カートの中身がありません<br>
        <%}%>
    </body>
    <%=jumptop.home()%>
    <%=login.Login(LogStat,loginName,"top.jsp")%>
</html>
