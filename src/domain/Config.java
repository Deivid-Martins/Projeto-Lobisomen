package domain;

import java.util.Scanner;
import java.util.Random;

public class Config {
	private Scanner input = new Scanner(System.in);
	private Random random = new Random();
	
	private Pessoa[] pessoas;
	
	/**
	 * Função onde inicia absolutamente tudo na main, nada além disso deve ser executado na mais, aqui deve
	 * conter todas as regras para o funcionamento planejado
	 */
	public void startGame() {
		System.out.println("-----===| \"Werewolf\" |===-----");
		System.out.print("Defina a quantia de jogadores: ");
		int pessoasLength = input.nextInt();
		if(pessoasLength <= 5) {
			System.out.println("Com essa quantia, melhor nem jogar mesmo.\nVá pra casa, vá");
		} else if (pessoasLength <= 8) {
			int detetives = 1, torturadores = 1;
			setFunctions(detetives, torturadores, pessoasLength);
		}
	}
	/**
	 * Função que randomiza os cargos a depender do tamanho de jogadores
	 * @param detetives: quantia de detetives que devem existir
	 * @param torturadores: quantia de torturadores que devem existir
	 * @param pessoasLength: quantia de Pessoas participando
	 */
	public void setFunctions(int detetives, int torturadores, int pessoasLength) {
		this.pessoas = new Pessoa[pessoasLength];
		for(int i = 0; i < pessoasLength; i ++) {
			if(detetives > 0 || torturadores > 0) {
				int indexRandom = random.nextInt(3);
				switch(indexRandom) {
					case 0:
						this.pessoas[i] = new Detetive();
						if(this.pessoas[i+1] != null) {
							this.pessoas[1+1] = new Filha();
						} else if (this.pessoas[i-1] != null) {
							if (this.pessoas[i-1] instanceof Aldeao) {
							this.pessoas[i-1] = new Filha();
							}
						}
						detetives--;
						break;
					case 1:
						this.pessoas[i] = new Torturador();
						torturadores--;
						break;
					case 2:
						this.pessoas[i] = new Aldeao();
						break;
					default:
						System.out.println("Erro inesperado, cheque até aonde o random está indo\ne olhe se adicionou a nova classe neste switch!");
				}
			}
		}
	}
	
	public Pessoa[] getPessoas () {
		return this.pessoas;
	}
}
