/**
	A classe QuantidadeDeUsuarios a quantidade de usuarios,
	tendo como base um int que respresenta a quantidade de usuarios.
	Instâncias desta classe permitem armazenar determinado numero de usuarios.
	@author Eduardo Migueis, Enzo Spinella, Gabriel Scalese e Nícolas Duarte
	@since 2019
*/
public class QuantidadeDeUsuarios extends Comunicado implements Cloneable, Comparable<QuantidadeDeUsuarios>
{
	private int qtd = 0;
/**
	Constroi uma instância da classe QuantidadeDeUsuarios.
	@param nome determina a quantidade de usuarios a ser armazenado na classe.
*/
	public QuantidadeDeUsuarios(int qtd)
	{
		this.qtd = qtd;
	}
/**
	    Constroi uma cópia da instância da classe QuantidadeDeUsuarios.
	    Para tanto, deve ser fornecida uma instancia da classe
	    QuantidadeDeUsuarios para ser utilizada como modelo para a
	    construção da nova instância.
	    @param qUsuarios a instância da classe QuantidadeDeUsuarios a ser usada
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
	 Calcula o código de espalhamento (ou código de hash) de uma QuantidadeDeUsuarios.
	 Calcula e resulta o código de espalhamento (ou código de hash, ou ainda o
	 hashcode) da QuantidadeDeUsuarios representada pela instância à qual o método for aplicado.
	 @return o código de espalhamento da QuantidadeDeUsuarios chamante do método.
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
	    Produz e resulta uma cópia da QuantidadeDeUsuarios representado pela instância
	    à qual o método for aplicado.
	    @return a cópia da QuantidadeDeUsuarios representada pela instância à qual
	    o método for aplicado.
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
	    Verifica se o Object fornecido como parâmetro representa uma
	    QuantidadeDeUsuarios igual àquela representada pela instância à qual este
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
/**
	    Gera uma representação textual da quantidade.
	    Produz e resulta um String com a quantidade.
	    @return um String contendo o conteúdo da quantidade.
	    */
	public String toString()
	{
		return "Quantidade: " + this.qtd;
	}
}
