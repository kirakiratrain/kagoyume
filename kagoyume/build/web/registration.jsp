<%-- 
    Document   : registration
    Created on : 2017/03/28, 15:55:18
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
    String msg = (String)session.getAttribute("ErrStat");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="registrationconfirm" method="POST">
        ID  :<br>
        <input type="text" name="NAME">
        <br>
        PASS:<br>
        <input type="text" name="PASS">
        <br>
        ���[���A�h���X:<br>
        <input type="text" name="MAIL">
        <br>
        �Z��:<br>
        <input type="text" name="ADRESS">
        <br>
        <input type="submit" name="btnSubmit" value="�o�^">
        </form>
        
    </body>
        <br><%=jumptop.home() %></br>
</html>
