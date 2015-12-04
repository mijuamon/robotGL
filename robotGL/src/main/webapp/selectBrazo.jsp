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
		
		
		<!-- CSS -->
		<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">		
		<script src= "js/functions.js" ></script>		
		
		<!-- FUENTES -->
		<script src="//use.edgefonts.net/cabin;source-sans-pro:n2,i2,n3,n4,n6,n7,n9.js"></script>
	</head>
	<body>	

	<!-- SLIDER DE IMAGENES -->
	
	<div id="container" style="width: 40%; height: 30%" align="center">
	<!-- Con   class="carousel" no sale error pero no funciona-->
		<div id="Carousel-roboticArm" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#Carousel-roboticArm" data-slide-to="0" class></li>
				<li data-target="#Carousel-roboticArm" data-slide-to="1" class></li>
				<li data-target="#Carousel-roboticArm" data-slide-to="2" class></li>
				<li data-target="#Carousel-roboticArm" data-slide-to="3" class></li>
				<li data-target="#Carousel-roboticArm" data-slide-to="4" class="active"></li>
			</ol>
		
		
			<!-- Wrapper for slides -->
			<div class="carousel-inner" rol="listbox">
			  <div class="item">
			    <img src="images/1.png" alt="HOLAAAAA"  data-holder.renderer="true" class="img-rounded">
			    <div class="carousel-caption">
			     TEXTOOOOOOOOOOOOOOOOOO
			    </div>
			  </div>
			  <div class="item">
			    <img src="images/2.png" alt="..."  data-holder.renderer="true" class="img-rounded">
			    <div class="carousel-caption">
			      ...
			    </div>
			  </div>
			  <div class="item">
			    <img src="images/3.png" alt="..."  data-holder.renderer="true" class="img-rounded">
			    <div class="carousel-caption">
			      ...
			    </div>
			  </div>
			  <div class="item active">
			    <img src="images/4.png" alt="..." data-holder.renderer="true" class="img-rounded">
			    <div class="carousel-caption">
			      ...
			    </div>
			  </div>
			</div>
		</div>
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
	<script  type="text/javascript" src="lib/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
		
	<h1>BINGO</h1>
		<script>
			
		</script>
	</body>
	 
</html>