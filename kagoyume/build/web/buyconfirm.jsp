<%-- 
    Document   : buyconfirm
    Created on : 2017/03/27, 14:05:50
    Author     : Choir
 * //buyconfirm
 * �w���m�F�y�[�W
 * �J�[�g�ɒǉ����ŏ��i�̖��O�i�����N�Ȃ��j���z���\�������
 * ���v���z���\������A���̉��ɔz�����@��I�����郉�W�I�{�^��������
 * �u��L�̓��e�ōw������v�{�^���Ɓu�J�[�g�ɖ߂�v�{�^��������
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="ec.itemDataBeans" 
        import="ec.ecHelper"
        import="ec.loginHelper"
        import="ec.UserDataDTO"%>
<%
    ecHelper jumptop = ecHelper.getInstance();
    //�Z�b�V�����X�^�[�g
    session = request.getSession();
    
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("cartData");
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
        <%if(iDB.getItemCnt() > 0)
        {%>
            <%for(int i=0; i < iDB.getItemCnt();i++)
            {%>

            <p class="title"><%= "�i���F"+iDB.getName(i) %></p>
            <p class="desc"><%= "���i�F" +iDB.getPrice(i) %></p>
   
            <%}%>
        <%}
        else
        {%>
            �J�[�g�̒��g������܂���<br>
        <%}%>
    </body>
    ���v���z�F<%= iDB.getTotalPrice()%>
    
    <h2>�z�����@</h2>
    <form name="Send">
    <input type="radio" value="" name="SendType" checked = \"checked\"">�܂Ƃ߂Ĕz��<br>
    <input type="radio" value="" name="SendType">�ʂɔz��<br>
    </form>
    <br>
    
    <form action=buycomplete method="GET">
    <input type="submit" name="btnBuy" value="��L�̓��e�ōw������">
    </form>
    <form action=cart method="GET">
    <input type="submit" name="btnCart" value="�J�[�g�֖߂�"> 
    </form>
</html>
