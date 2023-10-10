<%-- 
    Document   : list
    Created on : Sep 23, 2023, 3:32:25 PM
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

        <div class="container">
            <div class="row">
                <c:forEach var="dish" items="${list1}" >
                    <div class="product col-md-3 mx-3 mb-4">

                        <img><img src="img/${dish.getImage()}" alt="alt" style="
    height: 260px; "/> 
                        <div class="product-name-price">
                            <h3 class="product-name">${dish.getName()}</h3>
                            <p class="product-price">${dish.getPrice()}</p>
                        </div>

                        <p class="product-info">${dish.getInfor()}</p>

                        <div class="product-button d-flex justify-content-center">
                          
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
