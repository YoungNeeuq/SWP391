/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package customer.controller;

import com.entity.Cart;
import dal.CustomerDAO;
import dal.DishDAO;
import dal.InvoiceDAO;
import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Dish;

/**
 *
 * @author Asus
 */
public class CheckOutServlet extends HttpServlet {

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
            out.println("<title>Servlet CheckOutServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutServlet at " + request.getContextPath() + "</h1>");
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
            HttpSession session = request.getSession();
            int paymentMethod = Integer.parseInt(request.getParameter("cod"));
            Cart cart = (Cart) session.getAttribute("cart");
            CustomerDAO customerDAO = new CustomerDAO();
            int id = Integer.parseInt(request.getParameter("cus_id"));
            String store_selected = request.getParameter("store_id");
            
            int store_id = Integer.parseInt(store_selected);

            session.setAttribute("store_id", store_id);
            Customer c = customerDAO.getCustomer(id);
            if (c == null) {
                response.sendRedirect("login.jsp");
            } else {
                if (paymentMethod == 1) {
                    try {
                        OrderDAO d = new OrderDAO();
                        d.addOrder(c, cart, store_id);
                        response.sendRedirect("viewProduct.jsp");
                        session.removeAttribute("cart");
                    } catch (Exception ex) {
                        String errorMessage = ex.getMessage();

                        // Đặt thông báo lỗi vào request
                        request.setAttribute("errorMessage", errorMessage);

                        // Chuyển hướng người dùng đến trang error.jsp
                        request.getRequestDispatcher("error.jsp").forward(request, response);

                        Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (paymentMethod == 2) {
                    response.sendRedirect("vnpay_pay.jsp");
                } else {
                    try {
                        String vnp_ResponseCode = request.getParameter("vnp_ResponseCode");
request.setAttribute("vnp_ResponseCode", vnp_ResponseCode);
                        OrderDAO d = new OrderDAO();
                        d.addOrder(c, cart, store_id);
                        response.sendRedirect("vnpay_return.jsp");
                        session.removeAttribute("cart");
                    } catch (Exception ex) {
                        String errorMessage = ex.getMessage();

                        // Đặt thông báo lỗi vào request
                        request.setAttribute("errorMessage", errorMessage);

                        // Chuyển hướng người dùng đến trang error.jsp
                        request.getRequestDispatcher("error.jsp").forward(request, response);

                        Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();

            // Đặt thông báo lỗi vào request
            request.setAttribute("errorMessage", errorMessage);

            // Chuyển hướng người dùng đến trang error.jsp
            request.getRequestDispatcher("error.jsp").forward(request, response);
            Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int cusIdString = Integer.parseInt(request.getParameter("cus_id"));
            String name = request.getParameter("name");
            Cart cart = (Cart) session.getAttribute("cart");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            int totalPrice = cart.getTotal();
            int order_id = 2;
            InvoiceDAO invoiceDAO = new InvoiceDAO();
            invoiceDAO.add(name, quantity, address, phoneNumber, totalPrice, cusIdString, order_id);
            response.sendRedirect("success.jsp");

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();

            // Đặt thông báo lỗi vào request
            request.setAttribute("errorMessage", errorMessage);

            // Chuyển hướng người dùng đến trang error.jsp
            request.getRequestDispatcher("error.jsp").forward(request, response);
            Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
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
