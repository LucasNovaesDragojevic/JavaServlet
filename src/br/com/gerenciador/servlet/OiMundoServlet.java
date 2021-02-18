package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/oi")
public class OiMundoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<head>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Bem vindo!</h1>"
				+ "</body>"
				+ "</html>");
	}
}
