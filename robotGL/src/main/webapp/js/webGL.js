init();
animate();	
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
	document.addEventListener( 'mousedown', onDocumentMouseDown, false );
	document.addEventListener( 'touchstart', onDocumentTouchStart, false );
	
	
	
	
	
	camera();
	lights();
	//controls();
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
	camera.position.set(0,5,30);
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
	//window.stop()
	URL = url+'/model.json';	
	
	loader.load(URL, function(geometry,materials)
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
		objects.push( modelo );
		scene.add(modelo);		
	});	
}


