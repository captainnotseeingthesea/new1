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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 宣佚
 */
public class DeleteUser extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        String temp=request.getParameter("deleteUser");
        HttpSession session=request.getSession(true);
        ServletContext servletContext=request.getServletContext();
        ArrayList names=(ArrayList)session.getAttribute("lognames");
        ArrayList user_online=(ArrayList) servletContext.getAttribute("user_online");
        User user=new User();
        user.setUsername(username);
        UserDao userDao=new UserDao();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(temp==null){
                if(names!=null){
                        for(int j=0;j<user_online.size();j++){
                            if(username.equals(user_online.get(j))){
                                user_online.remove(j);
                                break;
                             }
                        }
                        for(int j=0;j<names.size();j++){
                            if(username.equals(names.get(j))){
                                names.remove(j);
                                break;
                             }
                        }
                        session.setAttribute("lognames", names);
                        servletContext.setAttribute("user_online", user_online);
                }
                out.println("<h1 style='text-align:center'>用户成功退出！</h1>");
                RequestDispatcher dsp=request.getRequestDispatcher("login.jsp");
                dsp.include(request, response);
            }
            else{
                if(userDao.deleteUser(user)!=0){
                    out.println("<h1 style='text-align:center'>用户帐号注销成功！</h1>");
                    RequestDispatcher dsp=request.getRequestDispatcher("login.jsp");
                    dsp.include(request, response);
                }
                else{
                    out.println("<h1 style='text-align:center'>异常，用户帐号注销失败，请重试！</h1>");
                    RequestDispatcher dsp=request.getRequestDispatcher("chatroom.jsp");
                    dsp.include(request, response);
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
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
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
