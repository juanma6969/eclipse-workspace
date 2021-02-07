package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dominio.Servidor;
import modelo.modeloInterface.ModeloInterface;


public class ServidorController extends HttpServlet {
	  ApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
			ModeloInterface modelo= (ModeloInterface) contexto.getBean("modelo");
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recibimos el parametro de accion, para ver que solicito el cliente.
        String action = request.getParameter("action");
        if ("ver".equals(action)) {
            this.verDetalle(request, response);
        } else if ("lista".equals(action)) {
            this.verTodas(request, response);
        } else if ("enviar".equals(action)) {
            this.mostrarFormulario(request, response);
        }
    }

    /**
     * Metodo que sirve para guardar un servidor.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recibimos parametros del formulario
        Servidor srv = new Servidor();
        String nombreParam = request.getParameter("nombre");
        srv.setNombre(nombreParam);
        String descripcionParam = request.getParameter("descripcion");
        srv.setDescripcion(descripcionParam);
        String detalleParam = request.getParameter("detalle");
        srv.setDetalle(detalleParam);
        
        //Imprimimos el objeto en consola (método toString)
        System.out.println(srv);
        
        // Procesamos los datos a guardar en BD
       
      
		Servidor status=modelo.altaS(srv);

        // Preparamos un mensaje para el usuario
        String msg = "";
        if (status!=null) {
            msg = "El servidor fue guardado correctamente.";
        } else {
            msg = "Ocurrio un error. El servidor no fue guardado.";
        }
  
        RequestDispatcher rd;
        // Compartimos la variable msg, para poder accederla desde la vista con Expression Language
        request.setAttribute("message", msg);
        // Enviarmos respuesta a la vista mensaje.jsp
        rd = request.getRequestDispatcher("/mensaje_admin.jsp");
        rd.forward(request, response);
    }

    /**
     * Metodo para ver los detalles completos de un Servidor.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void verDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recibimos id del servidor a consultar
        int idServidor = Integer.parseInt(request.getParameter("id"));
       
        Servidor srv = modelo.consultaS(idServidor);
    

        // Compartimos la variable srv para acceder desde la vista con Expression Language
        request.setAttribute("servidor", srv);
        RequestDispatcher rd;

        // Enviarmos respuesta a la vista detalle.jsp
        rd = request.getRequestDispatcher("/detalle.jsp");
        rd.forward(request, response);
    }

    /**
     * Metodo para buscar todos los servidores registrados.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void verTodas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        List<Servidor> lista = modelo.consultaAllS();
    
        // Compartimos la variable lista, para poder accederla desde la vista
        request.setAttribute("servidores", lista);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/servidores.jsp");
        rd.forward(request, response);
    }

    protected void mostrarFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        int idServidor = Integer.parseInt(request.getParameter("id"));      
        Servidor srv = null;
   
        srv = modelo.consultaS(idServidor);
             
        request.setAttribute("servidor", srv);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/frm.jsp");
        rd.forward(request, response);
    }

}
