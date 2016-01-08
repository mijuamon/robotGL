<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="mjuan.model.Brazo"%>
<%@page import="mjuan.dao.BrazoDAO"%>
<%@page import="mjuan.dao.interfaces.BrazoIDAO"%>
<%@page import="mjuan.util.Global"%>

<%
	BrazoIDAO brazoDAO = BrazoDAO.getInstance();
	List<Brazo> brazos = brazoDAO.getBrazos();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>RobotGL - Seleccion de robot</title>
		
		
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

		<!-- SLIDER DE IMAGENES -->
		
		<div id="container" class="c-wrapper" style="width: 60%; margin-left: 20%" align="center">
		<!-- Con   class="carousel" no sale error pero no funciona-->
			<div id="Carousel-roboticArm" class="carousel slide" >
				<ol class="carousel-indicators">
					<li data-target="#Carousel-roboticArm" data-slide-to="0" class="active"></li>
					<%
					for(int i=1;i<brazos.size();i++)
					{
						%><li data-target="#Carousel-roboticArm" data-slide-to="<%out.println(i); %>" class></li><%
					}
					 %>
				</ol>
				
				<!-- Wrapper for slides -->
				<div class="carousel-inner">
				<%
						boolean activo=true;
						
						for(Brazo i: brazos)
						{
							String url = i.getImg();
							if(activo)
							{
								activo=false;
								%><div class="item active"><%
							}
							else
							{
								%>
								<div class="item">
								<%	
							}
							%>
							<img src="<%out.println(url);%>" alt="IMG-NOT FOUND">
							<div class="carousel-caption">
								<h3><%out.println(i.getNombre());%></h3>
								<p><%out.println(i.getDescripcion());%></p>
							</div>
				 			</div><%
						}
						
				%>
				</div>		    
				   	
		
				<!-- Controls -->
				  <a ng-non-bindable class="left carousel-control" href="#Carousel-roboticArm" role="button" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				    <span class="sr-only">Anterior</span>
				  </a>
				  <a ng-non-bindable class="right carousel-control" href="#Carousel-roboticArm" role="button" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				    <span class="sr-only">Siguiente</span>
				  </a>				  
				  <input type="hidden" id="sliderValue" name ="sliderValue" value={{}}>
<!-- 				  <s:hidden name="nSlider" id="sliderValue" ng-hide="hideError"/>			 -->
			</div>
		</div>
	
		
		
		<form id="formShowBrazo" method="post" action="redirect" >
				<input type="button" value="Probar brazo seleccionado" ng-click="show()" class="btn btn-primary"/>
		</form>
		
		
		
		<script>
			var app = angular.module('menuAPP', ['ui.bootstrap']);
			app.controller('mainController', function($scope, $http, $window, $location) {
				$scope.hideError=true;
			    $scope.show = function() {
			    				    	
			    		    	
		  			$scope.currentIndex = $('div.active').index() + 1;//Saca el indice actual del carousel
		  			var params = "NSlider :"+$scope.currentIndex;
		  			var data = angular.toJson(params)
			    	$http({
			    	    method: 'POST',
			    	    url: 'showBrazo',			    	    			    	   		    	  
 			    	    data: 'NSlider=' + data,
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