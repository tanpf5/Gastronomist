<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
 <head>
  <title>Gastronomist Meal</title>
  <script type="text/javascript">
  function submit()
  {document.myfrom.submit();}
  </script>
  <link href="index.css" type="text/css" rel="stylesheet">
  <link href="shift.css" type="text/css" rel="stylesheet" >
 </head>
<body>
<div class="head-blank">
<div class="logo"><img src="2.png" width="300" height="90"></img></div>
</div>
<form action="login.do" method=post>
<div class="login-blank"><div class="login-blank2">
<div class="login-blank2-helper"><img src="6.jpg"style="width:100px;height:100px;margin-left:120px;"></img></div>
<div class="login-blank3">
<div class="login-blank3-helper1"><input type="text" maxlength=16; size="23"name="username"style="width:250px;height:43px;margin-left:20px;margin-top:18px;"/></div>
<div class="login-blank3-helper2"><input type="password" maxlength=16; size="23"name="password"style="width:250px;height:43px;margin-left:20px;margin-top:18px;"/></div>
</div><div class="login-button"><img src="7.png"  onclick="submit()" style="margin-top:20px;margin-left:7px;border:0px;"></div>
<a href="signup.jsp"><img src="8.png"style="margin-top:20px;margin-left:0px;border:0px;"></img></a>
</div>
<div class="main-page-pic"><img src="3.jpg"></img></div>
</div>
</form>
<div class="interpertation"><img src="5.png"></img></div>
</body>
</html>

