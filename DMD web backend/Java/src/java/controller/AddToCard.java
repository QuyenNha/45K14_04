/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddToCard", urlPatterns = {"/AddToCard"})
public class AddToCard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pId = request.getParameter("pId");
        HttpSession ss = request.getSession();
        Account acc = (Account) ss.getAttribute("ACC");
        CartDAO cartDAO = new CartDAO();
        Cart cart = cartDAO.get(acc.getuId(), pId);

        if (cart == null) {
            cartDAO.add(acc.getuId(), pId);
        } else {
            cartDAO.updade(acc.getuId(), pId, cart.getAmount() + 1);
        }
        response.sendRedirect("Home.jsp");
    }

}
