public class PedidoDeNome extends Comunicado
{
	private String nome;

	public PedidoDeNome(String nome)
	{
		this.nome = nome;
	}

	public String getNome()
	{
		return this.nome;
	}

	public PedidoDeNome(PedidoDeNome ped) throws Exception
	{
		if(ped == null)
			throw new Exception("O parametro era null");

		this.nome = ped.nome;
	}

	public Object clone()
	{
		PedidoDeNome ret = null;

		try
		{
			ret = new PedidoDeNome(this);
		}
		catch(Exception ex)
		{}

		return ret;
	}

	public String toString()
	{
		return "Nome: " + this.nome;
	}

	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;

		if(obj.getClass() != this.getClass())
			return false;

		if(this == obj)
			return true;

		PedidoDeNome ped = (PedidoDeNome) obj;
		if(ped.nome.equals(this.nome))
			return true;

		return false;
	}

	public int hashCode()
	{
		int ret = 17;

		ret = ret * 17 + this.nome.hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}
}