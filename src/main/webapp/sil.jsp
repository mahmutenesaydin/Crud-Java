<%--
  Created by IntelliJ IDEA.
  User: UniVersal88
  Date: 3.03.2021
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.uniyaz.db.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="favicon.ico"/>
    <link rel="stylesheet" href="style.css"/>
    <title>Sil</title>
</head>
<body>

<form action="sil.jsp" method="post">

    <div>
        <div style="width: 300px;">
            <div style="float: left;">
                <label for="id">Id</label>
                <input type="text" name="id">
            </div>
            <input type="submit" value="Sil">
            <input onclick="history.back();" type="button" value="Geri Dön">
        </div>
    </div>
</form>

<%

    String i =request.getParameter("id");
    if(i!=null)
    {
        int id = Integer.parseInt(i);

        DbOperations dbOperations = new DbOperations();
        dbOperations.rehberiSil(id);
    }

%>
</body>
</html>