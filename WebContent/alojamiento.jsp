<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="head.jsp" %>
<%@ page import="org.apache.commons.codec.binary.StringUtils,org.apache.commons.codec.binary.Base64" %>

</head>
<body>

<div id="fh5co-wrapper">
<div id="fh5co-page">
		
<header id="fh5co-header-section" class="sticky-banner">
<%@include file="headerSinSesion.jsp" %>
<%@page 

 			import="java.util.List" 
			import="datapackage.*"

		%>
		
</header>



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
          <form class="form-signin" method="POST" action="loginServlet">
      <input type="email" id="loginEmail" class="form-control" placeholder="Dirección de correo electrónico" name="loginEmail" required autofocus>
      <input type="password" id="loginPassword" class="form-control" placeholder="Contraseña" name="loginPassword" required>
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
          <form class="form-registro" method="POST" action="RegistroServlet">
      <input type="email" id="inputEmail" class="form-control" name="mail" placeholder="Dirección de correo electrónico" required autofocus>
      <input type="text" id="inputName" class="form-control" name="name" placeholder="Nombre" required>
      <input type="text" id="inputSurname" class="form-control" name="surname" placeholder="Apellidos" required>              
      <input type="password" id="inputPassword" class="form-control" name="pass" placeholder="Establece una contraseña" required>
      <button class="btn btn-lg btn-primary btn-block" type="submit" id="Registrate">Registrate</button>
    </form>

      </div>

      <div class="modal-footer">
        <p class="text-center">¿Ya tienes una cuenta TIWbnb?<a href="#" id="goRegistroLogin">  Inicia sesión</a></p>
      </div>

    </div>
  </div>
</div>    



<div id="fh5co-tours" class="fh5co-section-gray">
			<div class="container">
		
		<% 
					
					
				HttpSession miSesion= request.getSession();
				String num = (String) miSesion.getAttribute("index");
				int numero = Integer.parseInt(num);
				List <Alojamiento> aloja =(List <Alojamiento>) miSesion.getAttribute("listaAlojamientos");
		%>
				<div class="row">
					<div class="col-md-12 animate-box">
						<h2 class="heading-title"><%out.println(aloja.get(numero).getId().getNombre()); %></h2>
					</div>
					<div class="col-md-6 animate-box">
                        <span class="description">
						<p> <%out.println(aloja.get(numero).getDecripcion_larga()); %> </p> 
                        </span>
                        <table class="table">
                            <tbody>
                                <tr>                                
                                    <th scope="row">Anfitrión:</th>
                                    <td><span class="host"><%out.println(aloja.get(numero).getId().getANFITRIONES_USUARIOS_Correo()); %></span></td>
                                </tr>
                                
                                <tr>                                
                                        <th scope="row">Precio:</th>
                                    <td><span class="price"><%out.println(aloja.get(numero).getPrecio()+"€");%></span></td>
                                </tr>
                                <tr>
                                        <th scope="row">Nº Camas:</th>
                                        <td><span class="beds"><%out.println(aloja.get(numero).getNumero_camas()+" camas");%></span></td>
                                </tr>
                                <tr>
                                        <th scope="row">Tipo Alojamiento:</th>
                                        <td><span class="type"><%out.println(aloja.get(numero).getTipo());%></span></td>
                                </tr>                                
                            </tbody>
                        </table>
                        
        
                                                                        
                    </div>
					<div class="col-md-6 animate-box">
								<img style="height: 320px; width: 500px" src="<% StringBuilder sb = new StringBuilder();
								sb.append("data:image/png;base64,");
								sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(aloja.get(numero).getFoto(), false)));
								out.print(sb.toString()); %>"
								alt="Free HTML5 Website Template by FreeHTML5.co"
								class="img-responsive">
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