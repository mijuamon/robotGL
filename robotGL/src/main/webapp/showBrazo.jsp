<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="mjuan.model.Brazo"%>
<%@page import="mjuan.dao.BrazoDAO"%>
<%@page import="mjuan.dao.interfaces.BrazoIDAO"%>
<%@page import="mjuan.model.Pieza"%>
<%@page import="mjuan.model.SubPieza"%>
<%@page import="java.util.List"%>


<%
	BrazoIDAO brazoDAO = BrazoDAO.getInstance();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>RobotGL - Mostrar brazo</title>
	</head>
	<body>
	
	BINGO BRAZO 
		<%	
			int id = Integer.parseInt((String)session.getAttribute("id_brazo"));
			out.println(id);	
		%>
		<div id='container' width=800, height=600>	
		
		<script src="lib/threejs/three.min.js"></script>
		<script src="lib/threejs/OrbitControls.js"></script>
		<script src="lib/threejs/dat.gui.min.js"></script>
		<script src="lib/threejs/stats.min.js"></script>	
		<script src="lib/threejs/Projector.js"></script>
		<script src="lib/threejs/CanvasRenderer.js"></script>
			
		<script src="js/variables.js"></script>
		<script src="js/baseConverter.js"></script>
		<script src="js/input.js"></script>
		<script src="js/webGL.js"></script>
		
		<script type="text/javascript">
			<%
					Brazo brazo = brazoDAO.getBrazo(id);
				
				List<Pieza> piezas = brazo.getPiezas();
				
				int i=0;
				while(i<piezas.size())
				{
					String url=piezas.get(i).getUrl();
					String tipo=piezas.get(i).getTipo_fk().getNombre();
					List<SubPieza> subPiezas = piezas.get(i).getSubPiezas();
					int u=0;
					while(u<subPiezas.size())
					{
						String conf=subPiezas.get(u).getConf().toString();
						int n = subPiezas.get(u).getOrden();
						%>			
						setURL(<%="\""+url+"/"+tipo+"/"+tipo+n+".json\""%>,<%=conf%>);
						<%
						u++;
					}
					i++;
				}
			%>			
 		</script>
 		<script type="text/javascript">
 		startScene();
 		</script>
		
	</body>
</html>