package practica1_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletcabecerashttp
 */
@WebServlet("/servletcabecerashttp")
public class servletcabecerashttp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);

	}

	public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String title = "CABECERAS";
	    out.println(ServletUtilities.headWithTitle(title) +
	                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
	                "<B>Request Method: </B>" +
	                req.getMethod() + "<BR>\n" +
	                "<B>Request URI: </B>" +
	                req.getRequestURI() + "<BR>\n" +
	                "<B>Request Protocol: </B>" +
	                req.getProtocol() + "<BR><BR>\n" +
	                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
	                "<TR BGCOLOR=\"#88e8c0\">\n" +
	                "<TH>NOMBRE CABECERA<TH>VALOR CABECERA");

		Enumeration<String> headerNames = req.getHeaderNames();

		while (headerNames.hasMoreElements()) {

			//String headerName = headerNames.nextElement();
			//out.write(headerName);
			//out.write("n");
		     
		      while(headerNames.hasMoreElements()) {
		          String headerName = (String)headerNames.nextElement();
		          out.println("<TR><TD>" + headerName);
		          out.println("    <TD>" + req.getHeader(headerName));
		        }
		        out.println("</TABLE>\n</BODY></HTML>");

			/*Enumeration<String> headers = req.getHeaders(headerName);
			while (headers.hasMoreElements()) {
				String headerValue = headers.nextElement();
				out.write("t" + headerValue);
				out.write("n");
			}*/

		}

		out.close();

	}
}
