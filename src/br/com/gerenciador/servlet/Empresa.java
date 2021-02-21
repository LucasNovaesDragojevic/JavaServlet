package br.com.gerenciador.servlet;

import java.time.Instant;
import java.util.Date;

public class Empresa
{
	public Empresa() {}
	
	public Empresa(Integer id) 
	{
		this.id = id;
	}

	private Integer id;
	private String nome;
	private Date dataAbertura = Date.from(Instant.now());
	
	public Integer getId() 
	{
		return id;
	}
	
	public void setId(Integer id) 
	{
		this.id = id;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public Date getDataAbertura()
	{
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) 
	{
		this.dataAbertura = dataAbertura;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
