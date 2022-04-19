/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CartDAO;
import dao.OrderDAO;
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
import model.Order;

/**
 *
 * @author Trong Thinh
 */
@WebServlet(name = "SaveOrder", urlPatterns = {"/SaveOrder"})
public class SaveOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ss = request.getSession();
        Account acc = (Account) ss.getAttribute("ACC");
        CartDAO cartDAO = new CartDAO();
        ArrayList<Cart> list = cartDAO.getListByUId(acc.getuId());
        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();
        for (Cart cart : list) {
            Order c=orderDAO.getByUIdAndPId(cart.getuId(), cart.getpId());
            if(c==null){
                orderDAO.add(cart);
            }
            else{
                c.setAmount(c.getAmount()+cart.getAmount());
                orderDAO.update(c);
            }
            cartDAO.delete(cart.getuId(), cart.getpId());
        }
        response.sendRedirect("Home.jsp");

    }

}
