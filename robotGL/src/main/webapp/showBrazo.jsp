<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>RobotGL - Mostrar brazo</title>
	</head>
	<body onload="init();">
		<script src="lib/threejs/three.min.js"></script>
		<script src="lib/threejs/OrbitControls.js"></script>
		<script src="lib/threejs/dat.gui.min.js"></script>
		<script src="lib/threejs/stats.min.js"></script>
		<script src="js/webGL.js"></script>
		BINGO BRAZO 
		<%	
			int id = Integer.parseInt((String)session.getAttribute("id_brazo"));
			out.println(id);	
		%>
		<div id='container' width=800, height=600>	
	</body>
</html>