<%-- 
    Document   : mydata
    Created on : 2017/03/29, 15:36:58
    Author     : Choir
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList;" 
        import="ec.ecHelper"
        import="ec.loginHelper"
        import="ec.UserDataDTO"%>
<%
    session = request.getSession();
    ecHelper jumptop = ecHelper.getInstance();
        
    UserDataDTO userData = (UserDataDTO)session.getAttribute("registUser");
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
        <h1>���[�U�[���</h1>
        NAME�F<%=userData.getName() %><br>
        PASS�F<%=userData.getPass() %><br>
        ���[���A�h���X�F<%=userData.getMail() %><br>
        �Z���F<%=userData.getAddress() %><br>
        �w�����z�F<%=userData.getTotal() %><br>
        �X�V���F<%=userData.getNewDate() %><br>
        <form action="myHistory" method="GET">
             <a href="myHistory">�w������</a>
        </form>
        <form action="myupdate" method="GET">
        <input type="submit" name="myupdate" value="�X�V">
        </form>
        <form action="myDelete" method="GET">
        <input type="submit" name="myDelete" value="�폜">
        </form>
    </body>
    <%=jumptop.home()%>
    <%=login.Login(LogStat,loginName,"top.jsp")%>
</html>
