<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="mjuan.dao.PiezaDAO"%>
<%@page import="mjuan.dao.interfaces.PiezaIDAO"%>
<%@page import="mjuan.model.Pieza"%>
<%@page import="java.util.List"%>
<%@page import="mjuan.model.SubPieza"%>

<%
	PiezaIDAO piezaDAO = PiezaDAO.getInstance();
	List<Pieza> bases = piezaDAO.getBases();
	List<Pieza> antebrazos = piezaDAO.getAntebrazos();
	List<Pieza> manos = piezaDAO.getManos();
	
	int id_base = Integer.parseInt((String)session.getAttribute("id_base"));
	int id_antebrazo = Integer.parseInt((String)session.getAttribute("id_antebrazo"));
	int id_mano = Integer.parseInt((String)session.getAttribute("id_mano"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		BINGO PIEZAS
		<br>
		Base: 
		<%
		
		out.println(id_base);	 
		%>
		<br>
		Antebrazo: 
		<%
		
		out.println(id_antebrazo);	 
		%>
		<br>
		Mano: 
		<%
		
		out.println(id_mano);	%> 
		
		<div id='container' width=800, height=600>	
		
		<script src="lib/threejs/three.min.js"></script>
		<script src="lib/threejs/OrbitControls.js"></script>
		<script src="lib/threejs/dat.gui.min.js"></script>
		<script src="lib/threejs/stats.min.js"></script>	
		<script src="lib/threejs/Projector.js"></script>
		<script src="lib/threejs/CanvasRenderer.js"></script>
			
		<script src="js/variables.js"></script>
		<script src="js/selectObject.js"></script>
		<script src="js/webGL.js"></script>
		
		<script type="text/javascript">
		
		<%
			Pieza base=bases.get(id_base);
			Pieza antebrazo=antebrazos.get(id_antebrazo);
			Pieza mano=manos.get(id_mano);
			//BASE
			String url=base.getUrl();
			String tipo=base.getTipo_fk().getNombre();
			List<SubPieza> subPiezas = base.getSubPiezas();
			
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
			
			//ANTEBRAZO
			url=antebrazo.getUrl();
			tipo=antebrazo.getTipo_fk().getNombre();
			subPiezas = antebrazo.getSubPiezas();
			
			u=0;
			while(u<subPiezas.size())
			{
				String conf=subPiezas.get(u).getConf().toString();
				int n = subPiezas.get(u).getOrden();
				%>			
				setURL(<%="\""+url+"/"+tipo+"/"+tipo+n+".json\""%>,<%=conf%>);
				<%
				u++;
			}	
			
			//MANO
			url=mano.getUrl();
			tipo=mano.getTipo_fk().getNombre();
			subPiezas = mano.getSubPiezas();
			
			u=0;
			while(u<subPiezas.size())
			{
				String conf=subPiezas.get(u).getConf().toString();
				int n = subPiezas.get(u).getOrden();
				%>			
				setURL(<%="\""+url+"/"+tipo+"/"+tipo+n+".json\""%>,<%=conf%>);
				<%
				u++;
			}	
		
		%>
 		</script>
		<br>
	</body>
</html>