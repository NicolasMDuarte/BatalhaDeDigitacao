import java.net.InetAddress;
import java.util.ArrayList;

public class Servidor
{
	public static void main(String[] args)
	{
		System.out.print("Indique a porta desejada: ");
		String porta = null;
		try
		{
			porta = Teclado.getUmString();
		}
		catch(Exception e)
		{
			System.err.println("Valor invalido");
			return;
		}
		ArrayList<Parceiro> jogadores = new ArrayList<Parceiro>();

		AceitadoraDeConexao aceitadoraDeConexao = null;
		try
		{
			 aceitadoraDeConexao = new AceitadoraDeConexao(porta, jogadores);
			 try
			 {
			     System.out.println("\nIp para jogar: " + InetAddress.getLocalHost().getHostAddress() + "\n"); //Para mostrar o IP do computador para outros poderem acessar o jogo
			 }
			 catch(Exception e)
       		 {}

       		 aceitadoraDeConexao.start();
		}
		catch(Exception ex)
		{
			System.err.println("Escolha outra porta!\n");
			return;
		}

		for(;;)
		{
			System.out.println("O servidor esta ativo! Para desativa-lo, use o comando \"desativar\"\n");
            System.out.print("> ");

            String comando = null;
            try
            {
				comando = Teclado.getUmString();
			}
			catch(Exception ex)
			{}

			if(comando.toLowerCase().equals("desativar"))
			{
				synchronized(jogadores)
				{
					for(Parceiro jogador: jogadores)
					{
						ComunicadoDeDesligamento com = new ComunicadoDeDesligamento();
						try
						{
							jogador.receba(com);
							jogador.adeus();
						}
						catch(Exception ex)
						{}
					}
				}
				System.out.println("O servidor foi desativado!\n");
				System.exit(0);
			}
			else
				System.out.println("Comando invalido!\n");
		}
	}
}
