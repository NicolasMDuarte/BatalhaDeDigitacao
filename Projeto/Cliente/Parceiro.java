import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
	A classe Parceiro representa uma classe responsavel pelo envio de informacoes ao cliente ou ao servidor.
	Nela encontramos metodos que nos auxiliam nessa comunicacao.
	@author Nicolas Maisonnette Duarte, Eduardo Migueis, Gabriel Scalese e Enzo Spinella.
	@since 2019.
*/
public class Parceiro
{
    private Socket             conexao;
    private ObjectInputStream  receptor;
    private ObjectOutputStream transmissor;
    private String palavraEscolhida;
    private String nome;
    private String ultimoJogador;

	/**
		Constroi uma nova instancia da classe Parceiro.
		Para tanto, deve ser fornecido um Socket, que sera utilizado como conexao,
		um ObjectInputStream, que sera utilizado como um receptor e
		um ObjectOutputStream, que sera utilizado como um transmissor da instancia recem criada.
		@param conexao o Socket a ser utilizado como conexao.
		@param receptor o ObjectInputStream a ser utilizado como receptor.
		@param transmissor o ObjectOutputStream a ser utilizado como transmissor.
		@throws Exception se os parametros forem invalidos.
    */
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

	/**
		Envia um comunicado para o servidor.
		Para tanto, deve ser forncedio um comunicado, que sera enviado ao servidor por meio de um transmissor.
		@param x o Comunicado a ser transmitido.
		@throws Exception se ocorrer algum erro na transmissao.
    */
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

	/**
		Recebe um comunicado do servidor.
		@return o comunicado recebido do servidor.
		@throws Exception se ocorrer algum erro na recepcao.
    */
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

	/**
		Altera o nome do ultimo jogador.
		Recebe um nome e o utiliza para alterar o nome da classe.
		@param nome o nome a ser incluido.
		@throws Exception se o nome for invalido.
	*/
    public void setUltimoJogador(String nome) throws Exception
    {
		if(nome == null)
			throw new Exception("Parametro invalido");

		this.ultimoJogador = nome;
	}

	/**
		Altera a palavra escolhida.
		Recebe uma palavra e a utilza para substituir a palavra da classe.
		@param palavra a palavra a ser incluida.
		@throws Exception se a palavra for invalida.
	*/
	public void setPalavraEscolhida(String palavra) throws Exception
	{
		if(palavra == null)
			throw new Exception("Palavra invalida!");

		this.palavraEscolhida = palavra;
	}

	/**
		Altera o nome do jogador.
		Recebe um nome e o utiliza para alterar o nome da classe.
		@param nome o nome a ser incluido.
		@throws Exception se o nome for invalido.
	*/
	public void setNome(String nome) throws Exception
	{
		if(nome == null)
			throw new Exception("Nome invalido!");

		this.nome = nome;
	}

	/**
		Retorna a palavra escolhida armazenada.
		@return retorna a palavra relativa ao atributo desta classe.
	*/
	public String getPalavraEscolhida()
	{
		return this.palavraEscolhida;
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
		Retorna o nome do ultimo jogador armazenado.
		@return retorna o nome relativo ao atributo desta classe.
	*/
	public String getUltimoJogador()
	{
		return this.ultimoJogador;
	}

	/**
		Finaliza a conexao Servidor - Cliente.
		Fecha o transmissor, o receptor e a conexao.
		@throws Exception caso ocorra um erro de desconexao.
	*/
    public void adeus() throws Exception
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
