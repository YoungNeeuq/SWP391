<%-- 
    Document   : detail
    Created on : Oct 8, 2023, 1:59:56 PM
    Author     : Asus
--%>

<%@page import="model.Dish"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail</title>
        <link href="css/ceetet.css" rel="stylesheet"/>
        <link href="css/detailcss.css" rel="stylesheet"/>
        <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <%-- Hiển thị thông tin sản phẩm đã chọn --%>
        <% Dish dish = (Dish) request.getAttribute("selectedProduct");%>
        <h1>${ dish.name}</h1>
        <p>Price: ${ dish.price}</p>
        <p>Description: ${ dish.infor}</p>
    </body>
</html>
