package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.ReservasController;
import datapackage.Alojamiento;
import datapackage.Reserva;
import datapackage.ReservaPK;
import jms.IntercambioMensajes;

/**
 * Servlet implementation class AceptarReservaServlet
 */
@WebServlet("/AceptarReservaServlet")
public class AceptarReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AceptarReservaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String seleccion=request.getParameter("botonValidar");
		int a= Integer.valueOf(seleccion);
		HttpSession miSesion= request.getSession();
		ArrayList<Message> listaMensajes= (ArrayList <Message>) miSesion.getAttribute("listaMensajesReserva");
	
		Reserva reserva=new Reserva();
		ReservaPK reservaPK = new ReservaPK();
		
		
		TextMessage msg= (TextMessage)listaMensajes.get(a);
		String emisor = null;
			try {
				emisor= msg.getStringProperty("JMSXUserID");
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		String receptor = null;
		 try {
			receptor= msg.getJMSCorrelationID();
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String mensaje = null;
			 try {
				mensaje=msg.getText();
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		String fechaInicio=null;
		try {
			fechaInicio=msg.getStringProperty("JMSXFechaIni");
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String fechaFin =null;
		try {
			fechaFin= msg.getStringProperty("JMSXFechaFin");
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String nombreAlojamiento=null;
		try {
			nombreAlojamiento=msg.getStringProperty("JMSXNombre");
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		System.out.println("La fecha inicio es"+ fechaInicio);
		System.out.println("La fecha fin es "+ fechaFin);
		
		
	    Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		Date date2=null;
	    try {
			 date2=new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		//Busqueda busqueda= new Busqueda(ciudad, fechaInicio, fechaFin, precioNoche, tipo, adultos, ninyos);
	    
		reservaPK.setFecha_inicio(date1);
		reservaPK.setUsuario(emisor);
		reservaPK.setALOJAMIENTOS_Nombre(nombreAlojamiento);
		reserva.setALOJAMIENTOS_anfitrion(receptor);
		reserva.setFecha_fin(date2);
		reserva.setId(reservaPK);
		
		ReservasController controladorReserva= new ReservasController("mydb");
		
		List <Reserva> listaReservasCoincidentes= controladorReserva.ocupado(reserva);
		
	
		
		
		System.out.println(emisor);
		System.out.println(receptor);
		System.out.println(mensaje);
		
		
		
		if(listaReservasCoincidentes.size()==0) {
			
			controladorReserva.createReserva(reserva);
			mensaje+=" Su reserva ha sido aceptada.";
			
			
			
		}if(listaReservasCoincidentes.size()>0) {
			
			
			mensaje+=" Su reserva ha sido rechazada.";
			
		}
		
		
		IntercambioMensajes  recibir= new IntercambioMensajes();
		recibir.enviarMensajes(mensaje, emisor, receptor);
		ArrayList <Message> listaMensajes1 =recibir.recibirMensajesReserva(receptor);

		miSesion.setAttribute("listaMensajesReserva", listaMensajes1);
		miSesion.setAttribute("numeroMensajesReserva", listaMensajes1.size());
		RequestDispatcher miR = request.getRequestDispatcher("/confirmacionReservas.jsp");
		miR.forward(request, response);
		
	}

}
