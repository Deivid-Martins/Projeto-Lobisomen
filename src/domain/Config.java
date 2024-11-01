package domain;

import java.util.Scanner;
import java.util.Random;

public class Config {
	private Scanner input = new Scanner(System.in);
	private Random random = new Random();
	
	private DayOrNight dayOrNight = new DayOrNight();
	private Pessoa[] pessoas;
	
	private String getIntroducao() {
		return "Neste jogo o vilão é a bruxa, até o momento, não contaremos nada sobre oque cada classe faz,\n"
			 + "porém, cada pessoa receberá um resumo sobre como sua classe funcionará, peço que falem apenas\n"
			 + "no turno da noite, e outro aviso, os Aldeões, que são os \"Inocentes\" também receberão tarefas\n"
			 + "a noite, mas peço para que nenhum conte oque é, na segunda rodadas explicaremos como todas as\n"
			 + "categorias funcionam, então é isso, boa sorte a todos.";
	}
	
	private boolean pessoasStillNull() {
		for(int i = 0; i < this.pessoas.length; i ++) {
			if(pessoas[i] == null)
				return true;
		}
		return false;
	}
	
	private boolean pessoasHaveDetetive() {
		for(int i = 0; i < this.pessoas.length; i ++) {
			if(pessoas[i] instanceof Detetive)
				return true;
		}
		return false;
	}
	
	private int pessoasHaveAllBruxa() {
		int quant = 0;
		for(int i = 0; i < this.pessoas.length; i ++) {
			if(pessoas[i] instanceof Bruxa)
				quant++;
		}
		return quant;
	}
	
	private int pessoasHaveAllPadre() {
		int quant = 0;
		for(int i = 0; i < this.pessoas.length; i ++) {
			if(pessoas[i] instanceof Padre)
				quant++;
		}
		return quant;
	}
	
	private int pessoasHaveAllLeproso() {
		int quant = 0;
		for(int i = 0; i < this.pessoas.length; i ++) {
			if(pessoas[i] instanceof Leproso)
				quant++;
		}
		return quant;
	}
	
	private void defCargos(int pessoaLength, int bruxa, int detetive, int padre, int leproso) {
		int filha = detetive;
		int index;
		int classe = 0;
		while((!pessoasHaveDetetive()) || pessoasHaveAllBruxa() != bruxa || pessoasHaveAllPadre() != padre || pessoasHaveAllLeproso() != leproso) {
			if(!pessoasHaveDetetive())
				classe = 0;
			else if(pessoasHaveAllBruxa() != bruxa)
				classe = 1;
			else if(pessoasHaveAllPadre() != padre)
				classe = 2;
			else if(pessoasHaveAllLeproso() != leproso)
				classe = 3;
			index = random.nextInt(0, pessoaLength);
			if(this.pessoas[index] == null) {
				switch(classe) {
					case 0:
						if(detetive > 0) {
							this.pessoas[index] = new Detetive();
							detetive--;
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
						this.pessoas[index] = new Bruxa();
						break;
					case 2:
						this.pessoas[index] = new Padre();
						break;
					case 3:
						this.pessoas[index] = new Leproso();
						break;
					default:
						System.out.println("|| ERRO INESPERADO ||");
				}
			}
		}
		if(pessoasStillNull()) {
			for(int i = 0; i < pessoas.length; i ++) {
				if(this.pessoas[i] == null) {
					this.pessoas[i] = new Aldeao();
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
		System.out.println("Bem Vindo a Aldeia");
		System.out.println(getIntroducao());
		System.out.print("Defina a quantia de jogadores: ");
		int pessoasLength = input.nextInt();
		if(pessoasLength <= 4) {
			System.out.println("Vai ter nem graça com esse tanto de gente\nvá pra casa vá.");
		} else if (pessoasLength <= 8) {
			this.pessoas = new Pessoa[pessoasLength];
			int bruxa = 1;
			int detetive = 1;
			int padre = 1;
			int leproso = 1;
			defCargos(pessoasLength, bruxa, detetive, padre, leproso);
		} else if (pessoasLength <= 15) {
			this.pessoas = new Pessoa[pessoasLength];
			int bruxa = 2;
			int detetive = 1;
			int padre = 2;
			int leproso = 2;
			defCargos(pessoasLength, bruxa, detetive, padre, leproso);
		} else {
			this.pessoas = new Pessoa[pessoasLength];
			int bruxa = 3;
			int detetive = 1;
			int padre = 3;
			int leproso = 4;
			defCargos(pessoasLength, bruxa, detetive, padre, leproso);
		}
		System.out.println("\nDigite qualquer coisa para iniciar...");
		input.next();
		Tool.clearTerminal();
		dayOrNight.loop(pessoas);
	}
}
