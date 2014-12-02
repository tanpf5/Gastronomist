package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import JavaBean.Orders;

public final class myOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=ISO-8859-1");
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
Collection<Orders> orders = (Collection<Orders>) request.getAttribute("orders");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("    \n");
      out.write("    <title>Gastronomist</title>\n");
      out.write("    \n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\n");
      out.write("\t<link href=\"css/myOrder.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  \n");
      out.write("  <body>\n");
      out.write("    <div class=\"top-blank\"><img src=\"images/15.png\"></img></div>\n");
      out.write("<div class=\"background-register2\">\n");
      out.write("<div class=\"register-blank\">\n");
      out.write("<table border=1 width=500px>\n");
      out.write("<tr bgcolor=pink><th>restaurant</th><th>dish</th><th>price</th><th>mark</th><th>submit</th></tr>\n");
 		Iterator<Orders> iterator = orders.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Orders order = iterator.next();
			i++;
			String rest_name = order.getDish_id().getRest_id().getRe_name();
			String dish_name = order.getDish_id().getDi_name();
			double price = order.getDish_id().getPrice();
			int mark = order.getMark();
			int order_id = order.getId();
			if (mark == 0) {
			
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t<td>");
      out.print(rest_name);
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(dish_name);
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(price);
      out.write("</td>\n");
      out.write("\t\t\t<td><select name=\"mark");
      out.print(i);
      out.write("\">\n");
      out.write("\t\t\t\t<option value=1>1</option>\n");
      out.write("\t\t\t\t<option value=2>2</option>\n");
      out.write("\t\t\t\t<option value=3>3</option>\n");
      out.write("\t\t\t\t<option value=4>4</option>\n");
      out.write("\t\t\t\t<option value=5>5</option> \n");
      out.write("\t\t\t\t</select></td>\n");
      out.write("\t\t\t<td><input type=button value=submit \n");
      out.write("\t\t\tonclick=submit");
      out.print(i);
      out.write("() />\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t  <script type=\"text/javascript\">\n");
      out.write("    function submit");
      out.print(i);
      out.write("() {\n");
      out.write("    var mark = document.getElementsByName(\"mark");
      out.print(i);
      out.write("\")[0].value;\n");
      out.write("    window.location.href = \"mark.do?id=");
      out.print(order_id);
      out.write("&mark=\" + mark;\n");
      out.write("    }\n");
      out.write("  </script>\n");
      out.write("\t\t");
}}

      out.write("\n");
      out.write("</table>\n");
      out.write("<div class=\"register-button\"><img src=\"images/19.jpg\" ></img></div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<div class=\"interpertation\"><img src=\"images/5.png\"></img></div>\n");
      out.write("  </body>\n");
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
