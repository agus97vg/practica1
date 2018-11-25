package servlets;

import java.io.IOException;
import java.util.ArrayList;

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



import jms.IntercambioMensajes;

/**
 * Servlet implementation class RechazarReservaServlet
 */
@WebServlet("/RechazarReservaServlet")
public class RechazarReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechazarReservaServlet() {
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
		String seleccion=request.getParameter("botonInvalidar");
		int a= Integer.valueOf(seleccion);
		HttpSession miSesion= request.getSession();
		ArrayList<Message> listaMensajes= (ArrayList <Message>) miSesion.getAttribute("listaMensajesReserva");
		
		TextMessage msg= (TextMessage)listaMensajes.get(a);
		String emisor = null;
		try {
			emisor= msg.getStringProperty("JMSXUserID");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String receptor = null;
		try {
		 receptor= msg.getJMSCorrelationID();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mensaje = null;
		try {
			 mensaje=msg.getText()+" Ha sido rechazada.";
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			msg.clearProperties();
			msg.setBooleanProperty("JSMXReserva", true);
			msg.setBooleanProperty("JSMXRespuesta", true);
			msg.setStringProperty("JMSXUserID", emisor);
			msg.setJMSCorrelationID("**********");
		
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("El mensaje tiene la propiedad en" + msg.getBooleanProperty("JSMXRespuesta"));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(emisor);
		System.out.println(receptor);
		System.out.println(mensaje);
		
		
		IntercambioMensajes  recibir= new IntercambioMensajes();
		recibir.enviarMensajes(mensaje, emisor, receptor);
		ArrayList <Message> listaMensajes1 =recibir.recibirMensajesReserva(receptor);
		
		System.out.println("El numero de mensajes que ha recibido este usuario es de: "+ listaMensajes.size());
		

		miSesion.setAttribute("listaMensajesReserva", listaMensajes1);
		miSesion.setAttribute("numeroMensajesReserva", listaMensajes1.size());
		RequestDispatcher miR = request.getRequestDispatcher("/confirmacionReservas.jsp");
		miR.forward(request, response);
		
		
	}

}
