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
public class ChangePassword extends HttpServlet {

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
        String username=request.getParameter("username");
        String password_old=request.getParameter("password_old");
        String password_new1=request.getParameter("password_new1");
        String password_new2=request.getParameter("password_new2");
        User user=new User();
        UserDao userDao=new UserDao();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            user.setUsername(username);
            user.setPassword(password_old);
            if(userDao.selectByUser(user)==null){
                out.println("<h1 style='text-align:center'>旧密码不正确！</h1>");
                RequestDispatcher dsp=request.getRequestDispatcher("changePassword.jsp");
                dsp.include(request, response);
            }
            else{
                if(password_new1.length()==0||password_new2.length()==0){
                    out.println("<h1 style='text-align:center'>新密码不可以为空！</h1>");
                    RequestDispatcher dsp=request.getRequestDispatcher("changePassword.jsp");
                    dsp.include(request, response);
                }
                else{
                    if(!password_new1.equals(password_new2)){
                        out.println("<h1 style='text-align:center'>两次新密码不一致!</h1>");
                        RequestDispatcher dsp=request.getRequestDispatcher("changePassword.jsp");
                        dsp.include(request, response);
                    }
                    else{
                        user.setUsername(username);
                        user.setPassword(password_new1);
                        if(userDao.updataUserPassword(user)!=0){
                            out.println("<h1 style='text-align:center'>密码修改成功！</h1>");
                            Cookie cookie=new Cookie("username",URLEncoder.encode(username,"UTF-8"));
                            cookie.setMaxAge(1000);
                            response.addCookie(cookie);
                            response.sendRedirect("login.jsp");
                        }
                        else{
                            out.println("<h1 style='text-align:center'>异常，密码修改失败，请重试！</h1>");
                            RequestDispatcher dsp=request.getRequestDispatcher("changePassword.jsp");
                            dsp.include(request, response);
                        }
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
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
