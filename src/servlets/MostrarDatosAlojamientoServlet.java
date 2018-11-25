package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MostrarDatosAlojamientoServlet
 */
@WebServlet("/MostrarDatosAlojamientoServlet")
public class MostrarDatosAlojamientoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDatosAlojamientoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String miAloja = request.getParameter("miBotonAloja");
		HttpSession miSesion = request.getSession();
		miSesion.setAttribute("index", miAloja);
		
		if(miSesion.getAttribute("correo")==null) {
			
			RequestDispatcher miR = request.getRequestDispatcher("/alojamiento.jsp");
			miR.forward(request, response);
		} else {
		
			RequestDispatcher miR = request.getRequestDispatcher("/alojamientoSesionIniciada.jsp");
			miR.forward(request, response);
		}
		
		
	}

}