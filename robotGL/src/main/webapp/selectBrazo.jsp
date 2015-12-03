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
		<script src= "js/functions.js" ></script>
		
		
		<script src="libs/jquery-2.1.4.min.js"></script>
		<script src="//use.edgefonts.net/cabin;source-sans-pro:n2,i2,n3,n4,n6,n7,n9.js"></script>
	
		<!--Slipry-->
		<script src="libs/slippry/slippry.min.js"></script>
		<link rel="stylesheet" href="css/slippry.css">
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
	
	<script src="libs/threejs/three.min.js"></script>
	<script src="libs/threejs/OrbitControls.js"></script>
	<script src="libs/threejs/Coordinates.js"></script>
	<script src="libs/threejs/dat.gui.min.js"></script>
	<script src="libs/threejs/stats.min.js"></script>
	<script src="js/json.js"></script>
	
	<section class="wrapper">
		<ul id="slider2">
		<%
			List lista = picturesDAO.getPicturesPath(Global.PIEZA_TODO);
			for(int i=0; i<lista.size();i++)
			{
				Brazo brazo = (Brazo)lista.get(i);%>
				<li><img src="<%brazo.getUrl(); %>" />	</li><%
			}
		%>
		</ul>
	</section>
		
	<h1>BINGO</h1>
		<script>
			var slide = $('#slider2').slippry();
			var app = angular.module('menuAPP', ['ui.bootstrap']);
				app.controller('mainController', function($scope, $http, $window, $location)
				{
						$scope.myInterval = 5000;
					  $scope.noWrapSlides = false;
					  var slides = $scope.slides = [];
					  $scope.addSlide = function() {
					    var newWidth = 600 + slides.length + 1;
					    slides.push({
					      image: '//placekitten.com/' + newWidth + '/300',
					      text: ['More','Extra','Lots of','Surplus'][slides.length % 4] + ' ' +
					        ['Cats', 'Kittys', 'Felines', 'Cutes'][slides.length % 4]
					    });
					  };
					  for (var i=0; i<4; i++) {
					    $scope.addSlide();
					  }
				});
		</script>
	</body>
</html>