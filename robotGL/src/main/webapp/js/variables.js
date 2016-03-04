/**
 * ALMACENAMIENTO DE TODAS LAS VARIABLES GLOBALES
 */

//////////////DEBUG///////////////////
var show_tray=false; //Para si queremos ver las trayectorias del raycaster
/////////////////////////////////////



var width = window.innerWidth,
	height = window.innerHeight,
	clock = new THREE.Clock(),
	scene,
	camera,
	renderer,
	ambientLight,
	directionalLight,
	loader,
	URL;

var mouseVector = new THREE.Vector2();

//Almacenamos el objeto polilinea del objeto seleccionado
var selected_line;
var currentObject;

//Guardamos el indice del objeto seleccionado
var actualObject;

//Para el orden en que se encuentran los brazos
var brazo=new THREE.Object3D();
var actualObject3d=brazo; //Usado para guardar la parte de brazo anteriormente guardado.

var objects=[];

var LineMaterial;
var line_tray;


//SHADERS 
//-------

//material
var customMaterial;
var glow;

//////////////////

var objectCount = 0;
var objectsArray;


var auxnum=0;