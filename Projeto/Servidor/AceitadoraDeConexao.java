import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
	A classe AceitadoraDeConexao representa uma classe executavel responsavel pela conexao com servidor e supervisor.
	@author Nicolas Maisonnette Duarte, Eduardo Migueis, Gabriel Scalese e Enzo Spinella.
	@since 2019. 
*/
public class AceitadoraDeConexao extends Thread
{
    private static final int PORTA_PADRAO = 3000;

    private ServerSocket        pedido;
    private ArrayList<Parceiro> jogadores;

    /**
    	Constroi uma instancia contendo a porta e lista de todos os usuarios participantes do jogo.
	@param escolha representa a porta fornecida pelos usuarios.
	@param jogadores representa uma lista contendo todos os participantes do jogo.
	@throws Exception se a porta fornecida e invalida ou a lista de jogadores e invalida.
    */
    public AceitadoraDeConexao(String escolha, ArrayList<Parceiro> jogadores) throws Exception
    {
        int porta = AceitadoraDeConexao.PORTA_PADRAO;

        if (escolha != null)
        {
	    porta = Integer.parseInt(escolha);
	}

       	try
        {
            this.pedido = new ServerSocket(porta);
        }
        catch (Exception  erro)
        {
            throw new Exception ("Porta invalida");
		}

        if (jogadores==null)
            throw new Exception ("Usuarios ausentes");

        this.jogadores = jogadores;
    }

    /**
    	O metodo run faz a conexao entre a classe SupervisoraDeConexao e classe Servidor.
	Ha possibilidade de dar erro, porem os erros sao tratados sem lancar excecao.
    */
    public void run ()
    {
        for(;;)
        {
            Socket conexao=null;
            try
            {
                conexao = this.pedido.accept(); //Realizou a conexão
            }
            catch (Exception erro)
            {
                continue;
            }

            SupervisoraDeConexao supervisoraDeConexao=null;
            try
            {
                supervisoraDeConexao = new SupervisoraDeConexao(conexao, jogadores);
            }
            catch (Exception erro)
            {} // sei que passei parametros corretos para o construtor
            supervisoraDeConexao.start();
        }
    }
}
