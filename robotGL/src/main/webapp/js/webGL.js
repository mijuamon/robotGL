
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
	
	//Inicializamos Selected_line
	LineGeometry.vertices.push(new THREE.Vector3(0, 10, 0));
	selected_line = new THREE.Line(LineGeometry, LineMaterial);
	
	scene.add(selected_line);
	
	
	glow = new THREE.Mesh(new THREE.Geometry(),new THREE.LineBasicMaterial());
	scene.add(glow);
	
	//Cargador de modelos JSON
	loader = new THREE.JSONLoader();	
	
	/*var PI2 = Math.PI * 2;
	var particleMaterial = new THREE.SpriteCanvasMaterial( {

		color: 0x000000,
		program: function ( context ) {

			context.beginPath();
			context.arc( 0, 0, 0.5, 0, PI2, true );
			context.fill();

		}});*/
	
	//Eventos
	window.addEventListener('resize',updateAspectRatio);
	window.addEventListener( 'mousedown', MouseInput, false );
	window.addEventListener('keydown', keyboardInput, false);
	
	
	////////////////////////////
	
	camera();
	lights();
	controls();	
	shaderTexture();
	renderer.render(scene, camera);
}
//Textura del shadere de glow
function shaderTexture()
{
	customMaterial = new THREE.ShaderMaterial( 
			{
			    uniforms: 
				{ 
					"c":   { type: "f", value: 1.0 },
					"p":   { type: "f", value: 4.0 },
					glowColor: { type: "c", value: new THREE.Color(0xffff00) },
					viewVector: { type: "v3", value: camera.position }
				},
				vertexShader:   document.getElementById( 'vertexShader'   ).textContent,
				fragmentShader: document.getElementById( 'fragmentShader' ).textContent,
				side: THREE.FrontSide,
				blending: THREE.AdditiveBlending,
				transparent: true
			}   );
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

//Creación de luces
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

//Cargamos a traves de la url recibida el modelo JSON
function setURL(url, conf)
{	
	var currentOrder=objectCount;
	objectCount+=1;
	
	var modelo = new THREE.Mesh();
	modelo.index=currentOrder;
	objectsArray[currentOrder]=modelo;
	
	if(conf!="")
	{			
		var txt=conf.split(';');
		var pos=txt[0].split(':')[1].split(',');
		var rot=txt[1].split(':')[1].split(',');			
		var sca=txt[2].split(':')[1].split(',');
		
		modelo.lim_pos=txt[3].split(':')[1].split(',')[0];
		modelo.lim_rot=txt[3].split(':')[1].split(',')[1];
	}
	else
	{
		var pos=new THREE.Vector3(0,0,0);
		var rot=new THREE.Vector3(0,0,0);
		var sca=new THREE.Vector3(1,1,1);
	}
	
	loader.load(url, function(geometry,materials)
	{
		//Cargamos el modelo
		modelo.material=new THREE.MeshFaceMaterial(materials);
		modelo.geometry=geometry;		
		modelo.url=url;
		
		//Guardamos la configuracion inicial en el propio modelo
		//El punto de anclaje de la pieza no tiene por que ser el mismo que el centro del objeto.
		//Por eso es necesario guardar su posicion inicial ya que cuando se aplique una traslaccion o rotacion
		//en este modelo, se debe de recolocar conforme a la rotación.
		modelo.pos=pos;
		modelo.rot=rot;
		modelo.sca=sca;
		
		//Colocamos la pieza en su lugar correspondiente
		modelo.position.set(parseInt(pos[0]),parseInt(pos[1]),parseInt(pos[2]));
		modelo.scale.set(parseInt(sca[0]),parseInt(sca[1]),parseInt(sca[2]));
			
	});	
}
//Inicializaremos el vector que contendra los modelos antes de montar el arbol de objetos
function startVector(aux)
{
	objectsArray = new Array(aux);
}

//Iniciamos la escena
function startScene(aux)
{
	while(objectCount<aux){}
	for(i=0;i<aux;i++)
	{
		var obj=objectsArray[i];
		var obj3D = new THREE.Object3D();
		obj3D.index=obj.index
		obj3D.lim_pos=obj.lim_pos;
		obj3D.lim_rot=obj.lim_rot;	
		obj3D.add(obj);	
		objects.push(obj);
		actualObject3d.add(obj3D);
		actualObject3d=obj3D;
	}
	
	
	scene.add(brazo);
}


init();
animate();	


