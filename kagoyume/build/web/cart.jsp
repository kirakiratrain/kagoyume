<%-- 
    Document   : cart
    Created on : 2017/03/24, 22:32:33
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
    int sum = (int)request.getAttribute("sum");
    
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("cartData");
    //���i�摜�E���i���Ƌ��z��\������E
    //�폜�{�^��������
    //��ʉ����ɍ��v���z�̕\��
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="menu">
        <h1>�J�[�g�̒��g</h1>
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
            <form action=delete method="GET">
            <input type="submit" name="btnDelete" value="�폜">
            <input type="hidden" name="deleteIndex"  value="<%=i%>">
            </form>
            <%}%>
        <%}
        else
        {%>
            �J�[�g�̒��g������܂���<br>
        <%}%>
    </body>
    ���v���z�F<%= sum%>
</html>
