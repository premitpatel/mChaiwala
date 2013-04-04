<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>MoJoes Chai Payment</title>
    
  <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" rel="Stylesheet" />	
		<!--
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.js"></script>
		<script type="text/javascript" src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
		-->
		
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script>
	function makePayment() {
		alert("making a payment");
		var uname = '<%= request.getParameter("username") %>';
		var amt = document.getElementById('amount').value;
		var vend = '<%= request.getParameter("vendorid") %>';
		alert("creating url");
		var urlstr = "http://172.25.20.237:8080/MChaiwalaWeb/resteasy/chaiservice/chaipayment?username="+uname+"&amount="+amt+"&vendorid="+vend;
		alert(urlstr);
		console.log("urlstr:" +urlstr);
		$.ajax({
		    url: urlstr,
		    type: 'POST',
		    //contentType:'application/json; charset=utf-8',
		    dataType: 'json',
		    success: function(data) {
		     	alert("POST completed");
		     	alert(data); 
		    },
		    error : function(error) {
		    alert("");
		    }
		});
		return;
	}
	</script
	
  </head>
  
  <body> 
    <h1 align="center">Welcome to MoBeans </h1><br>
    <div>Coffee/Tea Payment<br><br> 
    
    <div><span>Username : </span><span><%= request.getParameter("username") %></span></div><br>
	<div><span>Amount:</span> <span>$<input type="text" id="amount" name="amount" value=<%= request.getParameter("amount") %>> </span> </div><br>
	
	<input type="submit" value="Make Payment" onclick="makePayment()">
    
    </div>
    
  </body>
</html>
