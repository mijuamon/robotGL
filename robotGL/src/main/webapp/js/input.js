/**
 * 
 */

function keyboardInput(event)
{
	if(event.keyCode==65 || event.keyCode==68 || event.keyCode==87 || event.keyCode==83)
	{
		if(actualObject!=undefined)
		{
			//ActualObject es el objeto seleccionado con el raton
			var indiceA=actualObject.index;
			var auxObjects3D = brazo.children[0];
			do
			{
				if(auxObjects3D==null)
					return;
				if (auxObjects3D.children[0].index == indiceA)
					break;
				else
					auxObjects3D=auxObjects3D.children[1];			
			}
			while(true);
			
			//EJES
			var axisX= new THREE.Vector3(1,0,0); 
			var axisY= new THREE.Vector3(1,0,0); 
			var axisZ= new THREE.Vector3(1,0,0); 
			
			var prev_pos=new THREE.Vector3(auxObjects3D.position);
			auxObjects3D.position=new THREE.Vector3(0,0,0);//Movemos a origen antes de hacer alguna transformacion
			
			
			if(auxObjects3D.lim_pos!=0 && auxObjects3D.lim_rot!=0)//Rotacion y desplazamiento
			{
				 switch (event.keyCode) 
				 {
				 
				 //DESPLAZAMIENTO
					case 65: // Left A -- reduce
						if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),1)==1)//X
							auxObjects3D.translateOnAxis( axisX,-0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),2)==1)//Y
							auxObjects3D.translateOnAxis( axisY,-0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),3)==1)//Z
							auxObjects3D.translateOnAxis( axisZ,-0.1);
					  break;	
					case 68: // Right D -- increase
						if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),1)==1)//X
							auxObjects3D.translateOnAxis( axisX,0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),2)==1)//Y
							auxObjects3D.translateOnAxis( axisY,0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),3)==1)//Z
							auxObjects3D.translateOnAxis( axisZ,0.1);
					  break;
					  
					  //ROTACION
					case 87: // Up
						if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),1)==1)//X
							auxObjects3D.rotateOnAxis( axisX,-0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),2)==1)//Y
							auxObjects3D.rotateOnAxis( axisY,-0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),3)==1)//Z
							auxObjects3D.rotateOnAxis( axisZ,-0.1);
					  break;
					case 83: // Down
						if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),1)==1)//X
							auxObjects3D.rotateOnAxis( axisX,0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),2)==1)//Y
							auxObjects3D.rotateOnAxis( axisY,0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),3)==1)//Z
							auxObjects3D.rotateOnAxis( axisZ,0.1);
					  break;
				  }
			}
			else if(auxObjects3D.lim_pos!=0)//Solo desplazamiento
			{
				 switch (event.keyCode) 
				 {
				 
				 //DESPLAZAMIENTO
					case 65: // Left A -- reduce
						if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),1)==1)//X
							auxObjects3D.translateOnAxis( axisX,-0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),2)==1)//Y
							auxObjects3D.translateOnAxis( axisY,-0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),3)==1)//Z
							auxObjects3D.translateOnAxis( axisZ,-0.1);
					  break;	
					case 68: // Right D -- increase
						if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),1)==1)//X
							auxObjects3D.translateOnAxis( axisX,0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),2)==1)//Y
							auxObjects3D.translateOnAxis( axisY,0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_pos),3)==1)//Z
							auxObjects3D.translateOnAxis( axisZ,0.1);
					  break;
				  }
			}
			else //Solo rotacion
			{
				 switch (event.keyCode) 
				 {  
					  //ROTACION
					case 87: // Up
						if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),1)==1)//X
							auxObjects3D.rotateOnAxis( axisX,-0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),2)==1)//Y
							auxObjects3D.rotateOnAxis( axisY,-0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),3)==1)//Z
							auxObjects3D.rotateOnAxis( axisZ,-0.1);
					  break;
					case 83: // Down
						if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),1)==1)//X
							auxObjects3D.rotateOnAxis( axisX,0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),2)==1)//Y
							auxObjects3D.rotateOnAxis( axisY,0.1);
						else if ( ConvertBase.bitPos(ConvertBase.dec2bin(auxObjects3D.lim_rot),3)==1)//Z
							auxObjects3D.rotateOnAxis( axisZ,0.1);
					  break;
				  }
			}
			
			//Volvemos a colocar a su posicion original con los cambios realizados
			auxObjects3D.position=new THREE.Vector3(auxObjects3D.position.x+prev_pos.x, auxObjects3D.position.y+prev_pos.y, auxObjects3D.position.z+prev_pos.z);		
			animate();
		}
	}
}





