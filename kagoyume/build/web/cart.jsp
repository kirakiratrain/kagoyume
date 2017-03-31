<%-- 
    Document   : cart
    Created on : 2017/03/24, 22:32:33
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
    //�Z�b�V�����X�^�[�g
    session = request.getSession();
    
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("cartData");
    //���i�摜�E���i���Ƌ��z��\������E
    //�폜�{�^��������
    //��ʉ����ɍ��v���z�̕\��
 
    //���O�C���ւ̃����N
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
        <div class="menu">
        <h1>�J�[�g�̒��g</h1>
        <%if(iDB != null)
        {%>
            <%for(int i=0; i < iDB.getItemCnt();i++)
            {%>
            
            <a href="item?ItemIndex=<%=i %>">
            <img src=<%= iDB.getImageURL(i) %> alt="">
            <p class="title"><%= "�i���F"+iDB.getName(i) %></p>
            <p class="desc"><%= "���i�F" +iDB.getPrice(i) %></p>
            </a>
            <form action=deleteItem method="GET">
            <input type="submit" name="btnDelete" value="�폜">
            <input type="hidden" name="deleteIndex"  value="<%=i%>">
            </form>
            <%}%>
            <form action=buyconfirm method="GET">
            <input type="submit" name="btnBuy" value="�w��"> 
            </form>
            ���v���z�F<%= iDB.getTotalPrice() %><br>
        <%}
        else
        {%>
            �J�[�g�̒��g������܂���<br>
        <%}%>
    </body>
    <%=jumptop.home()%>
    <%=login.Login(LogStat,loginName,"top.jsp")%>
</html>
