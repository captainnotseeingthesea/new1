<%-- 
    Document   : management
    Created on : 2017-12-21, 20:40:04
    Author     : 宣佚
--%>

<%@page import="com.wechat.wechatDomain.PageBean"%>
<%@page import="com.wechat.wechatService.UserException"%>
<%@page import="com.wechat.wechatDomain.User"%>
<%@page import="com.wechat.wechatService.UserService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ServletContext servletContext=request.getServletContext();
    
    String nameId=request.getParameter("nameId");
    
    String name=(String)session.getAttribute(nameId);
    if(name==null){
        response.sendRedirect("managerLogin.jsp");
    }
    String fun=request.getParameter("fun");//功能调用号
    int  pageNum=1;//当前访问的在线用户的页面号
    if(request.getParameter("pageNum")!=null){
        pageNum=Integer.parseInt(request.getParameter("pageNum"));
    }    
    String error_online="";//错误提示
    int pageSize=5;//每页显示的用户数
    int online=0;//在线用户数
    int num=0;//查询到的用户数
//        User[] users=null;
    PageBean<User>pageBean=null;
    ArrayList user_online=(ArrayList) servletContext.getAttribute("user_online");
    UserService userService=new UserService();
    try{
    pageBean=userService.SelectUserOnline(user_online,pageNum,pageSize);
    if(pageBean!=null){
        online=pageBean.getList().size();        
    }
    }
    catch(UserException ex){
        error_online=ex.getMessage();
    }
    PageBean <User>pageBeanSelect=(PageBean)request.getAttribute("pageBean");
    if(pageBeanSelect!=null){
        num=pageBeanSelect.getList().size();        
    }
    String condition=(String)request.getAttribute("condition");
    String username=request.getParameter("username");
    String sex=request.getParameter("sex");
    String temp="";//查找标记
    String delete="";//删除返回标记
    if(condition!=null){
        if(condition.equals("user")){
            temp="&selectByName=查询&username="+username;
            delete="selectByName";
        }
        else if(condition.equals("sex")){
            temp="&selectBySex=查询&sex="+sex;
            delete="selectBySex";
        }
    }
