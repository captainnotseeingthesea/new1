package com.wechat.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.wechat.wechatDao.UserDao;
import com.wechat.wechatDomain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
/**
 *
 * @author 宣佚
 */
public class Login extends HttpServlet {

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
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession(true);
        ServletContext servletContext=request.getServletContext();
        boolean haslog=false;
        ArrayList user_online=new ArrayList();
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String remember=request.getParameter("remember");
        System.out.println(remember);
        User user=new User();
        UserDao userDao=new UserDao();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            if(username.length()==0||password.length()==0)
            {
            out.println("<h1 style='text-align:center'>用户名或密码不可以为空！</h1>");
            out.println("</body>");
            out.println("</html>");
            RequestDispatcher dsp=request.getRequestDispatcher("login.jsp");
            dsp.include(request, response);
            }
            else{
                user.setUsername(username);
                user.setPassword(password);
                try {
                    User user1=userDao.selectByUser(user);
                    if(user1==null){
                        out.println("<h1 style='text-align:center'>用户名或密码不正确！</h1>");
                        out.println("</body>");
                        out.println("</html>");
                        RequestDispatcher dsp=request.getRequestDispatcher("login.jsp");
                        dsp.include(request, response);
                    }
                    else{
                        ArrayList names=(ArrayList)session.getAttribute("lognames");
                        user_online=(ArrayList) servletContext.getAttribute("user_online");
                        if(user_online==null){
                            user_online=new ArrayList();
                            //System.out.println("李宣佚6666");
                            names=new ArrayList();
                            names.add(username);
                            user_online.add(username);
                            session.setAttribute("lognames", names);
                            servletContext.setAttribute("user_online",user_online);
                            haslog=true;
                            if("on".equals(remember)){
                                Cookie cookie=new Cookie("username",URLEncoder.encode(username,"UTF-8"));
                                cookie.setMaxAge(1000);
                                response.addCookie(cookie);
                            }
                            RequestDispatcher dsp=request.getRequestDispatcher("ChatRoom.jsp");
                            dsp.forward(request, response);
                        }
                else{
                    System.out.println(user_online.size());
                    for(int i=0;i<user_online.size();i++){
                        System.out.println(user_online.get(i));
                        if(user_online.get(i).equals(username)){
                            System.out.println("您已登录");
                            out.println("<h1 style='text-align:center'>您已成功登录，无需重复登录！</h1>");
                            out.println("</body>");
                            out.println("</html>"); 
                            RequestDispatcher dsp=request.getRequestDispatcher("ChatRoom.jsp");
                            dsp.forward(request, response);
                            haslog=true;
                            break;
                        }
                      }
                    }
                    if(haslog!=true){
                        if(names==null){
                            names=new ArrayList();
                        }
                        names.add(username);
                        user_online.add(username);
                        session.setAttribute("lognames",names);
                        servletContext.setAttribute("user_online", user_online);
                        if("on".equals(remember)){
                            Cookie cookie=new Cookie("username",URLEncoder.encode(username,"UTF-8"));
                            cookie.setMaxAge(1000);
                            response.addCookie(cookie);
                        }
                        
                        RequestDispatcher dsp=request.getRequestDispatcher("ChatRoom.jsp");
                        dsp.forward(request, response);
                    }
                }
                }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            out.flush();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
