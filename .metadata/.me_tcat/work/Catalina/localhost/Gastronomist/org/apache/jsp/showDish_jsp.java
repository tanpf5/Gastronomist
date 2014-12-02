package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import JavaBean.Dish;

public final class showDish_jsp extends org.apache.jasper.runtime.HttpJspBase
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
Collection<Dish> dishes = (Collection<Dish>) request.getAttribute("dishes");
int rest_id = (Integer)request.getAttribute("rest_id");

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
      out.write("  \n");
      out.write("    \n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\n");
      out.write("\t<link href=\"css/showDish.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  \n");
      out.write("  <body>\n");
      out.write("    <div class=\"top-blank\"><img src=\"images/21.jpg\"></img></div>\n");
      out.write("<div class=\"background-register2\">\n");
      out.write("\n");
      out.write("<div class=\"register-blank\">\n");
      out.write("<table border=1 width=500px>\n");
      out.write("<tr bgcolor=pink><th>name</th><th>price</th><th>times</th><th>mark</th><th>buy</th></tr>\n");
 Iterator<Dish> iterator = dishes.iterator();
		while (iterator.hasNext()) {
			Dish dish = iterator.next();
			String dish_name = dish.getDi_name();
			double price = dish.getPrice();
			int times = dish.getTimes();
			int mark = dish.getMark();
			int id = dish.getId();
			
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t<td>");
      out.print(dish_name);
      out.write("</td><td>");
      out.print(price);
      out.write("</td><td>");
      out.print(times);
      out.write("</td><td>");
      out.print(mark);
      out.write("</td>\n");
      out.write("\t\t\t<td><input type=button value=buy \n");
      out.write("\t\t\tonclick=\"javascript:window.location.href='addCart.do?id=");
      out.print(id);
      out.write("&rest_id=");
      out.print(rest_id);
      out.write("'\"/>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t");
}

      out.write("\n");
      out.write("</table>\n");
      out.write("<div class=\"register-button\"><a href=\"checkout.do\"><img src=\"images/19.jpg\"></img></a></div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<div class=\"interpertation\"><img src=\"images/5.png\"></img></div>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
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
