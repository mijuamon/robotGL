/**
 * ALMACENAMIENTO DE TODAS LAS VARIABLES
 */

var width = window.innerWitdh,
	height = window.innerHeight,
	clock = new THREE.Clock(),
	scene,
	camera,
	renderer,
	ambientLight,
	directionalLight,
	loader,
	//Objeto que engobla los objetos que se modificaran
	modelo = new THREE.Object3D(),
	suelo = new THREE.Object3D(),
	base = new THREE.Object3D(),
	antebrazo = new THREE.Object3D(),
	mano = new THREE.Object3D(),
	cameraConmtrols,
	URL;
var particleMaterial;

//Object pick
var objects = new THREE.Object3D();
var projector = new THREE.Projector();
var mouseVector = new THREE.Vector3();
var actual = new THREE.Mesh();//Guardamos el objeto que tiene el puntero para luego devolverle el color
