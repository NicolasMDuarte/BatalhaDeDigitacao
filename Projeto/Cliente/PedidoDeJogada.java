public class PedidoDeJogada extends Comunicado
{
	private JogadaDePalavra jogada;

	public PedidoDeJogada(String jogadaString) throws Exception
	{
		try
		{
			this.jogada = new JogadaDePalavra(jogadaString); //Já verifica a validade da String passada
		}
		catch(Exception ex)
		{
			throw new Exception("Passe uma jogada válida!");
		}
	}

	public JogadaDePalavra getValorJogada()
	{
		return this.jogada;
	}
}
