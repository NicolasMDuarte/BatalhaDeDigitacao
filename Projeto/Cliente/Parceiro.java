import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Parceiro
{
    private Socket             conexao;
    private ObjectInputStream  receptor;
    private ObjectOutputStream transmissor;
    private String palavraEscolhida;
    private JogadaDePalavra jogada;
    private String nome;
    private String ultimoJogador;

    public Parceiro (Socket conexao, ObjectInputStream  receptor, ObjectOutputStream transmissor) throws Exception
    {
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (receptor==null)
            throw new Exception ("Receptor ausente");

        if (transmissor==null)
            throw new Exception ("Transmissor ausente");

        this.conexao     = conexao;
        this.receptor    = receptor;
        this.transmissor = transmissor;
    }

    public void receba (Comunicado x) throws Exception
    {
        try
        {
            this.transmissor.writeObject (x);
            this.transmissor.flush       ();
        }
        catch (IOException erro)
        {
            throw new Exception ("Erro de transmissao");
        }
    }

    public Comunicado envie () throws Exception
    {
        try
        {
            return (Comunicado)this.receptor.readObject();
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de recepcao");
        }
    }

    public void setUltimoJogador(String nome) throws Exception
    {
		this.ultimoJogador = nome;
	}

	public void setPalavraEscolhida(String palavra) throws Exception
	{
		if(palavra == null)
			throw new Exception("Palavra invalida!");

		this.palavraEscolhida = palavra;
	}

	public void setJogadaDePalavra(JogadaDePalavra jogada) throws Exception
	{
		if(jogada == null)
			throw new Exception("Jogada de palavra invalida");

		this.jogada = jogada;
	}

	public void setNome(String nome) throws Exception
	{
		if(nome == null)
			throw new Exception("Nome invalido!");
		this.nome = nome;
	}

	public JogadaDePalavra getJogadaDePalavra()
	{
		return this.jogada;
	}

	public String getPalavraEscolhida()
	{
		return this.palavraEscolhida;
	}

	public String getNome()
	{
		return this.nome;
	}

	public String getUltimoJogador()
	{
		return this.ultimoJogador;
	}

    public void adeus () throws Exception
    {
        try
        {
            this.transmissor.close();
            this.receptor   .close();
            this.conexao    .close();
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de desconexao");
        }
    }
}
