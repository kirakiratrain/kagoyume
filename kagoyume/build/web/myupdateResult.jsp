<%-- 
    Document   : myupdateResult
    Created on : 2017/03/30, 14:57:31
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
    //���O�C���ւ̃����N
    loginHelper login = new loginHelper();
     
    boolean LogStat = false;
    String loginName = ""; 
    UserDataDTO user = (UserDataDTO)session.getAttribute("updateData");
    
    if(user == null)
    {
        LogStat = false;
    }
    else
    {
        LogStat = true;
        loginName = user.getName();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        NAME�F<%=user.getName() %><br>
        PASS�F<%=user.getMail() %><br>
        ���[���A�h���X�F<%=user.getMail() %><br>
        �Z���F<%=user.getAddress() %><br>
        �ȏ�̓��e�ōX�V���܂����B
    </body>
     <br><%=jumptop.home()%></br>
</html>
