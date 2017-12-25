/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechat.servlet;

import com.wechat.wechatDomain.Manager;
import com.wechat.wechatService.ManagerException;
import com.wechat.wechatService.ManagerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 宣佚
 */
public class ManagerRegister extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        String password_1=request.getParameter("password_1");
        String password_2=request.getParameter("password_2");
        ManagerService managerService=new ManagerService();
        Manager manager=new Manager();
        manager.setName(name);
        manager.setPassword(password_1);
        try (PrintWriter out = response.getWriter()) {
            if(name.length()==0){
                request.setAttribute("error", "用户名不可以为空！");
                request.getRequestDispatcher("managerRegister.jsp").forward(request, response);
            }
            else{
                if(password_1.length()==0||password_2.length()==0){
                    request.setAttribute("error", "密码不可以为空！");
                    request.getRequestDispatcher("managerRegister.jsp").forward(request, response);
                }
                else{
                    if(!password_1.equals(password_2)){
                        request.setAttribute("error", "两次密码不一致！");
                        request.getRequestDispatcher("managerRegister.jsp").forward(request, response);
                    }
                    else{
                        try {
                            managerService.register(manager);
                            Cookie cookie=new Cookie("name",URLEncoder.encode(name,"UTF-8"));
                            cookie.setMaxAge(1000);
                            response.addCookie(cookie);
                            response.sendRedirect("managerLogin.jsp");
                        } catch (ManagerException ex) {
                            request.setAttribute("error", ex.getMessage());
                            request.getRequestDispatcher("managerRegister.jsp").forward(request, response);
                        }
                    }
                }
            }
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
        } catch (SQLException ex) {
            Logger.getLogger(ManagerRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerRegister.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ManagerRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerRegister.class.getName()).log(Level.SEVERE, null, ex);
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
