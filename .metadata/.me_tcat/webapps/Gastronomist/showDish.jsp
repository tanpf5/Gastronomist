<%@ page language="java" import="java.util.*, JavaBean.Dish" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Collection<Dish> dishes = (Collection<Dish>) request.getAttribute("dishes");
int rest_id = (Integer)request.getAttribute("rest_id");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Gastronomist</title>
  
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/showDish.css" type="text/css" rel="stylesheet">

  </head>
  
  <body>
    <div class="top-blank"><img src="images/21.jpg"></img></div>
<div class="background-register2">

<div class="register-blank">
<table border=1 width=500px>
<tr bgcolor=pink><th>name</th><th>price</th><th>times</th><th>mark</th><th>buy</th></tr>
<% Iterator<Dish> iterator = dishes.iterator();
		while (iterator.hasNext()) {
			Dish dish = iterator.next();
			String dish_name = dish.getDi_name();
			double price = dish.getPrice();
			int times = dish.getTimes();
			int mark = dish.getMark();
			int id = dish.getId();
			%>
			<tr>
			<td><%=dish_name%></td><td><%=price%></td><td><%=times%></td><td><%=mark%></td>
			<td><input type=button value=buy 
			onclick="javascript:window.location.href='addCart.do?id=<%=id%>&rest_id=<%=rest_id%>'"/>
			</td>
			</tr>
		<%}
%>
</table>
<div class="register-button"><a href="checkout.do"><img src="images/19.jpg"></img></a></div>
</div>
</div>
<div class="interpertation"><img src="images/5.png"></img></div>
  </body>
</html>
