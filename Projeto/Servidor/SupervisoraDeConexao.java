import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class SupervisoraDeConexao extends Thread
{
    private Parceiro            jogador;
    private Socket              conexao;
    private ArrayList<Parceiro> jogadores;
    private static int qtdJogadores = 0;
    private static int qtdJogadoresProntos = 0;
    private static boolean jaPediuPalavra = false;

    public SupervisoraDeConexao(Socket conexao, ArrayList<Parceiro> jogadores) throws Exception
    {
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (jogadores==null)
            throw new Exception ("Usuarios ausentes");

        this.conexao  = conexao;
        this.jogadores = jogadores;
    }

    public void run()
    {
        ObjectInputStream receptor=null;
        try
        {
            receptor=
            new ObjectInputStream(
            this.conexao.getInputStream());
        }
        catch (Exception erro)
        {
            return;
        }

        ObjectOutputStream transmissor;
        try
        {
            transmissor =
            new ObjectOutputStream(
            this.conexao.getOutputStream());
        }
        catch (Exception erro)
        {
            try
            {
                receptor.close ();
            }
            catch (Exception falha)
            {}

            return;
        }

        try
        {
            this.jogador =
            new Parceiro (this.conexao,
                          receptor,
                          transmissor);
        }
        catch (Exception erro)
        {} // sei que passei os parametros corretos

        try
        {
            synchronized (this.jogadores)
            {
                this.jogadores.add (this.jogador);
                this.qtdJogadores++;
                if(this.qtdJogadores == 4)
                	for(Parceiro jogador: this.jogadores)
                	{
						jogador.receba(new ComunicadoComecar());
					}
            }

            for(;;)
            {
                Comunicado comunicado = this.jogador.envie();

                 if(comunicado==null)
                    return;

				  if(comunicado instanceof PedidoDeNome)
				  {
					  String nome = ((PedidoDeNome)comunicado).getNome();
				  	  this.jogador.setNome(nome);
				  }
				  else
				  {
					  if(comunicado instanceof PedidoDePalavra)
					  {
						  if(!jaPediuPalavra)
						  {
							  jaPediuPalavra = true;
							  String palavraEscolhida = null;
							  BufferedReader arquivo = new BufferedReader(new InputStreamReader(new FileInputStream("palavra.txt"), "ISO-8859-1"));

							  int aleat = (int) (Math.random() * 100);
							  for (int i = 0; i < aleat; i++)
								  palavraEscolhida = arquivo.readLine();

							  for(Parceiro jogador:this.jogadores)
							  {
								  jogador.setPalavraEscolhida(palavraEscolhida);
								  jogador.receba(new Palavra(palavraEscolhida));
							  }
					  	  }
					  }


					  if(comunicado instanceof PedidoDeFinalizacao)
					  {
						  jaPediuPalavra = false;

						  for(Parceiro jogador:this.jogadores)
						  {
							  jogador.setUltimoJogador(this.jogador.getNome());
						  }
					  }


					  if(comunicado instanceof PedidoDeProntidao)
					  {
						  qtdJogadoresProntos++;
						  if(qtdJogadoresProntos >= this.jogadores.size())
						  {
							  qtdJogadoresProntos = 0;

							  for(Parceiro jogador:this.jogadores)
							  {
								  jogador.receba(new Prontidao(true));
							  }
						  }
						  else
						  {
							  this.jogador.receba(new Prontidao(false));
						  }
					  }


					  if(comunicado instanceof PedidoDeIgualdade)
					  {
						  this.jogador.receba(new Perdedor(this.jogador.getUltimoJogador()));
				  	  }


				  	  if(comunicado instanceof ComunicadoDeDesligamento)
				  	  {
						  synchronized (this.jogadores)
						  {
							  this.jogadores.remove (this.jogador);
						  }
						  this.jogador.adeus();
					  }


					  if(comunicado instanceof PedidoDeQuantidadeDeUsuarios)
					  {
						  this.jogador.receba(new QuantidadeDeUsuarios(this.jogadores.size()));
				  	  }
				  }
			}
        }
        catch (Exception erro)
        {
            try
            {
                transmissor.close ();
                receptor   .close ();
            }
            catch (Exception falha)
            {} // so tentando fechar antes de acabar a thread

            return;
        }
    }
}
