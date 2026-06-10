import java.util.Random;

public class JogoCartas extends Jogo {

	// atributos
	private String tipoBaralho;
	private static final int MINJOGADORES = 2;
	private static final int MAXJOGADORES = 6;
	private static final int TOTALCARTAS = 52;

	// construtor da classe
	public JogoCartas(String nome, int numeroJogadores, String tipoBaralho) {
		super(nome, numeroJogadores);
		this.tipoBaralho = tipoBaralho;
	}

	@Override
	public void iniciar() {
		System.out.println("===========================================");
		System.out.println("       INICIANDO JOGO DE CARTAS: " + super.nome.toUpperCase());
		System.out.println("===========================================");

		// 1. Validação da quantidade de jogadores
		if (numeroJogadores < MINJOGADORES) {
			System.out.println("ERRO: Número mínimo de jogadores é " + MINJOGADORES
					+ ". Jogo não pode ser iniciado.");
			return;
		}
		if (numeroJogadores > MAXJOGADORES) {
			System.out.println("ERRO: Número máximo de jogadores é " + MAXJOGADORES
					+ ". Jogo não pode ser iniciado.");
			return;
		}

		System.out.println("Jogadores confirmados: " + numeroJogadores);
		System.out.println("Tipo de baralho: " + tipoBaralho);
		System.out.println("-------------------------------------------");

		// 2. Definição da quantidade de cartas por jogador
		int cartasPorJogador = TOTALCARTAS / numeroJogadores;
		int cartasRestantes = TOTALCARTAS - (cartasPorJogador * numeroJogadores);

		System.out.println("Total de cartas no baralho: " + TOTALCARTAS);
		System.out.println("Cada jogador recebe: " + cartasPorJogador + " cartas");
		System.out.println("-------------------------------------------");

		// 3. Simulação de distribuição de cartas
		String[] nomeJogadores = gerarNomesJogadores(numeroJogadores);

		System.out.println("Distribuindo cartas...");
		for (int i = 0; i < numeroJogadores; i++) {
			System.out.println("  " + nomeJogadores[i] + " recebeu " + cartasPorJogador + " cartas.");
		}
		System.out.println("-------------------------------------------");

		// 4. Sorteio do vencedor da rodada
		Random random = new Random();
		int indiceVencedor = random.nextInt(numeroJogadores);
		System.out.println("Resultado da rodada:");
		System.out.println("  VENCEDOR: " + nomeJogadores[indiceVencedor] + "!");

		// 5. Exibição das cartas restantes no baralho
		System.out.println("-------------------------------------------");
		System.out.println("Cartas restantes no baralho: " + cartasRestantes);
		System.out.println("===========================================\n");
	}

	@Override
	public void exibirRegras() {
		System.out.println("--- REGRAS: " + super.nome + " ---");
		System.out.println("1. O jogo aceita de " + MINJOGADORES + " a " + MAXJOGADORES + " jogadores.");
		System.out.println("2. O baralho possui " + TOTALCARTAS + " cartas no total.");
		System.out.println("3. As cartas são distribuídas igualmente entre os jogadores.");
		System.out.println("4. Cada jogador deve jogar uma carta por vez.");
		System.out.println("5. Vence a rodada o jogador que jogar a carta de maior valor.");
		System.out.println("6. Vence o jogo quem acumular mais rodadas.");
		System.out.println();
	}

	// método auxiliar para gerar nomes dos jogadores
	private String[] gerarNomesJogadores(int quantidade) {
		String[] nomes = new String[quantidade];
		String[] nomesBase = {"Alice", "Bruno", "Carla", "Diego", "Eva", "Felipe"};
		for (int i = 0; i < quantidade; i++) {
			nomes[i] = "Jogador " + (i + 1) + " (" + nomesBase[i] + ")";
		}
		return nomes;
	}

	@Override
	public String toString() {
		return super.toString() + " | Tipo baralho: " + tipoBaralho;
	}
}