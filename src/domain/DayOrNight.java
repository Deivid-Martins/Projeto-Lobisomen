package domain;

import java.util.Scanner;

public class DayOrNight {
	private static final Scanner input = new Scanner(System.in);
	
	private int countDay;
	private int countNight;
	private boolean day;
	
	public DayOrNight() {
		this.countDay = 0;
		this.countNight = 0;
		this.day = false;
	}
	
	private boolean haveGoodPessoaAlive(Pessoa[] pessoas) {
		int counterAlives = 0;
		for(int i = 0; i < pessoas.length; i ++) {
			if(!(pessoas[i] instanceof Bruxa) && !(pessoas[i].status == Status.Dead)) {
				counterAlives++;
				if(counterAlives >= 2) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean bruxaStillAlive(Pessoa[] pessoas) {
		for(int i = 0; i < pessoas.length; i ++) {
			if(pessoas[i] instanceof Bruxa && !(pessoas[i].status == Status.Dead)) {
				return true;
			}
		}
		return false;
	}
	
	public void loop(Pessoa[] pessoas) {
		while(haveGoodPessoaAlive(pessoas) || bruxaStillAlive(pessoas)) {
			if(day == true) {
				isNight(pessoas);
			} else if(day == false) {
				isDay(pessoas);
			}
		}
		if(bruxaStillAlive(pessoas)) {
			System.out.println("Que pena, a bruxa venceu...");
		} else if (haveGoodPessoaAlive(pessoas)) {
			System.out.println("Que pena, a bruxa perdeu...");
		}
	}
	
	private int choosePessoa(Pessoa[] pessoas) {
		int opc = input.nextInt();
		while(pessoas[opc] == null) {
			System.out.print("Opção inexistente, tente novamente: ");
			opc = input.nextInt();
		}
		return opc - 1;
	}
	
	public void isNight(Pessoa[] pessoas) {
		System.out.println("------------------------- Noite -------------------------");
		this.day = false;
		countNight++;
		for(int i = 0; i < pessoas.length; i++) {
			System.out.println("Participante: " + pessoas[i].getNome() + "\nCargo: " + pessoas[i].cargo);
			if(countNight == 1) {
				System.out.println(pessoas[i].cargoResumo());
			}
			if(pessoas[i] instanceof Aldeao || pessoas[i] instanceof Filha || pessoas[i] instanceof Leproso) {
				pessoas[i].menu();
			} else {
				Tool.menuPessoas(pessoas);
				System.out.println("[0] - Não fazer nada\nFaça sua escolha: ");
				int opc = choosePessoa(pessoas);
				if(opc != 0) {
					if(pessoas[i] instanceof Bruxa) {
						Bruxa b = (Bruxa) pessoas[i];
						b.menu(pessoas[opc]);
					} else if(pessoas[i] instanceof Detetive) {
						Detetive d = (Detetive) pessoas[i];
						d.menu(pessoas[opc]);
					} else if(pessoas[i] instanceof Padre) {
						Padre p = (Padre) pessoas[i];
						p.menu(pessoas[opc]);
					} else if(pessoas[i] instanceof Padre) {
						Padre p = (Padre) pessoas[i];
						p.menu(pessoas[opc]);
					} else if(pessoas[i] instanceof Torturador) {
						Torturador t = (Torturador) pessoas[i];
						t.menu(pessoas[opc]);
					}
				}
			}
			System.out.println("\nDigite qualquer coisa para prosseguir ao proximo participante...");
			input.next();
			Tool.clearTerminal();
		}
		System.out.println("\nDigite qualquer coisa para encerrar a noite");
		input.next();
		Tool.clearTerminal();
	}
	
	public void isDay(Pessoa[] pessoas) {
		System.out.println("------------------------- Dia -------------------------");
		getRelatorio(pessoas);
		this.countDay++;
		this.day = true;
		System.out.println("\nDigite qualquer coisa para encerrar o dia");
		input.next();
		Tool.clearTerminal();
	}
	
	private void getRelatorio(Pessoa[] pessoas) {
		int pessoasVivas = 0;
		for(int i = 0; i < pessoas.length; i ++) {
			if(pessoas[i].status == Status.Blessed)
				pessoas[i].status = Status.Alive;
			else if(pessoas[i].status == Status.Dying) {
				System.out.println("--------------");
				System.out.println(pessoas[i].getNome());
				System.out.println(pessoas[i].isDead());
				System.out.println("--------------");
			} else if(pessoas[i].status == Status.Alive || pessoas[i].status == Status.Blessed) {
				pessoasVivas++;
			}
		}
		System.out.println("Pessoas vivas restantes: " + pessoasVivas);
	}
}