%>
    <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>managementRoom</title>
        <style>
             *{
                padding:0;
                margin: 0;
            }
            body{
                font-family:Microsoft YaHei,Segoe UI,Tahoma,Arial,Verdana,sans-serif;
                font-size:12px;
                color:#fff;
                height:100%;
                line-height:1;
                overflow: hidden;
            }
            header{
                width: 1366px;
                height: 97px;
                background: url(img/logo_bg1.png);
            }
            header .header_in{
                width:1300px;
                height: 60px;
                margin: 0 auto;
                border-bottom: 1px solid #AAAAAA;
            }
            header .header_in a{
                position: relative;
                top:10px;
                left: 10px;
            }
            header h1{
                display: inline;
            }
            #time{
                position: relative;
                left: 70px;
                font-size:13px;
            }
            header .header_in .welcome{
                display: inline;
                font-size: 15px;
                position: relative;
                left: 500px;
            }
            header .header_in .welcome a{
                margin-left: 10px;
                color:#FFFFFF;
                text-decoration: none;
                position: relative;
                top: -1px;
            }
            header .header_in .welcome a:hover{
                color:#ff00ff;
                text-decoration: underline;
            }
            header .header_in .welcome a img{
                position: relative;
                top:5px;
                right:8px;
            }
            header .header_in .exit{
                font-size: 16px;
                position: relative;
                left: 50px;
            }
            aside{
                height: 535px;
                width: 150px;
                border:1px solid #AAAAAA;
                margin-left: 10px;
            }
            aside .man{
                display: block;
                width: 100px;
                height: 100px;
                text-align: center;
                margin:0 auto;
                border-bottom: 1px solid #AAAAAA;
            }
            aside ul li{
                text-decoration: none;
                width: 150px;
                height: 60px;
                line-height: 60px;
                text-align: center;
            }
            aside ul li a{
                text-decoration: none;
                padding-bottom: 20px;
                color:#AAAAAA;
                font-size: 15px;
                letter-spacing:5px;
                border-bottom: 1px solid #AAAAAA;
            }
            aside ul li a:hover{
                color:#2977f4;
            }
            #body{
                width: 1000px;
                height: 510px;
                border: 1px solid #AAAAAA;
                position: absolute;
                top:100px;
                left: 250px;
                box-shadow: 10px 10px 5px #888888;
            }
            #body .body_reg{
                width:800px;
                height: 200px;
                border: #9999ff solid 1px;
                margin: 10px auto;
                border-radius: 3px;
            }
            #body .body_reg .body_reg_in{
                width: 280px;
                height: 100px;
                margin: 0 auto;
            }
            #body .body_reg .body_reg_in .text,#body .text{
                width: 280px;
                border:1px solid #AAAAAA;
                outline: 0;
                font-size:20px;
                background: rgba(255,255,255,0.5);
                padding: 5px 0 5px 10px;
                border-radius: 3px;
                margin-top: 10px;
            }
            #body .body_reg .body_reg_in .add{
                width:200px;
                height:45px;
                border-radius: 3px;
                background: #2977f4;
                border: 1px solid #2977f4;
                color: #FFFFFF;
                font-size:18px;
                font-weight: bold;
                margin-top: 10px;
                margin-left: 40px;
            }
            #body .body_title,#body .online_title,#body .user_title{
                text-align: center;
                color: #6699ff;
            }
            .error{
                text-align: center;
                color: #ff6666;
            }
            #body .body_reg .sex{
                color:#999999;
                position: relative;
                left: 70px;
                top: 5px;
                margin-left: 30px;
            }
            #online{
                color: #000000;
                border-color: #AAAAAA;
                font-size: 18px;
                margin: 20px auto;
                text-align: center;
                border-radius: 3px;
                box-shadow: 5px 5px 2px #888888;
            }
            #online td,#online th{
                height: 30px;
                line-height: 30px;
            }
            #body .page{
                color: blue;
                font-size: 15px;
            }
            #body .page_p{
                position: relative;
                top:80px;
                left: 400px;
            }
            #body .select_btn{
                width: 100px;
                height: 35px;
                border-radius: 3px;
                background: #2977f4;
                border: 1px solid #2977f4;
                color: #FFFFFF;
                font-size:15px;
                font-weight: bold; 
            }
            #select{
                margin: 0 auto;
                position: relative;
                left: 100px;   
            }
            #body .update_text{
                border:0;
                height: 25px;
                text-align: center;
                font-size: 15px;
            }
            #body .update,#body .delete{
                height: 25px;
            }
        </style>
        <script src="jquery/jquery-1.11.3.min.js"></script>
        <script type="text/javascript">
            onload=function(){
                var username,password,sex;
                var exe_1='<input name="delete" type="submit" class="delete" value="删除"><input type="button" name="update" class="update" value="修改">';
                var exe_2='<input name="sure" type="button" class="sure" value="修改"><input type="button" name="cancel" class="cancel" value="取消">';
                var cancel=function(e){
                    name_txt.text(username);
                    password_txt.text(password);
                    sex_txt.html(sex);
                    $(e.target).siblings(".sure").remove();
                    $(e.target).siblings(".func").after(exe_1);
                    $(e.target).siblings(".update").click(function(e){
                        update(e);
                        });
                    $(e.target).siblings(".delete").click(function(){
                            if(!confirm("确认删除该用户？")){
                                return false;
                            }
                    });
                    $(e.target).remove();
                };
                var sure=function(e){
                    $(e.target).siblings(".sure,.cancel").remove();
                    $(e.target).siblings(".func").after(exe_1);
                    $(e.target).siblings(".updateName").val($(e.target).parents(".exe").siblings(".oldName").children(".newName").val());
                    $(e.target).siblings(".updatePassword").val($(e.target).parents(".exe").siblings(".oldPassword").children(".newPassword").val());
                    $(e.target).siblings(".updateSex").val($(e.target).parents(".exe").siblings(".oldSex").children(".newSex").val());
                    $(e.target).siblings(".xiugai").val("修改");
                    $(e.target).parents("#form").submit();
                    $(e.target).siblings(".update").click(function(e){
                        update(e);
                    });
                    $(e.target).siblings(".delete").click(function(){
                            if(!confirm("确认删除该用户？")){
                                return false;
                            }
                        });
                };
                var update=function(e){
                    name_txt=$(e.target).parents("td").siblings().filter(".oldName");
                    password_txt=$(e.target).parents("td").siblings().filter(".oldPassword");
                    sex_txt=$(e.target).parents("td").siblings().filter(".oldSex");
                    username=name_txt.text();
                    password=password_txt.text();
                    sex=sex_txt.text();
                    name_txt.html('<input class="newName" maxlength="10" minlength="3" size="6" value='+username+">");
                    password_txt.html('<input class="newPassword" maxlength="15" minlength="6" size="6"  value='+password+">");
                    sex_txt.html('<input class="newSex" maxlength="1" minlength="1" size="1" value='+sex+">");
                    $(e.target).siblings(".delete").remove();
                    $(e.target).siblings(".func").after(exe_2);
                    $(e.target).siblings(".sure").click(function(e){
                        sure(e);
                    });
                    $(e.target).siblings(".cancel").click(function(e){
                        cancel(e);
                    });
                    $(e.target).remove();
                };
                showTime();
                var fun=document.getElementsByClassName("fun");
                for(var i=0;i<fun.length;i++){
                    fun[i].onclick=function(){
                         for(var j=0;j<fun.length;j++){
                            fun[j].style.color="#AAAAAA";
                        }
                         this.style.color="#2977f4";
                    };
            }
                $(".update").click(function(e){
                    update(e);
                });
              $(".delete").click(function(){
                  if(!confirm("确认删除该用户？")){
                      return false;
                  }
              });  
            };
            function showTime(){
                var myDate = new Date();
                var year = myDate.getFullYear();
                var month = myDate.getMonth() + 1;
                var date = myDate.getDate();
                var dateArr = ["日","一",'二','三','四','五','六'];
                var day = myDate.getDay();
                var hours = myDate.getHours();
                var minutes = formatTime(myDate.getMinutes());
                var seconds = formatTime(myDate.getSeconds());
//                var minutes=myDate.getMinutes();
//                var seconds=myDate.getSeconds();
                var systemTime = document.getElementById("time");
                systemTime.innerHTML = "今天是  " + year + "年" + month +"月" + date + "日&nbsp;&nbsp" + " 星期" + dateArr[day] + "&nbsp;&nbsp;&nbsp;&nbsp" + hours + ":" + minutes + ":" + seconds;
//                console.log(" " + year + "年" + month +"月" + date + "日" + " 星期" + dateArr[day] + " " + hours + ":" + minutes + ":" + seconds);
                setTimeout("showTime()",500);
            }
            function formatTime (i){
                if(i < 10){
                  i = "0" + i;
                }
                return i;
            }
        </script>
    </head>
    <body>
        <header>
            <div class="header_in">
                <h1>微信，一种生活方式</h1><a href="javascript:void(0)"><img src="img/logo_1.png"/></a>
                <span id="time"></span>
                <p class="welcome">欢迎管理员<a href="javascript:void(0)"><img src="img/man_logo.png" alt="logo" width="30px" height="30px"><span><%=name%></span><a href="ManagerExit?nameId=<%=nameId%>"class="exit">退出</a></p>
            </div>
        </header>
        <aside>
            <a href="javacript:void(0)" class="man"><img src="img/man.png" alt="点击重新加载"></a>
            <ul>
                <li class="aside_li">
