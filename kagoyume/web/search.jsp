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
    //���O�C���ւ̃����N
    loginHelper login = new loginHelper();
    
    //�Z�b�V�����X�^�[�g
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
        <h1>��������</h1>
        <h1>�������[�h:<%=word%></h1>
        <h1>�������ʐ��F<%= iDB.getItemCnt()%></h1>
        <%if(iDB.getItemCnt() > 0)
        {%>
            <%for(int i=0; i < iDB.getItemCnt();i++)
            {%>
            <li>
                <a href="item?ItemIndex=<%=i %>">
                <img src=<%= iDB.getImageURL(i) %> alt="">
                <p class="title"><%= "�i���F"+iDB.getName(i) %></p>
                <p class="desc"><%= "���i�F" +iDB.getPrice(i) %></p>
                </a>
            </li>
            <%}%>
        <%}
        else
        {%>
            �����Ώۂ�������܂���ł����B<br>
        <%}%>
        </div>
    </body>
    <body>
        <h1>��������</h1>
        <%if(iDB.getItemCnt() > 0)
        {%>
        <table border=1>
            <tr>
                <th>���i��</th>
                <th>���i</th>
            </tr>
            <a href="item">
                <img src=<%= iDB.getImageURL(0) %> border="0" width="240" height="180"/>
            </a>
            <tr>
                <td><%= "�i���F" + iDB.getName(0) %></td>
                <td><%= "���i�F" + iDB.getPrice(0) %></td>
            </tr>
        </table>
        <%}
        else
        {%>
            �����Ώۂ�������܂���ł����B<br>
        <%}%>
    </body>
     <%=jumptop.home()%>
     <%=login.Login(LogStat,loginName,"top.jsp")%>
</html>
