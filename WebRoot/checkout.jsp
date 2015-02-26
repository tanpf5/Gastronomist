<%@ page language="java" import="java.util.*, JavaBean.* , DAO.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Normaluser user = (Normaluser) request.getSession().getAttribute("user");
String name = user.getUsername();
double sum_price = (Double)request.getAttribute("sum_price");
Collection<OrderedDish> cart 
			= (Collection<OrderedDish>) request.getSession().getAttribute("cart");
DatabaseManager dbm = new DatabaseManager();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Gastronomist</title>
    <script type="text/javascript">
    function submit()
    {document.myfrom.submit();}
    </script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/checkout.css" type="text/css" rel="stylesheet">
  </head>
  
 <body>
<body>
<div class="top-blank"><img src="images/22.jpg"></img></div>
<div class="background-register1">
<form action="makeOrder.do" method=post>
<div class="register-blank">
<div class="name"><div class="username">
<h1 style="font-size:120%;color:green">DEAR <%=name %>, YOUR FEE IS: <%=sum_price %></br>
PLEASE CONFIRM:</h1></div>
<div class="dishes">
<table border=1 width=360px>
<tr bgcolor=pink><th>restaurant</th><th>dish</th><th>quantity</th><th>price</th></tr>
<% Iterator<OrderedDish> iterator = cart.iterator();
		while (iterator.hasNext()) {
			OrderedDish od = iterator.next();
			int dish_id = od.getDish_id();
			Dish dish = dbm.findDishById(dish_id);
			String rest_name = dish.getRest_id().getRe_name();
			String dish_name = dish.getDi_name();
			int quantity = od.getQuantity();
			double price = od.getTotal_price();
			%>
			<tr>
			<td><%=rest_name%></td><td><%=dish_name%></td><td><%=quantity%></td><td><%=price%></td>
			</tr>
		<%}
%>
</table>
</div>
<div class="tel">Tel:<input type="text"name="number"style="width:250px;height:30px;margin-left:51px;"></div>
<div class="address">Address:<input type="text"name="address"style="width:250px;height:30px;margin-left:20px;"></div>
</div>
<div class="register-button"><img src="images/19.jpg" onclick="submit()"></img></div>
</div>
</form>
</div>
<div class="interpertation"><image src="images/5.png"></image></div>

</body>
</html>
