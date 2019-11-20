import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
	A classe Cliente representa uma classe executavel responsavel pela comunicacao direta com o usuario.
	Nela encontramos uma main.
	@author Nicolas Maisonnette Duarte, Eduardo Migueis, Gabriel Scalese e Enzo Spinella.
	@since 2019.
*/
public class Cliente
{
	/**
		Roda a aplicacao.
		Realiza todas as interacoes necessarias com o usuario, sendo, portanto, o jogo em si.
		@param args parametro adicional passado pelo usuario.
	*/
	public static void main (String[] args)
	{
		String nome = "";

		System.out.println("Digite o ip e a porta de quem voce quer jogar com!");
		System.out.println("Dica: Para iniciar o jogo no seu computador, digite localhost.\n\n");

		String host = null;
		int porta = 0;
		try
		{
			System.out.print("Ip: ");
			host = Teclado.getUmString();
			System.out.print("\nPorta: ");
			porta = Teclado.getUmInt();
		}
		catch(Exception e)
		{
			System.err.println("Valores invalidos");
			return;
		}

		Socket conexao=null;
		try
		{
		    conexao = new Socket (host, porta);
		}
		catch (Exception erro)
		{
		    System.err.println ("Indique o servidor e a porta corretos!\n");
		    return;
		}

		ObjectOutputStream transmissor=null;
		try
		{
		    transmissor =
		    new ObjectOutputStream(
		    conexao.getOutputStream());
		}
		catch (Exception erro)
		{
		    System.err.println ("Indique o servidor e a porta corretos!\n");
		    return;
		}

		ObjectInputStream receptor=null;
		try
		{
		    receptor =
		    new ObjectInputStream(
		    conexao.getInputStream());
		}
		catch (Exception erro)
		{
		    System.err.println ("Indique o servidor e a porta corretos!\n");
		    return;
		}

		Parceiro servidor=null;
		try
		{
		    servidor = new Parceiro(conexao, receptor, transmissor);
		}
		catch (Exception erro)
		{
		    System.err.println ("Indique o servidor e a porta corretos!\n");
		    return;
		}


		try
		{
			System.out.println("\nPor favor, aguarde por 4 jogadores...");
			ComunicadoComecar comecar = (ComunicadoComecar)servidor.envie();
		}
		catch(Exception e)
		{}

		try
		{
			System.out.print("Escolha um nome para jogar, mas tome cuidado para nao repetir o dos seus amigos: ");
			nome = Teclado.getUmString();

			servidor.receba(new PedidoDeNome(nome));
		}
		catch(Exception ex)
		{
		    System.err.println ("Nome invalido!\n");
		    return;
		}

		Prontidao pront = new Prontidao(false);
		boolean perdeu = false;
		do
		{
			try
			{
				Palavra escolhida = null;
				try
				{
					servidor.receba(new PedidoDePalavra());
					escolhida = (Palavra)servidor.envie();
					System.out.print("Palavra: ");
					System.out.println(escolhida.getPalavra() + "\n");
				}
				catch(Exception ex)
				{
					System.err.println("Erro de recepcao de palavra. Tente novamente mais tarde!");
				}

				boolean igual = false;
				do
				{
					System.out.print("Digite a palavra: ");
					String palavraDigitada = Teclado.getUmString();

					if(palavraDigitada.equals(escolhida.getPalavra()))
					{
						igual = true;
						servidor.receba(new PedidoDeFinalizacao());
					}
				}
				while(igual == false);

				System.out.println("\nAguarde os outros jogadores...\n");
				servidor.receba(new PedidoDeProntidao());

				for(;;)
				{
					try
					{
						pront = (Prontidao)servidor.envie();
						if(pront.getProntidao() == true)
							break;
					}
					catch(Exception ex)
					{
						continue;
					}
				}

				Perdedor perdedor = new Perdedor("null");
				try
				{
					servidor.receba (new PedidoDeIgualdade());

					perdedor = (Perdedor)servidor.envie();

					System.out.println("Jogador Eliminado: " + perdedor.getPerdedor() + "\n");

					if(nome.equals(perdedor.getPerdedor()))
					{
						System.out.println("Voce perdeu...\n");
						perdeu = true;
					}


					servidor.receba(new PedidoDeQuantidadeDeUsuarios());
					QuantidadeDeUsuarios qtd = (QuantidadeDeUsuarios)servidor.envie();
					if(!perdeu)
					{
						if(qtd.getQtd() == 2)
						{
							System.out.println("Voce venceu!\n");
							perdeu = true;
							servidor.receba(new ComunicadoDeDesligamento());
						}
					}
				}
				catch(Exception e)
				{
					System.err.println("Erro de conexao com os outros jogadores. Tente novamente mais tarde!");
				}
			}
			catch (Exception erro)
			{
				System.err.println ("Erro de comunicacao com o servidor;");
				System.err.println ("Tente novamente!");
				System.err.println ("Caso o erro persista, termine o programa");
				System.err.println ("e volte a tentar mais tarde!");
			}
		}
		while (perdeu == false);

		try
		{
			System.out.println("\nVoce saiu do jogo.\n");
			servidor.receba(new ComunicadoDeDesligamento());
		}
		catch(Exception ex)
		{
			//Se der erro, é porque o jogador já foi desconectado
		}
    }
}
