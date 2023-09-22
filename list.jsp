
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div class="container">
            <div class="row">
                <c:forEach var="dish" items="${list}" >
                    <div class="product col-md-3 mx-3 mb-4">

                        <img><img src="img/${dish.getImage()}" alt="alt" style="
    height: 260px; "/> 
                        <div class="product-name-price">
                            <h3 class="product-name">${dish.getName()}</h3>
                            <p class="product-price">${dish.getPrice()}<i class="fa-solid fa-dong-sign" style="color: #fd1808;"></i></p>
                        </div>

                        <p class="product-info">${dish.getInfor()}</p>

                        <div class="product-button d-flex justify-content-center">
                            <form  action="updateServlet" method="GET">
                                <input type="hidden" name="dish_id" value="${dish.getDish_id()}">
                                <button class="btnedit btn-secondary" type="button" name="updateButton" value="update" ><i class="fa-solid fa-wrench"></i></button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
