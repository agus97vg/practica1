package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.jms.JMSException;
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
 * Servlet implementation class RecibirMensajesServlet
 */
@WebServlet("/RecibirMensajesServlet")
public class RecibirMensajesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecibirMensajesServlet() {
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
		System.out.println("El usuario destino es "+ recepcion);
		IntercambioMensajes  recibir= new IntercambioMensajes();
		ArrayList <Message> listaMensajes =recibir.recibirMensajes(recepcion);
		
		System.out.println("El numero de mensajes que ha recibido este usuario es de: "+ listaMensajes.size());
		

		mySesion.setAttribute("listaMensajes", listaMensajes);
		mySesion.setAttribute("numeroMensajes", listaMensajes.size());
		RequestDispatcher miR = request.getRequestDispatcher("/mensajes.jsp");
		miR.forward(request, response);
		
		
		
		
	}

}
