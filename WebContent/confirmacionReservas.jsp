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
		
		<%@page 

 			import="java.util.ArrayList" 
 			import="java.util.*"
			import="datapackage.*"
			import=" javax.jms.*"
			import=" javax.servlet.*"
			import="java.sql.Timestamp;"
 

		%>
		</header>
		<!-- end:header-top -->

		<!-- end:header-top -->
     <div id="message-container" class="fh5co-section-gray">	
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
						<h3>Peticiones de reserva</h3>
						<p>Estas son las peticiones de reserva pendientes por responder.</p>
				</div>
			</div>
			
			<div class="row row-bottom-padded-md">			
				<div class="col-md-8 col-md-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="pull-right">
								<div class="btn-group">
								</div>
							</div>
						
							<div class="table-container">
								<table class="table table-filter">
									<tbody>
										
								<% 
					
									HttpSession miSesion= request.getSession();
									
									int numero=(int) (miSesion.getAttribute("numeroMensajesReserva"));
									ArrayList <Message> aloja =(ArrayList <Message>) miSesion.getAttribute("listaMensajesReserva");
									for(int i = 0; i < numero; i+=1) { 
										Message mensaje= aloja.get(i);
										TextMessage mensajeTexto= (TextMessage) mensaje;
										
										
										
									%>
										
										<tr data-status="no-leido" class="no-leido">
											<td>
												<a href="javascript:;" class="star">
													<i class="glyphicon glyphicon-star"></i>
												</a>
											</td>
											<td>
												<div class="media">
													<h4 class="title">
																<%String var=((TextMessage)aloja.get(i)).getStringProperty("JMSXUserID");
																out.println(var);%>
													</h4>
												</div>
											</td>                                        
											<td>      
													<div class="media">
														<p class="summary"><%out.println(((TextMessage)(aloja.get(i))).getText()); %></p>
														<p class="meta"><%Timestamp ts=new Timestamp(aloja.get(i).getJMSTimestamp());  
										                Date date=new Date(ts.getTime());  
										                    
										                out.println(date);%></p>  
														<div class="pull-left">
															<div class="btn-group">
															<form action="AceptarReservaServlet" method="POST">	
								
																<button type="submit" class="btn btn-success btn-filter" value='<%=i%>'name="botonValidar">Validar</button>
															</form>
															
															<form action="RechazarReservaServlet" method="POST">		
																<button type="submit" class="btn btn-danger btn-filter" value='<%=i%>'name="botonInvalidar">Invalidar</button>
															</form>	
															</div>
														</div>                                              
													</div>
											</td>
										</tr>    
										
										
										<%}%>
										                                       
									</tbody>
								</table>
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