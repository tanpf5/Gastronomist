<%@ page language="java" import="java.util.*, JavaBean.Normaluser, JavaBean.Administrator" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int type = (Integer) request.getSession().getAttribute("type");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Gastronomist</title>
   <link href="css/homePage.css" type="text/css" rel="stylesheet">
   <link href="css/homePage2.css" type="text/css" rel="stylesheet" >
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
<div class="top"><img src="images/2.png"style="width:300px;height:100px;"></img>
<div class="name"><%
					if (type == 1) {
					Normaluser user = (Normaluser) request.getSession().getAttribute("user");
					String name = user.getUsername();
                    out.println("hello  "+name); 
                    %><a href="myOrder.do">MYORDER</a><a href="info.jsp">INFO</a>
                    </div><%} %></div> 
<div class="div17">
	<div class="navi">
	<ul>
	<li onmouseover="change('a',this)" onmouseout="change2(this)"></li>
	<li onmouseover="change('b',this)" onmouseout="change2(this)"></li>
	<li onmouseover="change('c',this)" onmouseout="change2(this)"></li>
	<li onmouseover="change('d',this)" onmouseout="change2(this)"></li>
	<li onmouseover="change('e',this)" onmouseout="change2(this)"></li>
	<li onmouseover="change('f',this)" onmouseout="change2(this)"></li>
	</ul>
	</div>
	<!--shift右部-->
	<div id="a" class="a" ><img src="images/dacan1.jpg"></img></div>
	<div id="b" class="b" ><img src="images/dacan2.jpg"></img></div>
	<div id="c" class="c" ><img src="images/dacan3.jpg"></img></div>
	<div id="d" class="d" ><img src="images/dacan4.jpg"></img></div>
	<div id="e" class="e" ><img src="images/dacan5.jpg"></img></div>
	<div id="f" class="f" ><img src="images/dacan6.jpg"></img></div>
	</div>
	<div class="div18">
	<a href="dish.do?id=<%=1 %>"><img id="w" src="images/dacan1.jpg" style="width:250px;height:250px;margin-left:39px;margin-top:40px;"></img></a>
	<a href="dish.do?id=<%=2 %>"><img id="w" src="images/dacan2.jpg" style="width:250px;height:250px;margin-left:20px;margin-top:10px;"></img></a>
	<a href="dish.do?id=<%=3 %>"><img id="w" src="images/dacan3.jpg" style="width:250px;height:250px;margin-left:20px;margin-top:10px;"></img></a>
	<a href="dish.do?id=<%=4 %>"><img id="w" src="images/dacan4.jpg" style="width:250px;height:250px;margin-left:49px;margin-top:20px;"></img></a>
	<a href="dish.do?id=<%=5 %>"><img id="w" src="images/dacan5.jpg" style="width:250px;height:250px;margin-left:20px;margin-top:20px;"></img></a>
	<a href="dish.do?id=<%=6 %>"><img id="w" src="images/dacan6.jpg" style="width:250px;height:250px;margin-left:20px;margin-top:20px;"></img></a>
	<div class="interpertation"><img src="images/5.png"></img></div>                  
	</div>
</body>
</html>