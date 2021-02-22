package br.com.gerenciador.model;

import java.util.ArrayList;
import java.util.List;

public class Banco
{
	private static List<Empresa> EMPRESAS = new ArrayList<>();
	private static List<Usuario> USUARIOS = new ArrayList<>();
	private static Integer CHAVE_SEQUENCIAL = 1;
	
	static 
	{
		Empresa empresa1 = new Empresa();
		Empresa empresa2 = new Empresa();
		
		empresa1.setNome("Alura");
		empresa2.setNome("Caelum");
		
		add(empresa1);
		add(empresa2);
		
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		
		usuario1.setLogin("lucas");
		usuario2.setLogin("luiza");
		
		usuario1.setSenha("1234");
		usuario2.setSenha("1234");
		
		add(usuario1);
		add(usuario2);
	}
	
	public static void add(Empresa empresa) 
	{
		empresa.setId(Banco.CHAVE_SEQUENCIAL++);
		EMPRESAS.add(empresa);
	}
	
	public static void add(Usuario usuario) 
	{
		USUARIOS.add(usuario);
	}
	
	public static List<Empresa> list() 
	{
		return Banco.EMPRESAS;
	}
	
	public static Empresa get(Integer id) 
	{
		for (Empresa empresa : EMPRESAS) 
		{
			if (empresa.getId().equals(id))
				return empresa;
		}
		return null;
	}

	public static void remove(Integer id) 
	{
		Banco.EMPRESAS.remove(new Empresa(id));
	}

	public static Usuario getUsuario(String login, String senha)
	{
		for (Usuario usuario : USUARIOS) 
		{
			if (usuario.ehIgual(login, senha))
				return usuario;
		}
		return null;
	}
}
