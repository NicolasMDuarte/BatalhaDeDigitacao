public class Prontidao extends Comunicado
{
	private boolean ok = false;

	public Prontidao(boolean ok)
	{
		this.ok = ok;
	}

	public boolean getProntidao()
	{
		return ok;
	}
}