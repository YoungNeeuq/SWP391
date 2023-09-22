
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form id="myModal" class="modal" action="addServlet" method="POST" enctype="multipart/form-data">
            <div class="modal-content" id="modall" style="width:30%;">
                <h2 id="header-modal">Thêm món ăn mới</h2>
                <div  class="container-form">
                    <div id="employeeForm">
                        <div class="form-group">
                            <label for="name"><i class="fa-solid fa-drumstick-bite"></i></label>
                            <input type="text" id="name" name="name" placeholder="Tên món ăn" required>
                            <span class="sp-thongbao" id="tbName"></span>
                        </div>

                        <div class="form-group">
                            <label for="infor" ><i class="fa-solid fa-circle-info"></i></label>
                            <input type="text" id="infor" name="infor" placeholder="Mô tả món ăn" required>
                            <span class="sp-thongbao" id="tbInfor"></span>
                        </div>

                        <div class="form-group">
                            <label for="price" ><i class="fa-solid fa-money-bill"></i></label>
                            <input type="number" id="price" name="price" placeholder="Giá" required>
                            <span class="sp-thongbao" id="tbPrice"></span>
                        </div>
                        <div class="form-group">

                            <input type="hidden" id="comment" name="comment" placeholder="Comment" required>
                            <span class="sp-thongbao" id="tbComment"></span>
                        </div>
                        <div class="form-group">
                            <label for="typeOfDish"><i class="fa-solid fa-tag"></i></label>
                            <input type="text" id="typeOfDish" name="typeOfDish" placeholder="Phân loại ( Combo : c , Món lẻ : d )" required>
                            <span class="sp-thongbao" id="tbType"></span>
                        </div>

                        <div class="form-group">
                            <label for="image"><i class="fa-solid fa-image"></i></label>
                            <input type="file" id="image" name="image" accept="img/*" placeholder="Tải ảnh lên" required><br>
                            <span class="sp-thongbao" id="tbSalary"></span>
                        </div>
                    </div>
                </div>
                <div class="footer-modal">
                    <button type="submit" value="Submit!" name="submit" style="margin-left: 46.5%;" class="submit submit-form" id="them">Thêm món ăn</button>
                    <button class="close-button" onclick="closeForm('myModal')">Đóng</button>
                </div>
            </div>
        </form> 
    </body>
</html>
