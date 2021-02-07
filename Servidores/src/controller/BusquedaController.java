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

public class BusquedaController extends HttpServlet  {
	  ApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		ModeloInterface modelo= (ModeloInterface) contexto.getBean("modelo");
		 
		@Override
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // Recibimos la cadena de busqueda del usuario
		        String q = request.getParameter("query");               
		        List<Servidor> lista = null;
		        // Con nuestro objeto DAO, hacemos la busqueda de servidores
		  
		        lista = modelo.consultaByName(q);
		      
		        RequestDispatcher rd;
		        request.setAttribute("servidores", lista);
		        rd = request.getRequestDispatcher("/servidores.jsp");
		        rd.forward(request, response);
		    }


}
