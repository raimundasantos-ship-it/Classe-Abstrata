public class Principal {

	public static void main(String[] args) {

		System.out.println("*******************************************");
		System.out.println("*        SIMULAÇÃO DE JOGOS               *");
		System.out.println("*******************************************\n");

		// --- Jogo de Tabuleiro ---
		Jogo jogoTabuleiro = new JogoTabuleiro("Banco Imobiliário", 3, "Quadrado");
		System.out.println("Informações: " + jogoTabuleiro);
		System.out.println();
		jogoTabuleiro.exibirRegras();
		jogoTabuleiro.iniciar();

		// --- Jogo de Cartas ---
		Jogo jogoCarta = new JogoCartas("Poker", 4, "Padrão");
		System.out.println("Informações: " + jogoCarta);
		System.out.println();
		jogoCarta.exibirRegras();
		jogoCarta.iniciar();

		// --- Teste de validação: jogadores insuficientes ---
		System.out.println("--- TESTE DE VALIDAÇÃO ---");
		Jogo jogoInvalido = new JogoCartas("Poker Solo", 1, "Padrão");
		jogoInvalido.iniciar();
	}
}