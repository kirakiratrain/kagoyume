<%-- 
    Document   : registrationcompleate
    Created on : 2017/03/28, 16:46:31
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
    UserDataDTO regData = (UserDataDTO)session.getAttribute("registData");
    
    session.removeAttribute("registData");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        NAME：<%=regData.getName() %><br>
        PASS：<%=regData.getMail() %><br>
        メールアドレス：<%=regData.getMail() %><br>
        住所：<%=regData.getAddress() %><br>
        以上の内容で登録しました。
    </body>
    <br><%=jumptop.home()%></br>
</html>
