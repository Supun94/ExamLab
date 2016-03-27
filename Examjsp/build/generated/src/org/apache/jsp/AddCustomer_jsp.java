package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"./static/css/bootstrap.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"./static/css/bootstrap-theme.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"./static/css/MyStyleSheet.css\" rel=\"stylesheet\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script type=\"text/javascript\" src=\"./static/js/JQ.js\" ></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"./static/js/Js.js\" ></script>\n");
      out.write("        <form>\n");
      out.write("            <div id=\"mainDiv\" class=\"row col-md-6  \"  style=\"margin-left: 100px; margin-top:80px \">\n");
      out.write("                <div id=\"header\" class=\"col-md-12 col-md-offset-4 form-group\">\n");
      out.write("                    <h1>Add Customer</h1>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"idDiv\" class=\"col-md-12\">\n");
      out.write("                    <div id=\"idLable\" class=\"col-md-6 col-md-push-2\">\n");
      out.write("                        <label class=\"lead\">Customer ID</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"idText\" class=\"col-md-4\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" name=\"customerId\" id=\"idTf\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"nameDiv\" class=\"col-md-12\">\n");
      out.write("                    <div id=\"nameLable\" class=\"col-md-6 col-md-push-2\">\n");
      out.write("                        <label class=\"lead\">Customer Name</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"nameText\" class=\"col-md-6\">\n");
      out.write("                        <input id=\"nameTf\" class=\"form-control\" onkeyup=\"TextValidation(id)\" type=\"text\" name=\"customerName\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"emailDiv\" class=\"col-md-12\">\n");
      out.write("                    <div id=\"emailLable\" class=\"col-md-6 col-md-push-2\">\n");
      out.write("                        <label class=\"lead\">Customer Email</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"emailText\" class=\"col-md-6\">\n");
      out.write("                        <input id=\"emailTf\" class=\"form-control\" type=\"text\" name=\"customerEmail\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"passwordDiv\" class=\"col-md-12\">\n");
      out.write("                    <div id=\"passwordLable\" class=\"col-md-6 col-md-push-2\">\n");
      out.write("                        <label class=\"lead\">Customer Password</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"passwordText\" class=\"col-md-6\">\n");
      out.write("                        <input id=\"passwordTf\" class=\"form-control\" type=\"password\" name=\"customerPassword\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"phoneNoDiv\" class=\"col-md-12\">\n");
      out.write("                    <div id=\"phoneNoLable\" class=\"col-md-6 col-md-push-2\">\n");
      out.write("                        <label class=\"lead\">Customer PhoneNo</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"phoneNoText\" class=\"col-md-6\">\n");
      out.write("                        <input id=\"phoneNoTf\" class=\"form-control\" type=\"text\" name=\"customerPhoneNo\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"addressDiv\" class=\"col-md-12\">\n");
      out.write("                    <div id=\"addressLable\" class=\"col-md-6 col-md-push-2\">\n");
      out.write("                        <label class=\"lead\">Customer Address</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"addressText\" class=\"col-md-6\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" name=\"customerAddress\" id=\"addressTf\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                   <div id=\"regDateDiv\" class=\"col-md-12\">\n");
      out.write("                    <div id=\"regDateLable\" class=\"col-md-6 col-md-push-2\">\n");
      out.write("                        <label class=\"lead\">Customer RegDate</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"regDateText\" class=\"col-md-6\">\n");
      out.write("                        <input id=\"regDateTf\" class=\"form-control\" type=\"text\" name=\"customerRegDate\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"buttonDiv\" class=\"col-md-11 col-md-push-7 form-group\">\n");
      out.write("\n");
      out.write("                    <input type=\"button\" value=\"Save\" class=\"btn  btn-success buttonSize\" onclick=\"addCustomer()\"/>\n");
      out.write("                    <input type=\"button\" value=\"Cancel\" class=\"btn btn-danger buttonSize\"/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function addCustomer() {\n");
      out.write("\n");
      out.write("                var xmlrequest;\n");
      out.write("                if (window.XMLHttpRequest) {\n");
      out.write("                    \n");
      out.write("                    xmlrequest = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    xmlrequest = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                xmlrequest.onreadystatechange = function () {\n");
      out.write("                    if (xmlrequest.readyState == 4 && xmlrequest.status == 200) {\n");
      out.write("                      //  alert(\"a\");\n");
      out.write("                        if (xmlrequest.responseText) {\n");
      out.write("                       //     alert(\"aa\");\n");
      out.write("                            var res = parseInt(xmlrequest.responseText);\n");
      out.write("                            if (res === 1) {\n");
      out.write("                       //         alert(\"aaaa\");\n");
      out.write("                                alert(\"Customer Added\");\n");
      out.write("                                document.getElementById(\"idTf\").valu0 = \"\";\n");
      out.write("                                document.getElementById(\"nameTf\").value = \"\";\n");
      out.write("                                document.getElementById(\"emailTf\").value = \"\";\n");
      out.write("                                document.getElementById(\"passwordTf\").value = \"\";\n");
      out.write("                                document.getElementById(\"phoneNoTf\").value = \"\";\n");
      out.write("                                document.getElementById(\"addressTf\").value = \"\";\n");
      out.write("                                document.getElementById(\"regDateTf\").value = \"\";\n");
      out.write("                            } else {\n");
      out.write("                                alert(\"Customer Not Add\");\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                var id = document.getElementById(\"idTf\").value;\n");
      out.write("                var name = document.getElementById(\"nameTf\").value;\n");
      out.write("                var email = document.getElementById(\"emilTf\").value;\n");
      out.write("                var password = document.getElementById(\"passwordTf\").value;\n");
      out.write("                var phoneNo = document.getElementById(\"phoneNoTf\").value;\n");
      out.write("                var address = document.getElementById(\"addressTf\").value;\n");
      out.write("                var regDate = document.getElementById(\"regDateTf\").value;\n");
      out.write("                \n");
      out.write("                //console.log(id+\"-\"+name+\"-\"+address)\n");
      out.write("                xmlrequest.open(\"POST\", \"Customer\", true);\n");
      out.write("                xmlrequest.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("                xmlrequest.send(\"nic=\" + id + \"&fullName=\" + name + \"&email=\" + email + \"&password=\" + password+\"&phoneNo=\"+phoneNo+\"&address=\"+address+\"&regDate=\"+regDate);\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            ;\n");
      out.write("\n");
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
