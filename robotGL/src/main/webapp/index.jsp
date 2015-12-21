<html>
<head>
	<script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" ></script>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
	
	<script src="http://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.14.3/ui-bootstrap-tpls.js" ></script>
	
	
	<script src= "js/functions.js" ></script>
	

	
</head>
<body ng-app="menuAPP" ng-controller="mainController">
	<div class="btn-group btn-group-justified" role="group" aria-label="..." align="center">
		<div class="btn-group" role="group">
			<form id="formBrazo" method="post" action="redirect" >
				<input type="button" value="Probar un brazo completo" ng-click="brazo_completo()" class="btn btn-primary"/>
			</form>
			<form id="formPieza" method="post" action="redirect" >
				<input type="button" value="Montar un brazo por piezas" ng-click="brazo_piezas()" class="btn btn-info"/>
			</form>
		</div>
	</div>




	<script>
			var app = angular.module('menuAPP', ['ui.bootstrap']);
			app.controller('mainController', function($scope, $http, $window, $location) {
			    $scope.brazo_completo = function() {
			    	$http({
			    	    method: 'post',
			    	    url: 'MenuBrazoAction'			    	    
			    	}).success(function(response)
	    			{
			    		post("formBrazo");
	    			});
			    };
			    $scope.brazo_piezas = function () 
			    {
			    	$http({
			    	    method: 'post',
			    	    url: 'MenuPiezaAction'			    	    
			    	}).success(function(response)
	    			{
			    		post("formPieza");
	    			});
			    };
			
			});
			
		
	</script>

</body>
</html>
