<%-- 
    Document   : managerRegister
    Created on : 2017-12-21, 19:33:48
    Author     : 宣佚
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>managerRegister</title>
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

            #register{
                width: 500px;
                height: 280px;
                background: url(img/login.png) no-repeat;
                background-position: -70px -150px;
                padding: 20px;
                margin: 150px auto;
/*              background-color: rgba(9,6,6,0.2);*/ 
            }
            #register .register_head{
                text-align: center;
                font-size: 15px;
            }
            #register .body{
                margin:20px auto;
                
            }
            #register .body form .text{
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
            #register .body form span{
                font-size: 14px;
            }
            #register .body form .reg{
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
            #register .body form a{
                text-decoration: none;
                color:#FFFFFF;
                font-size: 14px;
                margin-left: 180px;
            }
            #register .body form a:hover{
                color:#6797ef;
                text-decoration: underline;
            }
            #register .body form a{
                position: relative;
                left:150px;
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
</script>

    </head>
    <body>
        <h1 style='text-align:center;color: #66ffff;'>${requestScope.error}</h1>
        <div id="register">
            <div class="register_head">
                <h2 class="title">WeChat聊天系统后台注册</h2>
            </div>
            <div class="body">
                <form action="ManagerRegister" method="post">
                    <span>管理员帐号：</span><input type="text"  name="name" maxlength="10" minlength="3" class="text"><br/>
                    <span style="margin-left:40px;">密码：</span><input type="password"  name="password_1" maxlength="15" minlength="6" class="text"><br/>
                    <span style="margin-left:15px;">确认密码：</span><input type="password" class="text" name="password_2" maxlength="15" minlength="6">
                    <a href="managerLogin.jsp">已有帐号，直接登录</a>
                    <input type="submit" name="reg" class="reg" value="注册">
                </form>
            </div>
        </div>
        <div class="screenbg">
	<ul>
		<li><a href="javascript:;"><img src="img/bg_7.jpg"></a></li>
		<li><a href="javascript:;"><img src="img/bg_9.jpg"></a></li>
		<li><a href="javascript:;"><img src="img/bg_10.jpg"></a></li>
	</ul>
</div>

    </body>
</html>

