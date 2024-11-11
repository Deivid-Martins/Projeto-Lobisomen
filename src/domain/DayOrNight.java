// classe para ficar trocando o dia e a noite e coisas do tipo
package domain;

import java.util.Scanner;

public class DayOrNight {
	private Scanner input; // scanner 
	private int countNight; // contador de noite
	private boolean day; // verifica se é dia ou noite
	
	/**
	 * Construtor de DayorNight
	 */
	public DayOrNight() {
		input  = new Scanner(System.in); // inicia o scanner
		this.countNight = 0; // não começou nenhuma noite ainda
		this.day = true; // o jogo começa de dia
	}
	
	/**
	 * Se está de dia, vira noite e executa as funções da noite
	 * Se está de noite, vira dia e executa as funções do dia
	 * @param pessoas: arra de jogadores
	 */
	public void loop(Pessoa[] pessoas) {
			if(day == true)
				isNight(pessoas);
			else if(day == false)
				isDay(pessoas);
	}

	/**
	 * Escolhe uma pessoa dentre as opções de jogadores
	 * @param pessoas
	 * @return
	 */
	private int choosePessoa(Pessoa[] pessoas) {
		int opc = input.nextInt();
		while(opc < 0 || opc - 1 > pessoas.length) {
			System.out.print("Opção inválida, tente novamente: ");
			opc = input.nextInt();
		}
		return opc;
	}
	
	/**
	 * Executa as funções relacionadas a noite do jogo
	 * @param pessoas: array de jogadores
	 */
	public void isNight(Pessoa[] pessoas) {
		System.out.println("------------------------- Noite -------------------------");
		this.day = false; // vira noite
		countNight++; // aumenta o contador de noites
		
		// percorre o array de jogadores
		for(int i = 0; i < pessoas.length; i++) {
			if(!(pessoas[i].status == Status.Dead)) { // se alguém não está morto
				System.out.println("Participante: " + pessoas[i].getNome() + "\nCargo: " + pessoas[i].cargo);
				
				if(countNight == 1) { // se for a primeira noite
					System.out.println(pessoas[i].cargoResumo()); // imprime o resumo do cargo
				}
				
				if(pessoas[i] instanceof Torturador) { // se for um torturador
					Torturador t = (Torturador) pessoas[i]; // cria uma forma de acessar esse torturador
					
					if(t.firstNight) { // caso seja a primeira noite do torturador no jogo
						System.out.println(t.cargoResumo()); // imrpime seu resumo
						t.firstNight = false; // e já não é mais a primeira noite dele
					}
				}
				
				// se for qualquer outra coisa que não faz nada
				if(pessoas[i] instanceof Aldeao || pessoas[i] instanceof Filha || pessoas[i] instanceof Leproso) {
					pessoas[i].menu(); // imprime o menu (captcha)
				}
				else { // caso seja um cargo que faça algo
					Tool.menuPessoas(pessoas); // imprime as pessoas vivas
					System.out.println("[0] - Não fazer nada\nFaça sua escolha: "); // prompt
					int opc = choosePessoa(pessoas); // escolha
					
					// caso seja uma opção válida
					if(opc > 0 && opc - 1 < pessoas.length) {
						if(pessoas[i] instanceof Bruxa) { // caso seja uma bruxa que esteja jogando
							Bruxa b = (Bruxa) pessoas[i]; // cria uma forma de acessar a bruxa
							
							if(b.tonta == false) { // se ela não estiver tonta
								b.menu(pessoas[opc - 1]); // executa o menu dela (mata)
							} 
							else { // se ela está tonta
								opc = Tool.bruxaTontaKill(pessoas, i); // escolhe errado
								b.menu(pessoas[opc]); // mata errado
								b.tonta = false; // deixa de ficar tonta
							}
						} 
						else if(pessoas[i] instanceof Detetive) { // caso seja um detetive em jogo
							Detetive d = (Detetive) pessoas[i]; // acessa o detetive
							d.menu(pessoas[opc - 1]); // escolhe o menu dele
						} 
						// mesma coisa pro padre
						else if(pessoas[i] instanceof Padre) {
							Padre p = (Padre) pessoas[i];
							p.menu(pessoas[opc - 1]);
						} 
						// pro torturador também
						else if(pessoas[i] instanceof Torturador) {
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
	
	/**
	 * Executa as funções correlacionadas ao dia do jogo
	 * @param pessoas: array de jogadores
	 */
	public void isDay(Pessoa[] pessoas) {
		System.out.println("------------------------- Dia -------------------------");
		this.day = true; // é de dia
		Tool.getRelatorio(pessoas); // imprime quem morreu
		Tool.detetiveForTorturador(pessoas); // transforma o detetive em torturador, caso necessário
		Tool.resetBruxa(pessoas); // reseta o poder da bruxa
		Tool.clearPessoasVotos(pessoas); // apaga os votos dos jogadores
		
		System.out.println("\n"); 
		voteSystem(pessoas); // votação é aberta
		
		System.out.println("\nDigite qualquer coisa para encerrar o dia");
		input.next();
		Tool.clearTerminal();
	}

	/**
	 * Abre o sistema de votação para matar alguém
	 * @param pessoas: array de jogadores
	 */
	private void voteSystem(Pessoa[] pessoas) {
	    int opc; // escolha do usuário
	 
	    System.out.println("-----=== Votação ===-----");
	    for (int i = 0; i < pessoas.length; i++) {
	        if (pessoas[i].status != Status.Dead) { // se a pessoa não estiver morta
	            Tool.menuPessoasWithVotos(pessoas); // imprime o menu das pessoas com seus votos
	            
	            System.out.print(pessoas[i].getNome() + ", Quem você vai votar para a expulsão: "); // prompt
	            opc = input.nextInt() - 1; // faz a escolha diminuindo um
	            
	            // enquanto escolher alguém inválido pede outro input
	            while (pessoas[opc].status == Status.Dead || opc < 0 || opc >= pessoas.length) {
	                System.out.print("Tente novamente: ");
	                opc = input.nextInt();
	            }
	            
	            pessoas[opc].votos++; // aumenta os votos de alguém
	            
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
