<div class="container">
				<div class="nav-header">
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle dark"><i></i></a>
					<h1 id="fh5co-logo"><a href="indexAdmin.jsp"><i class="icon-airplane"></i>TIWbnb</a></h1>
					<!-- START #fh5co-menu-wrap -->
					<nav id="fh5co-menu-wrap" role="navigation">
						<ul class="sf-menu" id="fh5co-primary-menu">
							<li ><a href="indexAdmin.jsp">Home</a></li>
							<li>
								      
				
								      
								      <form id="formMensajesAdmin" method="POST" action="RecibirMensajesAdminServlet">
								      <a onclick="funcionMensajesAdmin()" style="cursor:pointer;" >Mensajes</a>
								      
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
								    
								     <li>
								      
								     
								       <a onclick="funcionGestionUsuarios()" style="cursor:pointer;" >Gestión Usuarios</a>
								      <form id="formGestionUsuarios" method="POST" action="GestionUsuariosServlet">
								      
								      
								      </form></li>
								       <li>
								      
								   
								       <a onclick="funcionGestionReservas()" style="cursor:pointer;" >Gestión Reservas</a>
								      <form id="formGestionReservas" method="POST" action="GestionAlojamientosServlet">
								      
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

function funcionMensajesAdmin(){
	
	document.getElementById("formMensajesAdmin").submit();	
}

function funcionCierreSesion(){
	
	document.getElementById("formCierreSesion").submit();	
}

function funcionGestionReservas(){
	
	document.getElementById("formGestionReservas").submit();	
}

function funcionGestionUsuarios(){
	
	document.getElementById("formGestionUsuarios").submit();	
}

</script>

