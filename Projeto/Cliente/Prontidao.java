public class Prontidao extends Comunicado
{
	private boolean ok = false;

	public Prontidao(boolean ok)
	{
		this.ok = ok;
	}

	public boolean getProntidao()
	{
		return ok;
	}

	public Prontidao(Prontidao pront) throws Exception
	{
		if(pront == null)
			throw new Exception("O parametro era null");

		this.ok = pront.ok;
	}

	public Object clone()
	{
		Prontidao ret = null;
		try
		{
			ret = new Prontidao(this);
		}
		catch(Exception ex)
		{}

		return ret;
	}

	public String toString()
	{
		return "Pronto: " + this.ok;
	}

	public int hashCode()
	{
		int ret = 17;

		ret = ret * 17 + new Boolean(this.ok).hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}

	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;

		if(obj == this)
			return true;

		if(obj.getClass() != this.getClass())
			return false;

		Prontidao pront = (Prontidao)obj;
		if(pront.ok != this.ok)
			return false;

		return true;
	}
}