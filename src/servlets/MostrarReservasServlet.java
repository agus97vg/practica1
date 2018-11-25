package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.ReservasController;
import datapackage.Reserva;

/**
 * Servlet implementation class MostrarReservasServlet
 */
@WebServlet("/MostrarReservasServlet")
public class MostrarReservasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarReservasServlet() {
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
		
		HttpSession mySesion = request.getSession();
		String correo = (String) mySesion.getAttribute("correo");
		ReservasController controller = new ReservasController("mydb");
		System.out.println(correo);
		
		List <Reserva> listaReservasUsuario = controller.Busqueda(correo);
		
		mySesion.setAttribute("listaReservas", listaReservasUsuario);
		mySesion.setAttribute("tamanyoListaReservas", listaReservasUsuario.size());
		
		System.out.println("El tamaño de la lista es: "+ listaReservasUsuario.size());
		RequestDispatcher miR = request.getRequestDispatcher("/viajes.jsp");
		miR.forward(request, response);
		
		
		
	}

}
