<%-- 
    Document   : ChatRoom
    Created on : 2017-12-9, 9:49:43
    Author     : 宣佚
--%>

<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.ArrayList,java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
    ServletContext servletContext = request.getServletContext();
    int online = 0;
    ArrayList user_online = (ArrayList) servletContext.getAttribute("user_online");
    String username = request.getParameter("username");
    if (user_online != null) {
        online = user_online.size();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ChatRoom</title>
        <style>
            *{
                padding:0;
                margin: 0;
            }
            body{
                background: url(img/bg_5.jpg);
            }
            #title{
                color: #ff0099;
                text-align: center;
            }
            #chatroom{
                width:800px;
                margin: 0 auto;
                height: 500px;
                border: 1px solid blue;
                border-radius: 3px;
                box-shadow: 10px 10px 5px #AAAAAA;
                position: relative;
            }
            #chatroom .chatContext{
                border-bottom: 2px solid #AAAAAA;
                height: 450px;
                overflow: auto;
            }
            #chatroom .chat_box{
                width: 400px;
                border:1px solid yellowgreen;
                border-radius: 3px;
                box-shadow: 3px 3px 2px #AAAAAA;
                word-wrap: break-word;
                margin-left: 30px;
            }
            #chatroom form{
                text-align: center;
            }
            #chatroom form .message{
                border: 1px solid #sAAAAAA;
                padding: 5px 0 5px 10px;
            }
            #chatroom form .reset{
                border:1px solid #AAAAAA ;
                background: #0033ff;
                opacity: 0.9;
                border-radius: 2px;
            }
            .user_box{
                border:1px solid #66ff33;
                width: 200px;
                float: left;
                margin-left: 30px;
                text-align: center;
            }
            #chatroom form .change{
                border:0;
                width:200px;
                height: 45px;
                color: #ff9900;
                font-size:18px;
                font-weight: bold;
                background: #EEEEEE;
                border-radius: 3px;
                opacity: 0.5;
                position: absolute;
                right: -250px;
                top:50px;
            }
            #chatroom form .delete,#chatroom form .exit{
                border:0;
                width:200px;
                height: 45px;
                color: #ff9900;
                font-size:18px;
                font-weight: bold;
                background: #EEEEEE;
                border-radius: 3px;
                opacity: 0.5;
            }
            #chatroom form .delete{
                position: absolute;
                right:-250px;
                top: 120px;
            }
            #chatroom form .exit{
                position: absolute;
                right:-250px;
                top: 190px;
            }
        </style>
    </head>
    <body>
        <h2 id="title">WeChat聊天室</h2>
        <p style="font-weight:bold;color:#ff9900">当前wechat聊天室的在线人数为：<span style="color:#ff6666;font-weight: bold"><%=online%></span></p>
        <p style="font-weight:bold;color:#ff9900">在线用户有如下：</p>
        <div class="user_box">
            <%
                for (int i = 0; i < user_online.size(); i++) {%>
            <span style="color:#66ffff;font-weight: bold"><%=user_online.get(i)%></span><br/>
            <% }
            %>
        </div>
        <p style="float:right;margin-right: 20px">欢迎<span style="color: #660066;font-weight: bold"><%=URLDecoder.decode(username, "UTF-8")%></span>来到wechat聊天室</p>
        <div id="chatroom">
            <div class="chatContext">
                <%
                    if (application.getAttribute("say") != null) {
                        ArrayList saywords = (ArrayList) application.getAttribute("say");
                        ArrayList user = (ArrayList) application.getAttribute("user");
                        for (int i = 0; i < saywords.size(); i++) {
                            if (user.get(i).equals(username)) {
                %>
                <span style="color: #660066;font-weight: bold;position: absolute;right: 10px;"><%=user.get(i)%></span><br/><div class="chat_box" style="margin-left:350px;"><%=saywords.get(i)%></div><br/>
                <%} else {%>
                <span style="color: #0000ff;font-weight: bold"><%=user.get(i)%></span><div class="chat_box"><%=saywords.get(i)%></div><br/><%}%>            

                <%}
                        }%>
            </div> 
            <form action="mysay.jsp" method="get"> 
                <input type="text"  class="message" name="mywords" placeholder="请输入您要发送的内容" autofocus required>
                <input type="hidden" name="username" value=<%=username%> />
                <input type="image" src="img/send.png" name="submit">
                <input type="reset" value="清空" class="reset">

            </form>
            <form action="changePassword.jsp" method="get">
                <input type="hidden" name="username" value=<%=username%> /> 
                <input type="submit" value="修改密码" name="change" class="change">
            </form>
                <form action="DeleteUser" method="get">
                    <input type="hidden" value=<%=username%> name="username">
                    <input type="submit" name="deleteUser" value="注销账户" class="exit">
                    <input type="submit" name="exitUser" value="退出系统" class="delete">
                </form>
        </div>

    </body>
</html>
