<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="mjuan.model.Brazo"%>
<%@page import="mjuan.dao.PicturesDAO"%>
<%@page import="mjuan.dao.interfaces.PicturesIDAO"%>
<%@page import="mjuan.util.Global"%>

<%
	PicturesIDAO picturesDAO = PicturesDAO.getInstance();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		
		<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<script src= "js/functions.js" ></script>		
		<script src="libs/jquery-2.1.4.min.js"></script>
		<script src="//use.edgefonts.net/cabin;source-sans-pro:n2,i2,n3,n4,n6,n7,n9.js"></script>
	</head>
	<body>
	<script src="js/bootstrap.min.js"></script>
	<script src="libs/threejs/three.min.js"></script>
	<script src="libs/threejs/OrbitControls.js"></script>
	<script src="libs/threejs/Coordinates.js"></script>
	<script src="libs/threejs/dat.gui.min.js"></script>
	<script src="libs/threejs/stats.min.js"></script>
	<script src="js/json.js"></script>
	
	<!-- SLIDER DE IMAGENES -->
	
	
	<div id="Carousel-roboticArm" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#Carousel-roboticArm" data-slide-to="0" class="active"></li>
			<li data-target="#Carousel-roboticArm" data-slide-to="1"></li>
			<li data-target="#Carousel-roboticArm" data-slide-to="2"></li>
		</ol>
	</div>
	
	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
	  <div class="item active">
	    <img src="images/1.png" alt="...">
	    <div class="carousel-caption">
	      ...
	    </div>
	  </div>
	  <div class="item">
	    <img src="images/2.png" alt="...">
	    <div class="carousel-caption">
	      ...
	    </div>
	  </div>
	  ...
	</div>
	
	<!-- Controls -->
	  <a class="left carousel-control" href="#Carousel-roboticArm" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Anterior</span>
	  </a>
	  <a class="right carousel-control" href="#Carousel-roboticArm" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Siguiente</span>
	  </a>
	</div>
		
	<h1>BINGO</h1>
		<script>
			
		</script>
	</body>
</html>