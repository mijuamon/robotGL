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
var actual;//Guardamos el objeto que tiene el puntero para luego devolverle el color
var Pmaterials;//Los materiales del objeto que actualmente tiene el puntero

var LineMaterial = new THREE.LineBasicMaterial({
    color: 0x0000ff
});
var LineGeometry = new THREE.Geometry();
var auxVert;
var line;