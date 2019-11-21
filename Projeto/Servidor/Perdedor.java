/**
	A classe Perdedor representa um perdedor,
	tendo como base uma String que respresenta o nome do mesmo.
	Instâncias desta classe permitem armazenar determinado perdedor.
	@author Eduardo Migueis, Enzo Spinella, Gabriel Scalese e Nicolas Duarte.
	@since 2019.
*/
public class Perdedor extends Comunicado
{
	private String perdedor;

    /**
	    Constroi uma instancia da classe Perdedor.
	    @param perdedor determina o perdedor a ser armazenado na classe.
	    @throws Exception se o parametro for null.
    */
	public Perdedor(String perdedor) throws Exception
	{
		if(perdedor == null)
			throw new Exception("O parametro era null");

		this.perdedor = perdedor;
	}

	/**
	    Constroi uma copia da instancia da classe Perdedor.
	    Para tanto, deve ser fornecida uma instancia da classe
	    Perdedor para ser utilizada como modelo para a
	    construcao da nova instancia.
	    @param perd a instancia da classe Perdedor a ser usada
            como modelo.
	    @throws Exception se o modelo for null.
	*/
	public Perdedor(Perdedor perd) throws Exception
		{
			if(perd == null)
				throw new Exception("O parametro era null");

			this.perdedor = perd.perdedor;
	}

	/**
		Retorna o perdedor armazenado.
		@return retorna o perdedor armazenado.
	*/
	public String getPerdedor()
	{
		return this.perdedor;
	}

	/**
	    Clona um Perdedor.
	    Produz e resulta uma copia do Perdedor representado pela instancia
	    a qual o metodo for aplicado.
	    @return a copia do Perdedor representado pela instancia a qual
	    o metodo for aplicado.
	*/
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

	/**
	    Gera uma representação textual do perdedor.
	    Produz e resulta um String com o perdedor.
	    @return um String contendo o conteudo do perdedor.
	*/
	public String toString()
	{
		return "Perdedor: " + this.perdedor;
	}

	/**
	    Verifica a igualdade entre dois Perdedores.
	    Verifica se o Object fornecido como parametro representa um
	    Perdedor igual aquele representado pela instancia ao qual este
	    metodo for aplicado, resultando true em caso afirmativo,
	    ou false, caso contrario.
	    @param  obj o objeto a ser comparado com a instancia a qual esse metodo
	            for aplicado.
	    @return true, caso o Object fornecido ao metodo e a instancia chamante do
	            metodo representarem perdedores iguais, ou false, caso contrario.
	*/
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

	/**
		 Calcula o codigo de espalhamento (ou codigo de hash) de um Perdedor.
		 Calcula e resulta o codigo de espalhamento (ou codigo de hash, ou ainda o
		 hashcode) do Perdedor representado pela instancia ao qual o metodo for aplicado.
		 @return o codigo de espalhamento do Perdedor chamante do metodo.
	*/
	public int hashCode()
	{
		int ret = 17;

		ret = ret * 17 + this.perdedor.hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}
}
