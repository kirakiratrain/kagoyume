<%-- 
    Document   : myHistory
    Created on : 2017/03/29, 16:12:38
    Author     : Choir
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList;" 
        import="ec.ecHelper"
        import="ec.loginHelper"
        import="ec.UserDataDTO"
        import="ec.BuyDataDTO"%>
<%
    session = request.getSession();
    ecHelper jumptop = ecHelper.getInstance();
        
    ArrayList<BuyDataDTO> BuyDataList = (ArrayList<BuyDataDTO>)session.getAttribute("buyHistory");
    
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
        <h1>購入履歴</h1>
       <% for(int i = 0; i < BuyDataList.size();i++ )
       { %>
        購入日：<%=BuyDataList.get(i).getBuyDate() %><br>
        商品コード：<%=BuyDataList.get(i).getItemCode()%><br>
            <%if(BuyDataList.get(i).getType() == 0){ %>
                配送方法：<%="まとめて配送"%><br>
            <%}else{%>
                配送方法：<%="個別に配送"%><br>
            <%}%>
       <%}%>
    </body>
   　<%=jumptop.home()%>
    <%=login.Login(LogStat,loginName,"top.jsp")%>
</html>