function MouseInput( e ) {
	var aux=window.innerWidth;
	mouseVector.x = (e.clientX / aux) * 2 - 1;
	mouseVector.y = - ( e.clientY / height ) * 2 + 1;
	//mouseVector.z=0.5;
	
	
	//http://soledadpenades.com/articles/three-js-tutorials/object-picking/
	//http://stackoverflow.com/questions/11036106/three-js-projector-and-ray-objects/
	
	//var ray = new THREE.Ray(camera.position, mouseVector.clone());
	var raycaster = new THREE.Raycaster();
	raycaster.setFromCamera(mouseVector, camera);
	//var raycaster = projector.setFromCamera( mouseVector.clone(), camera );
	var intersects = raycaster.intersectObjects(objects);

	if( intersects.length>=1 ) 
	{
		
		var intersection = intersects[ 0 ];
		var obj = intersection.object;
		
		
		/////////////DEBUG/////////////////
		if(show_tray)
		{
			//Esfera de punto de origen
			var geometry = new THREE.SphereGeometry( 0.5);
			var material = new THREE.MeshBasicMaterial( {color: 0xffff00} );
			var sphere = new THREE.Mesh( geometry, material );
			sphere.translateX(raycaster.ray.origin.x);
			sphere.translateY(raycaster.ray.origin.y);
			sphere.translateZ(raycaster.ray.origin.z);
			
			//Esfera de direccion de trayectoria
			var geometry2 = new THREE.SphereGeometry( 0.2);
			var material2 = new THREE.MeshBasicMaterial( {color: 0x00ff00} );
			var sphere2 = new THREE.Mesh( geometry2, material2 );
			sphere2.translateX(raycaster.ray.origin.x+raycaster.ray.direction.x);
			sphere2.translateY(raycaster.ray.origin.y+raycaster.ray.direction.y);
			sphere2.translateZ(raycaster.ray.origin.z+raycaster.ray.direction.z);
			
			scene.add( sphere );
			scene.add(sphere2);
			
			//Linea de trayectoria
			
			var LineGeometry = new THREE.Geometry();
			
			LineGeometry.vertices.push(raycaster.ray.origin);
			LineGeometry.vertices.push(obj.geometry.vertices[0]);
			var line_tray = new THREE.Line(LineGeometry, LineMaterial);
			scene.add(line_tray);
		}
		/////////////////////////////////
		
	

			var aux = obj.material.materials;	
			
			
			var geometry = obj.geometry;
			
			
			geometry.computeBoundingBox();

			var pv = new THREE.Vector3();
			pv.addVectors( geometry.boundingBox.min, geometry.boundingBox.max );
			pv.multiplyScalar( - 0.5 );

			//pv.applyMatrix4( obj.matrixWorld );
			//var pV=new THREE.Vector3(centerX,centerY,centerZ);
			

			LineGeometry = new THREE.Geometry();
			var contorno = obj.geometry.vertices;
			
			
			for(i=0;i<contorno.length;i++)
			{
				var auxVert=contorno[i]
				var auxX,auxY,auxZ;
				if(auxVert.x>pv.x)			
					auxX=auxVert.x+0.05;			
				else if(auxVert.x<pv.x)
					auxX=auxVert.x-0.05;
				
				if(auxVert.y>pv.y)			
					auxY=auxVert.y+0.05;			
				else if(auxVert.y<pv.y)
					auxY=auxVert.y-0.05;
				
				if(auxVert.z>pv.z)			
					auxZ=auxVert.z+0.05;			
				else if(auxVert.z<pv.z)
					auxZ=auxVert.z-0.05;
				LineGeometry.vertices.push(new THREE.Vector3(auxX,auxY,auxZ));			
				
			}
			
			scene.remove(selected_line);
			selected_line = new THREE.Line(LineGeometry, LineMaterial);
			scene.add(selected_line);
			
			actualObject=obj;
		
	}
	
	animate();
}