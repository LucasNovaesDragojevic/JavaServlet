package br.com.gerenciador.acao;

import java.io.IOException;

import br.com.gerenciador.model.Banco;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveEmpresa implements Acao
{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Banco.remove(Integer.valueOf(request.getParameter("id")));
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
