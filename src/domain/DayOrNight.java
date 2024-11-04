package domain;

import java.util.Scanner;

public class DayOrNight {
	private static final Scanner input = new Scanner(System.in);
	private int countNight;
	private boolean day;
	
	public DayOrNight() {
		this.countNight = 0;
		this.day = true;
	}
	
	public void loop(Pessoa[] pessoas) {
			if(day == true)
				isNight(pessoas);
			else if(day == false)
				isDay(pessoas);
	}
	
	private int choosePessoa(Pessoa[] pessoas) {
		int opc = input.nextInt();
		while(opc < 0 || opc - 1 > pessoas.length) {
			System.out.print("Opção inválida, tente novamente: ");
			opc = input.nextInt();
		}
		return opc;
	}
	
	public void isNight(Pessoa[] pessoas) {
		System.out.println("------------------------- Noite -------------------------");
		this.day = false;
		countNight++;
		for(int i = 0; i < pessoas.length; i++) {
			if(!(pessoas[i].status == Status.Dead)) {
				System.out.println("Participante: " + pessoas[i].getNome() + "\nCargo: " + pessoas[i].cargo);
				if(countNight == 1) {
					System.out.println(pessoas[i].cargoResumo());
				}
				if(pessoas[i] instanceof Torturador) {
					Torturador t = (Torturador) pessoas[i];
					if(t.firstNight) {
						System.out.println(t.cargoResumo());
						t.firstNight = false;
					}
				}
				if(pessoas[i] instanceof Aldeao || pessoas[i] instanceof Filha || pessoas[i] instanceof Leproso) {
					pessoas[i].menu();
				} else {
					Tool.menuPessoas(pessoas);
					System.out.println("[0] - Não fazer nada\nFaça sua escolha: ");
					int opc = choosePessoa(pessoas);
					if(opc > 0 && opc - 1 < pessoas.length) {
						if(pessoas[i] instanceof Bruxa) {
							Bruxa b = (Bruxa) pessoas[i];
							if(b.tonta == false) {
								b.menu(pessoas[opc - 1]);
							} else {
								opc = Tool.bruxaTontaKill(pessoas, i);
								b.menu(pessoas[opc]);
								b.tonta = false;
							}
						} else if(pessoas[i] instanceof Detetive) {
							Detetive d = (Detetive) pessoas[i];
							d.menu(pessoas[opc - 1]);
						} else if(pessoas[i] instanceof Padre) {
							Padre p = (Padre) pessoas[i];
							p.menu(pessoas[opc - 1]);
						} else if(pessoas[i] instanceof Torturador) {
							Torturador t = (Torturador) pessoas[i];
							t.menu(pessoas[opc - 1]);
						}
					}
				}
				System.out.println("\nDigite qualquer coisa para prosseguir ao proximo participante...");
				input.next();
				Tool.clearTerminal();
			}
		}
		System.out.println("\nDigite qualquer coisa para encerrar a noite");
		input.next();
		Tool.clearTerminal();
	}
	

	
	public void isDay(Pessoa[] pessoas) {
		System.out.println("------------------------- Dia -------------------------");
		this.day = true;
		Tool.getRelatorio(pessoas);
		Tool.detetiveForTorturador(pessoas);
		Tool.resetBruxa(pessoas);
		Tool.clearPessoasVotos(pessoas);
		System.out.println("\n");
		voteSystem(pessoas);
		System.out.println("\nDigite qualquer coisa para encerrar o dia");
		input.next();
		Tool.clearTerminal();
	}

	private void voteSystem(Pessoa[] pessoas) {
	    int opc;
	    System.out.println("-----=== Votação ===-----");
	    for (int i = 0; i < pessoas.length; i++) {
	        if (pessoas[i].status != Status.Dead) {
	            Tool.menuPessoasWithVotos(pessoas);
	            System.out.print(pessoas[i].getNome() + ", Quem você vai votar para a expulsão: ");
	            opc = input.nextInt() - 1;
	            while (pessoas[opc].status == Status.Dead || opc < 0 || opc >= pessoas.length) {
	                System.out.print("Tente novamente: ");
	                opc = input.nextInt();
	            }
	            pessoas[opc].votos++;
	            System.out.println("\nDigite qualquer coisa para ir ao próximo participante");
	            input.next();
	            Tool.clearTerminal();
	        }
	    }

	    // Encontrar o mais votado
	    int maxVotos = -1;
	    int countMaxVotados = 0;

	    for (int i = 0; i < pessoas.length; i++) {
	        if (pessoas[i].votos > maxVotos) {
	            maxVotos = pessoas[i].votos;
	            countMaxVotados = 1; // Resetar o contador para 1, pois encontramos um novo máximo
	        } else if (pessoas[i].votos == maxVotos && maxVotos != 0) {
	            countMaxVotados++; // Contar quantas pessoas têm o mesmo número de votos
	        }
	    }

	    // Exibir resultado da votação
	    System.out.println("-----=== Resultado da Votação ===-----");
	    if (countMaxVotados > 1) {
	        System.out.println("Empate ocorreu entre " + countMaxVotados + " pessoas.");
	    } else if (maxVotos > 0) {
	        for (int i = 0; i < pessoas.length; i++) {
	            if (pessoas[i].votos == maxVotos) {
	                System.out.println("A pessoa mais votada para a expulsão é: " + pessoas[i].nome);
	                System.out.println("Com um total de " + pessoas[i].votos + " votos.");
	                pessoas[i].status = Status.Dying;
	                System.out.println(pessoas[i].getNome() + " morreu: " + pessoas[i].isDead());
	            }
	        }
	    } else {
	        System.out.println("Nenhuma votação válida foi realizada.");
	    }
	}

}
