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
var objects = [];
var mouse = new THREE.Vector2();
var raycaster = new THREE.Raycaster();
var particleMaterial;