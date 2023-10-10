<%@page import="com.entity.Cart"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.entity.CartItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <h1>Cart Item Information</h1>

        <%-- Đọc giá trị từ cookie --%>
        <%
            String encodedCartItemJSON = null;
            Cookie[] cookies = request.getCookies();
            Cart cart = new Cart();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cartItem")) {
                        encodedCartItemJSON = cookie.getValue();
                        break;
                    }
                }
            }

// Giải mã chuỗi JSON thành đối tượng CartItem
           

    try {
        // Chuyển chuỗi JSON thành đối tượng CartItem
         CartItem cartItem = cart.decodeCartItem(encodedCartItemJSON);
         
            if (cartItem != null) {
        %>
        <p>Product ID: <%= cartItem.getDish().getDish_id()%></p>
        <p>Quantity: <%= cartItem.getQuantity()%></p>
        <p>Price: <%= cartItem.getDish().getPrice()%></p>
        <%
        } else {
        %>
        <p>Cart is empty.</p>
        <%
            }
        %>
        <% out.println("encodedCartItemJSON: " + encodedCartItemJSON); %>
        <% if (encodedCartItemJSON != null) {
            Gson gson = new Gson();
            cartItem = gson.fromJson(encodedCartItemJSON, CartItem.class);
        }
        %>
  <%  } catch (Exception e) {
        out.println("Exception occurred: " + e.getMessage());
        e.printStackTrace();
    }
%>
       

       
    </body>
</html>