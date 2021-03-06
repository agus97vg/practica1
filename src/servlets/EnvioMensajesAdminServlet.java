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
 * Servlet implementation class EnvioMensajesAdminServlet
 */
@WebServlet("/EnvioMensajesAdminServlet")
public class EnvioMensajesAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvioMensajesAdminServlet() {
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
		String destino= request.getParameter("destino");
		String mensaje= request.getParameter("mensaje");
		System.out.println("Este es el destino "+destino);
		System.out.println("Este es el mensaje "+mensaje);
		HttpSession mySesion= request.getSession();

		
		String emisor= "administrador";
		System.out.println("El emisor es este "+emisor);
		IntercambioMensajes envio = new IntercambioMensajes();
		envio.enviarMensajes(mensaje,destino,emisor);
		ArrayList <Message> listaMensajes =envio.recibirMensajes(emisor);
		mySesion.setAttribute("listaMensajesAdmin", listaMensajes);
		mySesion.setAttribute("numeroMensajesAdmin", listaMensajes.size());
		RequestDispatcher miR = request.getRequestDispatcher("/mensajesAdmin.jsp");
		miR.forward(request, response);
		
		
	
	}

}



