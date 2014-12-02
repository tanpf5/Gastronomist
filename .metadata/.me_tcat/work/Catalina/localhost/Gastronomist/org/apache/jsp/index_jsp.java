package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\n");
      out.write("<html>\n");
      out.write(" <head>\n");
      out.write("  <title>Gastronomist</title>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("  function submit()\n");
      out.write("  {document.myfrom.submit();}\n");
      out.write("  </script>\n");
      out.write("  <link href=\"css/index.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("  <link href=\"css/index2.css\" type=\"text/css\" rel=\"stylesheet\" >\n");
      out.write(" </head>\n");
      out.write("<body>\n");
      out.write("<div class=\"head-blank\">\n");
      out.write("<div class=\"logo\"><img src=\"images/2.png\" width=\"300\" height=\"90\"></img></div>\n");
      out.write("</div>\n");
      out.write("<form action=\"login.do\" method=post>\n");
      out.write("<div class=\"login-blank\"><div class=\"login-blank2\">\n");
      out.write("<div class=\"login-blank2-helper\"><img src=\"images/6.jpg\"style=\"width:100px;height:100px;margin-left:120px;\"></img></div>\n");
      out.write("<div class=\"login-blank3\">\n");
      out.write("<div class=\"login-blank3-helper1\"><input type=\"text\" maxlength=16; size=\"23\"name=\"username\"style=\"width:250px;height:43px;margin-left:20px;margin-top:18px;\"/></div>\n");
      out.write("<div class=\"login-blank3-helper2\"><input type=\"password\" maxlength=16; size=\"23\"name=\"password\"style=\"width:250px;height:43px;margin-left:20px;margin-top:18px;\"/></div>\n");
      out.write("administrator\n");
      out.write("<input type=\"checkbox\" name=\"admin?\" value=1 />\n");
      out.write("</div><div class=\"login-button\"><img src=\"images/7.png\"  onclick=\"submit()\" style=\"margin-top:20px;margin-left:7px;border:0px;\"></div>\n");
      out.write("<a href=\"signup.jsp\"><img src=\"images/8.png\"style=\"margin-top:20px;margin-left:0px;border:0px;\"></img></a>\n");
      out.write("</div>\n");
      out.write("<div class=\"main-page-pic\"><img src=\"images/3.jpg\"></img></div>\n");
      out.write("</div>\n");
      out.write("</form>\n");
      out.write("<div class=\"interpertation\"><img src=\"images/5.png\"></img></div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
