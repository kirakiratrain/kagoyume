<%-- 
    Document   : login
    Created on : 2017/03/25, 21:16:55
    Author     : Choir
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="ec.itemDataBeans" 
        import="ec.ecHelper"%>
<%
    ecHelper jumptop = ecHelper.getInstance();
    //�Z�b�V�����X�^�[�g
    session = request.getSession();
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="chkLogin" method="POST">
        ID  :<br>
        <input type="text" name="ID">
        <br>
        PASS:<br>
        <input type="text" name="PASS">
        <br>
        <input type="submit" name="btnSubmit" value="�T�C���C��">
        </form>
        <form>
        <a href="/kagoyume/registration">�V�K����o�^</a><br>
        </form>
        
    </body>
        <br><%=jumptop.home() %></br>
</html>
