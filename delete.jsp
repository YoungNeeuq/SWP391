
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="deleteServlet" method="POST">
                                <input type="hidden" name="dish_id" value="${dish.getDish_id()}">
                                <button class="product-delete btn btn-danger"> <i class="fa-solid fa-trash"></i></button>
                            </form>
    </body>
</html>
