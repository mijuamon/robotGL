
function init()
{
	//Obtenemos el objeto donde colocaremos el canvas
	renderer = new THREE.WebGLRenderer({antialias: true});
	renderer.setSize(width,height);	
	renderer.setClearColor(new THREE.Color(0x0000AA),1.0);
	document.getElementById('container').appendChild(renderer.domElement);
	
	//Creamos la escena
	scene =new THREE.Scene();	
	
	//Grid de apoyo
	scene.add(new THREE.GridHelper(20,1));
	
	//Cargador de modelos JSON
	loader = new THREE.JSONLoader();	
	
	var PI2 = Math.PI * 2;
	particleMaterial = new THREE.SpriteCanvasMaterial( {

		color: 0x000000,
		program: function ( context ) {

			context.beginPath();
			context.arc( 0, 0, 0.5, 0, PI2, true );
			context.fill();

		}});
	
	//Eventos
	window.addEventListener('resize',updateAspectRatio);
	window.addEventListener( 'mousemove', onMouseMove, false );
	
	
	////////////////////////////
	var material = new THREE.MeshBasicMaterial({color:0xFF0000, wireframe:true});
	var geometriaCubo = new THREE.CubeGeometry(10,10,10);
	var cubo = new THREE.Mesh(geometriaCubo,material);
	cubo.position.x=-7;
	scene.add(cubo);
	objects.add(cubo);
	
	camera();
	lights();
	controls();
	//animate();
}
function animate() {
	requestAnimationFrame( animate );
	cameraControls.update();
	renderer.render( scene, camera );
}

function onMouseMove( e ) {
	
	mouseVector.x = 2 * (e.clientX / width) - 1;
	mouseVector.y = 1 - 2 * ( e.clientY / height );
	
	
	//http://soledadpenades.com/articles/three-js-tutorials/object-picking/
	//http://stackoverflow.com/questions/11036106/three-js-projector-and-ray-objects/
	
	//var ray = new THREE.Ray(camera.position, mouseVector.clone());
	var raycaster = new THREE.Raycaster();
	raycaster.setFromCamera(mouseVector.clone(), camera);
	//var raycaster = projector.setFromCamera( mouseVector.clone(), camera );
	var intersects = raycaster.intersectObjects( scene.children );

	objects.children.forEach(function( cube ) {
		cube.material.color.setRGB( cube.grayness, cube.grayness, cube.grayness );
	});

		
	if( intersects.length>=1 ) 
	{
		var intersection = intersects[ 0 ];
		var obj = intersection.object;

		var aux = obj.material.materials;		
		//Recorremos todos los materiales del objeto
		if (aux!=null)
		{
			//Debe restablecer el objeto seleccionado al color original antes de cambiar al siguiente
			for (var u=0; u<aux.length; u++)
			{
				aux[u].color.setHex( 0xffffff);//Mejor setRGB
				
			}
		}
	}	
}

//Creacion y inicializacion de controles
function controls()
{
	
	//Movimiento de la camara con el raton
	cameraControls = new THREE.OrbitControls(camera, renderer.domElement);
	cameraControls.target.set(0,0,0);
}

//Creacion de la camara
function camera()
{
	var aspectRatio = width/height;	
	camera = new THREE.PerspectiveCamera(45, aspectRatio,0.1,100);
	camera.position.set(15,7,15);
	camera.lookAt(new THREE.Vector3(0,0,0));
	
}

//CREACION DE LUCES
function lights()
{
	//Luz ambiental
	ambientLight = new THREE.AmbientLight(0xffffff);
	scene.add(ambientLight);	
	
	//Luz direccional
	directionalLight = new THREE.DirectionalLight(0xffffff);
	directionalLight.position.set(0,1,0);
	scene.add(directionalLight);
}

function updateAspectRatio()
{
	//Renovar las dimensiones del renderer
	renderer.setSize(window.innerWidth, window.innerHeight);
	//Renovar la relacion de aspecto de frutum
	camera.aspect = window.innerWidth / window.innerHeight;
	
	camera.updateProjectionMatrix();
}
function animate() {

    requestAnimationFrame( animate );

   // modelo.rotation.x += 0.05;

    renderer.render( scene, camera );
}

function setURL(url, conf)
{	
	loader.load(url, function(geometry,materials)
	{
		//Cargamos el modelo
		modelo = new THREE.Mesh(geometry, new THREE.MeshFaceMaterial(materials));
		//modelo.geometry.computeTangents();
		
		//Cargamos el archivo de configuracion del modelo
		//------------------------------------		
		if(conf!="")
		{			
			var txt=conf.split(';');
			var pos=txt[0].split(':')[1].split(',');
			var rot=txt[1].split(':')[1].split(',');			
			var sca=txt[2].split(':')[1].split(',');
				
			modelo.position.set(parseInt(pos[0]),parseInt(pos[1]),parseInt(pos[2]));
			modelo.scale.set(parseInt(sca[0]),parseInt(sca[1]),parseInt(sca[2]));
			
		}
		//------------------------------------		
		objects.add(modelo);
		scene.add(modelo);		
	});	
}

init();
animate();	
