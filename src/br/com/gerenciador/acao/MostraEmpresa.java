package br.com.gerenciador.acao;

import java.io.IOException;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostraEmpresa 
{
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Empresa empresa = Banco.get(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request, response);
	}
}
