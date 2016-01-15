var width = window.innerWitdh,
	height = window.innerHeight,
	clock = new THREE.Clock(),
	scene,
	camera,
	renderer,
	ambientLight,
	directionalLight,
	loader,
	modelo = new THREE.Object3D(),
	cameraConmtrols,
	URL;

	//init();
	//animate();	


function init()
{
	

	renderer = new THREE.WebGLRenderer({antialias: true});
	renderer.setSize(width,height);	
	renderer.setClearColor(new THREE.Color(0x0000AA),1.0);
	document.getElementById('#container').appendChild(renderer.domElement);
	
	scene =new THREE.Scene();
	var aspectRatio = window.innerWidth/window.innerHeight;
	
	camera = new THREE.PerspectiveCamera(45, aspectRatio,0.1,100);
	camera.position.set(0,5,30);
	camera.lookAt(new THREE.Vector3(0,0,0));
	
	ambientLight = new THREE.AmbientLight(0xffffff);
	scene.add(ambientLight);
	
	directionalLight = new THREE.DirectionalLight(0xffffff);
	directionalLight.position.set(0,1,0);
	scene.add(directionalLight);
	
	scene.add(new THREE.GridHelper(10,1));
	loader = new THREE.JSONLoader();	
	
	
	//Cubo de prueba
	/*var material = new THREE.MeshBasicMaterial({color:0xFF0000, wireframe:true});
	var geometriaCubo = new THREE.CubeGeometry(2,2,2);
	var cubo = new THREE.Mesh(geometriaCubo,material);
	cubo.position.x=-1;
	scene.add(cubo);*/
	
	
	
	cameraControls = new THREE.OrbitControls(camera, renderer.domElement);
	cameraControls.target.set(0,0,0);
	window.addEventListener('resize',updateAspectRatio);
	animate();	
	
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

function setURL(url)
{
	//window.stop()
	URL = url+'/model.json';	
	
	loader.load(URL, function(geometry,materials)
	{
		//Cargamos el modelo
		modelo = new THREE.Mesh(geometry, new THREE.MeshFaceMaterial(materials));
		
		
		//Cargamos el archivo de configuracion del modelo
		//------------------------------------
	
		$.get(url+'/config.cfg', function(result) 
		{
			var txt=result.split('\n');
			var pos=txt[2].split(':')[1].split(',');
			var rot=txt[3].split(':')[1].split(',');			
			var sca=txt[4].split(':')[1].split(',');
				
			modelo.position.set(parseInt(pos[0]),parseInt(pos[1]),parseInt(pos[2]));
			modelo.scale.set(parseInt(sca[0]),parseInt(sca[1]),parseInt(sca[2]));
		});

		//------------------------------------
	
		scene.add(modelo);		
	});	
}


