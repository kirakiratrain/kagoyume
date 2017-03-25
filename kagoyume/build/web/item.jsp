<%-- 
    Document   : item
    Created on : 2017/03/24, 20:33:08
    Author     : Choir

概要：商品の詳細を表示する。

・カートに追加ボタンがある→add画面へ


--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<%@page import="ec.itemDataBeans" 
        import="ec.ecHelper"%>
<%
    //topへのリンク
    ecHelper jumptop = ecHelper.getInstance();
    //検索データ
    session = request.getSession();
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("searchData");
    //検索結果画面で選択したIndexを取得
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
        <h1>詳細画面</h1>
        <table border=1>
            <tr>
                <th>製品名</th>
                <td>概要</td>
                <td>価格</td>
                <td>ポイント</td>
                <td>評価</td>
                <td>評価数</td>
                <td>評価URL</td>
                <td>在庫</td>
                <td>メーカー</td>
            </tr>
            <a href="#">
                <img src=<%= iDB.getImageURL(index) %> border="0" width="240" height="240"/>
            </a>
            <tr>
                <td><%= "品名：" + iDB.getName(index) %></td>
                <%--
                <td><%= "概要：" + iDB.getOverView(index) %></td>
                <td><%= "価格：" + iDB.getPrice(index) %></td>
                <td><%= "ポイント：" + iDB.getPoint(index) %></td>
                <td><%= "評価：" + rev.reviewPoint %></td>
                <td><%= "評価数：" + rev.cnt %></td>
                <td><%= "評価URL：" + rev.URL %></td>
                <td><%= "在庫：" + iDB.getStock(index) %></td>
                <td><%= "メーカー：" + iDB.getMaker(index) %></td>
                --%>
            </tr>
        </table>
        <form action="add" method="GET">
        <input type="submit" name="addItem" value="カートへ追加">
        <input type="hidden" name="Index"  value="<%=index%>">
        </form>
        <form action="cart" method="GET">
        <input type="submit" name="cart" value="カート">
        </form>
    </body>
    <%=jumptop.home()%>
</html>
