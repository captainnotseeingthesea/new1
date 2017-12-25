<%-- 
    Document   : register
    Created on : 2017-12-18, 19:43:33
    Author     : 宣佚
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>WeChat-register</title>
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
                height: 400px;
                position: absolute;
                left:400px;
                background: white;
                margin:100px auto;
                border:1px solid #AAAAAA;
                border-radius: 5px;
                box-shadow: 10px 10px 5px #AAAAAA;
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
                width:400px;
                height:45px;
                border-radius: 3px;
                background: #2977f4;
                border: 1px solid #2977f4;
                color: #FFFFFF;
                font-size:18px;
                font-weight: bold;
                margin-top: 10px;
                /*margin-left: 150px;*/
/*                position: absolute;
                right: 5px;
                top:70px;*/
            }
            #login .body .body_in form label{
                font-size: 13px;
                margin-right: 20px;
                position: relative;
                left: 150px;
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
                margin: 10px auto;
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
            a:hover{
                text-decoration: underline;
                color:#2977f4;
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
                注册<span>WeChat</span>免费聊天室帐号
            </div>
            <div class="body">
                <div class="body_in">
                    <form action="UserRegister" method="post">
                        <div class="text">
                            <input type="text" name="username" placeholder="帐号或手机号" maxlength="10" minlength="3">
                            <div class="houzhui">@WeChat</div>
                        </div> 
                        <div class="password">
                            <input type="password" name="password_1" placeholder="输入密码" maxlength="15" minlength="6">
                        </div>
                        <div class="password">
                            <input type="password" name="password_2" placeholder="请再输入密码" maxlength="15" minlength="6">
                        </div>
                        <label><input type="radio" name="sex" value="男" checked>男</label>
                        <label><input type="radio" name="sex" value="女">女</label>
                        <a href="login.jsp" style=" text-decoration: none;position: relative;right:-200px;">已有帐号，直接登录</a>
                        <input type="submit" name="submit" class="submit" value="注册">
                    </form>
                </div>
            </div>
            <div class="bottom">
                <p><span>WeChat版本：默认版本</span></a></p>
                <!--<a href="#" class="icon"><img alt="icon" src="img/wechat.png"></a>-->    
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
