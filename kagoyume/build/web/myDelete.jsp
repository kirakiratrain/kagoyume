<%-- 
    Document   : myDelete
    Created on : 2017/03/30, 16:07:16
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
    UserDataDTO user = (UserDataDTO)session.getAttribute("LoginUser");
    
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
        ID�F<%=user.getUserID() %><br>
        NAME�F<%=user.getName() %><br>
        PASS�F<%=user.getMail() %><br>
        ���[���A�h���X�F<%=user.getMail() %><br>
        �Z���F<%=user.getAddress() %><br>
        ���z�F<%=user.getTotal() %><br>
        ���̃��[�U�f�[�^���}�W�ō폜���܂����H<br>
 
        <a href="/kagoyume/myDeleteResult">�͂�</a><br>
        <a href="top.jsp">������</a><br>
    </body>
     <br><%=jumptop.home()%></br>
</html>
