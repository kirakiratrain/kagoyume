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
    //�Z�b�V�����X�^�[�g
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
        NAME�F<%=regData.getName() %><br>
        PASS�F<%=regData.getMail() %><br>
        ���[���A�h���X�F<%=regData.getMail() %><br>
        �Z���F<%=regData.getAddress() %><br>
        ��L�̓��e�œo�^�������܂��B
        <%}%>
        <form action="registrationcompleate" method="POST">
        <br>
        <input type="submit" name="btnSubmit" value="�͂�">
        </form>
        <form action="registration" method="POST">
        <br>
        <input type="submit" name="btnSubmit" value="������">
        </form>
    </body>
</html>
