/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechat.servlet;

import com.wechat.wechatDomain.Manager;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author 宣佚
 */
public class ManagerLog extends HttpServlet {

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
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String verifiCode=request.getParameter("verifiCode");
        ManagerService managerLogin=new ManagerService();
        HttpSession session=request.getSession(true);
        Manager manager=new Manager();
        String remember=request.getParameter("remember");
        manager.setName(name);
        manager.setPassword(password);
        String id=request.getParameter("id");
        String online=(String) session.getAttribute("online");
        int count;
        if(online==null){
            count=0;
        }
        else{
            count=Integer.parseInt(online);
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Manager _manager=managerLogin.login(manager);
            if(name.length()==0){
                request.setAttribute("error","用户名不可以为空！");
                request.getRequestDispatcher("managerLogin.jsp").forward(request, response);
            }
            else{
                if(password.length()==0){
                    request.setAttribute("error","密码不可以为空！");
                    request.getRequestDispatcher("managerLogin.jsp").forward(request, response);
                }
                else{
                    if(verifiCode.length()==0){
                        request.setAttribute("error","验证码不可以为空！");
                        request.getRequestDispatcher("managerLogin.jsp").forward(request, response);
                    }
                    else{
                        if(verifiCode.toLowerCase().equals(((String)session.getAttribute(id)).toLowerCase()))
                        {
                            if(_manager==null){
                                request.setAttribute("error","用户名或密码错误，请重试！");
                                request.getRequestDispatcher("managerLogin.jsp").forward(request, response);
            }
                            else{
                                int temp=count++;
                                int i=0;
                                session.setAttribute("online", count+"");
                                if("on".equals(remember)){
                                    Cookie cookie=new Cookie("name",URLEncoder.encode(name,"UTF-8"));
                                    cookie.setMaxAge(1000);
                                    response.addCookie(cookie);
                                }
                                for(;i<temp;i++){
                                    if(session.getAttribute("name"+i)!=null){
                                        if(session.getAttribute("name"+i).equals(name)){
                                            break;
                                        }
                                    }
                                }
                                if(i==temp){
                                    for(i=0;i<temp;i++){
                                        if(session.getAttribute("name"+i)==null){
                                            break;
                                        } 
                                    }
                                    if(i==temp){
                                        i++;
                                    }
                                }
                                
                                session.setAttribute("name"+i, name);
                                response.sendRedirect("management.jsp?nameId=name"+i);
                            }
                        }
                        else{
                            request.setAttribute("error","验证码错误，请重试！");
                            request.getRequestDispatcher("managerLogin.jsp").forward(request, response);
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
            Logger.getLogger(ManagerLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerLog.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManagerLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerLog.class.getName()).log(Level.SEVERE, null, ex);
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
