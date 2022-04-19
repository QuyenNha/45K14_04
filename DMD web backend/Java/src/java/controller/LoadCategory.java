/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trong Thinh
 */
@WebServlet(name = "LoadCategory", urlPatterns = {"/LoadCategory"})
public class LoadCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cId = request.getParameter("cId");
        ProductDAO productDAO=new ProductDAO();
        request.setAttribute("LIST_PRODUCT_CATEGORY", productDAO.getListByCateogry(cId));
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }

}
