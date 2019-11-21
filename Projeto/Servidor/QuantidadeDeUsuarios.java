/**
	A classe QuantidadeDeUsuarios armazena a quantidade de usuarios no servidor,
	tendo como base um int que respresenta a quantidade de usuarios.
	Instancias desta classe permitem armazenar determinado numero de usuarios.
	@author Eduardo Migueis, Enzo Spinella, Gabriel Scalese e Nicolas Duarte.
	@since 2019.
*/
public class QuantidadeDeUsuarios extends Comunicado implements Cloneable, Comparable<QuantidadeDeUsuarios>
{
	private int qtd = 0;

	/**
		Constroi uma instancia da classe QuantidadeDeUsuarios.
		@param qtd determina a quantidade de usuarios a ser armazenado na classe.
	*/
	public QuantidadeDeUsuarios(int qtd)
	{
		this.qtd = qtd;
	}

	/**
	    Constroi uma copia da instancia da classe QuantidadeDeUsuarios.
	    Para tanto, deve ser fornecida uma instancia da classe
	    QuantidadeDeUsuarios para ser utilizada como modelo para a
	    construcao da nova instancia.
	    @param qUsuarios a instancia da classe QuantidadeDeUsuarios a ser usada
            como modelo.
	    @throws Exception se o modelo for null.
	*/
	public QuantidadeDeUsuarios(QuantidadeDeUsuarios qUsuarios) throws Exception
	{
		if(qUsuarios == null)
			throw new Exception("O parametro era null");

		this.qtd = qUsuarios.qtd;
	}

	/**
		Retorna a quantidade de usuarios armazenada.
		@return retorna a quantidade associada ao atributo desta classe.
	*/
	public int getQtd()
	{
		return this.qtd;
	}

	/**
		 Calcula o codigo de espalhamento (ou codigo de hash) de uma QuantidadeDeUsuarios.
		 Calcula e resulta o codigo de espalhamento (ou codigo de hash, ou ainda o
		 hashcode) da QuantidadeDeUsuarios representada pela instancia a qual o metodo for aplicado.
		 @return o codigo de espalhamento da QuantidadeDeUsuarios chamante do metodo.
	*/
	public int hashCode()
	{
		int ret = 17;

		ret = ret * 17 + new Integer(this.qtd).hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}

	/**
	    Clona uma QuantidadeDeUsuarios.
	    Produz e resulta uma copia da QuantidadeDeUsuarios representado pela instancia
	    a qual o metodo for aplicado.
	    @return a copia da QuantidadeDeUsuarios representada pela instancia a qual
	    o metodo for aplicado.
	*/
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

	/**
	    Verifica a igualdade entre duas QuantidadeDeUsuarios.
	    Verifica se o Object fornecido como parametro representa uma
	    QuantidadeDeUsuarios igual aquela representada pela instancia a qual este
	    metodo for aplicado, resultando true em caso afirmativo,
	    ou false, caso contrario.
	    @param  obj o objeto a ser comparado com a instancia a qual esse metodo
	            for aplicado.
	    @return true, caso o Object fornecido ao metodo e a instancia chamante do
	            metodo representarem QuantidadeDeUsuarios iguais, ou false, caso contrario.
	*/
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

	/**
		Compara duas QuantidadeDeUsuarios.
		Verifica se o parametro representa uma QuantidadeDeUsuarios igual, maior ou menor aquela representada pela instancia a qual este
		metodo for aplicado, resultando um numero positivo(maior), negativo(menor) ou 0(igual).
		@param  qtdU o parametro a ser comparado com a instancia a qual esse metodo
				for aplicado.
		@return 17, caso o qtdU fornecido ao metodo seja menor que this, ou -17, caso contrario, ou entao 0, se os dois forem iguais.
	*/
	public int compareTo(QuantidadeDeUsuarios qtdU)
	{
		if(this.qtd > qtdU.qtd)
			return 17;

		if(this.qtd < qtdU.qtd)
			return -17;

		return 0;
	}

	/**
	    Gera uma representacao textual da quantidade.
	    Produz e resulta um String com a quantidade.
	    @return um String contendo o conteudo da quantidade.
	*/
	public String toString()
	{
		return "Quantidade: " + this.qtd;
	}
}
