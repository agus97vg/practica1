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

import datapackage.Alojamiento;
import datapackage.Reserva;

/**
 * Servlet implementation class MostrarDatosAlojamientoReservadoServlet
 */
@WebServlet("/MostrarDatosAlojamientoReservadoServlet")
public class MostrarDatosAlojamientoReservadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDatosAlojamientoReservadoServlet() {
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
		
		HttpSession miSesion = request.getSession();
		List <Reserva> aloja =(List <Reserva>) miSesion.getAttribute("listaReservas");
		String num= request.getParameter("alojaSeleccionado");
		System.out.println(num);
		int index = Integer.valueOf(num);
		System.out.println("ASDNASDASDASDASDASDASDA"+index);
		System.out.println("El tamaño de la lista essssssss" +aloja.size());
		System.out.println("El index es "+index);
		Reserva alojad=aloja.get(index);
		miSesion.setAttribute("alojad", alojad);
		
			
			RequestDispatcher miR = request.getRequestDispatcher("/alojamientoReservado.jsp");
			miR.forward(request, response);
		
		
		
	}

}
