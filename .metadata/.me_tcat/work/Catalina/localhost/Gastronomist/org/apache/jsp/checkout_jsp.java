package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import JavaBean.*;
import DAO.*;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
Normaluser user = (Normaluser) request.getSession().getAttribute("user");
String name = user.getUsername();
double sum_price = (Double)request.getAttribute("sum_price");
Collection<OrderedDish> cart 
			= (Collection<OrderedDish>) request.getSession().getAttribute("cart");
DatabaseManager dbm = new DatabaseManager();

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
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    function submit()\n");
      out.write("    {document.myfrom.submit();}\n");
      out.write("    </script>\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\n");
      out.write("\t<link href=\"css/checkout.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("  </head>\n");
      out.write("  \n");
      out.write(" <body>\n");
      out.write("<body>\n");
      out.write("<div class=\"top-blank\"><img src=\"images/22.jpg\"></img></div>\n");
      out.write("<div class=\"background-register1\">\n");
      out.write("<form action=\"makeOrder.do\" method=post>\n");
      out.write("<div class=\"register-blank\">\n");
      out.write("<div class=\"name\"><div class=\"username\">\n");
      out.write("<h1 style=\"font-size:120%;color:green\">DEAR ");
      out.print(name );
      out.write(", YOUR FEE IS: ");
      out.print(sum_price );
      out.write("</br>\n");
      out.write("PLEASE CONFIRM:</h1></div>\n");
      out.write("<div class=\"dishes\">\n");
      out.write("<table border=1 width=360px>\n");
      out.write("<tr bgcolor=pink><th>restaurant</th><th>dish</th><th>quantity</th><th>price</th></tr>\n");
 Iterator<OrderedDish> iterator = cart.iterator();
		while (iterator.hasNext()) {
			OrderedDish od = iterator.next();
			int dish_id = od.getDish_id();
			Dish dish = dbm.findDishById(dish_id);
			String rest_name = dish.getRest_id().getRe_name();
			String dish_name = dish.getDi_name();
			int quantity = od.getQuantity();
			double price = od.getTotal_price();
			
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t<td>");
      out.print(rest_name);
      out.write("</td><td>");
      out.print(dish_name);
      out.write("</td><td>");
      out.print(quantity);
      out.write("</td><td>");
      out.print(price);
      out.write("</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t");
}

      out.write("\n");
      out.write("</table>\n");
      out.write("</div>\n");
      out.write("<div class=\"tel\">Tel:<input type=\"text\"name=\"number\"style=\"width:250px;height:30px;margin-left:51px;\"></div>\n");
      out.write("<div class=\"address\">Address:<input type=\"text\"name=\"address\"style=\"width:250px;height:30px;margin-left:20px;\"></div>\n");
      out.write("</div>\n");
      out.write("<div class=\"register-button\"><img src=\"images/19.jpg\" onclick=\"submit()\"></img></div>\n");
      out.write("</div>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("<div class=\"interpertation\"><image src=\"images/5.png\"></image></div>\n");
      out.write("\n");
      out.write("</body>\n");
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
