package br.com.gerenciador.servlet;

import java.io.IOException;

import br.com.gerenciador.acao.AlteraEmpresa;
import br.com.gerenciador.acao.ListaEmpresas;
import br.com.gerenciador.acao.MostraEmpresa;
import br.com.gerenciador.acao.NovaEmpresa;
import br.com.gerenciador.acao.RemoveEmpresa;
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
		
		if (paramAcao.equals("ListaEmpresas"))
			new ListaEmpresas().executa(request, response);
		else if (paramAcao.equals("RemoveEmpresa"))
			new RemoveEmpresa().executa(request, response);
		else if (paramAcao.equals("MostraEmpresa"))
			new MostraEmpresa().executa(request, response);
		else if (paramAcao.equals("AlteraEmpresa"))
			new AlteraEmpresa().executa(request, response);
		else if (paramAcao.equals("NovaEmpresa"))
			new NovaEmpresa().executa(request, response);
	}

}
