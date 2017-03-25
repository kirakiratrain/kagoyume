<%-- 
    Document   : err
    Created on : 2017/03/24, 22:00:09
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
    String msg = (String)session.getAttribute("ErrStat");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>エラー</h2>
        <br>
        <%= msg%><br>
        
    </body>
    <%=jumptop.home() %>
</html>
