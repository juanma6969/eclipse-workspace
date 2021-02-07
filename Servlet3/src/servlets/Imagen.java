package servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Imagen
 */
@WebServlet("/Imagen")
public class Imagen extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setContentType("image/jpeg");
	      OutputStream out = null;
	      String pathToWeb = getServletContext().getRealPath(File.separator);
	      System.out.println(pathToWeb);
	      File f = new File("C:/Users/Juan Manuel/eclipse-workspace/Servlet3/WebContent/" + "imagenes/linux_distros.jpg");
	      try {
	      BufferedImage bi = ImageIO.read(f);
	 out = response.getOutputStream();
	      ImageIO.write(bi, "jpg", out);
	      }
	      catch(Exception e) {}
	      finally {
	      out.close();
	      }
	      
	}

}
