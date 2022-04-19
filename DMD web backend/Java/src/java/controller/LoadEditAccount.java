/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Trong Thinh
 */
@WebServlet(name = "LoadEditAccount", urlPatterns = {"/LoadEditAccount"})
public class LoadEditAccount extends HttpServlet {

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

        String uID = request.getParameter("id");

        AccountDAO dao = new AccountDAO();
        Account a = dao.getAccountByID(uID);

        PrintWriter out = response.getWriter();

        out.println("<div class=\"modal-dialog\">\n"
                + "                <div class=\"modal-content\">\n"
                + "                    <form action=\"EditAccount\" method=\"post\">\n"
                + "                        <div class=\"modal-header\">						\n"
                + "                            <h4 class=\"modal-title\">Edit Account</h4>\n"
                + "                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n"
                + "                        </div>\n"
                + "                        <div class=\"modal-body\">					\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label>User</label>\n"
                + "                                <input name=\"user\" value=\"" + a.getuId() + "\" type=\"text\" class=\"form-control\" readonly=\"\">\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label>Password</label>\n"
                + "                                <input value=\"" + a.getPaswrod() + "\" type=\"password\" class=\"form-control\" readonly=\"\">\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label>Name</label>\n"
                + "                                <input name=\"name\" value=\"" + a.getName() + "\" type=\"text\" class=\"form-control\" required>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label>Type</label>\n"
                + "                                <select name=\"type\" class=\"form-control\" aria-label=\"Default select example\">\n");
        String type = a.getType();
        switch (type) {
            case "admin":
                out.println("                                    <option value=\"admin\" selected>Admin</option>\n"
                        + "                                    <option value=\"customer\">Customer</option>\n"
                        + "                                    <option value=\"employee\">Employee</option>\n");
                break;
            case "customer":
                out.println("                                    <option value=\"admin\">Admin</option>\n"
                        + "                                    <option value=\"customer\" selected>Customer</option>\n"
                        + "                                    <option value=\"employee\">Employee</option>\n");
                break;
            case "employee":
                out.println("                                    <option value=\"admin\">Admin</option>\n"
                        + "                                    <option value=\"customer\">Customer</option>\n"
                        + "                                    <option value=\"employee\" selected>Employee</option>\n");
                break;
        }
                        
        out.println("                                </select>\n"
                + "                            </div>					\n"
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
