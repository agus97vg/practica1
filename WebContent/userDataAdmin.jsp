

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="head.jsp" %>
<%@include file="comprobarLogin.jsp"%>
<%@page 

 			import="java.util.*" 
			import="datapackage.*"

%>


</head>
<body>
<div id="fh5co-wrapper">
		<div id="fh5co-page">
<header id="fh5co-header-section" class="sticky-banner">

<%@include file="headerAdmin.jsp" %>
</header>

		<% 
				HttpSession miSesion= request.getSession();
									
									
				ArrayList <Usuario> myUser =(ArrayList <Usuario>) miSesion.getAttribute("arrayUsers");
				int index=(int) miSesion.getAttribute("editarUserAdmin");
									
				Usuario antiguoUsuario= myUser.get(index); 
									
		%>

<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-image: url(images/cover_bg_5.jpg);">
				<div class="desc">
					<div class="container">
						<div class="row">
							<div class="span12">
								<!-- <a href="index.jsp" id="main-logo">Travel</a> -->
								<div class="tabulation animate-box">

								  <!-- Nav tabs -->
								   <ul class="nav nav-tabs" role="tablist">
								      <li role="presentation" class="active">
								    	   <a  aria-controls="datos" role="tab" data-toggle="tab">Mis datos</a>
								      </li>
								   </ul>

								   <!-- Tab panes -->
									<div class="tab-content">
									 <div role="tabpanel" class="tab-pane active" id="data">
									 	<div class="row">
											<div class="col-xxs-12 col-xs-12 mt">
											
											<form  method="POST" action="AplicarCambiosAdminServlet">
													<div class="col-xxs-12 col-xs-12 mt">
												<div class="input-field">
													<label for="from">Modificar nombre:</label>
													<input type="text" class="form-control" id="Nombre" name="name" value='<%=antiguoUsuario.getNombre()%>'/>
												</div>
											</div>
											
											<div class="col-xxs-12 col-xs-12 mt">
												<div class="input-field">
													<label for="from">Modificar apellidos:</label>
													<input type="text" class="form-control" id="Apellido" name="surname" value="<%=antiguoUsuario.getApellidos()%>"/>
												</div>
											</div>
							
											<div class="col-xxs-12 col-xs-12 mt">
												<div class="input-field">
													<label for="from">Cambiar contraseña:</label>
													<input type="text" class="form-control" id="Contraseña" name="pass" value="<%=antiguoUsuario.getContrasenya()%>"/>
												</div>
											</div>
									        
										
                                            
        								
											<div class="col-xs-12">
												<a> <input type="submit" class="btn btn-primary btn-block"  value="Aplicar cambios"> </a>
											</div>
							
											</form>
											
                                        </div>
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


</div>
	<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->

                
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