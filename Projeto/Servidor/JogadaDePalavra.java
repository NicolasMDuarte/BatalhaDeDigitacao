public class JogadaDePalavra extends Comunicado
{
	private String palavra;

	public JogadaDePalavra(String palavra) throws Exception
	{
		if(palavra == null)
			throw new Exception("Palavra inv�lida");

		this.palavra = palavra;
	}
}
