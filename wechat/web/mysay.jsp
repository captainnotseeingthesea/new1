<%-- 
    Document   : mysay
    Created on : 2017-12-9, 17:01:44
    Author     : 宣佚
--%>

<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    request.setCharacterEncoding("UTF-8");
    String username=new String(request.getParameter("username"));
    String mywords=new String(request.getParameter("mywords"));
    ArrayList say=new ArrayList();
    ArrayList user=new ArrayList();
    if(application.getAttribute("say")==null){
        application.setAttribute("say", say);
        application.setAttribute("user", user);
    }
    user=(ArrayList)application.getAttribute("user");
    say=(ArrayList)application.getAttribute("say");
    user.add(username);
    say.add(mywords);
    application.setAttribute("say",say);
    application.setAttribute("user", user);
    response.sendRedirect("ChatRoom.jsp?username="+URLEncoder.encode(username,"UTF-8"));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MySay</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
