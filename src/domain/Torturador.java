// classe que gerencia a evolução do detetive
package domain;

public class Torturador extends Pessoa {
	protected boolean usedPower; // verifica se ele já usou o poder
	protected boolean firstNight; // analisa se está é a primeira noite

	/**
	 * Construtor de torturador
	 * @param nome: nome do jogador
	 */
	public Torturador(String nome) {
		super(nome); // herda de pessoa
		this.usedPower = false; // não usou o poder ainda, já que iniciou agora
		this.firstNight = true; // é a primeira aparição do torturador no jogo
		this.cargo = "Torturador"; // define o cargo
		
		// define as mensagens de morte
		this.deathMessages = new String[4];
		defineDeathMessages();
	}
	
	/**
	 * Define as mensagens de morte com base em um array de strings
	 */
	@Override
	public void defineDeathMessages() {
		deathMessages[0] = "Eu lutei tanto...e mesmo assim...";
		deathMessages[1] = "Filha... não sou o herói que você pensou,\nmas ainda assim lutei por você até o fim.";
		deathMessages[2] = "Tanto sangue... Eu sabia que ia me afogar uma hora...";
		deathMessages[3] = "Eles falam... todos falam... e mesmo assim...";
	}
	
	/**
	 * Retorna o nome, status e cargo do jogador
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + this.cargo;
	}
	
	/**
	 * Função que realiza o uso do poder do torturador e revela o cargo de alguem escolhido por ele, apenas uma vez
	 * @param alvo: pessoa que sofrerá as consequências do Torturador
	 */
	public void torturar(Pessoa alvo) {
		if(!this.equals(alvo)) { // se ele não quiser cometer suicídio
			if(alvo.status != Status.Dead) { // se a pessoa não estiver morta
				if(this.usedPower == false) { // se ele ainda não usou o poder
					usedPower = true; // ele usa o poder
					System.out.println("Você arranca a pele de " + alvo.nome + " com uma faca e ele"
									 + "\nconfessa que ele(a) é um(a) " + alvo.cargo + "\n"
							         + "Ele continua no chão a angustiar, será que sobreviverá?");
					
					if(!(alvo.status == Status.Blessed)) { // se a pessoa não estiver abençoada
						alvo.status = Status.Dying; // ela começa a morrer
					}
				} else {
					System.out.println("Você ja usou sua habilidade. Não tente me enganar, jogador!");
				}
			} else {
				System.out.println("Seu alvo ja está morto");
			}
		} else {
			System.out.println("Não permitimos suicídios aqui!");
		}
	}
	
	/**
	 * Executa o menu para torturar ou cancelar após escolher alguém
	 * @param alvo: pessoa escolhida
	 */
	public void menu(Pessoa alvo) {
		System.out.println("[1] - Torturar\n[0] - Cancelar");
		int opc = 1;
		while(opc != 0) {
			opc = input.nextInt();
			switch(opc) {
				case 1:
					torturar(alvo);
					opc = 0;
					break;
				case 0:
					break;
				default:
					System.out.println("Opção inexistente");
			}
		}
	}

	/**
	 * Da um resumo do cargo e explica o que o jogador deve fazer
	 */
	@Override
	public String cargoResumo() {
		return "Você agora é um Torturador\n"
			 + "Você caçou e investigou, mas antes de descobrir, perdeu sua filha.\n"
			 + "Você sente a loucura clamando seu nome e...você sucumbi a ela.\n"
			 + "Sua habilidade foi restaurada, mas dessa vez, quem for o alvo\n"
			 + "talvez não resista ao interrogatório. Escolha com sabedoria...";
	}
}
