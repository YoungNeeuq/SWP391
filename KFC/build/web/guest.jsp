<%-- 
    Document   : guest
    Created on : Sep 11, 2023, 4:01:00 PM
    Author     : HAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/styleguest.css">
         <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <title>JSP Page</title>
    </head>
    <body>
<div id="header">
        <div class="container-header">
                <div class="header-img col-md-3">
                    <img src="img/logo.jpg" alt="">
                </div>

                <div id="show" class="header-select col-md-9">
                    <ul>
                        <li> <a href="">Home</a></li>
                        <li> <a href="ProductServlet">Menu</a></li>
                        <li> <a href="">Sale</a></li>
                        <li> <a href="">Services</a></li>
                        <li> <a href="">Contact us</a></li>
                        <li> <a href="login.jsp">Login</a></li>
                    </ul>
                </div>
        </div>
    </div>
         <div class="container-content">
        <div class="banner">
            <<img src="img/banner.jpg" alt="alt"/>
        </div>
    </div>
    </body>
</html>
