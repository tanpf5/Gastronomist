<%@ page language="java" import="java.util.*, JavaBean.Dish" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Collection<Dish> dishes = (Collection<Dish>) request.getAttribute("dishes");
int rest_id = (Integer) request.getAttribute("rest_id");
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
	<link href="css/editMenu.css" type="text/css" rel="stylesheet">

  </head>
  
  <body>
    <div class="top-blank"><img src="images/edit.png"></img></div>
<div class="background-register2">
<div class="register-blank">
<table border=1 width=500px>
<tr bgcolor=pink><th>name</th><th>price</th><th>times</th><th>mark</th><th>edit</th>
<th>delete</th>
</tr>
<% Iterator<Dish> iterator = dishes.iterator();
		while (iterator.hasNext()) {
			Dish dish = iterator.next();
			String dish_name = dish.getDi_name();
			double price = dish.getPrice();
			int times = dish.getTimes();
			int mark = dish.getMark();
			int dish_id=dish.getId();
			%>
			<tr><td><%=dish_name%></td><td><%=price%></td><td><%=times%></td><td><%=mark%></td>
			<td><input type=button value=edit 
			onclick="javascript:window.location.href='editDish.jsp?dish_id=<%=dish_id%>&rest_id=<%=rest_id%>'"/></td>
			<td><input type=button value=delete 
			onclick="javascript:window.location.href='deleteDish.do?dish_id=<%=dish_id%>&rest_id=<%=rest_id%>'"/></td>
			</tr>
		<%}
%>
</table>
<div class="register-button"><a href="addDish.jsp?rest_id=<%=rest_id%>"><img src="images/add.png" >
</img></a></div>
</div>
</div>
<div class="interpertation"><img src="images/5.png"></img></div>
  </body>
</html>


