package domain;

import java.util.Scanner;
import java.util.Random;

public class Config {
	private Scanner input = new Scanner(System.in);
	private Random random = new Random();
	
	private Pessoa[] pessoas;
	
	public void startGame() {
		System.out.println("-----===| \"Werewolf\" |===-----");
		System.out.print("Defina a quantia de jogadores: ");
		int pessoasLength = input.nextInt();
		if(pessoasLength <= 4) {
			System.out.println("Com essa quantia, melhor nem jogar mesmo.\nVá pra casa, vá");
		} else if (pessoasLength <= 7) {
			int detetives = 2, torturadores = 1;
			setFunctions(detetives, torturadores, pessoasLength);
		}
	}
	
	public void setFunctions(int detetives, int torturadores, int pessoasLength) {
		this.pessoas = new Pessoa[pessoasLength];
		for(int i = 0; i < pessoasLength; i ++) {
			if(detetives > 0 || torturadores > 0) {
				int indexRandom = random.nextInt(2);
				switch(indexRandom) {
					case 0:
						this.pessoas[i] = new Detetive();
						detetives--;
						break;
					case 1:
						this.pessoas[i] = new Torturador();
						torturadores--;
						break;
					default:
						this.pessoas[i] = new Filha();
				}
			}
		}
	}
	
	public Pessoa[] getPessoas () {
		return this.pessoas;
	}
}
