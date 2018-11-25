package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.jms.Message;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jms.IntercambioMensajes;

/**
 * Servlet implementation class SolicitudReservaServlet
 */
@WebServlet("/SolicitudReservaServlet")
public class SolicitudReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitudReservaServlet() {
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
		
		
		
		
		HttpSession mySesion= request.getSession();
		String recepcion = (String) mySesion.getAttribute("correo");
		String fechaInicio =(String) mySesion.getAttribute("fechaInicioReserva");
		String fechaFin= (String) mySesion.getAttribute("fechaFinReserva");
		String destino=request.getParameter("destinatario");
		String tarjeta= request.getParameter("tarjeta");
		String fecha = request.getParameter("fecha");
		String cvv = request.getParameter("cvv");
		String alojamiento = request.getParameter("alojamiento");
		String mensaje= "Se ha realizado una solicitud de reserva por parte del usuario "+recepcion+" para el alojamiento "+alojamiento+". Estos son sus datos de pago: "
				+ "Tarjeta="+tarjeta+" CVV="+cvv+" fecha="+fecha+".";
		System.out.println(mensaje);
		String emisor= (String) mySesion.getAttribute("correo");
		System.out.println("El emisor es este "+emisor);
		IntercambioMensajes envio = new IntercambioMensajes();
		envio.enviarMensajeReserva(mensaje,destino,emisor,fechaInicio,fechaFin,alojamiento);
		RequestDispatcher miR = request.getRequestDispatcher("/indexSesionIniciada.jsp");
		miR.forward(request, response);
	}

}
