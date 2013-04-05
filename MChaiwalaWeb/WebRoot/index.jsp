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
	
	
  </head>
  
  <body> 
    <h1 align="center">Welcome to MoJoe Cafe </h1><br>
    <div>Chai Payment</div> 
    <form>
	    <div>Employee Username : <%= request.getParameter("username") %></div><br>
	    <div><input type="hidden" name="employeeid" value=<%= request.getParameter("username") %> /></div>
	    <div>Amount: $<input type="text" id="amount" name="amount" value=<%= request.getParameter("amount") %>/> </div><br>
	    <input type="submit" value="Make Payment">
	    <span></span>
    </form>
    
    
    <script>
 		$("form").submit(function() {
	 		alert("hello");
	 
		 	$.get("test.html",function(data,status){
		      alert("Data: " + data + "\nStatus: " + status);
		    });
 		});
	</script>
	
  </body>
</html>