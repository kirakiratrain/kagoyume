<%-- 
    Document   : cart
    Created on : 2017/03/24, 22:32:33
    Author     : Choir
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="ec.itemDataBeans" 
        import="ec.ecHelper"%>
<%
    ecHelper jumptop = ecHelper.getInstance();
    //セッションスタート
    session = request.getSession();
    int sum = (int)request.getAttribute("sum");
    
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("cartData");
    //商品画像・商品名と金額を表示する・
    //削除ボタンを実装
    //画面下部に合計金額の表示
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="menu">
        <h1>カートの中身</h1>
        <%if(iDB.getItemCnt() > 0)
        {%>
            <%for(int i=0; i < iDB.getItemCnt();i++)
            {%>
            <li>
                <a href="item?ItemIndex=<%=i %>">
                <img src=<%= iDB.getImageURL(i) %> alt="">
                <p class="title"><%= "品名："+iDB.getName(i) %></p>
                <p class="desc"><%= "価格：" +iDB.getPrice(i) %></p>
                </a>
            </li>
            <form action=delete method="GET">
            <input type="submit" name="btnDelete" value="削除">
            <input type="hidden" name="deleteIndex"  value="<%=i%>">
            </form>
            <%}%>
        <%}
        else
        {%>
            カートの中身がありません<br>
        <%}%>
    </body>
    合計金額：<%= sum%>
</html>
