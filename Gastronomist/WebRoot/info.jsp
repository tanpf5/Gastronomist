<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<link href="css/signup.css" type="text/css" rel="stylesheet">

  </head>
  
  <body>
<div class="top-blank"><img src="images/13.jpg"></img></div>
<div class="background-register">
<form action="changeInfo.do" method=post>
<div class="register-blank">
<div class="Username"><div class="Username-helper">
 <font size="3" style="font-family:verdana">New Username</font>
 <font size="2" style="font-family:verdana;color:red">*</font>
 <input type="text"name="uid"style="width:250px;height:43px;margin-left:20px;">
 </div>
 </div>
<div class="PassWord"><div class="PassWord-helper">
<font size="3" style="font-family:verdana">New Password</font>
<font size="2" style="font-family:verdana;color:red">*</font>
<input type="password"name="password"style="width:250px;height:43px;margin-left:20px;">
</div></div>
<div class="Confirm"><div class="Confirm-helper">
<font size="3" style="font-family:verdana">New Confirm</font>
<font size="2" style="font-family:verdana;color:red">*</font>
<input type="password"name="confirm"style="width:250px;height:43px;margin-left:20px;">
</div></div>
<div class="Address"><div class="Address-helper">
<font size="3" style="font-family:verdana">New Address</font>
<font size="2" style="font-family:verdana;color:red">*</font>
<input type="text"name="address"style="width:250px;height:43px;margin-left:20px;">
</div></div>
<div class="Tel"><div class="Tel-helper">
<font size="3" style="font-family:verdana">New Telephone</font>
<font size="2" style="font-family:verdana;color:red">*</font>
<input type="text"name="tel"style="width:250px;height:43px;margin-left:20px;">
</div></div>
<div class="register-button"><img src="images/19.jpg" onclick="submit()"></img></div>
</div>
</form>
</div>
<div class="interpertation"><img src="images/5.png"></img></div>
</body>
</html>
