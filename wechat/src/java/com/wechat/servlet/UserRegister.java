/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechat.servlet;

import com.wechat.wechatDao.UserDao;
import com.wechat.wechatDomain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 宣佚
 */
public class UserRegister extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        String password_1=request.getParameter("password_1");
        String password_2=request.getParameter("password_2");
        String sex=request.getParameter("sex");
        UserDao userDao=new UserDao();
        User user=new User();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(username.length()==0||password_1.length()==0||password_2.length()==0){
                //System.out.print("lalalsldaldajfak");
                out.println("<h1 style='text-align:center'>用户名或密码不可以为空！</h1>");
                RequestDispatcher dsp=request.getRequestDispatcher("register.jsp");
                dsp.include(request, response);
            }
            else{
                if(!password_1.equals(password_2)){
                    out.println("<h1 style='text-align:center'>两次密码输入不同！</h1>");
                    RequestDispatcher dsp=request.getRequestDispatcher("register.jsp");
                    dsp.include(request, response);
            }
                else{
                    user.setUsername(username);
                    user.setPassword(password_1);
                    user.setSex(sex);
                    if(userDao.selectByUsername(user)==null){
                        userDao.insertUser(user);
                        Cookie cookie=new Cookie("username",URLEncoder.encode(username,"UTF-8"));
                        cookie.setMaxAge(1000);
                        response.addCookie(cookie);
                        response.sendRedirect("login.jsp");
                    }
                    else{
                        out.println("<h1 style='text-align:center'>该用户已经被注册了！</h1>");
                        RequestDispatcher dsp=request.getRequestDispatcher("register.jsp");
                        dsp.include(request, response);
                    }
                }
            }
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
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
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
