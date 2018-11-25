package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import controllers.AlojamientoController;
import controllers.AnfitrionController;
import datapackage.Alojamiento;
import datapackage.AlojamientoPK;
import datapackage.Anfitrione;

/**
 * Servlet implementation class AnyadirAlojamientoServlet
 */
@WebServlet("/AnyadirAlojamientoServlet")
@MultipartConfig

public class AnyadirAlojamientoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnyadirAlojamientoServlet() {
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
		
		
		String nombre= request.getParameter("name");
		String ciudad= request.getParameter("ciudad");
		String breveDescripcion= request.getParameter("bDescripcion");
		String descripcion= request.getParameter("descripcion");
		String tipo= request.getParameter("tipo");
		String numero= request.getParameter("numero");
		String numeroCamas= request.getParameter("numeroCamas");
		String fechaInicio= request.getParameter("fechaIni");
		String fechaFin= request.getParameter("fechaFin");
		String precioPorNoche= request.getParameter("precio");
		AlojamientoPK primaryKey= new AlojamientoPK();
		
		
		
		
		String[] fechaIni= fechaInicio.split("/"); 
	    String[] fechaFi= fechaFin.split("/");
	    
	    fechaInicio= fechaIni[2]+"-"+fechaIni[0]+"-"+fechaIni[1];
	    fechaFin= fechaFi[2]+"-"+fechaFi[0]+"-"+fechaFi[1];
	    
	    
	    
		Part filePart = request.getPart("crearFoto");
	    byte[] data = new byte[(int) filePart.getSize()];
	    filePart.getInputStream().read(data, 0, data.length);
	    
	    
	    
	    
		
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
	    
	    
	    Alojamiento aloja=new Alojamiento();
	    AlojamientoController aloj =new AlojamientoController("mydb");
	    
	   
	    primaryKey.setNombre(nombre);
	    primaryKey.setANFITRIONES_USUARIOS_Correo((String)(request.getSession().getAttribute("correo")));
	    
	    
	    System.out.println("LA FECHA ES LA SIGUIENTE "+ date1);
	    
	    aloja.setId(primaryKey);
	    aloja.setCiudad(ciudad);
	    aloja.setDescripcion_breve(breveDescripcion);
	    aloja.setDecripcion_larga(descripcion);
	    aloja.setTipo(tipo);
	    aloja.setNumero_camas(Integer.valueOf(numeroCamas));
	    aloja.setNumero_huespedes(Integer.valueOf(numero));
	    aloja.setFecha_inicio(date1);
	    aloja.setFecha_fin(date2);
	    aloja.setPrecio(Integer.valueOf(precioPorNoche));
	    aloja.setFoto(data);
	 
	    aloja.setANFITRIONES_USUARIOS_Correo(aloja.getId().getANFITRIONES_USUARIOS_Correo());
	    System.out.println(aloja.getId().getNombre());
		System.out.println(aloja.getId().getANFITRIONES_USUARIOS_Correo());
		System.out.println(aloja.getCiudad());
		System.out.println(aloja.getDescripcion_breve());
		System.out.println(aloja.getDecripcion_larga());
		System.out.println(aloja.getTipo());
		System.out.println(aloja.getNumero_camas());
		System.out.println(aloja.getNumero_huespedes());
		System.out.println(aloja.getFecha_inicio());
		System.out.println(aloja.getFecha_fin());
		System.out.println(aloja.getPrecio());
		System.out.println(aloja.getFoto());
	    
	    Anfitrione anfitrion;
	   
	    AnfitrionController anfi =new AnfitrionController("mydb");
	    
	    HttpSession miSesion = request.getSession();
	    if(miSesion.getAttribute("correo")!=null) {
	    	
	    	System.out.println("EL correo es "+(String)miSesion.getAttribute("correo"));
	    	anfitrion=anfi.buscarPorMail((String)miSesion.getAttribute("correo"));
	    	
	    	if(anfitrion==null) {
	    		anfitrion = new Anfitrione();
	    		anfitrion.setUSUARIOS_Correo((String)miSesion.getAttribute("correo"));
	    		System.out.println("El correo del anfitrion es"+ anfitrion.getUSUARIOS_Correo());
	    		anfi.createAnfitrion(anfitrion);
	    		aloj.createAlojamiento(aloja);
	    		response.sendRedirect("indexSesionIniciada.jsp");
	    		
	    	} else {
	    		
	    		aloj.createAlojamiento(aloja);
	    		response.sendRedirect("indexSesionIniciada.jsp");
	    		
	    	}
	    	
	    	
	    	
	    	
	    }	    
	    
		
		
		
	}

}
