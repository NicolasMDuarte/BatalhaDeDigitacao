/**
	A classe pedido de nome representa um pedido do nome de determinado Cliente,
	tendo como base uma String que respresenta o nome do mesmo.
	Instâncias desta classe permitem armazenar determinado nome de Cliente.
	@author Eduardo Migueis, Enzo Spinella, Gabriel Scalese e Nícolas Duarte
	@since 2019
*/
public class PedidoDeNome extends Comunicado
{
	private String nome;
/**
	Constroi uma instância da classe PedidoDeNome.
	@param nome determina o nome a ser armazenado na classe.
*/
	public PedidoDeNome(String nome)
	{
		this.nome = nome;
	}

/**
	Retorna o nome armazenado.
	@return retorna o nome relativo ao atributo desta classe.
*/
	public String getNome()
	{
		return this.nome;
	}

/**
	    Constroi uma cópia da instância da classe PedidoDeNome dada.
	    Para tanto, deve ser fornecida uma instancia da classe
	    PedidoDeNome para ser utilizada como modelo para a
	    construção da nova instância.
	    @param ped a instância da classe PedidoDeNome a ser usada
            como modelo.
	    @throws Exception se o modelo for null.

*/
	public PedidoDeNome(PedidoDeNome ped) throws Exception
	{
		if(ped == null)
			throw new Exception("O parametro era null");

		this.nome = ped.nome;
	}
	/**
	    Clona um PedidoDeNome.
	    Produz e resulta uma cópia do PedidoDeNome representado pela instância
	    à qual o método for aplicado.
	    @return a cópia do PedidoDeNome representada pela instância à qual
	    o método for aplicado.
	 */

	public Object clone()
	{
		PedidoDeNome ret = null;

		try
		{
			ret = new PedidoDeNome(this);
		}
		catch(Exception ex)
		{}

		return ret;
	}
/**
	    Gera uma representação textual de todo conteúdo do nome.
	    Produz e resulta um String com todos o nome.
	    @return um String contendo o conteúdo do nome.
	    */

	public String toString()
	{
		return "Nome: " + this.nome;
	}
	/**
	    Verifica a igualdade entre dois PedidosDeNome.
	    Verifica se o Object fornecido como parâmetro representa um
	    PedidoDeNome igual àquela representada pela instância à qual este
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

		PedidoDeNome ped = (PedidoDeNome) obj;
		if(ped.nome.equals(this.nome))
			return true;

		return false;
	}

	public int hashCode()
	{
		int ret = 17;

		ret = ret * 17 + this.nome.hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}
}
