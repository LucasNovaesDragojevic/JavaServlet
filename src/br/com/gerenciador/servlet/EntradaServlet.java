package br.com.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;

import br.com.gerenciador.acao.Acao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String paramAcao = request.getParameter("acao");
		String nomeClasse = "br.com.gerenciador.acao." + paramAcao;
		String nome = null;
		
		try 
		{
			Class<?> classe = Class.forName(nomeClasse);
			Constructor<?> construtor = classe.getDeclaredConstructor();
			Object objeto = construtor.newInstance();
			Acao acao = (Acao) objeto;
			nome = acao.executa(request, response);
		}
		catch (Exception e) 
		{
			throw new ServletException(e); 
		}

		String[] tipoEndereco = nome.split(":");
		
		if (tipoEndereco[0].equals("forward")) 
		{
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect(tipoEndereco[1]);
		}
	}

}
