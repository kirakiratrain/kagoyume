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
    //セッションスタート
    session = request.getSession();
    //ログインへのリンク
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
        NAME：<%=user.getName() %><br>
        PASS：<%=user.getMail() %><br>
        メールアドレス：<%=user.getMail() %><br>
        住所：<%=user.getAddress() %><br>
        以上の内容で更新しました。
    </body>
     <br><%=jumptop.home()%></br>
</html>
