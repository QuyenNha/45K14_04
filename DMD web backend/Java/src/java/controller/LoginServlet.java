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
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Trong Thinh
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uId = request.getParameter("user");
        String p = request.getParameter("pass");
        AccountDAO accountDAO=new AccountDAO();
        Account acc=accountDAO.login(uId, p);
        if(acc!=null){
            HttpSession ss=request.getSession();
            ss.setAttribute("ACC", acc);
            response.sendRedirect("Home.jsp");
        }
        else{
            request.setAttribute("ERR", "Wrong username or password!!!");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

}
