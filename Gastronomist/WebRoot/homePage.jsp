<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Gastronomist Meal</title>
   <link href="homePage.css" type="text/css" rel="stylesheet">
   <link href="homePage2.css" type="text/css" rel="stylesheet" >
   <script language="javascript">
  function change(val,obj){
    if(val=='a'){
	   obj.style.backgroundColor="FFC12D";
	    a.style.display="block";
	    c.style.display="none";
		b.style.display="none";
		d.style.display="none";
		e.style.display="none";
		f.style.display="none";
	}else if(val=='b'){
        obj.style.backgroundColor="FFC12D";
        b.style.display="block";
        a.style.display="none";
	    c.style.display="none";
		d.style.display="none";
		e.style.display="none";
		f.style.display="none";
	}else if(val=='c'){
		obj.style.backgroundColor="FFC12D";
		c.style.display="block";
		b.style.display="none";
        a.style.display="none";
		d.style.display="none";
		e.style.display="none";
		f.style.display="none";

	}else if(val=="d"){
		obj.style.backgroundColor="FFC12D";
		d.style.display="block";
		c.style.display="none";
		a.style.display="none";
		b.style.display="none";
		e.style.display="none";
		f.style.display="none";
	}else if(val=="e"){
		obj.style.backgroundColor="FFC12D";
		e.style.display="block";
		c.style.display="none";
		a.style.display="none";
		b.style.display="none";
		d.style.display="none";
		f.style.display="none";
	}else if(val=="f"){
		obj.style.backgroundColor="FFC12D";
		f.style.display="block";
		c.style.display="none";
		a.style.display="none";
		b.style.display="none";
		d.style.display="none";
		e.style.display="none";
	}
}
function change2(obj){
	obj.style.backgroundColor="silver";
}
  </script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
<body>
<div class="top"><img src="2.png"style="width:300px;height:100px;"></img>
<div class="name"><%String name=request.getParameter("username");
                    out.println("hello  "+name); %><a href="index.jsp">MYORDER</a><a id="a1" href="Reset.jsp">RESET</a></div></div>
<div class="div17">
	
	<!--shift右部div-->
	<div id="a" class="a" ><img src="dacan1.jpg"></img></div>
	<div id="b" class="b" ><img src="dacan2.jpg"></img></div>
	<div id="c" class="c" ><img src="dacan3.jpg"></img></div>
	<div id="d" class="d" ><img src="dacan4.jpg"></img></div>
	<div id="e" class="e" ><img src="dacan5.jpg"></img></div>
	<div id="f" class="f" ><img src="dacan6.jpg"></img></div>
	</div>
	<div class="div18"><a href="dish.do?id=<%=3 %>"><img id="w" src="hafo.jpg" style="width:250px;height:250px;margin-left:39px;margin-top:40px;"></img></a>
	<img id="w" src="hafo.jpg" style="width:250px;height:250px;margin-left:20px;margin-top:10px;"></img>
	<img id="w" src="hafo.jpg" style="width:250px;height:250px;margin-left:20px;margin-top:10px;"></img>
	<img id="w" src="hafo.jpg" style="width:250px;height:250px;margin-left:49px;margin-top:20px;"></img>
	<img id="w" src="hafo.jpg" style="width:250px;height:250px;margin-left:20px;margin-top:20px;"></img>
	<img id="w" src="hafo.jpg" style="width:250px;height:250px;margin-left:20px;margin-top:20px;"></img>
	<div class="interpertation"><img src="5.png"></img></div>                  
	</div>
</body>
</html>