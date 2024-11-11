// classe para gerir funções diversas
package domain;

import java.util.Random;

public abstract class Tool {
	private static final Random random = new Random(); // randomizer
	
	/**
	 * Printa um array de pessoas na tela
	 * @param pessoas: array de pessoas que será impresso
	 */
	public static void printArrayPessoa (Pessoa[] pessoas) {
		for(int i = 0; i < pessoas.length; i ++) {
			System.out.println(pessoas[i]);
			if(i < pessoas.length - 1) {
				System.out.println("|=====-------------");
			}
		}
	}
	
	/**
	 * Imprime um menu com as pessoas que estão jogando e estão vivas
	 * @param pessoas: as pessoas vivas que serão impressas
	 */
	public static void menuPessoas(Pessoa[] pessoas) {
		if(pessoas != null) {
			for(int i = 0; i < pessoas.length; i++) {
				if(i == 0) {
					System.out.println("---------------");
				}
				if(pessoas[i] != null && pessoas[i].status != Status.Dead) {
					System.out.printf("[%d] - %s\n", i+1, pessoas[i].getNome()); // Exibe uma opção do array
				}
			}
			System.out.println("---------------");
		}
	}
	
	/**
	 * Imprime o menu de pessoas mas com os votos do lado
	 * @param pessoas: jogadores que serão impressos
	 */
	public static void menuPessoasWithVotos(Pessoa[] pessoas) {
		System.out.println();
		if(pessoas != null) {
			for(int i = 0; i < pessoas.length; i++) {
				if(i == 0) {
					System.out.println("---------------");
				}
				if(pessoas[i] != null && pessoas[i].status != Status.Dead) {
					System.out.printf("[%d] - %s - Votos: %d\n", i+1, pessoas[i].getNome(), pessoas[i].votos); // Exibe uma opção do array
				}
			}
			System.out.println("[0] - Votar Nulo");
			System.out.println("---------------");
		}
	}
	
	/**
	 * Reseta o votos das pessoas para 0
	 * @param pessoas: array com as pessoaas que terão os votos resetados
	 */
	public static void clearPessoasVotos(Pessoa[] pessoas) {
		for(int i = 0; i < pessoas.length; i ++) {
			pessoas[i].votos = 0;
		}
	}
	
	/**
	 * "Limpa" o terminal
	 */
	public static void clearTerminal() {
		for(int i = 0; i < 50; i ++) {
			System.out.println();
		}
	}
	
	/**
	 * Reseta o poder da bruxa para que ela possa usar novamente na noite
	 * @param pessoas: array de jogadores
	 */
	public static void resetBruxa(Pessoa[] pessoas) {
		for(int i = 0; i < pessoas.length; i ++) {
			if(pessoas[i] instanceof Bruxa) { // se a pessoa for uma instância de bruxa
				Bruxa b = (Bruxa) pessoas[i]; // cria uma forma de acessar essa bruxa
				b.usedPowerTonight = false; // reseta o poder
			}
		}
	}
	
	/**
	 * Transforma o detetive em um torturador
	 * @param pessoas: array com todos os jogadores
	 */
	public static void detetiveForTorturador (Pessoa[] pessoas) {
		for(int i = 0; i < pessoas.length; i ++) {
			if(pessoas[i] instanceof Detetive && pessoas[i].status != Status.Dead) {
				Detetive d = (Detetive) pessoas[i];
				if(!(d.checkFilhaAlive(d.getFilha()))) {
					pessoas[i] = new Torturador(d.getNome());
				}
			}
		}
	}
	
	/**
	 * Imprime um relatório com quem morreu
	 * @param pessoas: array de pessoas
	 */
	public static void getRelatorio(Pessoa[] pessoas) {
		int pessoasVivas = 0; // contador de pessoas vivas
		
		for(int i = 0; i < pessoas.length; i ++) {
			if(pessoas[i].status == Status.Blessed) // caso alguém esteja abençoado
				pessoas[i].status = Status.Alive; // fica vivo de dida
			
			else if(pessoas[i].status == Status.Dying) { // se estiver morrendo
				System.out.println(pessoas[i].getNome() + " Morreu:"); // ela morre
				System.out.println(pessoas[i].isDead()); // e morre
				System.out.println("--------------");
			}
			else if(!(pessoas[i].status == Status.Dead)) { // se alguém não está morto
				pessoasVivas++; // aumenta o contador de gente viva
			}
		}
		System.out.println("Pessoas vivas restantes: " + pessoasVivas);
	}
	
	/**
	 * A bruxa mata alguém, mas tonta, matando alguém aleatório como consequência
	 * @param pessoas: array de jogadores
	 * @param indexBruxa: posição da bruxa
	 * @return retorna o índice de quem ela vai matar quando tonta
	 */
	public static int bruxaTontaKill(Pessoa[] pessoas, int indexBruxa) {
		int randomPeople;
		do {
			randomPeople = random.nextInt(0, pessoas.length);
		} while(pessoas[randomPeople] instanceof Bruxa && pessoas[randomPeople].status == Status.Dead);
		
		return randomPeople;
	}
}
