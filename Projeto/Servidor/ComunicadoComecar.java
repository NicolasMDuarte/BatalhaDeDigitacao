public class ComunicadoComecar extends Comunicado
{
	private boolean comecar;
	public ComunicadoComecar(boolean comecar)
	{
		this.comecar = comecar;
	}

	public boolean getComecar()
	{
		return this.comecar;
	}
}
