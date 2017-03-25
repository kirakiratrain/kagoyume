<%-- 
    Document   : add
    Created on : 2017/03/24, 21:21:31
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
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("cartData");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>以下の商品をカートに追加しました</h2>
        <a href="#">
            <img src=<%= iDB.getImageURL(0) %> border="0" width="240" height="240"/><br>
        </a>
            価格:<%= iDB.getPrice(0) %><br>
            製品名:<%= iDB.getName(0) %><br>
    </body>
    <%=jumptop.home()%>
</html>
