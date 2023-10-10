<%@page import="com.entity.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.google.gson.Gson" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cart</title>
        <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
        <style>
            .img-thumbnail {
                max-width: 100px;
                max-height: 100px;
            }
        </style>
    </head>
    <body>
        <br>
        <div class="text-center mb-3">
            <a href="ProductServlet" class="btn btn-success">Home</a>
        </div>
        <div class="container">

            <%-- Sử dụng biểu thức EL để truy cập giá trị của Cookie --%>


            <table class="table">
                <thead>
                    <tr>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>

                <h1 class="text-center">Cart</h1>



                <c:forEach var="dish" items="${cart.getCartItems()}" varStatus="loop">
                    <tr>
                        <td>${dish.getDish().getName()}</td>
                        <td>${dish.getDish().getPrice()}</td>
                        <td>
                            <input type="hidden" name="quantity${loop.index}" value="${dish.getQuantity()}">
                            <input type="hidden" name="dish_id" value="${dish.getDish().getDish_id()}">

                            <button onclick="decrementQuantity(${loop.index}, ${dish.getDish().getDish_id()})">-</button>
                            <span id="quantity${loop.index}" >${dish.getQuantity()}</span>
                            <button onclick="incrementQuantity(${loop.index}, ${dish.getDish().getDish_id()})">+</button>


                        </td>

                        <td>
                            <form action="RemoveItem" method="GET">
                                <input type="hidden" name="index" value="${loop.index}">
                                <button type="submit" name="deleteButton" value="delete">
                                    X
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            
            <div class="text-center mb-3">
                <p class="btn btn-defaut" id="total">Total: ${cart.getTotal()}</p>
            </div>
            <p id="distanceResult"> </p>
            <a href="ListStoreServlet"  class="btn btn-lg btn-primary">Check out</a>
        </div>
        <script>
            function incrementQuantity(index, dish_id) {
                var quantitySpan = document.getElementById("quantity" + index);
                var currentQuantity = parseInt(quantitySpan.innerText);
                quantitySpan.innerText = currentQuantity + 1;
                updateTotal();

                // Chuyển hướng và truyền dish_id trong URL
                window.location.href = "AddtoCartServlet?dish_id=" + dish_id + "&action=increment";
            }
            function decrementQuantity(index, dish_id) {
                var quantitySpan = document.getElementById("quantity" + index);
                var currentQuantity = parseInt(quantitySpan.innerText);
                if (currentQuantity > 1) {
                    quantitySpan.innerText = currentQuantity - 1;
                    updateTotal();

                    // Chuyển hướng và truyền dish_id trong URL
                    window.location.href = "AddtoCartServlet?dish_id=" + dish_id + "&action=decrement";
                }
            }

            //update total price
            function updateTotal() {
                var total = 0;
                var quantities = document.querySelectorAll('[id^="quantity"]');
                var prices = document.querySelectorAll('td:nth-child(2)');

                for (var i = 0; i < quantities.length; i++) {
                    var quantity = parseInt(quantities[i].innerText);
                    var price = parseFloat(prices[i].innerText);
                    total += quantity * price;
                }

                document.getElementById("total").innerText = "Total: " + total.toFixed(2);
            }



        </script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </body>
</html>
