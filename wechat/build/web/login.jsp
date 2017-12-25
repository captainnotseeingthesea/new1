<%-- 
    Document   : login
    Created on : 2017-12-9, 9:19:59
    Author     : 宣佚
--%>

<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    Cookie cookies[]=request.getCookies();
    String username="";
    if(cookies!=null){
        System.out.print("123");
        for(Cookie c:cookies){
            System.out.println(c.getName());
            if(c.getName().equals("username")){
                username=URLDecoder.decode(c.getValue(), "UTF-8");
                System.out.println(username);
            }
        }
    }
%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>WeChat-login</title>
<style>
            *{
                padding: 0;
                margin: 0;
            }
            body{
                color:#555555;
                font-size:12px;
                font-family: verdana;
                /*background: url(img/bg_4.jpg);*/
            }
            .bg_pic{
                height:100%;
                width:100%;
                position: absolute;
                z-index: -1;
                top:0;
            }
            #login{
                width: 500px;
                height: 380px;
                position: absolute;
                left:400px;
                background: white;
                margin:100px auto;
                border:1px solid #AAAAAA;
                border-radius: 5px;
                box-shadow: 10px 10px 5px #AAAAAA;
                /*display:none;*/
            }
            #login .header{
                height: 60px;
                font-size: 25px;
                font-weight:bold;
                margin-left: 50px;
                line-height:60px;
            }
            #login .header span{
                color:#3366ff;
            }
            #login .body{
                width: 500px;
            }
            #login .body .body_in{
                margin: 0 auto;
                width: 400px;
                position:relative;
            }
            #login .body .body_in .text input,.password input{
                width: 280px;
                border:0;
                outline: 0;
                font-size:20px;
                background: #ccecef;
            }
            #login .body .body_in .houzhui{
                height:53px;
                width:100px;
                font-size: 17px;
                font-weight: bold;
                line-height: 55px;
                background: #FFFFFF;
                position: absolute;
                top:1px;
                right: 1px;
            }
            #login .body .body_in .text,.password{
                padding: 15px 0 15px 15px;
                border-radius: 3px;
                border:1px solid #AAAAAA;
                margin:10px 0;
                background: #ccecef;
            }
            #login .body .body_in .submit{
                width:100px;
                height:45px;
                border-radius: 3px;
                background: #2977f4;
                border: 1px solid #2977f4;
                color: #FFFFFF;
                font-size:18px;
                font-weight: bold;
                position: absolute;
                right: 5px;
                top:70px;
            }
            #login .body .body_in .body_bottom{
                margin-top: 15px;
            }
            #login .body .body_in .body_bottom span{
                margin-right:80px;
            }
            #login .body .body_in .body_bottom a{
                text-decoration: none;
                color:#555555;  
            }
            #login .body .body_in .body_bottom a:hover{
                color:#6797ef;
            }
            #login .bottom{
                margin: 20px auto;
                width:400px;
                border-top: 1px solid #DDDDDD;
            }
            #login .bottom p{
                margin-top: 15px;   
            }
            #login .bottom p a{
                color:#2977f4;
                text-decoration: none;
                margin-left:100px;
            }
            #login .bottom p a:hover{
                text-decoration: underline;
            }
            #login .bottom .icon{
                display: block;
                margin-top: 30px;
            }
        </style>
    </head>
    <body>
        <div class="bg_pic" style="background:url(img/bg_3.jpg)"></div>
        <div class="bg_pic" style="background:url(img/bg_4.jpg)"></div>
        <div class="bg_pic" style="background:url(img/bg_5.jpg)"></div>
        <div class="bg_pic" style="background:url(img/bg_6.jpg)"></div>
        <div id="login"> 
            <div class="header">
                登录<span>WeChat</span>免费聊天室
            </div>
            <div class="body">
                <div class="body_in">
                    <form action="Login" method="post">
                        <div class="text">
                            <input type="text" name="username" placeholder="帐号或手机号" value=<%=username%>>
                            <div class="houzhui">@WeChat</div>
                        </div> 
                        <div class="password">
                            <input type="password" name="password" placeholder="密码">
                        </div>
                        <input type="submit" name="submit" class="submit" value="登录">
                        <div class="body_bottom">
                            <label><input type="checkbox" name="remember" value="on"><span>记住帐号</span></label> 
                            <label><input type="checkbox" name="ssl"><span>SSL安全登陆</span></label>
                            <a href="">忘记密码</a>
                        </div>
                    </form>
                </div>
            </div>
            <div class="bottom">
                <p><span>WeChat版本：默认版本</span><a href="register.jsp">注册WeChat免费帐号</a></p>
                <a href="#" class="icon"><img alt="icon" src="img/wechat.png"></a>    
            </div>
        </div>
        <script type="text/javascript">
            var bg_box=document.getElementsByClassName("bg_pic");
            var j=0;
            var timer=setInterval(function(){
                for(var i=0;i<bg_box.length;i++){
                bg_box[i].style.display="none";
            }
                console.log("1111");
                bg_box[(j++)%bg_box.length].style.display="block";
            },2000);
        </script>
    </body>
</html>
