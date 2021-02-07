package com.ecodeup.proyecto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Ingresamos al metodo GET de MyServlet");
		System.out.println(request.getParameter("var1"));
		System.out.println(request.getParameter("var2"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Metodo POST");
		System.out.println(request.getParameter("numero1"));
		
		int num1=Integer.parseInt(request.getParameter("numero1"));
		int num2=Integer.parseInt(request.getParameter("numero2"));
		int num3=num1*num2;
		
		System.out.println(num3+"");
		//doGet(request, response);	
		
	//Session
		request.getSession().setAttribute("numero3", Integer.toString(num3));
		
		
		
		RequestDispatcher rd;
	rd=request.getRequestDispatcher("/Presentacion.jsp");
	rd.forward(request, response);

		
	}

}
