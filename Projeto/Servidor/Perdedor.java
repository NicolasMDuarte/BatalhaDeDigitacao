public class Perdedor extends Comunicado
{
	private String perdedor;

	public Perdedor(String perdedor) throws Exception
	{
		if(perdedor == null)
			throw new Exception("O parametro era null");

		this.perdedor = perdedor;
	}

	public Perdedor(Perdedor perd) throws Exception
		{
			if(perd == null)
				throw new Exception("O parametro era null");

			this.perdedor = perd.perdedor;
	}

	public String getPerdedor()
	{
		return this.perdedor;
	}

	public Object clone()
	{
		Perdedor ret = null;

		try
		{
			ret = new Perdedor(this);
		}
		catch(Exception ex)
		{}

		return ret;
	}

	public String toString()
	{
		return "Perdedor: " + this.perdedor;
	}

	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;

		if(obj.getClass() != this.getClass())
			return false;

		if(this == obj)
			return true;

		Perdedor perd = (Perdedor) obj;
		if(perd.perdedor.equals(this.perdedor))
			return true;

		return false;
	}

	public int hashCode()
	{
		int ret = 17;

		ret = ret * 17 + this.perdedor.hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}
}
