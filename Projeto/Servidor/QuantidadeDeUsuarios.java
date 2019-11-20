public class QuantidadeDeUsuarios extends Comunicado implements Cloneable, Comparable<QuantidadeDeUsuarios>
{
	private int qtd = 0;

	public QuantidadeDeUsuarios(int qtd)
	{
		this.qtd = qtd;
	}

	public QuantidadeDeUsuarios(QuantidadeDeUsuarios qUsuarios) throws Exception
	{
		if(qUsuarios == null)
			throw new Exception("O parametro era null");

		this.qtd = qUsuarios.qtd;
	}

	public int getQtd()
	{
		return this.qtd;
	}

	public int hashCode()
	{
		int ret = 17;

		ret = ret * 17 + new Integer(this.qtd).hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}

	public Object clone()
	{
		QuantidadeDeUsuarios ret = null;

		try
		{
			ret = new QuantidadeDeUsuarios(this);
		}
		catch(Exception ex)
		{}

		return ret;
	}

	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;

		if(obj.getClass() != this.getClass())
			return false;

		if(this == obj)
			return true;

		QuantidadeDeUsuarios qtdU = (QuantidadeDeUsuarios) obj;
		if(qtdU.qtd != this.qtd)
			return false;

		return true;
	}

	public int compareTo(QuantidadeDeUsuarios qtdU)
	{
		if(this.qtd > qtdU.qtd)
			return 17;

		if(this.qtd < qtdU.qtd)
			return -17;

		return 0;
	}

	public String toString()
	{
		return "Quantidade: " + this.qtd;
	}
}