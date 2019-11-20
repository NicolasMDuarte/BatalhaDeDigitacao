import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class AceitadoraDeConexao extends Thread
{
    private static final int PORTA_PADRAO = 3000;

    private ServerSocket        pedido;
    private ArrayList<Parceiro> jogadores;

    public AceitadoraDeConexao(String escolha, ArrayList<Parceiro> jogadores)
    throws Exception
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
