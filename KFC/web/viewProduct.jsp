<%-- 
    Document   : list
    Created on : Jun 1, 2023, 10:26:42 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Dish Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="css/styleadmin.css"/>
        <link href="bootstrap/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <h1>Danh sách món ăn</h1>

        <a href="ProductServlet">List Product</a> 
        <button id="btnThem"> Add Product</button>
     



        <div class="container">
            <div class="row">
                <c:forEach var="dish" items="${list}" >
                    <div class="product col-md-3 mx-3 mb-4">

                        <img><img src="img/${dish.getImage()}" alt="alt" style="
                                  height: 260px; "/> 
                        <div class="product-name-price">
                          <a href="ProductServlet?dish_id=${dish.getDish_id()}">${dish.getName()}</a>
                            <p class="product-price">${dish.getPrice()}</p>
                            
                        </div>
                        <input type="hidden" name="cus_id" value="<%= session.getAttribute("customer_id") %>" >
                        <p class="product-info">${dish.getInfor()}</p>
                        <form action="AddtoCartServlet" method="GET" >
                            <input type="hidden" name="dish_id" value="${dish.getDish_id()}">
                            <input type="hidden" name="name" value="${dish.getName()}">
                            <input type="hidden" name="price" value="${dish.getPrice()}">
                            <input type="hidden" name="infor" value="${dish.getInfor()}">
                            <input type="hidden" name="action" value="increment">
                            <button type="submit" class="btn btn-lg btn-outline-primary text-uppercase">
                                <i class="fas fa-shopping-cart"></i> Add to Cart
                            </button>
                        </form>


                    </div>
                </c:forEach>
            </div>
        </div>


        

    </body>
</html>