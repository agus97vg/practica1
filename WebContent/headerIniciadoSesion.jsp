<div class="container">
				<div class="nav-header">
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle dark"><i></i></a>
					<h1 id="fh5co-logo"><a href="indexSesionIniciada.jsp"><i class="icon-airplane"></i>TIWbnb</a></h1>
					<!-- START #fh5co-menu-wrap -->
					<nav id="fh5co-menu-wrap" role="navigation">
						<ul class="sf-menu" id="fh5co-primary-menu">
							<li><a href="indexSesionIniciada.jsp">Home</a></li>
							<li>
								      
								      <form id="formReservas"method="POST" action="MostrarReservasServlet">
								      <a onclick="funcionReservas()" style="cursor:pointer;" >Viajes</a>
								      
							</form></li>
							
							
							<li>
								      
								      <form id="formMensajes" method="POST" action="RecibirMensajesServlet">
								      <a onclick="funcionMensajes()" style="cursor:pointer;" >Mensajes</a>
								      
								      
							</form></li>
						
							
							
							
							<li><a><% //Try{
								 
								//String variable = (String) request.getAttribute("nombre");
								//}Catch(Exception e){
									
								//Imprime en pantalla el error que se ocasione 
								//	out.println(getMessage());
								//}
								
								
								//String variable =  (String) session.getAttribute("nombre");
								//System.out.println(variable);
								//out.println(variable);
								
								String username = (String)request.getSession().getAttribute("nombre");
								out.println(username);
								%></a>
							
								<ul class="dropdown-menu">
								      <li><a href="userData.jsp">Editar perfil</a></li>
								      
								      <li>
								      
								      
								       <a onclick="funcionAlojamientos()" style="cursor:pointer;" >Mis alojamientos</a>
								       <form id="formAlojamientos" method="POST" action="MisAlojamientosServlet">
								      
								      </form></li>
								      <li><a href="altaAlojamiento.jsp">Añadir alojamiento</a></li>
								     <li>
								      
								      
								      <a onclick="funcionSolReservas()" style="cursor:pointer;" >Confirma reservas</a>
								      <form id="formSolReservas" method="POST" action="RecibirSolicitudReserva">
								      
							</form></li>
								     
								     
								     
								    
								     
								      <li>
								      						       
								      <a onclick="funcionCierreSesion()" style="cursor:pointer;" >Cerrar sesión</a>
								      <form id="formCierreSesion" method="POST" action="EliminarSesionServlet">
								      
								      
								      </form></li>
								
									 
								</ul>	
							</li>                    
						</ul>
						
						
					</nav>
				</div>
</div>

<script>

function funcionMensajes(){
	
	document.getElementById("formMensajes").submit();	
}

function funcionReservas(){
	
	document.getElementById("formReservas").submit();	
}

function funcionAlojamientos(){
	
	document.getElementById("formAlojamientos").submit();	
}

function funcionSolReservas(){
	
	document.getElementById("formSolReservas").submit();	
}

function funcionCierreSesion(){
	
	document.getElementById("formCierreSesion").submit();	
}


</script>