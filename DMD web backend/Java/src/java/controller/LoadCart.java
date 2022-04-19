/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CartDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;

/**
 *
 * @author Trong Thinh
 */
@WebServlet(name = "LoadCart", urlPatterns = {"/LoadCart"})
public class LoadCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ss=request.getSession();
        Account acc=(Account)ss.getAttribute("ACC");
        CartDAO cartDAO=new CartDAO();
        ArrayList<Cart> list=cartDAO.getListByUId(acc.getuId());
        ProductDAO productDAO=new ProductDAO();
        int total=0;
        for (Cart cart : list) {
            total+=productDAO.getById(cart.getpId()).getPrice()*cart.getAmount();
        }
        request.setAttribute("LIST_CART_PRODUCT", list);
        request.setAttribute("TOTAL", total);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
        
    }

}
