<%-- 
    Document   : add
    Created on : 2017/03/24, 21:21:31
    Author     : Choir
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="ec.itemDataBeans" 
        import="ec.ecHelper"%>
<%
    ecHelper jumptop = ecHelper.getInstance();
    //�Z�b�V�����X�^�[�g
    session = request.getSession();
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("cartData");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>�ȉ��̏��i���J�[�g�ɒǉ����܂���</h2>
        <a href="#">
            <img src=<%= iDB.getImageURL(0) %> border="0" width="240" height="240"/><br>
        </a>
            ���i:<%= iDB.getPrice(0) %><br>
            ���i��:<%= iDB.getName(0) %><br>
    </body>
    <%=jumptop.home()%>
</html>
