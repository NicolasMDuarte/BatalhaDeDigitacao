/**
	A classe Prontidao representa o estado de prontidao de determinado Cliente,
	tendo como base um boolean que respresenta o estado de prontidao do mesmo.
	@author Eduardo Migueis, Enzo Spinella, Gabriel Scalese e Nicolas Duarte.
	@since 2019.
*/
public class Prontidao extends Comunicado
{
	private boolean ok = false;

	/**
		Constroi uma instancia da classe Prontidao.
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
		Constroi uma copia da instancia da classe Prontidao.
		Para tanto, deve ser fornecida uma instancia da classe
		Prontidao para ser utilizada como modelo para a
		construcao da nova instancia.
		@param pront a instancia da classe Prontidao a ser usada
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
	    Produz e resulta uma copia da Prontidao representado pela instancia
	    a qual o metodo for aplicado.
	    @return a copia da Prontidao representada pela instancia a qual
	    o metodo for aplicado.
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
	    Gera uma representacao textual do conteudo dos atributos.
	    Produz e resulta um String com o estado de prontidao.
	    @return um String contendo o conteudo do atributo boolean.
	*/
	public String toString()
	{
		return "Pronto: " + this.ok;
	}

	/**
	    Calcula o codigo de espalhamento (ou codigo de hash) de uma Prontidao.
	    Calcula e resulta o codigo de espalhamento (ou codigo de hash, ou ainda o
	    hashcode) da Prontidao representada pela instancia a qual o metodo for aplicado.
	    @return o codigo de espalhamento da Prontidao chamante do metodo.
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
	    Verifica se o Object fornecido como parametro representa uma
	    Prontidao igual aquela representada pela instancia a qual este
	    metodo for aplicado, resultando true em caso afirmativo,
	    ou false, caso contrario.
	    @param  obj o objeto a ser comparado com a instancia a qual esse metodo
	            for aplicado.
	    @return true, caso o Object fornecido ao metodo e a instancia chamante do
	            metodo representarem Prontidoes iguais, ou false, caso contrario.
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
