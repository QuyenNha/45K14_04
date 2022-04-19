/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Order2;

/**
 *
 * @author Trong Thinh
 */
@WebServlet(name = "LoadManagerOrder", urlPatterns = {"/LoadManagerOrder"})
public class LoadManagerOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDAO categoryDAO=new CategoryDAO();
        ArrayList<Category> listCate=categoryDAO.getList();
        ArrayList<Order2> listOrder= new ArrayList<>();
        OrderDAO orderDAO=new OrderDAO();
        for (Category cate : listCate) {
            int collected=orderDAO.getCollectByCateId(cate.getcId());
            listOrder.add(new Order2(cate.getName(), collected, cate.getRequired(),cate.getcId()));
        }
        request.setAttribute("LIST_ORDER", listOrder);
        request.getRequestDispatcher("ManagerOrder.jsp").forward(request, response);
             

    }

}
