<%-- 
    Document   : managerLogin
    Created on : 2017-12-20, 9:14:51
    Author     : 宣佚
--%>

<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id;
    if(session.getAttribute("id")!=null){
        id= Integer.parseInt(session.getAttribute("id").toString());
        id++;
        session.setAttribute("id",id+"");
    }
    else{
        id=1;
        session.setAttribute("id",id+"");
    }
    Cookie cookies[]=request.getCookies();
    String name="";
    if(cookies!=null){
        for(Cookie c:cookies){
            System.out.println(c.getName());
            if(c.getName().equals("name")){
                name=URLDecoder.decode(c.getValue(), "UTF-8");
            }
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>managerLogin</title>
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
                background:#999;
            }

            #login{
                width: 500px;
                height: 280px;
                background: url(img/login.png) no-repeat;
                background-position: -70px -150px;
                padding: 20px;
                margin: 150px auto;
/*              background-color: rgba(9,6,6,0.2);*/ 
            }
            #login .login_head{
                text-align: center;
                font-size: 15px;
            }
            #login .body{
                margin:20px auto;
                
            }
            #login .body form .text{
/*                border:1px solid */
                width: 280px;
                border:0;
                outline: 0;
                font-size:20px;
                background: rgba(255,255,255,0.5);
                padding: 5px 0 5px 10px;
                border-radius: 3px;
                margin-top: 10px;
            }
            #login .body form .verifiCode{
                width: 150px;
                border: 0;
                outline: 0;
                font-size:20px;
                background: rgba(255,255,255,0.5);
                padding: 5px 0 5px 10px;
                border-radius: 3px;
                margin: 5px 0 0 10px;
            }
            #login .body form label{
                margin-left:50px;
            }
            #login .body form span{
                font-size: 14px;
            }
            #login .body form .Login{
                width:200px;
                height:45px;
                border-radius: 3px;
                background: #2977f4;
                border: 1px solid #2977f4;
                color: #FFFFFF;
                font-size:18px;
                font-weight: bold;
                margin-left: 130px;
            }
            #login .body form a{
                text-decoration: none;
                color:#FFFFFF;
                font-size: 14px;
                margin-left: 180px;
            }
            #login .body form a:hover{
                color:#6797ef;
                text-decoration: underline;
            }
            .screenbg{
                position:fixed;
                bottom:0;
                left:0;
                z-index:-999;
                overflow:hidden;
                width:100%;
                height:100%;
                min-height:100%;
            }  
            .screenbg ul li{
                display:block;
                list-style:none;
                position:fixed;
                overflow:hidden;
                top:0;
                left:0;
                width:100%;
                height:100%;
                z-index:-1000;
                float:right;
            }
            .screenbg ul a{
                left:0;
                top:0;
                width:100%;
                height:100%;
                display:inline-block;
                margin:0;
                padding:0;
                cursor:default;
            }
            .screenbg a img{
                vertical-align:middle;
                display:inline;
                border:none;
                display:block;
                list-style:none;
                position:fixed;
                overflow:hidden;
                top:0;left:0;
                width:100%;
                height:100%;
                z-index:-1000;
                float:right;
            }
            #validateCodeImg{
                border-radius: 3px;
                border: 1px solid yellow;
                height: 30px;
                /*display: inline;*/
                vertical-align: central;
                position: relative;
                top:10px;
            }
        </style>
        <script type="text/javascript" src="jquery/jquery-1.11.3.min.js"></script>
        <script type="text/javascript">
        $(function(){
                $(".screenbg ul li").each(function(){
                        $(this).css("opacity","0");
                });
                $(".screenbg ul li:first").css("opacity","1");
                var index = 0;
                var t;
                var li = $(".screenbg ul li");	
                var number = li.size();
                function change(index){
                        li.css("visibility","visible");
                        li.eq(index).siblings().animate({opacity:0},3000);
                        li.eq(index).animate({opacity:1},3000);
                }
                function show(){
                        index = index + 1;
                        if(index<=number-1){
                                change(index);
                        }else{
                                index = 0;
                                change(index);
                        }
                }
                t = setInterval(show,8000);
                //根据窗口宽度生成图片宽度
                var width = $(window).width();
                $(".screenbg ul img").css("width",width+"px");
        });
        function changeImg(){
            document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/DrawImage?"+Math.random();
    }
//        function login(){
//            var login=document.getElementById("login");
//            var register=document.getElementById("register");
//            login.style.display="block";
//            register.style.display="none";
//    }
//        function register(){
//            var login=document.getElementById("login");
//            var register=document.getElementById("register");
//            login.style.display="none";
//            register.style.display="block";
//    }
</script>

    </head>
    <body>
        <h1 style='text-align:center;color: #66ffff;'>${requestScope.error}</h1>
        <div id="login">
            <div class="login_head">
                <h2 class="title">WeChat聊天系统后台登录</h2>
            </div>
            <div class="body">
                <form action="ManagerLog" method="post">
                    <span>管理员帐号：</span><input type="text"  name="name" maxlength="10" minlength="3" class="text" value=<%=name%>><br/>
                    <span style="margin-left:40px;">密码：</span><input type="password"  name="password" maxlength="15" minlength="6" class="text"><br/>
                    <span style="margin-left:15px;">验证码：</span><input type="text" class="verifiCode" name="verifiCode" size="4">
                    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/DrawImage" id="validateCodeImg" onclick="changeImg()">
                    <a href="javascript:void(0)" onclick="changeImg()" style="margin: 0">看不清，换一张</a>
                    <label><input type="checkbox" value="on" name="remember"><span>记住帐号</span></label>
                    <a href="managerRegister.jsp">没有管理员帐号?</a>
                    <input type="hidden" value=<%=id%> name="id">
                    <input type="submit" name="login" class="Login" value="登录">
                </form>
            </div>
        </div>
        <div class="screenbg">
	<ul>
		<li><a href="javascript:;"><img src="img/bg_7.jpg"></a></li>
		<li><a href="javascript:;"><img src="img/bg_8.jpg"></a></li>
		<li><a href="javascript:;"><img src="img/bg_9.jpg"></a></li>
	</ul>
</div>

    </body>
</html>