<%
                    if(fun==null||"1".equals(fun)){
%>
    <a href="management.jsp?fun=1&nameId=<%=nameId%>" class="fun" style="color:#2977f4">添加用户</a>
<%
    }else{
%>         
    <a href="management.jsp?fun=1&nameId=<%=nameId%>" class="fun">添加用户</a>
<%
    }
%>
                </li>
                <li class="aside_li">
<%
                    if("2".equals(fun)){
%>
    <a href="SelectAllUserByCondition?fun=2&nameId=<%=nameId%>" class="fun" style="color:#2977f4">用户列表</a>
<%
    }else{
%>         
    <a href="SelectAllUserByCondition?fun=2&nameId=<%=nameId%>" class="fun">用户列表</a>
<%
    }
%>
                </li>
                <li class="aside_li">
<%
                    if("3".equals(fun)){
%>
    <a href="management.jsp?fun=3&nameId=<%=nameId%>" class="fun" style="color:#2977f4">在线用户</a>
<%
    }else{
%>         
    <a href="management.jsp?fun=3&nameId=<%=nameId%>" class="fun">在线用户</a>
<%
    }
%>
                </li>
            </ul>   
        </aside>
<div id="body">
<%
    if(fun==null||"1".equals(fun)){
%>
    }
    <h1 class="body_title">wechat用户录入</h1>
        <div class="body_reg">
            <h2 class="error">${requestScope.error}</h2>
            <div class="body_reg_in">
                <form action="ManageUserReg" method="post">
                    <input type="text" name="username" placeholder="用户名" class="text"><br/>
                    <input type="password" name="password"  placeholder="密码" class="text"><br/>
                    <label class="sex"><input type="radio" name="sex" value="男" checked><span>男</span></label>
                    <label class="sex"><input type="radio" name="sex" value="女"><span>女</span></label>
                    <input type="hidden" name="nameId" value=<%=nameId%>> 
                    <input type="submit" name="reg" value="录入" class="add">
                </form>
            </div>
        </div> 
