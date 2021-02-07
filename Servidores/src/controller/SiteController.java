package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dominio.Servidor;
import modelo.modeloInterface.ModeloInterface;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SiteController extends HttpServlet {
	  ApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		ModeloInterface modelo= (ModeloInterface) contexto.getBean("modelo");

		@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws  IOException {
			try {
			   RequestDispatcher rd;   
			   List<Servidor> lista =modelo.consultaAllS(); 
			   request.setAttribute("ultimos", lista);
			   rd = request.getRequestDispatcher("/index.jsp");
		        rd.forward(request, response);
		        
			}catch (ServletException e){
				e.printStackTrace();
			}
		}
			
}
