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
		<!-- end:header-top -->

		<!-- end:header-top -->
		<%@page 

 			import="java.util.ArrayList" 
 			import="java.util.*"
			import="datapackage.*"
			import=" javax.jms.*"
			import=" javax.servlet.*"
			import="java.sql.Timestamp;"
 

		%>
		<!-- Enviar Mensaje Modal -->
<div class="modal fade" id="EnviarMensajeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h1 class="h3 mb-3 font-weight-normal">Contactar con </h1>
      </div>
      <div class="modal-body">
      
          <form class="form-signin" action="EnvioMensajesServlet" method="POST">
          
		<select class="auxselect" id="seleccion" onchange="funcion2()" required>
			<option value="P2"> Usuario</option>									
			<option value="P1"> Administrador</option>
		</select>
      <input type="text" id="loginEmail" class="form-control" placeholder="Destinatario" name="destino"required autofocus>
      <input type="text" id="sendMessage" class="form-control" placeholder="Escriba su mensaje..." name="mensaje" required autofocus>
	 
	 
       <button class="btn btn-lg btn-primary btn-block" type="submit" id="mensaj">Enviar mensaje</button> 
      
    </form>

      </div>

     

    </div>
  </div>
</div>

		<!-- Responder Mensaje Modal -->
<div class="modal fade" id="responderMensajeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h1 class="h3 mb-3 font-weight-normal">Contactar con </h1>
      </div>
      <div class="modal-body">
      
          <form class="form-signin" action="EnvioMensajesServlet" method="POST">
          
      <input type="text" id="destinatario" name="destino" class="form-control" style="display:none" placeholder="User"  autofocus>
      <input type="text" id="mensaje" name="mensaje" class="form-control" placeholder="Escriba su mensaje..." required autofocus>

       <button class="btn btn-lg btn-primary btn-block" type="submit" id="envio">Enviar mensaje</button> 
    </form>

      </div>

     

    </div>
  </div>
</div>
		
		
		
		
		
     <div id="message-container" class="fh5co-section-gray">	
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
						<h3>Mensajes</h3>
						<p>Estos son los mensajes que has recibido hasta ahora.</p>
				</div>
			</div>
			
			<div class="row row-bottom-padded-md">			
				<div class="col-md-8 col-md-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="pull-right">
								<div class="btn-group space">
									<a href="#" id="EnviarMensaje"><button type="button" class="btn btn-default btn-filter" data-target="all">Enviar mensaje</button></a>
								</div>
							</div>
							<div class="table-container">
								<table class="table table-filter">
								
								
								
								<% 
					
									HttpSession miSesion= request.getSession();
									
									int numero=(int) (miSesion.getAttribute("numeroMensajes"));
									ArrayList <Message> aloja =(ArrayList <Message>) miSesion.getAttribute("listaMensajes");
									for(int i = 0; i < numero; i+=1) { 
									%>
								
									<tbody>
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
												
												<a href="#" id="respuestaMensaje" ><button type="button"  name="responderMensaje" class="btn btn-default btn-filter" data-target="all" value='<%=var%>' id='<%=i%>' onclick="funcion1(this.value)">Responder</button></a>
											<td>      
													<div class="media">
														<p class="summary"><%out.println(((TextMessage)(aloja.get(i))).getText()); %></p>
														<p class="meta"><%Timestamp ts=new Timestamp(aloja.get(i).getJMSTimestamp());  
										                Date date=new Date(ts.getTime());  
										                    
										                out.println(date);%></p>                                                
													</div>
											</td>
										</tr>    
										                                   
									</tbody>
									
									<%} %>
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
        
        $(document).on('click', '#EnviarMensaje', function () {
            
            $("#EnviarMensajeModal").modal("show");
         });
		
        
        $(document).on('click', '#respuestaMensaje', function () {
            
            $("#responderMensajeModal").modal("show");
                        
         });
        
        function funcion1(varx){
        	document.getElementById("destinatario").value=varx;
        }
        
        function funcion2(){
        	if(document.getElementById("seleccion").value=="P1"){
        		document.getElementById("loginEmail").style.display='none';
        		document.getElementById("loginEmail").value="administrador";
        		
        	}
        		
        	if(document.getElementById("seleccion").value=="P2"){
        		document.getElementById("loginEmail").style.display='block';
    		document.getElementById("loginEmail").value="";
        		
        	}	
        }
    </script>

</body>
</html>