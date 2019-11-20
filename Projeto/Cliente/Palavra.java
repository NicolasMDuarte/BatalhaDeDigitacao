/**
	A classe Palavra representa uma palavra recebida do Servidor.
	Essa classe permite o envio de palavras do Servidor ao Cliente por meio da classe Comunicado.
	Nela encontramos, por exemplo, equals, toString, getters, construtores, clone e hashCode.
	@author Nicolas Maisonnette Duarte, Eduardo Migueis, Gabriel Scalese e Enzo Spinella.
	@since 2019.
*/
public class Palavra extends Comunicado
{
	private String palavra;

	/**
	    Constroi uma nova instancia da classe Palavra.
	    Para tanto, deve ser fornecida uma cadeia de caracteres, que sera utilizada como palavra da instancia recem criada.
	    @param palavra a cadeia de caracteres a ser utilizada como palavra.
	    @throws Exception se a palavra for invalida.
    */
	public Palavra(String palavra) throws Exception
	{
		if(palavra == null)
			throw new Exception("Palavra invalida");

		this.palavra = palavra;
	}

	/**
	     Coleta a palavra.
	     Retorna uma String representando a palavra da classe.
	     @return a palavra em String.
    */
	public String getPalavra()
	{
		return this.palavra;
	}

	/**
		Constroi uma nova instancia da classe Palavra.
		Para tanto, deve ser fornecida outra instancia da classe Palavra.
		@param pa a Palavra a ser copiada.
		@throws Exception se a Palavra for invalida.
    */
	public Palavra(Palavra pa) throws Exception
	{
		if(pa == null)
			throw new Exception("O parametro era null");

		this.palavra = pa.palavra;
	}

	/**
	    Constroi uma copia da instancia da classe Palavra dada.
	    Para tanto, foi utilizado o construtor de copia, que gera uma de this.
	    @return a copia da instancia desta palavra.
    */
	public Object clone()
	{
		Palavra ret = null;

		try
		{
			ret = new Palavra(this);
		}
		catch(Exception ex)
		{}

		return ret;
	}

	/**
	    Gera uma representacao textual de todo conteudo da palavra.
	    Produz e resulta um String com a palavra desta classe.
	    @return um String contendo todo o conteudo da palavra.
    */
	public String toString()
	{
		return "Palavra: " + this.palavra;
	}

	/**
	    Verifica a igualdade entre duas palavras.
	    Verifica se o Object fornecido como parametro representa uma
	    palavra igual aquela representada pela instancia a qual este
	    metodo for aplicado, resultando true em caso afirmativo,
	    ou false, caso contrario.
	    @param  obj o objeto a ser comparado com a instancia a qual esse metodo
	            for aplicado.
	    @return true, caso o Object fornecido ao metodo e a instancia chamante do
	            método representarem palavras iguais, ou false, caso contrario.
    */
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;

		if(obj.getClass() != this.getClass())
			return false;

		if(this == obj)
			return true;

		Palavra pa = (Palavra) obj;
		if(pa.palavra.equals(this.palavra))
			return true;

		return false;
	}

	/**
	    Calcula o codigo de espalhamento (ou codigo de hash) de uma palavra.
	    Calcula e resulta o codigo de espalhamento (ou codigo de hash, ou ainda o
	    hashcode) da palavra representada pela instancia a qual o metodo for aplicado.
	    @return o codigo de espalhamento da palavra chamante do metodo.
    */
	public int hashCode()
	{
		int ret = 17;

		ret = ret * 17 + this.palavra.hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}
}
