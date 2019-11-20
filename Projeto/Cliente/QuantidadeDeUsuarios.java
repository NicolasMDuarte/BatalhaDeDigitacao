public class QuantidadeDeUsuarios extends Comunicado
{
	private int qtd = 0;

	public QuantidadeDeUsuarios(int qtd)
	{
		this.qtd = qtd;
	}

	public int getQtd()
	{
		return this.qtd;
	}
}