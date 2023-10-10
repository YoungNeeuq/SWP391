<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Checkout</title>
        <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Check out</h1>
            <div class="text-center mb-3">
                <a href="ProductServlet" class="btn btn-success">Home</a>
            </div>
            <form action="CheckOutServlet" method="GET">
                <div class="mb-3">
                    <input type="hidden" name="cus_id" value="<%= session.getAttribute("customer_id")%>" >
                    <c:forEach var="dish" items="${cart.getCartItems()}" varStatus="loop">
                        <input type="hidden" name="dish_id" value="${dish.getDish().getDish_id()}">
                        <input type="hidden" name="quantity" value="${dish.getQuantity()}">
                        <input type="hidden" name="total" value="${cart.getTotal()}">
                    </c:forEach>
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Phone number</label>
                    <input type="text" class="form-control" id="phone" name="phone" required>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <textarea class="form-control" id="address" name="address" required></textarea>
                </div>
                <div class="mb-3">
                    <label for="store_address" class="form-label">Store</label>
                    <select name="store_id">
                        <c:forEach var="item" items="${myList}">
                            <option value="${item.getStore_id()}"> ${item.getAddress()}</option>
                        </c:forEach>
                    </select>


                </div>
                     <input type="radio"  id="cod" name="cod" value="1">
                       <label for="bankCode">COD</label><br>
                      <input type="radio"  id="cod" name="cod" value="2">
                       <label for="bankCode">VNPay</label><br>

                <button type="submit" class="btn btn-primary">Confirm Order</button>
            </form>
                    
        </div>


    </body>
</html>
