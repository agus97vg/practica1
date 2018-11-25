

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="head.jsp" %>
<%@include file="comprobarLogin.jsp"%>


</head>
<body>
<div id="fh5co-wrapper">
		<div id="fh5co-page">
<header id="fh5co-header-section" class="sticky-banner">

<%@include file="headerIniciadoSesion.jsp" %>
</header>

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
									 	
									 	<form method="POST" action="ModificarDatosServlet">
											<div class="col-xxs-12 col-xs-12 mt">
												<div class="input-field">
													<label for="from">Modificar nombre:</label>
													<input type="text" class="form-control" id="Nombre" name="name" value="${sessionScope.nombre}"/>
												</div>
											</div>
											
											<div class="col-xxs-12 col-xs-12 mt">
												<div class="input-field">
													<label for="from">Modificar apellidos:</label>
													<input type="text" class="form-control" id="Apellido" name="surname" value="${sessionScope.apellidos}"/>
												</div>
											</div>
							
											<div class="col-xxs-12 col-xs-12 mt">
												<div class="input-field">
													<label for="from">Cambiar contraseña:</label>
													<input type="text" class="form-control" id="Contraseña" name="pass" value="${sessionScope.contrasenya}"/>
												</div>
											</div>
									
										
                                            
										
                                            
        								
											<div class="col-xs-12">
												<a href="indexSesionIniciada.jsp"> <input type="submit" class="btn btn-primary btn-block"  value="Aplicar cambios"> </a>
											</div>
											
											</form>
											
											<form  method="POST" action="EliminarCuentaServlet">
							
											<div class="col-xs-12">
												<a href="index.jsp"> <input type="submit" class="btn btn-delete btn-block col-xs-12-margin"  value="Eliminar cuenta"> </a>
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
		
	

<!-- Login Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h1 class="h3 mb-3 font-weight-normal">Iniciar sesión para continuar</h1>
      </div>
      <div class="modal-body">
          <form class="form-signin">
      <input type="email" id="loginEmail" class="form-control" placeholder="Dirección de correo electrónico" required autofocus>
      <input type="password" id="loginPassword" class="form-control" placeholder="Contraseña" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Recordarme
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit" id="IniciaSesion">Inicia sesión</button>
    </form>

      </div>

      <div class="modal-footer">
        <p class="text-center">¿No tienes cuenta?<a href="index.jsp">  Regístrate</a></p>
        <p class="text-center"><a href="index.jsp"> Atrás </a></p>
      </div>

    </div>
  </div>
</div>
            
            
<!-- Registro Modal -->
<div class="modal fade" id="RegistroModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h1 class="h3 mb-3 font-weight-normal">Introduce tus datos</h1>
      </div>
      <div class="modal-body">
          <form class="form-registro">
      <input type="email" id="inputEmail" class="form-control" placeholder="Dirección de correo electrónico" required autofocus>
      <input type="text" id="inputName" class="form-control" placeholder="Nombre" required>
      <input type="text" id="inputSurname" class="form-control" placeholder="Apellidos" required>              
      <input type="password" id="inputPassword" class="form-control" placeholder="Establece una contraseña" required>
      <button class="btn btn-lg btn-primary btn-block" type="submit" id="Registrate">Registrate</button>
    </form>

      </div>

      <div class="modal-footer">
        <p class="text-center">¿Ya tienes una cuenta TIWbnb?<a href="#" id="goRegistroLogin">  Inicia sesión</a></p>
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