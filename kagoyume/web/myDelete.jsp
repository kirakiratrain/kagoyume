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
    //セッションスタート
    session = request.getSession();
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
        ID：<%=user.getUserID() %><br>
        NAME：<%=user.getName() %><br>
        PASS：<%=user.getMail() %><br>
        メールアドレス：<%=user.getMail() %><br>
        住所：<%=user.getAddress() %><br>
        総額：<%=user.getTotal() %><br>
        このユーザデータをマジで削除しますか？<br>
 
        <a href="/kagoyume/myDeleteResult">はい</a><br>
        <a href="top.jsp">いいえ</a><br>
    </body>
     <br><%=jumptop.home()%></br>
</html>
