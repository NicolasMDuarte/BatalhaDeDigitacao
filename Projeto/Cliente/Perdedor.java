/**
	A classe Perdedor representa um perdedor,
	tendo como base uma String que respresenta o nome do mesmo.
	Instâncias desta classe permitem armazenar determinado perdedor.
	@author Eduardo Migueis, Enzo Spinella, Gabriel Scalese e Nícolas Duarte
	@since 2019
*/
public class Perdedor extends Comunicado
{
	private String perdedor;

/**
	Constroi uma instância da classe Perdedor.
	@param nome determina o perdedor a ser armazenado na classe.
*/
	public Perdedor(String perdedor) throws Exception
	{
		if(perdedor == null)
			throw new Exception("O parametro era null");

		this.perdedor = perdedor;
	}
	
	/**
	    Constroi uma cópia da instância da classe Perdedor.
	    Para tanto, deve ser fornecida uma instancia da classe
	    Perdedor para ser utilizada como modelo para a
	    construção da nova instância.
	    @param perd a instância da classe Perdedor a ser usada
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
	    Produz e resulta uma cópia do Perdedor representado pela instância
	    à qual o método for aplicado.
	    @return a cópia do Perdedor representada pela instância à qual
	    o método for aplicado.
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
	    @return um String contendo o conteúdo do perdedor.
	    */
	public String toString()
	{
		return "Perdedor: " + this.perdedor;
	}
/**
	    Verifica a igualdade entre dois Perdedores.
	    Verifica se o Object fornecido como parâmetro representa um
	    Perdedor igual àquela representada pela instância à qual este
	    método for aplicado, resultando true em caso afirmativo,
	    ou false, caso contrário.
	    @param  obj o objeto a ser comparado com a instância à qual esse método
	            for aplicado.
	    @return true, caso o Object fornecido ao método e a instância chamante do
	            método representarem agendas iguais, ou false, caso contrário.
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
	 Calcula o código de espalhamento (ou código de hash) de um Perdedor.
	 Calcula e resulta o código de espalhamento (ou código de hash, ou ainda o
	 hashcode) do Perdedor representada pela instância à qual o método for aplicado.
	 @return o código de espalhamento do Perdedor chamante do método.
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
