package domain;

import java.util.Random;

public abstract class Tool {
	private static final Random random = new Random();
	
	public static void printArrayPessoa (Pessoa[] pessoas) {
		for(int i = 0; i < pessoas.length; i ++) {
			System.out.println(pessoas[i]);
			if(i < pessoas.length - 1) {
				System.out.println("|=====-------------");
			}
		}
	}
	
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
			System.out.println("---------------");
		}
	}
	
	public static void clearPessoasVotos(Pessoa[] pessoas) {
		for(int i = 0; i < pessoas.length; i ++) {
			pessoas[i].votos = 0;
		}
	}
	
	public static void clearTerminal() {
		for(int i = 0; i < 50; i ++) {
			System.out.println();
		}
	}
	
	public static void resetBruxa(Pessoa[] pessoas) {
		for(int i = 0; i < pessoas.length; i ++) {
			if(pessoas[i] instanceof Bruxa) {
				Bruxa b = (Bruxa) pessoas[i];
				b.usedPowerTonight = false;
			}
		}
	}
	
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
	
	public static void getRelatorio(Pessoa[] pessoas) {
		int pessoasVivas = 0;
		for(int i = 0; i < pessoas.length; i ++) {
			if(pessoas[i].status == Status.Blessed)
				pessoas[i].status = Status.Alive;
			else if(pessoas[i].status == Status.Dying) {
				System.out.println(pessoas[i].getNome() + " Morreu:");
				System.out.println(pessoas[i].isDead());
				System.out.println("--------------");
			} else if(!(pessoas[i].status == Status.Dead)) {
				pessoasVivas++;
			}
		}
		System.out.println("Pessoas vivas restantes: " + pessoasVivas);
	}
	
	public static int bruxaTontaKill(Pessoa[] pessoas, int indexBruxa) {
		int randomPeople;
		do {
			randomPeople = random.nextInt(0, pessoas.length);
		} while(pessoas[randomPeople] instanceof Bruxa && pessoas[randomPeople].status == Status.Dead);
		
		return randomPeople;
	}
}
