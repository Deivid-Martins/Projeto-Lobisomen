package domain;

import java.util.Scanner;
import java.util.Random;

public class Config {
	private Scanner input = new Scanner(System.in);
	private Random random = new Random();
	
	private Pessoa[] pessoas;
	
	private String getIntroducao() {
		return "Neste jogo o vilão é a bruxa, até o momento, não contaremos nada sobre oque cada classe faz,\n"
			 + "porém, cada pessoa receberá um resumo sobre como sua classe funcionará, peço que falem apenas\n"
			 + "no turno da noite, e outro aviso, os Aldeões, que são os \"Inocentes\" também receberão tarefas\n"
			 + "a noite, mas peço para que nenhum conte oque é, na segunda rodadas explicaremos como todas as\n"
			 + "categorias funcionam, então é isso, boa sorte a todos.";
	}
	
	private boolean pessoaStillNull() {
		for(int i = 0; i < this.pessoas.length; i ++) {
			if(pessoas[i] == null)
				return true;
		}
		return false;
	}
	
	private void defCargos(int pessoaLength, int detetives) {
		int filha = detetives;
		int index;
		int classe;
		while(pessoaStillNull()) {
			index = random.nextInt(0, pessoaLength);
			classe = random.nextInt(0, 2);
			if(this.pessoas[index] == null) {
				switch(classe) {
					case 0:
						if(detetives > 0) {
							this.pessoas[index] = new Detetive();
							detetives--;
							int saveDadIndex = index;
							for(int i = 0; i < this.pessoas.length; i ++) {
								if(pessoas[i] == null && filha > 0) {
									this.pessoas[i] = new Filha();
									if (this.pessoas[i] instanceof Filha && this.pessoas[saveDadIndex] instanceof Detetive) {
										Filha f = (Filha) this.pessoas[i];
										Detetive p = (Detetive) this.pessoas[saveDadIndex];
										f.defineDad(p);
										p.defineDaughter(f);
										f.defineDeathMessages();
										p.defineDeathMessages();
									}
									filha --;
								}
							}
						}
						break;
					case 1:
						this.pessoas[index] = new Aldeao();
						break;
					default:
						System.out.println("|| ERRO INESPERADO ||");
				}
			}
		}
	}
	
	public Pessoa[] getPessoas () {
		return this.pessoas;
	}
	
	public int intInputLimitado(int limiteBaixo, int limiteAlto){
		int opc; // Opção escolhida pelo usuário
		do {
			System.out.print("Informe um número: "); // Prompt
			opc = input.nextInt(); // Guarda a categoria
			
			// Caso seja um número inválido
			if(opc < limiteBaixo || opc > limiteAlto) 
			{ 
				System.out.printf("Digite um número válido! Só pode entre %d e %d!\n", limiteBaixo, limiteAlto);
			}
		} while(opc < limiteBaixo || opc > limiteAlto);
		return opc;
	}
	
	/**
	 * Função onde inicia absolutamente tudo na main, nada além disso deve ser executado na mais, aqui deve
	 * conter todas as regras para o funcionamento planejado
	 */
	public void startGame() {
		System.out.println("                               -----===| \"Werewolf\" |===-----");
		System.out.println(getIntroducao());
		System.out.print("Defina a quantia de jogadores: ");
		int pessoasLength = input.nextInt();
		if(pessoasLength <= 4) {
			System.out.println("Vai ter nem graça com esse tanto de gente\nvá pra casa vá.");
		} else if (pessoasLength <= 8) {
			this.pessoas = new Pessoa[pessoasLength];
			int detetives = 1;
			defCargos(pessoasLength, detetives);
		} else if (pessoasLength <= 15) {
			this.pessoas = new Pessoa[pessoasLength];
			int detetives = 1;
			defCargos(pessoasLength, detetives);
		} else {
			this.pessoas = new Pessoa[pessoasLength];
			int detetives = 1;
			defCargos(pessoasLength, detetives);
		}
	}
}
