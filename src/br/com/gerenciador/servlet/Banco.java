package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco
{
	private static List<Empresa> empresas = new ArrayList<>(); 
	
	static 
	{
		Empresa empresa1 = new Empresa();
		Empresa empresa2 = new Empresa();
		empresa1.setNome("Alura");
		empresa2.setNome("Caelum");
		empresas.add(empresa1);
		empresas.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) 
	{
		empresas.add(empresa);
	}
	
	public static List<Empresa> getEmpresas() 
	{
		return Banco.empresas;
	}
}
