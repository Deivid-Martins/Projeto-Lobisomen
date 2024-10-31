package domain;

public abstract class Tool {
	
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
	
	public static void clearTerminal() {
		for(int i = 0; i < 50; i ++) {
			System.out.println();
		}
	}
}
