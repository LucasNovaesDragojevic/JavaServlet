package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco
{
	private static List<Empresa> EMPRESAS = new ArrayList<>();
	private static Integer CHAVE_SEQUENCIAL = 1;
	
	static 
	{
		Empresa empresa1 = new Empresa();
		Empresa empresa2 = new Empresa();
		
		empresa1.setNome("Alura");
		empresa2.setNome("Caelum");
		
		add(empresa1);
		add(empresa2);
	}
	
	public static void add(Empresa empresa) 
	{
		empresa.setId(Banco.CHAVE_SEQUENCIAL++);
		EMPRESAS.add(empresa);
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
}
