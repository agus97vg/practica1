<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="head.jsp" %>
<%@include file="comprobarLogin.jsp"%>
<%@ page import="org.apache.commons.codec.binary.StringUtils,org.apache.commons.codec.binary.Base64" %>

</head>
<body>

<div id="fh5co-wrapper">
<div id="fh5co-page">
		
<header id="fh5co-header-section" class="sticky-banner">
<%@include file="headerIniciadoSesion.jsp" %>
<%@page 

 			import="java.util.List" 
			import="datapackage.*"

		%>

</header>





<div id="fh5co-tours" class="fh5co-section-gray">
			<div class="container">
		<% 
					
					HttpSession miSesion= request.getSession();
					
					String num=(String) (miSesion.getAttribute("index"));
					
					int numero=Integer.parseInt(num);
					List <Alojamiento> aloja =(List <Alojamiento>) miSesion.getAttribute("listaAlojamientos");
					Alojamiento sesion= aloja.get(numero);
					String a=sesion.getId().getANFITRIONES_USUARIOS_Correo();
					String b=aloja.get(numero).getId().getNombre();
					
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
                                    <td id="contacto"><span class="host"><%out.println(aloja.get(numero).getId().getANFITRIONES_USUARIOS_Correo()); %></span></td>
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
                        <div class="col-xxs-12 col-xs-6 mt">
                            <a href="#" id="Reservar"><input type="button" class="btn btn-primary btn-block" value="Reservar" ></a>
                        </div>
                        <div class="col-xxs-12 col-xs-6 mt">
                        
                            <a href="#" id="EnviarMensaje"><input type="button" class="btn btn-primary btn-block" value="Contactar"></a>
                        </div>
                                                                        
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
		
		
		
		<!-- Enviar Mensaje Modal -->
<div class="modal fade" id="EnviarMensajeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h1 class="h3 mb-3 font-weight-normal">Contactar con anfitrion</h1>
      </div>
      <div class="modal-body">
          <form class="form-signin" action="EnvioMensajesServlet" method="POST">
      
      <input type="hidden" id="Destinatario" class="form-control" name="destino" value="<%=a%>"  required autofocus>
      <input type="text" id="Mensaje" class="form-control" name="mensaje" placeholder="Escriba su mensaje..." required autofocus>

       <button class="btn btn-lg btn-primary btn-block" type="submit" id="mensaje">Enviar mensaje</button> 
    </form>

      </div>

     

    </div>
  </div>
</div>
		
<div class="modal fade" id="ReservarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">

  <div class="modal-dialog modal-dialog-centered" role="document">

    <div class="modal-content">

      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
         <span aria-hidden="true">&times;</span>
        </button>
        <h1 class="h3 mb-3 font-weight-normal">Haz tu reserva</h1>
      </div>
      <div class="modal-body">      

          <form class="form-signin" action="SolicitudReservaServlet" method="POST">

		<input type="hidden" id="Destinatario" class="form-control" name="destinatario" value="<%=a%>"  required autofocus>
       <input type="hidden" id="Alojamiento" class="form-control" name="alojamiento" value="<%=b%>"  required autofocus>
      <input type="text" maxlength="16" minlength="16" id="loginTarjeta" class="form-control col-xxs-12 col-xs-12 mt alternate" pattern="[0-9]+" name="tarjeta" placeholder="Número de tarjeta" required autofocus>

  							
								<input type="text"  class=" form-control" id="date-start" placeholder="mm/dd/yyyy" name="fecha"/>

								<input type="text" maxlength="3"  id="loginCvvv"  class="form-control" placeholder="CVV" name ="cvv" pattern="[0-9]+" required autofocus>


      

     

       <button class="btn btn-lg btn-primary btn-block" type="submit" id="reserva">Realizar reserva</button> 

    </form>



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
    
          $(document).on('click', '#EnviarMensaje', function () {
      
              $("#EnviarMensajeModal").modal("show");
           });
          
          $(document).on('click', '#Reservar', function () { 

              $("#ReservarModal").modal("show");

           });
		
    </script>

</body>
</html>