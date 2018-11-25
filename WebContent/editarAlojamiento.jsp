

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

<%@include file="headerIniciadoSesion.jsp" %>
</header>

<div class="fh5co-hero claseAux">
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
								    	   <a href="#alojamientos" aria-controls="alojamientos" role="tab" data-toggle="tab">Editar alojamiento</a>
								      </li>
								   </ul>

								   <% 
									HttpSession miSesion= request.getSession();
									
								   
								   int index=(int) (miSesion.getAttribute("editarAlojamientoAdmin"));
									List <Alojamiento> aloja =(List <Alojamiento>) miSesion.getAttribute("listaMisAlojamientos");
									
		
									System.out.println("Hasta aqui llega");
									
									Alojamiento antiguoAloja= aloja.get(index); 
									
											%>
											
								   <!-- Tab panes -->
									<div class="tab-content">
									 <div role="tabpanel" class="tab-pane active" id="registro">
									 	<div class="row">
									 	
									 		<form method="POST" action="EditarAlojamientoUsuarioServlet">
											
											
											<div class="col-xxs-12 col-xs-12 mt">
												<div class="input-field">
													<label for="from">Ciudad:</label>
													<input type="text" required value='<%=antiguoAloja.getCiudad()%>' class="form-control" id="breveDescripcion" name="ciudad"/>
												</div>
											</div>
											
											<div class="col-xxs-12 col-xs-12 mt">
												<div class="input-field">
													<label for="from">Breve descripcion:</label>
													<input type="text" required value='<%=antiguoAloja.getDescripcion_breve()%>' class="form-control" id="breveDescripcion" name="bDescripcion"/>
												</div>
											</div>
											
											<div class="col-xxs-12 col-xs-12 mt">
												<div class="input-field">
													<label for="from">Descripcion:</label>
													<input type="text" class="form-control" name ="descripcion" required value='<%=antiguoAloja.getDecripcion_larga()%>'/>
												</div>
											</div>
											
											<div class="col-xxs-12 col-xs-6 mt">
												<section>
													<label for="class">Tipo de alojamiento</label>
													<select class="cs-select cs-skin-border" name="tipo">
														
														<%if(antiguoAloja.getTipo().equals("Alojamiento Entero")){%>
														<option value="Alojamiento Entero" selected>Alojamiento entero</option>
														<option value="Habitacion privada">Habitación privada</option>
														<option value="Habitacion compartida">Habitación compartida</option>
														<%} %>
														
														<%if(antiguoAloja.getTipo().equals("Habitacion compartida")){%>
														<option value="Alojamiento Entero">Alojamiento entero</option>
														<option value="Habitacion privada">Habitación privada</option>
														<option value="Habitacion compartida" selected>Habitación compartida</option>
														<%} %>
														
														<%if(antiguoAloja.getTipo().equals("Habitacion privada")){%>
														<option value="Alojamiento Entero">Alojamiento entero</option>
														<option value="Habitacion privada" selected>Habitación privada</option>
														<option value="Habitacion compartida">Habitación compartida</option>
														<%} %>
													</select>
												</section>
											</div>
											
											
                                            
											<div class="col-xxs-12 col-xs-6 mt">
												<section>
													<label for="class">Número de huespedes:</label>
													<select class="cs-select cs-skin-border" name="numero">
														<option selected> <%=antiguoAloja.getNumero_huespedes()%></option>
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
														<option value="4">4</option>
														<option value="5">5</option>
														<option value="6">6</option>
														<option value="7">7</option>
														<option value="8">8</option>
													</select>
												</section>
											</div>
											
											<div class="col-xxs-12 col-xs-6 mt">
												<section>
													<label for="class">Número de camas:</label>
													<select class="cs-select cs-skin-border" name="numeroCamas">
														<option  selected> <%=antiguoAloja.getNumero_camas()%></option>
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
														<option value="4">4</option>
													</select>
												</section>
											</div>
											
											<div class="col-xxs-12 col-xs-6 mt">
												<div class="input-field">
													<label for="from">Precio por noche:</label>
													<input type="text"  value='<%=antiguoAloja.getPrecio()%>' class="form-control" id="PPN" required name="precio" />
												</div>
											</div>
											
											
									
												<a> <input type="submit" class="btn btn-primary btn-block" value="Aplicar cambios"></a>
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
        
        
        function Numeros(string){//Solo numeros
            var out = '';
            var filtro = '1234567890';//Caracteres validos
        	
            //Recorrer el texto y verificar si el caracter se encuentra en la lista de validos 
            for (var i=0; i<string.length; i++)
               if (filtro.indexOf(string.charAt(i)) != -1) 
                     //Se añaden a la salida los caracteres validos
        	     out += string.charAt(i);
        	
            //Retornar valor filtrado
            return out;
        } 
		
    </script>


</body>
</html>