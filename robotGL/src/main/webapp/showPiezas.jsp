<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<script src="lib/threejs/three.min.js"></script>
		<script src="lib/threejs/OrbitControls.js"></script>
		<script src="lib/threejs/dat.gui.min.js"></script>
		<script src="lib/threejs/stats.min.js"></script>
		<script src="js/webGL.js"></script>
		BINGO PIEZAS
		<br>
		Base: 
		<%
		int id_base = Integer.parseInt((String)session.getAttribute("id_base"));
		out.println(id_base);	 
		%>
		<br>
		Antebrazo: 
		<%
		int id_antebrazo = Integer.parseInt((String)session.getAttribute("id_antebrazo"));
		out.println(id_antebrazo);	 
		%>
		<br>
		Mano: 
		<%
		int id_mano = Integer.parseInt((String)session.getAttribute("id_mano"));
		out.println(id_mano);	 
		%>
		<br>
	</body>
</html>