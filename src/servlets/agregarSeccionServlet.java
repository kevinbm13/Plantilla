package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import entidad.Controlador;



public class agregarSeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public agregarSeccionServlet() {
        super();
    } 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreSeccion = request.getParameter("nombreSeccion");
		String vigencia = request.getParameter("vigencia");
		String id = request.getParameter("id");
		
		Controlador controlador = new Controlador();
		controlador.crearEstructura("plantilla.xml");
		try {
			controlador.crearSeccion(id, nombreSeccion);
		} catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = "Seccion " + nombreSeccion + " con el ID " + id + " agregada correctamente.\nVigencia: " + vigencia;
	
		
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(result);

	    
	}

}
