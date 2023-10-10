<%-- 
    Document   : abc
    Created on : Oct 9, 2023, 5:45:32 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="ListStoreServlet" class="btn btn-lg btn-primary">Checkout</a>
        
    <c:forEach var="item" items="${myList}">
    <!-- In giá trị name của mỗi phần tử trong danh sách -->
    <input type="hidden" value="${item.getStore_name()}">
</c:forEach>
</body>
</html>
