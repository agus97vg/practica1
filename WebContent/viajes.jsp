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
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
						<h3>Viajes</h3>
						<p>Estos son las reservas que has realizado hasta ahora.</p>
					</div>
				</div>
				
				
				<% 
					
					HttpSession miSesion= request.getSession();
					
					int numero=(int) (miSesion.getAttribute("tamanyoListaReservas"));
					List <Reserva> aloja =(List <Reserva>) miSesion.getAttribute("listaReservas");
				
					for(int i = 0; i < numero; i+=1) { 
					%>
				<div class="row row-bottom-padded-md">
					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
						<div ><img src="images/place-1.jpg" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
							<div class="desc">
								<span></span>
								<h3><%out.println(aloja.get(i).getId().getALOJAMIENTOS_Nombre());%></h3>                
                                <span>Fechas: <%out.println(aloja.get(i).getId().getFecha_inicio()); %> hasta <%out.println(aloja.get(i).getFecha_fin()); %></span>                
								<form method="POST" action="MostrarDatosAlojamientoReservadoServlet">
								<a> <input type="hidden" class="btn btn-primary btn-block"  name="alojaSeleccionado" value="<%=i%>">  </a>
								<a> <input type="submit" class="btn btn-primary btn-block"   value="Seleccionar"> </a>
								</form>
							
							</div>
						</div>
					</div>
					
					<%} %>	
					
				</div>
</div>
	<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->
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