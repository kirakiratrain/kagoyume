<%-- 
    Document   : registrationconfirm
    Created on : 2017/03/28, 16:16:45
    Author     : Choir
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="ec.itemDataBeans" 
        import="ec.ecHelper"
        import="ec.UserDataDTO "%>
<%
    ecHelper jumptop = ecHelper.getInstance();
    //セッションスタート
    session = request.getSession();
    String errMsg = (String)request.getAttribute("notInput");
    UserDataDTO regData = (UserDataDTO)session.getAttribute("registData");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <%if(!errMsg.equals("")){%>
        
        <%= errMsg %><br>
        
        <%}
        else{%>
        NAME：<%=regData.getName() %><br>
        PASS：<%=regData.getMail() %><br>
        メールアドレス：<%=regData.getMail() %><br>
        住所：<%=regData.getAddress() %><br>
        上記の内容で登録いたします。
        <%}%>
        <form action="registrationcompleate" method="POST">
        <br>
        <input type="submit" name="btnSubmit" value="はい">
        </form>
        <form action="registration" method="POST">
        <br>
        <input type="submit" name="btnSubmit" value="いいえ">
        </form>
    </body>
</html>
