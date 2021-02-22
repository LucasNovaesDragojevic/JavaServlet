package br.com.gerenciador.acao;

import java.io.IOException;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login implements Acao 
{
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Usuario usuario = Banco.getUsuario(request.getParameter("login"), request.getParameter("senha"));
		
		if (usuario != null)
		{
			request.getSession().setAttribute("usuario", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		}
		else
		{
			return "redirect:entrada?acao=LoginForm";
		}	
		
	}
}