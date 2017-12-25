/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechat.listener;

import java.util.ArrayList;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author 宣佚
 */
public class NewServletListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       ArrayList user_online=(ArrayList)se.getSession().getServletContext().getAttribute("user_online");
       ArrayList names=(ArrayList)se.getSession().getAttribute("lognames");
       //ArrayList name_sum=(ArrayList)se.getSession().getServletContext().getAttribute("")
       if(names!=null){
           for(int i=0;i<names.size();i++){
               for(int j=0;j<user_online.size();j++){
                   if(names.get(i).equals(user_online.get(j))){
                       user_online.remove(j);
                   }
               }
           }
       }
       se.getSession().getServletContext().setAttribute("user_online", user_online);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
