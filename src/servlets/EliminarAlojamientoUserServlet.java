package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.AlojamientoController;
import datapackage.Alojamiento;

/**
 * Servlet implementation class EliminarAlojamientoUserServlet
 */
@WebServlet("/EliminarAlojamientoUserServlet")
public class EliminarAlojamientoUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarAlojamientoUserServlet() {
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
		String miAloja = request.getParameter("miBotonAloja");
		int a= Integer.valueOf(miAloja);
		HttpSession miSesion = request.getSession();
		List <Alojamiento> alojad =(List <Alojamiento>) miSesion.getAttribute("listaMisAlojamientos");
		Alojamiento aloja = alojad.get(a);
		alojad.remove(a);
		miSesion.setAttribute("listaMisAlojamientos", alojad);
		miSesion.setAttribute("tamanyoListaMisAlojamientos", alojad.size());
		
		System.out.println("EL FORMATO DE LA FECHA ES"+aloja.getFecha_inicio());
		aloja.setANFITRIONES_USUARIOS_Correo(aloja.getId().getANFITRIONES_USUARIOS_Correo());
		AlojamientoController controlador= new AlojamientoController("mydb");
		controlador.deleteAlojamiento(aloja);
		response.sendRedirect("misalojamientos.jsp");
		
	}

}
