<%-- 
    Document   : search
    Created on : 2017/03/17, 13:04:24
    Author     : Choir
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="ec.itemDataBeans" 
        import="ec.ecHelper"
        import="ec.loginHelper"
        import="ec.UserDataDTO"%>
<%
    ecHelper jumptop = ecHelper.getInstance();
    //ログインへのリンク
    loginHelper login = new loginHelper();
    
    //セッションスタート
    session = request.getSession();
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("searchData");
    String word = (String)request.getAttribute("SearchWord");
   
    session.setAttribute("ac","search");
    
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
        <style>
        .menu
        {
        padding: 20px;
        background-color: rgba(0, 0, 0, 0.17);
        }

        .menu h1
        {
            margin-bottom: 5px;
            font-size: 25px;
        }
        
        .ul,ol,li
        {
            margin: 0;
            padding: 0;
            font-size: 15px;
            line-height: 1.4;
            list-style: none;
            margin-bottom: 1px;
        }
        .menu li a
        {
            display: block;
            padding: 10px;
            color: #000;
            text-decoration: none;
            outline: 1px red solid;
        }

        .menu li a:hover
        {
            background-color: buttonhighlight;
        }

        .menu img
        {
            float: left;
        }
        .menu p
        {
            margin: 0 0 0 100px;
            /*margin: 0 0 0 100px;*/
        }
        
        .menu .title
        {
            font-weight: bold;
            color: red;
        }
        .p desc
        {
            color: #44ea58;
            font-size: 40px;
        }
        .menu li a:after
        {
            content: "";
            display: block;
            clear: both;
        }
    </style>
    </head>
    <body>
        <div class="menu">
        <h1>検索結果</h1>
        <h1>検索ワード:<%=word%></h1>
        <h1>検索結果数：<%= iDB.getItemCnt()%></h1>
        <%if(iDB.getItemCnt() > 0)
        {%>
            <%for(int i=0; i < iDB.getItemCnt();i++)
            {%>
            <li>
                <a href="item?ItemIndex=<%=i %>">
                <img src=<%= iDB.getImageURL(i) %> alt="">
                <p class="title"><%= "品名："+iDB.getName(i) %></p>
                <p class="desc"><%= "価格：" +iDB.getPrice(i) %></p>
                </a>
            </li>
            <%}%>
        <%}
        else
        {%>
            検索対象が見つかりませんでした。<br>
        <%}%>
        </div>
    </body>
    <body>
        <h1>検索結果</h1>
        <%if(iDB.getItemCnt() > 0)
        {%>
        <table border=1>
            <tr>
                <th>製品名</th>
                <th>価格</th>
            </tr>
            <a href="item">
                <img src=<%= iDB.getImageURL(0) %> border="0" width="240" height="180"/>
            </a>
            <tr>
                <td><%= "品名：" + iDB.getName(0) %></td>
                <td><%= "価格：" + iDB.getPrice(0) %></td>
            </tr>
        </table>
        <%}
        else
        {%>
            検索対象が見つかりませんでした。<br>
        <%}%>
    </body>
     <%=jumptop.home()%>
     <%=login.Login(LogStat,loginName,"top.jsp")%>
</html>
