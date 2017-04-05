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
    //ログインへのリンク
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
        <h1>ユーザー情報</h1>
        NAME：<%=userData.getName() %><br>
        PASS：<%=userData.getPass() %><br>
        メールアドレス：<%=userData.getMail() %><br>
        住所：<%=userData.getAddress() %><br>
        購入総額：<%=userData.getTotal() %><br>
        更新日：<%=userData.getNewDate() %><br>
        <form action="myHistory" method="GET">
             <a href="myHistory">購入履歴</a>
        </form>
        <form action="myupdate" method="GET">
        <input type="submit" name="myupdate" value="更新">
        </form>
        <form action="myDelete" method="GET">
        <input type="submit" name="myDelete" value="削除">
        </form>
    </body>
    <%=jumptop.home()%>
    <%=login.Login(LogStat,loginName,"top.jsp")%>
</html>
