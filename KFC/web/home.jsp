<%-- 
    Document   : verify
    Created on : Sep 10, 2023, 1:08:10 PM
    Author     : HAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="VerifyServlet" method="post">
    <label for="otp">Mã OTP:</label>
    <input type="text" id="otp" name="otp" required><br><br>

    <input type="submit" value="Xác nhận">
</form>
    </body>
</html>
