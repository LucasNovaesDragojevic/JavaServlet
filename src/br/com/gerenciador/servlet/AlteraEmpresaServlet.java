package br.com.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/altera-empresa")
public class AlteraEmpresaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Empresa empresa = Banco.get(Integer.valueOf(request.getParameter("id")));
		String nomeEmpresa = request.getParameter("nome");
		String data = request.getParameter("data");
		Date dataAbertura = null;
		
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(data);
		} 
		catch (ParseException e) 
		{
			throw new ServletException(e);
		}
		
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		response.sendRedirect("lista-empresas");
	}
}
