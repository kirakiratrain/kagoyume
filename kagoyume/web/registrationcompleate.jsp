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
    //�Z�b�V�����X�^�[�g
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
        NAME�F<%=regData.getName() %><br>
        PASS�F<%=regData.getMail() %><br>
        ���[���A�h���X�F<%=regData.getMail() %><br>
        �Z���F<%=regData.getAddress() %><br>
        �ȏ�̓��e�œo�^���܂����B
    </body>
    <br><%=jumptop.home()%></br>
</html>
