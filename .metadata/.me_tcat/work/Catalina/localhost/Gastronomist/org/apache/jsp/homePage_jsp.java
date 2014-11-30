package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import JavaBean.Normaluser;

public final class homePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("    <title>Gastronomist</title>\n");
      out.write("   <link href=\"css/homePage.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("   <link href=\"css/homePage2.css\" type=\"text/css\" rel=\"stylesheet\" >\n");
      out.write("   <script language=\"javascript\">\n");
      out.write("  function change(val,obj){\n");
      out.write("    if(val=='a'){\n");
      out.write("\t   obj.style.backgroundColor=\"FFC12D\";\n");
      out.write("\t    a.style.display=\"block\";\n");
      out.write("\t    c.style.display=\"none\";\n");
      out.write("\t\tb.style.display=\"none\";\n");
      out.write("\t\td.style.display=\"none\";\n");
      out.write("\t\te.style.display=\"none\";\n");
      out.write("\t\tf.style.display=\"none\";\n");
      out.write("\t}else if(val=='b'){\n");
      out.write("        obj.style.backgroundColor=\"FFC12D\";\n");
      out.write("        b.style.display=\"block\";\n");
      out.write("        a.style.display=\"none\";\n");
      out.write("\t    c.style.display=\"none\";\n");
      out.write("\t\td.style.display=\"none\";\n");
      out.write("\t\te.style.display=\"none\";\n");
      out.write("\t\tf.style.display=\"none\";\n");
      out.write("\t}else if(val=='c'){\n");
      out.write("\t\tobj.style.backgroundColor=\"FFC12D\";\n");
      out.write("\t\tc.style.display=\"block\";\n");
      out.write("\t\tb.style.display=\"none\";\n");
      out.write("        a.style.display=\"none\";\n");
      out.write("\t\td.style.display=\"none\";\n");
      out.write("\t\te.style.display=\"none\";\n");
      out.write("\t\tf.style.display=\"none\";\n");
      out.write("\n");
      out.write("\t}else if(val==\"d\"){\n");
      out.write("\t\tobj.style.backgroundColor=\"FFC12D\";\n");
      out.write("\t\td.style.display=\"block\";\n");
      out.write("\t\tc.style.display=\"none\";\n");
      out.write("\t\ta.style.display=\"none\";\n");
      out.write("\t\tb.style.display=\"none\";\n");
      out.write("\t\te.style.display=\"none\";\n");
      out.write("\t\tf.style.display=\"none\";\n");
      out.write("\t}else if(val==\"e\"){\n");
      out.write("\t\tobj.style.backgroundColor=\"FFC12D\";\n");
      out.write("\t\te.style.display=\"block\";\n");
      out.write("\t\tc.style.display=\"none\";\n");
      out.write("\t\ta.style.display=\"none\";\n");
      out.write("\t\tb.style.display=\"none\";\n");
      out.write("\t\td.style.display=\"none\";\n");
      out.write("\t\tf.style.display=\"none\";\n");
      out.write("\t}else if(val==\"f\"){\n");
      out.write("\t\tobj.style.backgroundColor=\"FFC12D\";\n");
      out.write("\t\tf.style.display=\"block\";\n");
      out.write("\t\tc.style.display=\"none\";\n");
      out.write("\t\ta.style.display=\"none\";\n");
      out.write("\t\tb.style.display=\"none\";\n");
      out.write("\t\td.style.display=\"none\";\n");
      out.write("\t\te.style.display=\"none\";\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("function change2(obj){\n");
      out.write("\tobj.style.backgroundColor=\"silver\";\n");
      out.write("}\n");
      out.write("  </script>\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\n");
      out.write("  </head>\n");
      out.write("<body>\n");
      out.write("<div class=\"top\"><img src=\"images/2.png\"style=\"width:300px;height:100px;\"></img>\n");
      out.write("<div class=\"name\">");
Normaluser user = (Normaluser) request.getSession().getAttribute("user");
					String name = user.getUsername();
                    out.println("hello  "+name); 
      out.write("<a href=\"myOrder.do\">MYORDER</a><a href=\"info.jsp\">INFO</a></div></div>\n");
      out.write("<div class=\"div17\">\n");
      out.write("\t\n");
      out.write("\t<!--shift右部-->\n");
      out.write("\t<div id=\"a\" class=\"a\" ><img src=\"images/dacan1.jpg\"></img></div>\n");
      out.write("\t<div id=\"b\" class=\"b\" ><img src=\"images/dacan2.jpg\"></img></div>\n");
      out.write("\t<div id=\"c\" class=\"c\" ><img src=\"images/dacan3.jpg\"></img></div>\n");
      out.write("\t<div id=\"d\" class=\"d\" ><img src=\"images/dacan4.jpg\"></img></div>\n");
      out.write("\t<div id=\"e\" class=\"e\" ><img src=\"images/dacan5.jpg\"></img></div>\n");
      out.write("\t<div id=\"f\" class=\"f\" ><img src=\"images/dacan6.jpg\"></img></div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"div18\"><a href=\"dish.do?id=");
      out.print(1 );
      out.write("\"><img id=\"w\" src=\"images/dacan1.jpg\" style=\"width:250px;height:250px;margin-left:39px;margin-top:40px;\"></img></a>\n");
      out.write("\t<img id=\"w\" src=\"hafo.jpg\" style=\"width:250px;height:250px;margin-left:20px;margin-top:10px;\"></img>\n");
      out.write("\t<img id=\"w\" src=\"hafo.jpg\" style=\"width:250px;height:250px;margin-left:20px;margin-top:10px;\"></img>\n");
      out.write("\t<img id=\"w\" src=\"hafo.jpg\" style=\"width:250px;height:250px;margin-left:49px;margin-top:20px;\"></img>\n");
      out.write("\t<img id=\"w\" src=\"hafo.jpg\" style=\"width:250px;height:250px;margin-left:20px;margin-top:20px;\"></img>\n");
      out.write("\t<img id=\"w\" src=\"hafo.jpg\" style=\"width:250px;height:250px;margin-left:20px;margin-top:20px;\"></img>\n");
      out.write("\t<div class=\"interpertation\"><img src=\"images/5.png\"></img></div>                  \n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
