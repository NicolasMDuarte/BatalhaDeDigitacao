public class Palavra extends Comunicado
{
	private String palavra;

	public Palavra(String palavra) throws Exception
	{
		if(palavra == null)
			throw new Exception("Palavra invalida");

		this.palavra = palavra;
	}

	public String getPalavra()
	{
		return this.palavra;
	}
}
