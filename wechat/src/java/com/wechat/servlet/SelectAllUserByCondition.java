/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechat.servlet;

import com.wechat.wechatDomain.PageBean;
import com.wechat.wechatDomain.User;
import com.wechat.wechatService.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 宣佚
 */
public class SelectAllUserByCondition extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String condition="all";
        String nameId=request.getParameter("nameId");
        System.out.print(nameId);
        int pageNum=1;
        if(request.getParameter("pageNum")!=null){
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }  
        UserService userService=new UserService();
        String username=request.getParameter("username");
        String sex=request.getParameter("sex");
        PageBean pageBean=null;
        User user=new User();
        if(request.getParameter("selectByName")==null&&request.getParameter("selectBySex")==null){
            pageBean=userService.selectAllUsersByCondition(pageNum, 5, condition, user);
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("condition", condition);
            //response.sendRedirect("management.jsp?fun=2&nameId="+nameId+"&pageNum="+pageNum);
            request.getRequestDispatcher("management.jsp").forward(request, response);
        }
        else{
            if(request.getParameter("selectByName")!=null){
                if(username.length()==0){
                    request.setAttribute("error", "请输入查询内容");
                    pageBean=userService.selectAllUsersByCondition(pageNum, 5, condition, user);
                    request.setAttribute("pageBean", pageBean);
                    request.setAttribute("condition", condition);
                    //response.sendRedirect("management.jsp?fun=2&nameId="+nameId+"&pageNum="+pageNum);
                    request.getRequestDispatcher("management.jsp?fun=2").forward(request, response);
                }
                else{
                    condition="user";
                    user.setUsername(username);
                    pageBean=userService.selectAllUsersByCondition(pageNum, 5, condition, user);
                    request.setAttribute("pageBean", pageBean);
                    request.setAttribute("condition", condition);
                    request.getRequestDispatcher("management.jsp?fun=2").forward(request, response);
                    //response.sendRedirect("management.jsp?fun=2&nameId="+nameId+"&pageNum="+pageNum);
                }
            }
            else{
                if(sex.length()==0){
                    request.setAttribute("error", "请输入查询内容");
                    pageBean=userService.selectAllUsersByCondition(pageNum, 5, "all", user);
                    request.setAttribute("pageBean", pageBean);
                    request.setAttribute("condition", condition);
                    request.getRequestDispatcher("management.jsp?fun=2").forward(request, response);
                    //response.sendRedirect("management.jsp?fun=2&nameId="+nameId+"&pageNum="+pageNum);
                }
                else{
                    condition="sex";
                    user.setSex(sex);
                    pageBean=userService.selectAllUsersByCondition(pageNum, 5, condition, user);
                    request.setAttribute("pageBean", pageBean);
                    request.setAttribute("condition", condition);
                    request.getRequestDispatcher("management.jsp?fun=2").forward(request, response);
                    //response.sendRedirect("management.jsp?fun=2&nameId="+nameId+"&pageNum="+pageNum);
                }
            }
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
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
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SelectAllUserByCondition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SelectAllUserByCondition.class.getName()).log(Level.SEVERE, null, ex);
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
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SelectAllUserByCondition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SelectAllUserByCondition.class.getName()).log(Level.SEVERE, null, ex);
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
