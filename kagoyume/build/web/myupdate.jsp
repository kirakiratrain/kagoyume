<%-- 
    Document   : myupdate
    Created on : 2017/03/29, 18:35:00
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
    //�Z�b�V�����X�^�[�g
    session = request.getSession();
    UserDataDTO logUser = (UserDataDTO)session.getAttribute("LoginUser");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="myupdateResult" method="POST">
        NAME:<br>
        <input type="text" name="NAME" value="<%=logUser.getName() %>">
        <br>
        PASS:<br>
        <input type="text" name="PASS" value="<%=logUser.getPass() %>">
        <br>
        ���[���A�h���X:<br>
        <input type="text" name="MAIL" value="<%=logUser.getMail()%>">
        <br>
        �Z��:<br>
        <input type="text" name="ADRESS" value="<%=logUser.getAddress() %>">
        <br>
        <input type="submit" name="btnSubmit" value="���M">
        </form>
        
    </body>
        <br><%=jumptop.home() %></br>
</html>
