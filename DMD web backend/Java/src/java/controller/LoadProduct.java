/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

/**
 *
 * @author Trong Thinh
 */
@WebServlet(name = "LoadProduct", urlPatterns = {"/LoadProduct"})
public class LoadProduct extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");

        ProductDAO dao = new ProductDAO();
        CategoryDAO categoryDao = new CategoryDAO();

        Product p = dao.getProduct(id);
        List<Category> listC = categoryDao.getList();

        PrintWriter out = response.getWriter();

        out.println("<div class=\"modal-dialog\">\n"
                + "                <div class=\"modal-content\">\n"
                + "                    <form action=\"EditProduct\" method=\"post\">\n"
                + "                        <div class=\"modal-header\">						\n"
                + "                            <h4 class=\"modal-title\">Edit Product</h4>\n"
                + "                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n"
                + "                        </div>\n"
                + "                        <div class=\"modal-body\">					\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label>ID</label>\n"
                + "                                <input value=\"" + p.getpId() + "\" name=\"id\" type=\"text\" class=\"form-control\" readonly=\"\">\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label>Name</label>\n"
                + "                                <input value=\"" + p.getName() + "\" name=\"name\" type=\"text\" class=\"form-control\" required>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label>Image</label>\n"
                + "                                <input value=\"" + p.getImg() + "\" name=\"image\" type=\"text\" class=\"form-control\" required>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label>Price</label>\n"
                + "                                <input value=\"" + p.getPrice() + "\" name=\"price\" type=\"text\" class=\"form-control\" required>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\\n\"\n"
                + "                                <label>Description</label>\n"
                + "                                <textarea name=\"description\" class=\"form-control\" required>" + p.getDesc() + "</textarea>\n"
                + "                            </div>\n"
                + "                            <select name=\"category\" class=\"form-select\" aria-label=\"Default select example\">\n");
        for (Category o : listC) {
            if (o.getcId().equals(p.getCateId())) {
                out.println("<option selected value=\"" + o.getcId() + "\">" + o.getName() + "</option>");
            } else {
                out.println("<option value=\"" + o.getcId() + "\">" + o.getName() + "</option>");
            }
        }
        out.println("                            </select>\n"
                + "                        </div>\n"
                + "                        <div class=\"modal-footer\">\n"
                + "                            <input type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" value=\"Cancel\">\n"
                + "                            <input type=\"submit\" class=\"btn btn-info\" value=\"Save\">\n"
                + "                        </div>\n"
                + "                    </form>\n"
                + "                </div>\n"
                + "            </div>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
