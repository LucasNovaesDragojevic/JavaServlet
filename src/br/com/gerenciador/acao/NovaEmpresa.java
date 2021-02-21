package br.com.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NovaEmpresa implements Acao
{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		Banco.add(empresa);
		
		return "redirect:entrada?acao=ListaEmpresas";	
	}
}
