<%-- 
    Document   : item
    Created on : 2017/03/24, 20:33:08
    Author     : Choir

�T�v�F���i�̏ڍׂ�\������B

�E�J�[�g�ɒǉ��{�^�������遨add��ʂ�


--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="ec.itemDataBeans" 
        import="ec.ecHelper"%>
<%
    //top�ւ̃����N
    ecHelper jumptop = ecHelper.getInstance();
    //�����f�[�^
    session = request.getSession();
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("searchData");
    //�������ʉ�ʂőI������Index���擾
    String strIndex = (String)request.getAttribute("ItemIndex");
    int index = Integer.parseInt(strIndex);
    //itemDataBeans.Review rev = iDB.getReview(index); 
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>�ڍ׉��</h1>
        <table border=1>
            <tr>
                <th>���i��</th>
                <td>�T�v</td>
                <td>���i</td>
                <td>�|�C���g</td>
                <td>�]��</td>
                <td>�]����</td>
                <td>�]��URL</td>
                <td>�݌�</td>
                <td>���[�J�[</td>
            </tr>
            <a href="#">
                <img src=<%= iDB.getImageURL(index) %> border="0" width="240" height="240"/>
            </a>
            <tr>
                <td><%= "�i���F" + iDB.getName(index) %></td>
                <%--
                <td><%= "�T�v�F" + iDB.getOverView(index) %></td>
                <td><%= "���i�F" + iDB.getPrice(index) %></td>
                <td><%= "�|�C���g�F" + iDB.getPoint(index) %></td>
                <td><%= "�]���F" + rev.reviewPoint %></td>
                <td><%= "�]�����F" + rev.cnt %></td>
                <td><%= "�]��URL�F" + rev.URL %></td>
                <td><%= "�݌ɁF" + iDB.getStock(index) %></td>
                <td><%= "���[�J�[�F" + iDB.getMaker(index) %></td>
                --%>
            </tr>
        </table>
        <form action="add" method="GET">
        <input type="submit" name="addItem" value="�J�[�g�֒ǉ�">
        <input type="hidden" name="Index"  value="<%=index%>">
        </form>
        <form action="cart" method="GET">
        <input type="submit" name="cart" value="�J�[�g">
        </form>
    </body>
    <%=jumptop.home()%>
</html>