<% 
    }
    else if("2".equals(fun)){
%>
<h1 class="user_title">wechat用户统计</h1>
<h2 class="error">${requestScope.error}</h2>
<form  action="SelectAllUserByCondition" method="get" id="select">
    <input type="text" name="username" class="text" placeholder="你要查询的用户名称">
    <input type="hidden" name="nameId" value=<%=nameId%>>
    <input type="hidden" name="pageNum" value=1>
    <input type="submit" name="selectByName" value="查询" class="select_btn">
    <input type="text" name="sex" class="text" placeholder="性别" size="1" maxlength="1" style="width:50px;margin-left: 100px;">
    <input type="submit" name="selectBySex" class="select_btn" value="查询">
</form>
    <table id="online" border='1' width='700' cellspacing='0'>
    <tr>
        <th>用户编号</th>
        <th>用户名称</th>
        <th>用户密码</th>
        <th>用户性别</th>
        <th>操作</th>
    </tr>
<%
if(pageBeanSelect!=null){
    for(int i=0;i<num;i++){%>
        <tr>
                <td class="id"><%=pageBeanSelect.getStartIndex()+i+1%></td>
                <td class="oldName"><%=pageBeanSelect.getList().get(i).getUsername()%></td>
                <td class="oldPassword"><%=pageBeanSelect.getList().get(i).getPassword()%></td>
                <td class="oldSex"><%=pageBeanSelect.getList().get(i).getSex()%></td>
                <td class="exe">
                    <form action="ManageUpdateUser" method="get" id="form">                
                            <input type="hidden" name="name" value=<%=pageBeanSelect.getList().get(i).getUsername()%>>
                            <input type="hidden" name="nameId" value=<%=nameId%>>
                            <input type="hidden" name=<%=delete%> value="查询">
                            <input type="hidden" name="username" value=<%=username%>>
                            <input type="hidden" name="sex" value=<%=sex%>>
                            <input type="hidden" name="updateName" class="updateName">
                            <input type="hidden" name="updatePassword"  class="updatePassword">
                            <input type="hidden" name="updateSex"   class="updateSex">
                            <input type="hidden" name="pageNum" value=<%=pageBeanSelect.getPageNum()%>>
                            <input type="hidden" name="fun" value="2" class="func">
                            <input type="hidden" name="sure" class="xiugai" value="">
                            <input type="submit" value="删除" class="delete" name="delete">
                            <input type="button" value="修改" class="update" name="update">
                    </form> 
                </td>
        </tr>
    <%}%>
</table>
<p class="page_p" >   
<%        if(pageBeanSelect.getPageNum()>1){%>
<a  class="page" href="SelectAllUserByCondition?pageNum=<%=1%>&fun=2&nameId=<%=nameId%><%=temp%>">首页</a>
        <a  class="page" href="SelectAllUserByCondition?pageNum=<%=pageBeanSelect.getPageNum()-1%>&fun=2&nameId=<%=nameId%><%=temp%>">前一页</a>
<%}
        for(int i=pageBeanSelect.getStart();i<pageBeanSelect.getPageNum();i++){%>
        <a  class="page" href="SelectAllUserByCondition?pageNum=<%=i%>&fun=2&nameId=<%=nameId%><%=temp%>">第<%=i%>页</a>
<%}%>
<span class="page">第<%=pageBeanSelect.getPageNum()%>页</span>
<%       for(int i=pageBeanSelect.getPageNum()+1;i<=pageBeanSelect.getEnd();i++){%>
<a class="page" href="SelectAllUserByCondition?pageNum=<%=i%>&fun=2&nameId=<%=nameId%><%=temp%>">第<%=i%>页</a>
<%}
if(pageBeanSelect.getPageNum()<pageBeanSelect.getTotalPage()){
%>
<a   class="page" href="SelectAllUserByCondition?pageNum=<%=pageBeanSelect.getPageNum()+1%>&fun=2&nameId=<%=nameId%><%=temp%>">下一页</a>
<a  class="page" href="SelectAllUserByCondition?pageNum=<%=pageBeanSelect.getTotalPage()%>&fun=2&nameId=<%=nameId%><%=temp%>">尾页</a>
<%}%> 
</p>
<%}
}
    else if("3".equals(fun)){
%>
<h1 class="online_title">wechat在线用户统计</h1><br/>
<h2 class="error"><%=error_online%></h2>
<table id="online" border='1' width='700' cellspacing='0'>
    <tr>
        <th>用户编号</th>
        <th>用户名称</th>
        <th>用户密码</th>
        <th>用户性别</th>
    </tr>
<%
    if(pageBean!=null){
    for(int i=0;i<online;i++){%>
        <tr>
            <td><%=pageBean.getStartIndex()+i+1%></td>
            <td><%=pageBean.getList().get(i).getUsername()%></td>
            <td><%=pageBean.getList().get(i).getPassword()%></td>
            <td><%=pageBean.getList().get(i).getSex()%></td>
        </tr>
    <%}%>
</table>
<p class="page_p" >   
<%        if(pageBean.getPageNum()>1){%>
        <a  class="page" href="management.jsp?pageNum=<%=1%>&fun=3&nameId=<%=nameId%>">首页</a>
        <a  class="page" href="management.jsp?pageNum=<%=pageNum-1%>&fun=3&nameId=<%=nameId%>">前一页</a>
<%}
        for(int i=pageBean.getStart();i<pageBean.getPageNum();i++){%>
        <a  class="page" href="management.jsp?pageNum=<%=i%>&fun=3&nameId=<%=nameId%>">第<%=i%>页</a>
<%}%>
<span class="page">第<%=pageBean.getPageNum()%>页</span>
<%       for(int i=pageBean.getPageNum()+1;i<=pageBean.getEnd();i++){%>
<a class="page" href="management.jsp?pageNum=<%=i%>&fun=3&nameId=<%=nameId%>">第<%=i%>页</a>
<%}
if(pageBean.getPageNum()<pageBean.getTotalPage()){
%>
<a   class="page" href="management.jsp?pageNum=<%=pageNum+1%>&fun=3&nameId=<%=nameId%>">下一页</a>
<a  class="page" href="management.jsp?pageNum=<%=pageBean.getTotalPage()%>&fun=3&nameId=<%=nameId%>">尾页</a>
<%}%> 
</p>
<%}
}%>
</div>            
    </body>
</html>
