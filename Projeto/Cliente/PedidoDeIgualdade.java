public class PedidoDeIgualdade extends Comunicado
{
	private boolean igual;

	public PedidoDeIgualdade(boolean igual) throws Exception
	{
		this.igual = igual;
	}

	public boolean getIgualdade()
	{
		return this.igual;
	}
}
