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

//Usado para guardar el orden en que se guarada en el arbol.
//Cada object3D tendra la variable indice con el mismo valor que el objeto
//que tiene.
var indice=0;

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