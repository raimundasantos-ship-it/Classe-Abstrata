import java.util.Random;

public class JogoTabuleiro extends Jogo {

	// atributos
	private String tipoTabuleiro;
	private static final int TAMANHOTABULEIRO = 30;
	private static final int MAXRODADAS = 20;

	// construtor
	public JogoTabuleiro(String nome, int numeroJogadores, String tipoTabuleiro) {
		super(nome, numeroJogadores);
		this.tipoTabuleiro = tipoTabuleiro;
	}

	@Override
	public void iniciar() {
		System.out.println("===========================================");
		System.out.println("     INICIANDO JOGO DE TABULEIRO: " + super.nome.toUpperCase());
		System.out.println("===========================================");
		System.out.println("Tipo de tabuleiro: " + tipoTabuleiro);
		System.out.println("Número de jogadores: " + numeroJogadores);
		System.out.println("Casas no tabuleiro: " + TAMANHOTABULEIRO);
		System.out.println("-------------------------------------------");

		Random random = new Random();

		// Controle de posição de cada jogador
		int[] posicoes = new int[numeroJogadores];
		String[] nomeJogadores = gerarNomesJogadores(numeroJogadores);
		int vencedor = -1;
		int totalRodadas = 0;

		// Inicializa todos na posição 0
		for (int i = 0; i < numeroJogadores; i++) {
			posicoes[i] = 0;
		}

		// Loop de rodadas
		for (int rodada = 1; rodada <= MAXRODADAS; rodada++) {
			System.out.println("  [ RODADA " + rodada + " ]");
			totalRodadas = rodada;

			for (int i = 0; i < numeroJogadores; i++) {
				// Sorteio do dado (1 a 6)
				int dado = random.nextInt(6) + 1;
				posicoes[i] += dado;

				System.out.println("    " + nomeJogadores[i]
						+ " tirou " + dado
						+ " -> posição " + Math.min(posicoes[i], TAMANHOTABULEIRO)
						+ "/" + TAMANHOTABULEIRO);

				// Verifica se chegou ao fim
				if (posicoes[i] >= TAMANHOTABULEIRO) {
					vencedor = i;
					break;
				}
			}

			if (vencedor != -1) {
				break;
			}
		}

		System.out.println("-------------------------------------------");

		// Resultado final
		if (vencedor != -1) {
			System.out.println("VENCEDOR: " + nomeJogadores[vencedor]
					+ " chegou à casa " + TAMANHOTABULEIRO + "!");
		} else {
			// Se ninguém chegou ao fim, vence quem estiver mais avançado
			int melhorPosicao = -1;
			for (int i = 0; i < numeroJogadores; i++) {
				if (posicoes[i] > melhorPosicao) {
					melhorPosicao = posicoes[i];
					vencedor = i;
				}
			}
			System.out.println("Limite de rodadas atingido!");
			System.out.println("VENCEDOR: " + nomeJogadores[vencedor]
					+ " com maior posição: " + melhorPosicao + "!");
		}

		System.out.println("Total de rodadas realizadas: " + totalRodadas);

		// Exibe posições finais
		System.out.println("-------------------------------------------");
		System.out.println("Posições finais:");
		for (int i = 0; i < numeroJogadores; i++) {
			System.out.println("  " + nomeJogadores[i]
					+ ": casa " + Math.min(posicoes[i], TAMANHOTABULEIRO));
		}
		System.out.println("===========================================\n");
	}

	@Override
	public void exibirRegras() {
		System.out.println("--- REGRAS: " + super.nome + " ---");
		System.out.println("1. O tabuleiro possui " + TAMANHOTABULEIRO + " casas.");
		System.out.println("2. Cada jogador lança um dado (1 a 6) por rodada.");
		System.out.println("3. O jogador avança o número de casas sorteado no dado.");
		System.out.println("4. Vence o primeiro jogador a alcançar ou ultrapassar a casa " + TAMANHOTABULEIRO + ".");
		System.out.println("5. Se nenhum jogador vencer em " + MAXRODADAS + " rodadas, vence quem estiver mais avançado.");
		System.out.println();
	}

	// método auxiliar para gerar nomes dos jogadores
	private String[] gerarNomesJogadores(int quantidade) {
		String[] nomes = new String[quantidade];
		String[] nomesBase = {"Ana", "Beto", "Clara", "Daniel", "Elena", "Fábio"};
		for (int i = 0; i < quantidade; i++) {
			if (i < nomesBase.length) {
				nomes[i] = "Jogador " + (i + 1) + " (" + nomesBase[i] + ")";
			} else {
				nomes[i] = "Jogador " + (i + 1);
			}
		}
		return nomes;
	}

	@Override
	public String toString() {
		return super.toString() + " | Tipo tabuleiro: " + tipoTabuleiro;
	}
}