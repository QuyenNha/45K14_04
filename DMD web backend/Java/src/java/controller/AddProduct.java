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
@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})
public class AddProduct extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name=request.getParameter("name");
        String id=request.getParameter("id");
        String img=request.getParameter("image");
        String price=request.getParameter("price");
        String des=request.getParameter("description");
        String cate=request.getParameter("category");
        ProductDAO pdao=new ProductDAO();
        if (pdao.getProduct(id)==null)
        pdao.addProduct(id, name, img,Integer.parseInt(price) , des, cate);
        response.sendRedirect("ManagerProduct.jsp");
        
    }

    

}
