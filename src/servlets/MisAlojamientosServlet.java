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

import controllers.AlojamientoController;
import controllers.ReservasController;
import datapackage.Alojamiento;
import datapackage.Reserva;

/**
 * Servlet implementation class MisAlojamientosServlet
 */
@WebServlet("/MisAlojamientosServlet")
public class MisAlojamientosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MisAlojamientosServlet() {
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
		
		System.out.println("HOLA ESTOY EN EL SERVLET");
		
		HttpSession mySesion = request.getSession();
		
		String correo = (String) mySesion.getAttribute("correo");
		AlojamientoController controller = new AlojamientoController("mydb");
		
		List <Alojamiento> listaMisAlojamientos = controller.BusquedaMisAlojamientos(correo);
		
		mySesion.setAttribute("listaMisAlojamientos", listaMisAlojamientos);
		mySesion.setAttribute("tamanyoListaMisAlojamientos", listaMisAlojamientos.size());
		

		RequestDispatcher miR = request.getRequestDispatcher("/misalojamientos.jsp");
		miR.forward(request, response);
	
	}

}
