
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
	//scene.add(new THREE.GridHelper(20,1));
	
	//Inicializamos el objeto LINE usado para dibujar una polilinea alrededor del objeto seleccionado
	LineMaterial = new THREE.LineBasicMaterial({
	    color: 0xF6CC4C
	});
	var LineGeometry = new THREE.Geometry();
	
	LineGeometry.vertices.push(new THREE.Vector3(0, 10, 0));
	selected_line = new THREE.Line(LineGeometry, LineMaterial);
	
	scene.add(selected_line);
	//Cargador de modelos JSON
	loader = new THREE.JSONLoader();	
	
	var PI2 = Math.PI * 2;
	var particleMaterial = new THREE.SpriteCanvasMaterial( {

		color: 0x000000,
		program: function ( context ) {

			context.beginPath();
			context.arc( 0, 0, 0.5, 0, PI2, true );
			context.fill();

		}});
	
	//Eventos
	window.addEventListener('resize',updateAspectRatio);
	window.addEventListener( 'mousedown', MouseInput, false );
	window.addEventListener('keydown', keyboardInput, false);
	
	
	////////////////////////////
	
	camera();
	lights();
	controls();	
	renderer.render(scene, camera);
}



function animate() {
	requestAnimationFrame( animate );
	cameraControls.update();
	renderer.render( scene, camera );
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
    renderer.render( scene, camera );
}

function setURL(url, conf)
{	
	loader.load(url, function(geometry,materials)
	{
		//Cargamos el modelo
		modelo = new THREE.Mesh(geometry, new THREE.MeshFaceMaterial(materials));
		//modelo.geometry.computeTangents();
		var obj3D = new THREE.Object3D();
		//Cargamos el archivo de configuracion del modelo
		//------------------------------------		
		if(conf!="")
		{			
			var txt=conf.split(';');
			var pos=txt[0].split(':')[1].split(',');
			var rot=txt[1].split(':')[1].split(',');			
			var sca=txt[2].split(':')[1].split(',');
			
			//Metemos las limitacionjes y el indice
			obj3D.lim_pos=txt[3].split(':')[1].split(',')[0];
			obj3D.lim_rot=txt[3].split(':')[1].split(',')[1];				
			obj3D.index=indice;
			/*Necesario que lo tenga tambien el objeto para que cuando el raycaster detecte este objeto, sepa hasta que nivel
			del arbol debe de llegar para estar en el object3D correcto, para que el resto de arbol se mueva a la vez que
			se mueve el objeto seleccionado.*/
			modelo.index=indice;
			
			
			indice =indice+1;
			
			modelo.position.set(parseInt(pos[0]),parseInt(pos[1]),parseInt(pos[2]));
			modelo.scale.set(parseInt(sca[0]),parseInt(sca[1]),parseInt(sca[2]));
			
		}
		//------------------------------------
		obj3D.add(modelo);
		//scene.add(modelo);
				
		objects.push(modelo);
		actualObject3d.add(obj3D);//Añadimos el Object3D al arbol
		actualObject3d=obj3D;
		//actualObject=obj3D;
	});	
}

function startScene()
{
	scene.add(brazo);
}


init();
animate();	


