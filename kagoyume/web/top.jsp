<%-- 
    Document   : top
    Created on : 2017/03/17, 13:05:36
    Author     : Choir
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="ec.itemDataBeans" 
        import="ec.loginHelper"
        import="ec.UserDataDTO"%>
<%
    loginHelper login = new loginHelper();
    session = request.getSession();
    boolean LogStat = false;
    String loginName = ""; 
//    if(session.getAttribute("LoginStat").equals("")
//            || session.getAttribute("LoginStat").equals(null))
    UserDataDTO user = (UserDataDTO)session.getAttribute("LoginUser");
    
    session.setAttribute("ac","top");
    
    //if(strLoginChk.equals(null) || strLoginChk.equals(""))
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
        <title>TODO supply a title</title>
        <meta charset="Shift_JIS">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>ECサイト</div>
        商品の検索・購入が行えるECサイトです。
        <form action="search" method="GET">
        
        <input type="text" name="searchtext">
        <br>
        <input type="submit" name="btnSubmit" value="検索">
        </form>
    </body>　
     <%=login.Login(LogStat,loginName,"top.jsp")%>
</html>