<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int rest_id = Integer.parseInt(request.getParameter("rest_id"));
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
	<link href="css/addDish.css" type="text/css" rel="stylesheet">

  </head>
  
  <body>
<div class="top-blank"><img src="images/add.png"></img></div>
<div class="background-register">
<form action="addDish.do?rest_id=<%=rest_id %>" method=post>
<div class="register-blank">
<div class="Username"><div class="Username-helper">
 <font size="3" style="font-family:verdana">Dish</font>
 <font size="2" style="font-family:verdana;color:red">*</font>
 <input type="text"maxlength=16; name="dish_name"style="width:250px;height:43px;margin-left:20px;">
 </div>
 </div>
<div class="PassWord"><div class="PassWord-helper">
<font size="3" style="font-family:verdana">Price</font>
<font size="2" style="font-family:verdana;color:red">*</font>
<input type="text" maxlength=16; name="price"style="width:250px;height:43px;margin-left:20px;">
</div></div>
<div class="register-button"><img src="images/19.jpg"onclick="submit()"></img></div>
</div>
</form>
</div>
<div class="interpertation"><img src="images/5.png" ></img></div>
</body>
</html>
