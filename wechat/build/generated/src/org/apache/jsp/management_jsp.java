package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.wechat.wechatDomain.PageBean;
import com.wechat.wechatService.UserException;
import com.wechat.wechatDomain.User;
import com.wechat.wechatService.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class management_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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

      out.write("\n");
      out.write("    <!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>managementRoom</title>\n");
      out.write("        <style>\n");
      out.write("             *{\n");
      out.write("                padding:0;\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                font-family:Microsoft YaHei,Segoe UI,Tahoma,Arial,Verdana,sans-serif;\n");
      out.write("                font-size:12px;\n");
      out.write("                color:#fff;\n");
      out.write("                height:100%;\n");
      out.write("                line-height:1;\n");
      out.write("                overflow: hidden;\n");
      out.write("            }\n");
      out.write("            header{\n");
      out.write("                width: 1366px;\n");
      out.write("                height: 97px;\n");
      out.write("                background: url(img/logo_bg1.png);\n");
      out.write("            }\n");
      out.write("            header .header_in{\n");
      out.write("                width:1300px;\n");
      out.write("                height: 60px;\n");
      out.write("                margin: 0 auto;\n");
      out.write("                border-bottom: 1px solid #AAAAAA;\n");
      out.write("            }\n");
      out.write("            header .header_in a{\n");
      out.write("                position: relative;\n");
      out.write("                top:10px;\n");
      out.write("                left: 10px;\n");
      out.write("            }\n");
      out.write("            header h1{\n");
      out.write("                display: inline;\n");
      out.write("            }\n");
      out.write("            #time{\n");
      out.write("                position: relative;\n");
      out.write("                left: 70px;\n");
      out.write("                font-size:13px;\n");
      out.write("            }\n");
      out.write("            header .header_in .welcome{\n");
      out.write("                display: inline;\n");
      out.write("                font-size: 15px;\n");
      out.write("                position: relative;\n");
      out.write("                left: 500px;\n");
      out.write("            }\n");
      out.write("            header .header_in .welcome a{\n");
      out.write("                margin-left: 10px;\n");
      out.write("                color:#FFFFFF;\n");
      out.write("                text-decoration: none;\n");
      out.write("                position: relative;\n");
      out.write("                top: -1px;\n");
      out.write("            }\n");
      out.write("            header .header_in .welcome a:hover{\n");
      out.write("                color:#ff00ff;\n");
      out.write("                text-decoration: underline;\n");
      out.write("            }\n");
      out.write("            header .header_in .welcome a img{\n");
      out.write("                position: relative;\n");
      out.write("                top:5px;\n");
      out.write("                right:8px;\n");
      out.write("            }\n");
      out.write("            header .header_in .exit{\n");
      out.write("                font-size: 16px;\n");
      out.write("                position: relative;\n");
      out.write("                left: 50px;\n");
      out.write("            }\n");
      out.write("            aside{\n");
      out.write("                height: 535px;\n");
      out.write("                width: 150px;\n");
      out.write("                border:1px solid #AAAAAA;\n");
      out.write("                margin-left: 10px;\n");
      out.write("            }\n");
      out.write("            aside .man{\n");
      out.write("                display: block;\n");
      out.write("                width: 100px;\n");
      out.write("                height: 100px;\n");
      out.write("                text-align: center;\n");
      out.write("                margin:0 auto;\n");
      out.write("                border-bottom: 1px solid #AAAAAA;\n");
      out.write("            }\n");
      out.write("            aside ul li{\n");
      out.write("                text-decoration: none;\n");
      out.write("                width: 150px;\n");
      out.write("                height: 60px;\n");
      out.write("                line-height: 60px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            aside ul li a{\n");
      out.write("                text-decoration: none;\n");
      out.write("                padding-bottom: 20px;\n");
      out.write("                color:#AAAAAA;\n");
      out.write("                font-size: 15px;\n");
      out.write("                letter-spacing:5px;\n");
      out.write("                border-bottom: 1px solid #AAAAAA;\n");
      out.write("            }\n");
      out.write("            aside ul li a:hover{\n");
      out.write("                color:#2977f4;\n");
      out.write("            }\n");
      out.write("            #body{\n");
      out.write("                width: 1000px;\n");
      out.write("                height: 510px;\n");
      out.write("                border: 1px solid #AAAAAA;\n");
      out.write("                position: absolute;\n");
      out.write("                top:100px;\n");
      out.write("                left: 250px;\n");
      out.write("                box-shadow: 10px 10px 5px #888888;\n");
      out.write("            }\n");
      out.write("            #body .body_reg{\n");
      out.write("                width:800px;\n");
      out.write("                height: 200px;\n");
      out.write("                border: #9999ff solid 1px;\n");
      out.write("                margin: 10px auto;\n");
      out.write("                border-radius: 3px;\n");
      out.write("            }\n");
      out.write("            #body .body_reg .body_reg_in{\n");
      out.write("                width: 280px;\n");
      out.write("                height: 100px;\n");
      out.write("                margin: 0 auto;\n");
      out.write("            }\n");
      out.write("            #body .body_reg .body_reg_in .text,#body .text{\n");
      out.write("                width: 280px;\n");
      out.write("                border:1px solid #AAAAAA;\n");
      out.write("                outline: 0;\n");
      out.write("                font-size:20px;\n");
      out.write("                background: rgba(255,255,255,0.5);\n");
      out.write("                padding: 5px 0 5px 10px;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("            }\n");
      out.write("            #body .body_reg .body_reg_in .add{\n");
      out.write("                width:200px;\n");
      out.write("                height:45px;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                background: #2977f4;\n");
      out.write("                border: 1px solid #2977f4;\n");
      out.write("                color: #FFFFFF;\n");
      out.write("                font-size:18px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                margin-left: 40px;\n");
      out.write("            }\n");
      out.write("            #body .body_title,#body .online_title,#body .user_title{\n");
      out.write("                text-align: center;\n");
      out.write("                color: #6699ff;\n");
      out.write("            }\n");
      out.write("            .error{\n");
      out.write("                text-align: center;\n");
      out.write("                color: #ff6666;\n");
      out.write("            }\n");
      out.write("            #body .body_reg .sex{\n");
      out.write("                color:#999999;\n");
      out.write("                position: relative;\n");
      out.write("                left: 70px;\n");
      out.write("                top: 5px;\n");
      out.write("                margin-left: 30px;\n");
      out.write("            }\n");
      out.write("            #online{\n");
      out.write("                color: #000000;\n");
      out.write("                border-color: #AAAAAA;\n");
      out.write("                font-size: 18px;\n");
      out.write("                margin: 20px auto;\n");
      out.write("                text-align: center;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                box-shadow: 5px 5px 2px #888888;\n");
      out.write("            }\n");
      out.write("            #online td,#online th{\n");
      out.write("                height: 30px;\n");
      out.write("                line-height: 30px;\n");
      out.write("            }\n");
      out.write("            #body .page{\n");
      out.write("                color: blue;\n");
      out.write("                font-size: 15px;\n");
      out.write("            }\n");
      out.write("            #body .page_p{\n");
      out.write("                position: relative;\n");
      out.write("                top:80px;\n");
      out.write("                left: 400px;\n");
      out.write("            }\n");
      out.write("            #body .select_btn{\n");
      out.write("                width: 100px;\n");
      out.write("                height: 35px;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                background: #2977f4;\n");
      out.write("                border: 1px solid #2977f4;\n");
      out.write("                color: #FFFFFF;\n");
      out.write("                font-size:15px;\n");
      out.write("                font-weight: bold; \n");
      out.write("            }\n");
      out.write("            #select{\n");
      out.write("                margin: 0 auto;\n");
      out.write("                position: relative;\n");
      out.write("                left: 100px;   \n");
      out.write("            }\n");
      out.write("            #body .update_text{\n");
      out.write("                border:0;\n");
      out.write("                height: 25px;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 15px;\n");
      out.write("            }\n");
      out.write("            #body .update,#body .delete{\n");
      out.write("                height: 25px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"jquery/jquery-1.11.3.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            onload=function(){\n");
      out.write("                var username,password,sex;\n");
      out.write("                var form=document.getElementById(\"form\");\n");
      out.write("                var exe_1='<input name=\"delete\" type=\"submit\" class=\"delete\" value=\"删除\"><input type=\"button\" name=\"update\" class=\"update\" value=\"修改\">';\n");
      out.write("                var exe_2='<input name=\"sure\" type=\"button\" class=\"sure\" value=\"修改\"><input type=\"button\" name=\"cancel\" class=\"cancel\" value=\"取消\">';\n");
      out.write("                var cancel=function(){\n");
      out.write("                    name_txt.text(username);\n");
      out.write("                    password_txt.text(password);\n");
      out.write("                    sex_txt.html(sex);\n");
      out.write("                    $(\".sure,.cancel\").remove();\n");
      out.write("                    $(\".func\").after(exe_1);\n");
      out.write("                    $(\".update\").click(function(e){\n");
      out.write("                        update(e);\n");
      out.write("                        });\n");
      out.write("                    $(\".delete\").click(function(){\n");
      out.write("                            if(!confirm(\"确认删除该用户？\")){\n");
      out.write("                                return false;\n");
      out.write("                            }\n");
      out.write("                    });\n");
      out.write("                };\n");
      out.write("                var sure=function(){\n");
      out.write("                    $(\".sure,.cancel\").remove();\n");
      out.write("                    $(\".func\").after(exe_1);\n");
      out.write("                    $(\".updateName\").val($(\".newName\").val());\n");
      out.write("                    $(\".updatePassword\").val($(\".newPassword\").val());\n");
      out.write("                    $(\".updateSex\").val($(\".newSex\").val());\n");
      out.write("                    $(\".xiugai\").val(\"修改\");\n");
      out.write("                    form.submit();\n");
      out.write("                    $(\".update\").click(function(e){\n");
      out.write("                        update(e);\n");
      out.write("                    });\n");
      out.write("                    $(\".delete\").click(function(){\n");
      out.write("                            if(!confirm(\"确认删除该用户？\")){\n");
      out.write("                                return false;\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                };\n");
      out.write("                var update=function(e){\n");
      out.write("                    name_txt=$(e.target).parents(\"td\").siblings().filter(\".oldName\");\n");
      out.write("                    password_txt=$(e.target).parents(\"td\").siblings().filter(\".oldPassword\");\n");
      out.write("                    sex_txt=$(e.target).parents(\"td\").siblings().filter(\".oldSex\");\n");
      out.write("                    username=name_txt.text();\n");
      out.write("                    password=password_txt.text();\n");
      out.write("                    sex=sex_txt.text();\n");
      out.write("                    name_txt.html('<input class=\"newName\" maxlength=\"10\" minlength=\"3\" size=\"6\" value='+username+\">\");\n");
      out.write("                    password_txt.html('<input class=\"newPassword\" maxlength=\"15\" minlength=\"6\" size=\"6\"  value='+password+\">\");\n");
      out.write("                    sex_txt.html('<input class=\"newSex\" maxlength=\"1\" minlength=\"1\" size=\"1\" value='+sex+\">\");\n");
      out.write("                    $(\".delete,.update\").remove();\n");
      out.write("                    $(\".func\").after(exe_2);\n");
      out.write("                    $(\".sure\").click(function(){\n");
      out.write("                        sure();\n");
      out.write("                    });\n");
      out.write("                    $(\".cancel\").click(function(){\n");
      out.write("                        cancel();\n");
      out.write("                    });\n");
      out.write("                };\n");
      out.write("                showTime();\n");
      out.write("                var fun=document.getElementsByClassName(\"fun\");\n");
      out.write("                for(var i=0;i<fun.length;i++){\n");
      out.write("                    fun[i].onclick=function(){\n");
      out.write("                         for(var j=0;j<fun.length;j++){\n");
      out.write("                            fun[j].style.color=\"#AAAAAA\";\n");
      out.write("                        }\n");
      out.write("                         this.style.color=\"#2977f4\";\n");
      out.write("                    };\n");
      out.write("            }\n");
      out.write("                $(\".update\").click(function(e){\n");
      out.write("                    update(e);\n");
      out.write("                });\n");
      out.write("              $(\".delete\").click(function(){\n");
      out.write("                  if(!confirm(\"确认删除该用户？\")){\n");
      out.write("                      return false;\n");
      out.write("                  }\n");
      out.write("              });  \n");
      out.write("            };\n");
      out.write("            function showTime(){\n");
      out.write("                var myDate = new Date();\n");
      out.write("                var year = myDate.getFullYear();\n");
      out.write("                var month = myDate.getMonth() + 1;\n");
      out.write("                var date = myDate.getDate();\n");
      out.write("                var dateArr = [\"日\",\"一\",'二','三','四','五','六'];\n");
      out.write("                var day = myDate.getDay();\n");
      out.write("                var hours = myDate.getHours();\n");
      out.write("                var minutes = formatTime(myDate.getMinutes());\n");
      out.write("                var seconds = formatTime(myDate.getSeconds());\n");
      out.write("//                var minutes=myDate.getMinutes();\n");
      out.write("//                var seconds=myDate.getSeconds();\n");
      out.write("                var systemTime = document.getElementById(\"time\");\n");
      out.write("                systemTime.innerHTML = \"今天是  \" + year + \"年\" + month +\"月\" + date + \"日&nbsp;&nbsp\" + \" 星期\" + dateArr[day] + \"&nbsp;&nbsp;&nbsp;&nbsp\" + hours + \":\" + minutes + \":\" + seconds;\n");
      out.write("//                console.log(\" \" + year + \"年\" + month +\"月\" + date + \"日\" + \" 星期\" + dateArr[day] + \" \" + hours + \":\" + minutes + \":\" + seconds);\n");
      out.write("                setTimeout(\"showTime()\",500);\n");
      out.write("            }\n");
      out.write("            function formatTime (i){\n");
      out.write("                if(i < 10){\n");
      out.write("                  i = \"0\" + i;\n");
      out.write("                }\n");
      out.write("                return i;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"header_in\">\n");
      out.write("                <h1>微信，一种生活方式</h1><a href=\"javascript:void(0)\"><img src=\"img/logo_1.png\"/></a>\n");
      out.write("                <span id=\"time\"></span>\n");
      out.write("                <p class=\"welcome\">欢迎管理员<a href=\"javascript:void(0)\"><img src=\"img/man_logo.png\" alt=\"logo\" width=\"30px\" height=\"30px\"><span>");
      out.print(name);
      out.write("</span><a href=\"ManagerExit?nameId=");
      out.print(nameId);
      out.write("\"class=\"exit\">退出</a></p>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <aside>\n");
      out.write("            <a href=\"javacript:void(0)\" class=\"man\"><img src=\"img/man.png\" alt=\"点击重新加载\"></a>\n");
      out.write("            <ul>\n");
      out.write("                <li class=\"aside_li\">\n");

                    if(fun==null||"1".equals(fun)){

      out.write("\n");
      out.write("    <a href=\"management.jsp?fun=1&nameId=");
      out.print(nameId);
      out.write("\" class=\"fun\" style=\"color:#2977f4\">添加用户</a>\n");

    }else{

      out.write("         \n");
      out.write("    <a href=\"management.jsp?fun=1&nameId=");
      out.print(nameId);
      out.write("\" class=\"fun\">添加用户</a>\n");

    }

      out.write("\n");
      out.write("                </li>\n");
      out.write("                <li class=\"aside_li\">\n");

                    if("2".equals(fun)){

      out.write("\n");
      out.write("    <a href=\"SelectAllUserByCondition?fun=2&nameId=");
      out.print(nameId);
      out.write("\" class=\"fun\" style=\"color:#2977f4\">用户列表</a>\n");

    }else{

      out.write("         \n");
      out.write("    <a href=\"SelectAllUserByCondition?fun=2&nameId=");
      out.print(nameId);
      out.write("\" class=\"fun\">用户列表</a>\n");

    }

      out.write("\n");
      out.write("                </li>\n");
      out.write("                <li class=\"aside_li\">\n");

                    if("3".equals(fun)){

      out.write("\n");
      out.write("    <a href=\"management.jsp?fun=3&nameId=");
      out.print(nameId);
      out.write("\" class=\"fun\" style=\"color:#2977f4\">在线用户</a>\n");

    }else{

      out.write("         \n");
      out.write("    <a href=\"management.jsp?fun=3&nameId=");
      out.print(nameId);
      out.write("\" class=\"fun\">在线用户</a>\n");

    }

      out.write("\n");
      out.write("                </li>\n");
      out.write("            </ul>   \n");
      out.write("        </aside>\n");
      out.write("<div id=\"body\">\n");

    if(fun==null||"1".equals(fun)){

      out.write("\n");
      out.write("    }\n");
      out.write("    <h1 class=\"body_title\">wechat用户录入</h1>\n");
      out.write("        <div class=\"body_reg\">\n");
      out.write("            <h2 class=\"error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("            <div class=\"body_reg_in\">\n");
      out.write("                <form action=\"ManageUserReg\" method=\"post\">\n");
      out.write("                    <input type=\"text\" name=\"username\" placeholder=\"用户名\" class=\"text\"><br/>\n");
      out.write("                    <input type=\"password\" name=\"password\"  placeholder=\"密码\" class=\"text\"><br/>\n");
      out.write("                    <label class=\"sex\"><input type=\"radio\" name=\"sex\" value=\"男\" checked><span>男</span></label>\n");
      out.write("                    <label class=\"sex\"><input type=\"radio\" name=\"sex\" value=\"女\"><span>女</span></label>\n");
      out.write("                    <input type=\"hidden\" name=\"nameId\" value=");
      out.print(nameId);
      out.write("> \n");
      out.write("                    <input type=\"submit\" name=\"reg\" value=\"录入\" class=\"add\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div> \n");
 
    }
    else if("2".equals(fun)){

      out.write("\n");
      out.write("<h1 class=\"user_title\">wechat用户统计</h1>\n");
      out.write("<h2 class=\"error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("<form  action=\"SelectAllUserByCondition\" method=\"get\" id=\"select\">\n");
      out.write("    <input type=\"text\" name=\"username\" class=\"text\" placeholder=\"你要查询的用户名称\">\n");
      out.write("    <input type=\"hidden\" name=\"nameId\" value=");
      out.print(nameId);
      out.write(">\n");
      out.write("    <input type=\"hidden\" name=\"pageNum\" value=1>\n");
      out.write("    <input type=\"submit\" name=\"selectByName\" value=\"查询\" class=\"select_btn\">\n");
      out.write("    <input type=\"text\" name=\"sex\" class=\"text\" placeholder=\"性别\" size=\"1\" maxlength=\"1\" style=\"width:50px;margin-left: 100px;\">\n");
      out.write("    <input type=\"submit\" name=\"selectBySex\" class=\"select_btn\" value=\"查询\">\n");
      out.write("</form>\n");
      out.write("    <table id=\"online\" border='1' width='700' cellspacing='0'>\n");
      out.write("    <tr>\n");
      out.write("        <th>用户编号</th>\n");
      out.write("        <th>用户名称</th>\n");
      out.write("        <th>用户密码</th>\n");
      out.write("        <th>用户性别</th>\n");
      out.write("        <th>操作</th>\n");
      out.write("    </tr>\n");

if(pageBeanSelect!=null){
    for(int i=0;i<num;i++){
      out.write("\n");
      out.write("        <tr>\n");
      out.write("                <td class=\"id\">");
      out.print(pageBeanSelect.getStartIndex()+i+1);
      out.write("</td>\n");
      out.write("                <td class=\"oldName\">");
      out.print(pageBeanSelect.getList().get(i).getUsername());
      out.write("</td>\n");
      out.write("                <td class=\"oldPassword\">");
      out.print(pageBeanSelect.getList().get(i).getPassword());
      out.write("</td>\n");
      out.write("                <td class=\"oldSex\">");
      out.print(pageBeanSelect.getList().get(i).getSex());
      out.write("</td>\n");
      out.write("                <td class=\"exe\">\n");
      out.write("                    <form action=\"ManageUpdateUser\" method=\"get\" id=\"form\">                \n");
      out.write("                            <input type=\"hidden\" name=\"name\" value=");
      out.print(pageBeanSelect.getList().get(i).getUsername());
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"nameId\" value=");
      out.print(nameId);
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=");
      out.print(delete);
      out.write(" value=\"查询\">\n");
      out.write("                            <input type=\"hidden\" name=\"username\" value=");
      out.print(username);
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"sex\" value=");
      out.print(sex);
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"updateName\" class=\"updateName\">\n");
      out.write("                            <input type=\"hidden\" name=\"updatePassword\"  class=\"updatePassword\">\n");
      out.write("                            <input type=\"hidden\" name=\"updateSex\"   class=\"updateSex\">\n");
      out.write("                            <input type=\"hidden\" name=\"pageNum\" value=");
      out.print(pageBeanSelect.getPageNum());
      out.write(">\n");
      out.write("                            <input type=\"hidden\" name=\"fun\" value=\"2\" class=\"func\">\n");
      out.write("                            <input type=\"hidden\" name=\"sure\" class=\"xiugai\" value=\"\">\n");
      out.write("                            <input type=\"submit\" value=\"删除\" class=\"delete\" name=\"delete\">\n");
      out.write("                            <input type=\"button\" value=\"修改\" class=\"update\" name=\"update\">\n");
      out.write("                    </form> \n");
      out.write("                </td>\n");
      out.write("        </tr>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("</table>\n");
      out.write("<p class=\"page_p\" >   \n");
        if(pageBeanSelect.getPageNum()>1){
      out.write("\n");
      out.write("<a  class=\"page\" href=\"SelectAllUserByCondition?pageNum=");
      out.print(1);
      out.write("&fun=2&nameId=");
      out.print(nameId);
      out.print(temp);
      out.write("\">首页</a>\n");
      out.write("        <a  class=\"page\" href=\"SelectAllUserByCondition?pageNum=");
      out.print(pageBeanSelect.getPageNum()-1);
      out.write("&fun=2&nameId=");
      out.print(nameId);
      out.print(temp);
      out.write("\">前一页</a>\n");
}
        for(int i=pageBeanSelect.getStart();i<pageBeanSelect.getPageNum();i++){
      out.write("\n");
      out.write("        <a  class=\"page\" href=\"SelectAllUserByCondition?pageNum=");
      out.print(i);
      out.write("&fun=2&nameId=");
      out.print(nameId);
      out.print(temp);
      out.write("\">第");
      out.print(i);
      out.write("页</a>\n");
}
      out.write("\n");
      out.write("<span class=\"page\">第");
      out.print(pageBeanSelect.getPageNum());
      out.write("页</span>\n");
       for(int i=pageBeanSelect.getPageNum()+1;i<=pageBeanSelect.getEnd();i++){
      out.write("\n");
      out.write("<a class=\"page\" href=\"SelectAllUserByCondition?pageNum=");
      out.print(i);
      out.write("&fun=2&nameId=");
      out.print(nameId);
      out.print(temp);
      out.write("\">第");
      out.print(i);
      out.write("页</a>\n");
}
if(pageBeanSelect.getPageNum()<pageBeanSelect.getTotalPage()){

      out.write("\n");
      out.write("<a   class=\"page\" href=\"SelectAllUserByCondition?pageNum=");
      out.print(pageBeanSelect.getPageNum()+1);
      out.write("&fun=2&nameId=");
      out.print(nameId);
      out.print(temp);
      out.write("\">下一页</a>\n");
      out.write("<a  class=\"page\" href=\"SelectAllUserByCondition?pageNum=");
      out.print(pageBeanSelect.getTotalPage());
      out.write("&fun=2&nameId=");
      out.print(nameId);
      out.print(temp);
      out.write("\">尾页</a>\n");
}
      out.write(" \n");
      out.write("</p>\n");
}
}
    else if("3".equals(fun)){

      out.write("\n");
      out.write("<h1 class=\"online_title\">wechat在线用户统计</h1><br/>\n");
      out.write("<h2 class=\"error\">");
      out.print(error_online);
      out.write("</h2>\n");
      out.write("<table id=\"online\" border='1' width='700' cellspacing='0'>\n");
      out.write("    <tr>\n");
      out.write("        <th>用户编号</th>\n");
      out.write("        <th>用户名称</th>\n");
      out.write("        <th>用户密码</th>\n");
      out.write("        <th>用户性别</th>\n");
      out.write("    </tr>\n");

    if(pageBean!=null){
    for(int i=0;i<online;i++){
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(pageBean.getStartIndex()+i+1);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(pageBean.getList().get(i).getUsername());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(pageBean.getList().get(i).getPassword());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(pageBean.getList().get(i).getSex());
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("</table>\n");
      out.write("<p class=\"page_p\" >   \n");
        if(pageBean.getPageNum()>1){
      out.write("\n");
      out.write("        <a  class=\"page\" href=\"management.jsp?pageNum=");
      out.print(1);
      out.write("&fun=3&nameId=");
      out.print(nameId);
      out.write("\">首页</a>\n");
      out.write("        <a  class=\"page\" href=\"management.jsp?pageNum=");
      out.print(pageNum-1);
      out.write("&fun=3&nameId=");
      out.print(nameId);
      out.write("\">前一页</a>\n");
}
        for(int i=pageBean.getStart();i<pageBean.getPageNum();i++){
      out.write("\n");
      out.write("        <a  class=\"page\" href=\"management.jsp?pageNum=");
      out.print(i);
      out.write("&fun=3&nameId=");
      out.print(nameId);
      out.write("\">第");
      out.print(i);
      out.write("页</a>\n");
}
      out.write("\n");
      out.write("<span class=\"page\">第");
      out.print(pageBean.getPageNum());
      out.write("页</span>\n");
       for(int i=pageBean.getPageNum()+1;i<=pageBean.getEnd();i++){
      out.write("\n");
      out.write("<a class=\"page\" href=\"management.jsp?pageNum=");
      out.print(i);
      out.write("&fun=3&nameId=");
      out.print(nameId);
      out.write("\">第");
      out.print(i);
      out.write("页</a>\n");
}
if(pageBean.getPageNum()<pageBean.getTotalPage()){

      out.write("\n");
      out.write("<a   class=\"page\" href=\"management.jsp?pageNum=");
      out.print(pageNum+1);
      out.write("&fun=3&nameId=");
      out.print(nameId);
      out.write("\">下一页</a>\n");
      out.write("<a  class=\"page\" href=\"management.jsp?pageNum=");
      out.print(pageBean.getTotalPage());
      out.write("&fun=3&nameId=");
      out.print(nameId);
      out.write("\">尾页</a>\n");
}
      out.write(" \n");
      out.write("</p>\n");
}
}
      out.write("\n");
      out.write("</div>            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
