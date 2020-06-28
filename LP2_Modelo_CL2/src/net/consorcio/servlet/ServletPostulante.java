package net.consorcio.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.consorcio.entidad.Postulante;
import net.consorcio.service.PostulanteService;
@WebServlet("/ServletPostulante")
public class ServletPostulante extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //
	private PostulanteService servicioPostulante;
	
    public ServletPostulante() {
        super();
        servicioPostulante=new PostulanteService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("REGISTRAR"))
			registrar(request,response);
		else if(tipo.equals("ACTUALIZAR"))
			acualizar(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminar(request,response);
		else if(tipo.equals("BUSCAR"))
			buscar(request,response);
		else if(tipo.equals("LISTAR"))
			listar(request,response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//crear un objeto de tipo arreglo de objeto de la clase Postulante
				List<Postulante> lista=servicioPostulante.listar();
				//crear un objeto que contenga todo el JSON
				JsonArrayBuilder arreglo=Json.createArrayBuilder();
				//bucle
				for(Postulante bean: lista) {
					//crear cada fila
					JsonObject obj=Json.createObjectBuilder().add("codigo", bean.getCodigo()).
															  add("nombres", bean.getNombres()).
															  add("apellidos", bean.getApellidos()).
															  add("edad", bean.getEdad()).build();
					//enviar el objeto "obj" al arreglo
					arreglo.add(obj);
				}
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter salida=response.getWriter();
				salida.println(arreglo.build());
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Postulante bean;
		String cod;
		cod=request.getParameter("codigo");
		bean=servicioPostulante.buscar(Integer.parseInt(cod));
		request.setAttribute("postulante",bean);
		request.getRequestDispatcher("/actualizar.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod;
		cod=request.getParameter("codigo");
		int salida=servicioPostulante.eliminar(Integer.parseInt(cod));
		//PASO 5: validar el valor de salida y crear el atributo
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Registro eliminado correctamente");
		else
			request.setAttribute("MENSAJE", "Error en la eliminación del registro");
			
		request.getRequestDispatcher("/actualizar.jsp").forward(request, response);
	}

	private void acualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod,nom,ape,edad;
		cod=request.getParameter("codigo");
		nom=request.getParameter("nombre");
		ape=request.getParameter("apellido");
		edad=request.getParameter("edad");
		//PASO 2: crear un objeto de la clase Postulante
		Postulante bean=new Postulante();
		//PASO 3: setear los atributos del objeto bean con los valores de las variables
		bean.setCodigo(Integer.parseInt(cod));
		bean.setNombres(nom);
		bean.setApellidos(ape);
		bean.setEdad(Integer.parseInt(edad));
		//PASO 4: invocar al método addPostulante
		int salida=servicioPostulante.actualizar(bean);
		//PASO 5: validar el valor de salida y crear el atributo
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Registro actualizado correctamente");
		else
			request.setAttribute("MENSAJE", "Error al actualizar el registro");
			
		request.getRequestDispatcher("/actualizar.jsp").forward(request, response);
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PASO 1: variables para leer los valores de las cajas
		String nom,ape,edad;
		nom=request.getParameter("nombre");
		ape=request.getParameter("apellido");
		edad=request.getParameter("edad");
		//PASO 2: crear un objeto de la clase Postulante
		Postulante bean=new Postulante();
		//PASO 3: setear los atributos del objeto bean con los valores de las variables
		bean.setNombres(nom);
		bean.setApellidos(ape);
		bean.setEdad(Integer.parseInt(edad));
		//PASO 4: invocar al método addPostulante
		int salida=servicioPostulante.registrar(bean);
		//PASO 5: validar el valor de salida y crear el atributo
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Registro guardado correctamente");
		else
			request.setAttribute("MENSAJE", "Error al guardar el registro");
			
		request.getRequestDispatcher("/nuevo.jsp").forward(request, response);
		
	}

}
