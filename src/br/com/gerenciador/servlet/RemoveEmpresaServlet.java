package br.com.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/remove-empresa")
public class RemoveEmpresaServlet extends HttpServlet 
{	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Banco.remove(Integer.valueOf(request.getParameter("id")));
		response.sendRedirect("lista-empresas");
	}
}
