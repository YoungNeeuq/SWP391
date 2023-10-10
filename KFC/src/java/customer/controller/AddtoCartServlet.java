/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package customer.controller;

import com.entity.Cart;
import com.entity.CartItem;
import com.google.gson.Gson;
import dal.DishDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dish;

/**
 *
 * @author Asus
 */
public class AddtoCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddtoCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddtoCartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            int dish_id = Integer.parseInt(request.getParameter("dish_id"));
            String action = request.getParameter("action");
            DishDAO dishDAO = new DishDAO();
            Dish dish = dishDAO.getDish(dish_id);
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");

            if (cart == null) {
                cart = new Cart();

                session.setAttribute("cart", cart);
            }

            if ("increment".equalsIgnoreCase(action)) {
                cart.addItem(dish, 1); // Tăng số lượng lên 1
                session.setAttribute("cart", cart);
            } else if ("decrement".equalsIgnoreCase(action)) {
                cart.decrementItem(dish, 1); // Giảm số lượng xuống 1
                session.setAttribute("cart", cart);
            }
            CartItem cartItem = cart.getCartItems().get(0);
            String name = cartItem.getDish().getName();
            session.setAttribute("name", name);
            // Lưu thông tin giỏ hàng vào Cookie dưới dạng JSON
//            Gson gson = new Gson();
//            String cartJson = gson.toJson(cart);
//
//// Tạo một cookie và đặt giá trị của nó là chuỗi JSON
//            Cookie cartCookie = new Cookie("cart", cartJson);
//
//// Đặt thời gian sống của cookie (ví dụ: 1 giờ)
//            cartCookie.setMaxAge(3600);
//
//// Thêm cookie vào phản hồi
//            response.addCookie(cartCookie);
            session.setAttribute("cart", cart);
            response.sendRedirect("viewCard.jsp");
        } catch (Exception ex) {
            response.sendRedirect("error.jsp");
            Logger.getLogger(AddtoCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Lấy thông tin cart item từ request (ví dụ: productId, quantity, price)
            int dish_id = Integer.parseInt(request.getParameter("dish_id"));
            DishDAO dishDAO = new DishDAO();
            int quantity = 1;
            CartItem cartItem = new CartItem(dishDAO.getDish(dish_id), quantity); // Thay đổi dữ liệu tùy theo cart item thêm vào
            Cart cart = new Cart();
            // Chuyển đối tượng thành chuỗi JSON
            Gson gson = new Gson();

            // Trước khi lưu trữ trong cookie, mã hóa các ký tự không hợp lệ, ví dụ: dấu phẩy
            String encodedCartItemJSON = cart.encodeCartItem(cartItem);

// Tạo cookie và đặt giá trị vào cookie
            Cookie cartCookie = new Cookie("cartItem", encodedCartItemJSON);
            cartCookie.setMaxAge(300); // 5 phút
            response.addCookie(cartCookie);

            // Tạo một cookie để lưu trữ cart item trong 5 phút
            // Chuyển hướng người dùng đến trang JSP
            request.getRequestDispatcher("demoCookie.jsp").forward(request, response);
        } catch (Exception ex) {
            // Lấy thông báo lỗi từ Exception
            String errorMessage = ex.getMessage();

            // Đặt thông báo lỗi vào request
            request.setAttribute("errorMessage", errorMessage);

            // Chuyển hướng người dùng đến trang error.jsp
            request.getRequestDispatcher("error.jsp").forward(request, response);

            // Ghi log lỗi
            Logger.getLogger(AddtoCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
