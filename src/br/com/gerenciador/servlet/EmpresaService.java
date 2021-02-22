package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empresas")
public class EmpresaService extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Empresa> empresas = Banco.list();
		
		String valor = request.getHeader("accept");
		
		if (valor.endsWith("xml"))
		{
			XStream xStream = new XStream();
			xStream.alias("empresas", List.class);
			xStream.alias("empresa", Empresa.class);
			String xml = xStream.toXML(empresas);
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		}
		else if (valor.endsWith("json"))
		{
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			response.setContentType("application/json");
			response.getWriter().print(json);
		}
		else
		{
		    response.setContentType("application/json");
		    response.getWriter().print("{\"message\":\"no content\"}");
		}
	}
}
