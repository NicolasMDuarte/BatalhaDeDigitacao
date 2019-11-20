public class Palavra extends Comunicado
{
	private String palavra;

	public Palavra(String palavra) throws Exception
	{
		if(palavra == null)
			throw new Exception("Palavra invalida");

		this.palavra = palavra;
	}

	public String getPalavra()
	{
		return this.palavra;
	}

	public Palavra(Palavra pa) throws Exception
	{
		if(pa == null)
			throw new Exception("O parametro era null");

		this.palavra = pa.palavra;
	}

	public Object clone()
	{
		Palavra ret = null;

		try
		{
			ret = new Palavra(this);
		}
		catch(Exception ex)
		{}

		return ret;
	}

	public String toString()
	{
		return "Palavra: " + this.palavra;
	}

	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;

		if(obj.getClass() != this.getClass())
			return false;

		if(this == obj)
			return true;

		Palavra pa = (Palavra) obj;
		if(pa.palavra.equals(this.palavra))
			return true;

		return false;
	}

	public int hashCode()
	{
		int ret = 17;

		ret = ret * 17 + this.palavra.hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}
}
