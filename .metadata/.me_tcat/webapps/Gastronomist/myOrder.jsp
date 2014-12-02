<%@ page language="java" import="java.util.*, JavaBean.Orders" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Collection<Orders> orders = (Collection<Orders>) request.getAttribute("orders");
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
	<link href="css/myOrder.css" type="text/css" rel="stylesheet">

  </head>
  
  <body>
    <div class="top-blank"><img src="images/15.png"></img></div>
<div class="background-register2">
<div class="register-blank">
<table border=1 width=500px>
<tr bgcolor=pink><th>restaurant</th><th>dish</th><th>price</th><th>mark</th><th>submit</th></tr>
<% 		Iterator<Orders> iterator = orders.iterator();
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
			%>
			<tr>
			<td><%=rest_name%></td>
			<td><%=dish_name%></td>
			<td><%=price%></td>
			<td><select name="mark<%=i%>">
				<option value=1>1</option>
				<option value=2>2</option>
				<option value=3>3</option>
				<option value=4>4</option>
				<option value=5>5</option> 
				</select></td>
			<td><input type=button value=submit 
			onclick=submit<%=i%>() />
			</td>
			</tr>
			  <script type="text/javascript">
    function submit<%=i%>() {
    var mark = document.getElementsByName("mark<%=i%>")[0].value;
    window.location.href = "mark.do?id=<%=order_id%>&mark=" + mark;
    }
  </script>
		<%}}
%>
</table>
<div class="register-button"><img src="images/19.jpg" ></img></div>
</div>
</div>
<div class="interpertation"><img src="images/5.png"></img></div>
  </body>
</html>