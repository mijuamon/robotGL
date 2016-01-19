<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="mjuan.model.Pieza"%>
<%@page import="mjuan.dao.PiezaDAO"%>
<%@page import="mjuan.dao.interfaces.PiezaIDAO"%>
<%@page import="mjuan.util.Global"%>

<%
	PiezaIDAO brazoDAO = PiezaDAO.getInstance();

	List<Pieza> bases = brazoDAO.getBases();
	List<Pieza> antebrazos = brazoDAO.getAntebrazos();
	List<Pieza> manos = brazoDAO.getManos();
%>

<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>RobotGL - Seleccion de robot por piezas</title>
	
			<!-- CSS -->
			<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
			<link href="css/personalStyle.css" rel="stylesheet">		
			
			
			<!-- JS -->
			<script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" ></script>
			<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
			<script src= "js/functions.js" ></script>		
			<script type="text/javascript" src="lib/jquery-2.1.4.min.js"></script>
			<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
			<script src="http://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.14.3/ui-bootstrap-tpls.js" ></script>
	</head>
	<body ng-app="menuAPP" ng-controller="mainController">
	
	
	
		<!-- ------------------------------------------------------ -->
		<!-- SLIDER DE BASES DE BRAZOS ROBOTICOS -->
				
		<div id="container" class="c-wrapper" style="width: 60%; margin-left: 20%" align="center">
		<!-- Con   class="carousel" no sale error pero no funciona-->
			<div id="Carousel-roboticArmB" class="carousel slide" >
				<ol class="carousel-indicators">
					<li data-target="#Carousel-roboticArmB" data-slide-to="0" class="active"></li>
					<%
					for(int i=1;i<=bases.size();i++)
					{
						%><li data-target="#Carousel-roboticArmB data-slide-to="<%out.println(i); %>" class></li><%
					}
					 %>
				</ol>
				
				<!-- Wrapper for slides -->
				<div class="carousel-inner">
				<%
						boolean activo=true;
						
						for(Pieza i: bases)
						{
							String url = i.getImg();
							if(activo)
							{
								activo=false;
								%>
								<div class="item active" id="base">
								<img src="<%out.println(url);%>" alt="IMG-NOT FOUND">
								<div class="carousel-caption">
									<h3><%out.println(i.getNombre());%></h3>
									<p><%out.println(i.getDescripcion());%></p>
								</div>
					 			</div>
								<%
							}
							else
							{
								%>
								<div class="item" id="base">
								<img src="<%out.println(url);%>" alt="IMG-NOT FOUND">
								<div class="carousel-caption">
									<h3><%out.println(i.getNombre());%></h3>
									<p><%out.println(i.getDescripcion());%></p>
								</div>
					 			</div>
								<%	
							}							
						}						
				%>
				</div>		    
				   	
		
				<!-- Controls -->
				  <a ng-non-bindable class="left carousel-control" href="#Carousel-roboticArmB" role="button" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				    <span class="sr-only">Anterior</span>
				  </a>
				  <a ng-non-bindable class="right carousel-control" href="#Carousel-roboticArmB" role="button" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				    <span class="sr-only">Siguiente</span>
				  </a>				  
				  <input type="hidden" id="sliderValue" name ="sliderValue" value={{}}>
			</div>
		</div>
		<hr>
		
		<!-- ------------------------------------------------------ -->
		<!-- SLIDER DE ANTEBRAZOS ROBOTICOS -->
				
		<div id="container" class="c-wrapper" style="width: 60%; margin-left: 20%" align="center">
		<!-- Con   class="carousel" no sale error pero no funciona-->
			<div id="Carousel-roboticArmA" class="carousel slide" >
				<ol class="carousel-indicators">
					<li data-target="#Carousel-roboticArmA" data-slide-to="0" class="active"></li>
					<%
					for(int i=1;i<=antebrazos.size();i++)
					{
						%><li data-target="#Carousel-roboticArmA data-slide-to="<%out.println(i); %>" class></li><%
					}
					 %>
				</ol>
				
				<!-- Wrapper for slides -->
				<div class="carousel-inner">
				<%
						activo=true;
						
						for(Pieza i: antebrazos)
						{
							String url = i.getImg();
							if(activo)
							{
								activo=false;
								%>
								<div class="item active" id="ante">
								<img src="<%out.println(url);%>" alt="IMG-NOT FOUND">
								<div class="carousel-caption">
									<h3><%out.println(i.getNombre());%></h3>
									<p><%out.println(i.getDescripcion());%></p>
								</div>
					 			</div>
								<%
							}
							else
							{
								%>
								<div class="item" id="ante">
								<img src="<%out.println(url);%>" alt="IMG-NOT FOUND">
								<div class="carousel-caption">
									<h3><%out.println(i.getNombre());%></h3>
									<p><%out.println(i.getDescripcion());%></p>
								</div>
					 			</div>
								<%	
							}						
						}
						
				%>
				</div>
						
				<!-- Controls -->
				  <a ng-non-bindable class="left carousel-control" href="#Carousel-roboticArmA" role="button" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				    <span class="sr-only">Anterior</span>
				  </a>
				  <a ng-non-bindable class="right carousel-control" href="#Carousel-roboticArmA" role="button" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				    <span class="sr-only">Siguiente</span>
				  </a>				  
				  <input type="hidden" id="sliderValue" name ="sliderValue" value={{}}>
			</div>
		</div>
		<hr>
		<!-- ------------------------------------------------------ -->
		<!-- SLIDER DE MANOS ROBOTICOS -->
				
		<div id="container" class="c-wrapper" style="width: 60%; margin-left: 20%" align="center">
		<!-- Con   class="carousel" no sale error pero no funciona-->
			<div id="Carousel-roboticArmM" class="carousel slide" >
				<ol class="carousel-indicators">
					<li data-target="#Carousel-roboticArmM" data-slide-to="0" class="active"></li>
					<%
					for(int i=1;i<=manos.size();i++)
					{
						%><li data-target="#Carousel-roboticArmM data-slide-to="<%out.println(i); %>" class></li><%
					}
					 %>
				</ol>
				
				<!-- Wrapper for slides -->
				<div class="carousel-inner">
				<%
						activo=true;
						
						for(Pieza i: manos)
						{
							String url = i.getImg();
							if(activo)
							{
								activo=false;
								%>
								<div class="item active" id="mano">
								<img src="<%out.println(url);%>" alt="IMG-NOT FOUND">
								<div class="carousel-caption">
									<h3><%out.println(i.getNombre());%></h3>
									<p><%out.println(i.getDescripcion());%></p>
								</div>
					 			</div>
								<%
							}
							else
							{
								%>
								<div class="item" id="mano">
								<img src="<%out.println(url);%>" alt="IMG-NOT FOUND">
								<div class="carousel-caption">
									<h3><%out.println(i.getNombre());%></h3>
									<p><%out.println(i.getDescripcion());%></p>
								</div>
					 			</div>
								<%	
							}							
						}						
				%>
				</div>		    
			  	<hr> 	
		
				<!-- Controls -->
				  <a ng-non-bindable class="left carousel-control" href="#Carousel-roboticArmM" role="button" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				    <span class="sr-only">Anterior</span>
				  </a>
				  <a ng-non-bindable class="right carousel-control" href="#Carousel-roboticArmM" role="button" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				    <span class="sr-only">Siguiente</span>
				  </a>				  
				  <input type="hidden" id="sliderValue" name ="sliderValue" value={{}}>
			</div>
		</div>
		<!-- ------------------------------------------------------ -->
		<form id="formShowBrazo" method="post" action="redirect" >
				<input type="button" value="Probar brazo seleccionado" ng-click="show()" class="btn btn-primary"/>
		</form>

		<script>
			var app = angular.module('menuAPP', ['ui.bootstrap']);
			app.controller('mainController', function($scope, $http, $window, $location) {
				$scope.hideError=true;
			    $scope.show = function() {
			    	
			    	//var targetDiv = document.getElementById("brazo").getElementsByClassName("active")[0];
			    	//var targetDiv2 = document.getElementById("antebrazo").getElementsByClassName("active")[0];
			    	//var targetDiv3 = document.getElementById("mano").getElementsByClassName("active")[0];
			    	
			    	
		  			$scope.currentBaseIndex = $("div.active#base").index() + 1;//Saca el indice actual del carousel
		  			$scope.currentAnteIndex = $("div.active#ante").index() + 1;//Saca el indice actual del carousel
		  			$scope.currentManoIndex = $("div.active#mano").index() + 1;//Saca el indice actual del carousel
		  			
		  			
		  			var params = "Data :"+$scope.currentBaseIndex+":"+$scope.currentAnteIndex+":"+$scope.currentManoIndex;
		  			var data = angular.toJson(params)
			    	$http({
			    	    method: 'POST',
			    	    url: 'showPieza',			    	    			    	   		    	  
 			    	    data: 'Data=' + data,
 			    	    headers : {
 			                'Content-Type' : 'application/x-www-form-urlencoded'
 			            }
			    	}).success(function(response)
	    			{
			    		post("formShowBrazo");
	    			});
			    };		
			    
			    function isActive(slide) {
			    	  return slide.active;
		    	};
		    	
		    	  
		    
			});		
		</script>	
	</body>
</html>