/**
	A classe Prontidao representa o estado de prontidao de determinado Cliente,
	tendo como base um boolean que respresenta o estado de prontidao do mesmo.
	@author Eduardo Migueis, Enzo Spinella, Gabriel Scalese e Nícolas Duarte
	@since 2019
*/
public class Prontidao extends Comunicado
{
	private boolean ok = false;

/**
	Constroi uma instância da classe Prontidao.
	@param ok determina o estado (true ou false) a ser armazenado na classe.
*/
	public Prontidao(boolean ok)
	{
		this.ok = ok;
	}
/**
	Retorna o estado armazenado.
	@return retorna o boolean relativo ao estado de prontidao.
*/
	public boolean getProntidao()
	{
		return ok;
	}

/**
	    Constroi uma cópia da instância da classe Prontidao.
	    Para tanto, deve ser fornecida uma instancia da classe
	    Prontidao para ser utilizada como modelo para a
	    construção da nova instância.
	    @param pront a instância da classe Prontidao a ser usada
            como modelo.
	    @throws Exception se o modelo for null.
*/
	public Prontidao(Prontidao pront) throws Exception
	{
		if(pront == null)
			throw new Exception("O parametro era null");

		this.ok = pront.ok;
	}
/**
	    Clona uma Prontidao.
	    Produz e resulta uma cópia da Prontidao representado pela instância
	    à qual o método for aplicado.
	    @return a cópia da Prontidao representada pela instância à qual
	    o método for aplicado.
*/
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

/**
	    Gera uma representação textual do conteúdo dos atributos.
	    Produz e resulta um String com o estado de prontidao.
	    @return um String contendo o conteúdo do do atributo boolean.
	    */
	public String toString()
	{
		return "Pronto: " + this.ok;
	}
	    /**
	    Calcula o código de espalhamento (ou código de hash) de uma Prontidao.
	    Calcula e resulta o código de espalhamento (ou código de hash, ou ainda o
	    hashcode) da Prontidao representada pela instância à qual o método for aplicado.
	    @return o código de espalhamento da Prontidao chamante do método.
	    */
	public int hashCode()
	{
		int ret = 17;

		ret = ret * 17 + new Boolean(this.ok).hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}
/**
	    Verifica a igualdade entre duas Prontidoes.
	    Verifica se o Object fornecido como parâmetro representa uma
	    Prontidao igual àquela representada pela instância à qual este
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
