

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="head.jsp" %>
<%@include file="comprobarLogin.jsp"%>

<%@page 

 			import="java.util.ArrayList" 
			import="datapackage.*"

		%>


</head>
<body>
<div id="fh5co-wrapper">
		<div id="fh5co-page">
<header id="fh5co-header-section" class="sticky-banner">

<%@include file="headerAdmin.jsp" %>
</header>


<div id="message-container" class="fh5co-section-gray">	

<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
						<h3>Usuarios</h3>
						<p>Estos son los usuarios registrados en la aplicacion.</p>
				</div>
				
</div>



<div class="row row-bottom-padded-md">			
				<div class="col-md-12 ">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="table-container">
								<table class="table table-filter">
									<tbody>
								<% 
									
									HttpSession miSesion= request.getSession();
									
								
									ArrayList <Usuario> Usuario =(ArrayList <Usuario>) miSesion.getAttribute("arrayUsers");
									int numero=Usuario.size();
									for(int i = 0; i < numero; i+=1) { 
										System.out.println(Usuario.get(i).getNombre());
									%>
													
										<tr>
											<td>
												<div class="claseCentrar"> 
													<h4 class="title"><%out.println(Usuario.get(i).getCorreo()); %></h4>
												</div>
										
											</td>
										
										
										
											<td>
												<div class="media">
												
													<form method="POST" action="ModificarUsuariosAdminServlet">
															<a> <input type="hidden" name="miBotonModificar" value='<%=i%>' /> </a>
															<a> <input type="submit" class="btn btn-primary btn-block"  value="Modificar datos"> </a>
													</form>
													
												</div>
											</td>
											
											
											<td>
												<div class="media">
													<form method="POST" action="EliminarUsuarioAdminServlet">
															<a> <input type="hidden" name="miBotonEliminar" value='<%=i%>' /> </a>
															<a> <input type="submit" class="btn btn-primary btn-block"  value="Eliminar Usuario"> </a>
													</form>
												</div>
											</td>								
										</tr>
										
										<%} %>
									
										
										

										                                    
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	



















<footer>

<%@include file="Footer.jsp" %>

</footer>        




                
	<!-- jQuery -->

	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/sticky.js"></script>

	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Date Picker -->
	<script src="js/bootstrap-datepicker.min.js"></script>
	<!-- CS Select -->
	<script src="js/classie.js"></script>
	<script src="js/selectFx.js"></script>
	
	<!-- Main JS -->
	<script src="js/main.js"></script>

        
    <script>
          $(document).on('click', '#Login', function () {
              $("#loginModal").modal("show");
           });
          $(document).on('click', '#Registro', function () {
              $("#RegistroModal").modal("show");
           });
        
        $(document).on('click', '#goRegistroLogin', function () {
              $("#RegistroModal").modal("hide");
              $("#loginModal").modal("show");              
           });
		
    </script>


</body>
</html>