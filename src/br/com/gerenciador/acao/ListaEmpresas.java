package br.com.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListaEmpresas 
{

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Empresa> empresas = Banco.list();
		request.setAttribute("empresas", empresas);
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);
	}

}
