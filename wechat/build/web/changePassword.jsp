<%-- 
    Document   : changePassword
    Created on : 2017-12-19, 18:43:12
    Author     : 宣佚
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    String username=request.getParameter("username");
%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>WeChat-changePassword</title>
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
            #changePassword{
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
            #changePassword .header{
                height: 60px;
                font-size: 25px;
                font-weight:bold;
                margin-left: 50px;
                line-height:60px;
            }
           #changePassword .header span{
                color:#3366ff;
            }
            #changePassword .body{
                width: 500px;
            }
            #changePassword .body .body_in{
                margin: 0 auto;
                width: 400px;
                position:relative;
            }
            .password input,#changePassword .body .body_in .password input {
                width: 280px;
                border:0;
                outline: 0;
                font-size:20px;
                background: #ccecef;
            }
            #changePassword .body .body_in .password{
                padding: 15px 0 15px 15px;
                border-radius: 3px;
                border:1px solid #AAAAAA;
                margin:10px 0;
                background: #ccecef;
            }
            #changePassword .body .body_in .submit{
                width:400px;
                height:45px;
                border-radius: 3px;
                background: #2977f4;
                border: 1px solid #2977f4;
                color: #FFFFFF;
                font-size:18px;
                letter-spacing: 5px;
                font-weight: bold;
                position: absolute;
                right: 0;
                bottom:-60px;
                text-align: center;
            }
            #changePassword .bottom{
                margin: 80px auto;
                width:400px;
                border-top: 1px solid #DDDDDD;
            }
        </style>
    </head>
    <body>
        <div class="bg_pic" style="background:url(img/bg_3.jpg)"></div>
        <div class="bg_pic" style="background:url(img/bg_4.jpg)"></div>
        <div class="bg_pic" style="background:url(img/bg_5.jpg)"></div>
        <div class="bg_pic" style="background:url(img/bg_6.jpg)"></div>
        <div id="changePassword">
            <div class="header">
                更改<span>WeChat</span>登录密码
            </div> 
            <div class="body">
                <div class="body_in">
                    <form action="ChangePassword" method="post">
                        <div class="password">
                            <input type="password" name="password_old" placeholder="输入旧密码">
                        </div>
                        <div class="password">
                            <input  type="password" name="password_new1" placeholder="输入新密码" maxlength="15" minlength="6">
                        </div>
                        <div class="password">
                            <input  type="password" name="password_new2" placeholder="请再输入新密码" maxlength="15" minlength="6">
                        </div>
                        <input type="hidden" name="username" value=<%=username%> > 
                        <input type="submit" name="changePw" value="修改密码" class="submit">
                    </form>
                </div>
                 <div class="bottom">
                    <p><span>WeChat版本：默认版本</span></p>
                 </div>
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
