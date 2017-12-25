package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLDecoder;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>WeChat-login</title>\n");
      out.write("<style>\n");
      out.write("            *{\n");
      out.write("                padding: 0;\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                color:#555555;\n");
      out.write("                font-size:12px;\n");
      out.write("                font-family: verdana;\n");
      out.write("                /*background: url(img/bg_4.jpg);*/\n");
      out.write("            }\n");
      out.write("            .bg_pic{\n");
      out.write("                height:100%;\n");
      out.write("                width:100%;\n");
      out.write("                position: absolute;\n");
      out.write("                z-index: -1;\n");
      out.write("                top:0;\n");
      out.write("            }\n");
      out.write("            #login{\n");
      out.write("                width: 500px;\n");
      out.write("                height: 380px;\n");
      out.write("                position: absolute;\n");
      out.write("                left:400px;\n");
      out.write("                background: white;\n");
      out.write("                margin:100px auto;\n");
      out.write("                border:1px solid #AAAAAA;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-shadow: 10px 10px 5px #AAAAAA;\n");
      out.write("                /*display:none;*/\n");
      out.write("            }\n");
      out.write("            #login .header{\n");
      out.write("                height: 60px;\n");
      out.write("                font-size: 25px;\n");
      out.write("                font-weight:bold;\n");
      out.write("                margin-left: 50px;\n");
      out.write("                line-height:60px;\n");
      out.write("            }\n");
      out.write("            #login .header span{\n");
      out.write("                color:#3366ff;\n");
      out.write("            }\n");
      out.write("            #login .body{\n");
      out.write("                width: 500px;\n");
      out.write("            }\n");
      out.write("            #login .body .body_in{\n");
      out.write("                margin: 0 auto;\n");
      out.write("                width: 400px;\n");
      out.write("                position:relative;\n");
      out.write("            }\n");
      out.write("            #login .body .body_in .text input,.password input{\n");
      out.write("                width: 280px;\n");
      out.write("                border:0;\n");
      out.write("                outline: 0;\n");
      out.write("                font-size:20px;\n");
      out.write("                background: #ccecef;\n");
      out.write("            }\n");
      out.write("            #login .body .body_in .houzhui{\n");
      out.write("                height:53px;\n");
      out.write("                width:100px;\n");
      out.write("                font-size: 17px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                line-height: 55px;\n");
      out.write("                background: #FFFFFF;\n");
      out.write("                position: absolute;\n");
      out.write("                top:1px;\n");
      out.write("                right: 1px;\n");
      out.write("            }\n");
      out.write("            #login .body .body_in .text,.password{\n");
      out.write("                padding: 15px 0 15px 15px;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                border:1px solid #AAAAAA;\n");
      out.write("                margin:10px 0;\n");
      out.write("                background: #ccecef;\n");
      out.write("            }\n");
      out.write("            #login .body .body_in .submit{\n");
      out.write("                width:100px;\n");
      out.write("                height:45px;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                background: #2977f4;\n");
      out.write("                border: 1px solid #2977f4;\n");
      out.write("                color: #FFFFFF;\n");
      out.write("                font-size:18px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                position: absolute;\n");
      out.write("                right: 5px;\n");
      out.write("                top:70px;\n");
      out.write("            }\n");
      out.write("            #login .body .body_in .body_bottom{\n");
      out.write("                margin-top: 15px;\n");
      out.write("            }\n");
      out.write("            #login .body .body_in .body_bottom span{\n");
      out.write("                margin-right:80px;\n");
      out.write("            }\n");
      out.write("            #login .body .body_in .body_bottom a{\n");
      out.write("                text-decoration: none;\n");
      out.write("                color:#555555;  \n");
      out.write("            }\n");
      out.write("            #login .body .body_in .body_bottom a:hover{\n");
      out.write("                color:#6797ef;\n");
      out.write("            }\n");
      out.write("            #login .bottom{\n");
      out.write("                margin: 20px auto;\n");
      out.write("                width:400px;\n");
      out.write("                border-top: 1px solid #DDDDDD;\n");
      out.write("            }\n");
      out.write("            #login .bottom p{\n");
      out.write("                margin-top: 15px;   \n");
      out.write("            }\n");
      out.write("            #login .bottom p a{\n");
      out.write("                color:#2977f4;\n");
      out.write("                text-decoration: none;\n");
      out.write("                margin-left:100px;\n");
      out.write("            }\n");
      out.write("            #login .bottom p a:hover{\n");
      out.write("                text-decoration: underline;\n");
      out.write("            }\n");
      out.write("            #login .bottom .icon{\n");
      out.write("                display: block;\n");
      out.write("                margin-top: 30px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"bg_pic\" style=\"background:url(img/bg_3.jpg)\"></div>\n");
      out.write("        <div class=\"bg_pic\" style=\"background:url(img/bg_4.jpg)\"></div>\n");
      out.write("        <div class=\"bg_pic\" style=\"background:url(img/bg_5.jpg)\"></div>\n");
      out.write("        <div class=\"bg_pic\" style=\"background:url(img/bg_6.jpg)\"></div>\n");
      out.write("        <div id=\"login\"> \n");
      out.write("            <div class=\"header\">\n");
      out.write("                登录<span>WeChat</span>免费聊天室\n");
      out.write("            </div>\n");
      out.write("            <div class=\"body\">\n");
      out.write("                <div class=\"body_in\">\n");
      out.write("                    <form action=\"Login\" method=\"post\">\n");
      out.write("                        <div class=\"text\">\n");
      out.write("                            <input type=\"text\" name=\"username\" placeholder=\"帐号或手机号\" value=");
      out.print(username);
      out.write(">\n");
      out.write("                            <div class=\"houzhui\">@WeChat</div>\n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"password\">\n");
      out.write("                            <input type=\"password\" name=\"password\" placeholder=\"密码\">\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"submit\" name=\"submit\" class=\"submit\" value=\"登录\">\n");
      out.write("                        <div class=\"body_bottom\">\n");
      out.write("                            <label><input type=\"checkbox\" name=\"remember\" value=\"on\"><span>记住帐号</span></label> \n");
      out.write("                            <label><input type=\"checkbox\" name=\"ssl\"><span>SSL安全登陆</span></label>\n");
      out.write("                            <a href=\"\">忘记密码</a>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"bottom\">\n");
      out.write("                <p><span>WeChat版本：默认版本</span><a href=\"register.jsp\">注册WeChat免费帐号</a></p>\n");
      out.write("                <a href=\"#\" class=\"icon\"><img alt=\"icon\" src=\"img/wechat.png\"></a>    \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            var bg_box=document.getElementsByClassName(\"bg_pic\");\n");
      out.write("            var j=0;\n");
      out.write("            var timer=setInterval(function(){\n");
      out.write("                for(var i=0;i<bg_box.length;i++){\n");
      out.write("                bg_box[i].style.display=\"none\";\n");
      out.write("            }\n");
      out.write("                console.log(\"1111\");\n");
      out.write("                bg_box[(j++)%bg_box.length].style.display=\"block\";\n");
      out.write("            },2000);\n");
      out.write("        </script>\n");
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
