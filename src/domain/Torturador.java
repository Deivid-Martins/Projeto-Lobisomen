package domain;

public class Torturador extends Pessoa {
	protected boolean usedPower;
	protected boolean firstNight;

	public Torturador(String nome) {
		super(nome);
		this.usedPower = false;
		this.firstNight = true;
		this.cargo = "Torturador";
		this.deathMessages = new String[4];
		defineDeathMessages();
	}
	
	@Override
	public void defineDeathMessages() {
		deathMessages[0] = "Eu lutei tanto...e mesmo assim...";
		deathMessages[1] = "Filha... não sou o herói que você pensou,\nmas ainda assim lutei por você até o fim.";
		deathMessages[2] = "Tanto sangue... Eu sabia que ia me afogar uma hora...";
		deathMessages[3] = "Eles falam... todos falam... e mesmo assim...";
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + this.cargo;
	}
	
	/**
	 * Função que realiza o uso do poder do torturador e revela o cargo de alguem escolhido por ele, apenas uma vez
	 * @param alvo: Pessoa que sofrerá as consequências do Torturador
	 */
	public void torturar(Pessoa alvo) {
		if(!this.equals(alvo)) {
			if(alvo.status != Status.Dead) {
				if(this.usedPower == false) {
					usedPower = true;
					System.out.println("Você arranca a pele de " + alvo.nome + " com uma faca e ele"
									 + "\nconfessa que ele(a) é um(a) " + alvo.cargo + "\n"
							         + "Ele continua no chão a angustiar, será que sobreviverá?");
					
					if(!(alvo.status == Status.Blessed)) {
						alvo.status = Status.Dying;
					}
				} else {
					System.out.println("Você ja usou seu poder, bobalhão!");
				}
			} else {
				System.out.println("Seu alvo ja está morto");
			}
		} else {
			System.out.println("Não permitimos suicídios aqui!");
		}
	}
	
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

	@Override
	public String cargoResumo() {
		return "Você agora é um Torturador\n"
			 + "Após investigar e, antes de descobrir, perder sua filha\n"
			 + "para o mal, você enlouqueceu e decidiu torturar pessoas.\n"
			 + "seu poder foi restaurado, mas dessa vez, quem for o alvo\n"
			 + "morrerá, escolha com sabedoria...";
	}
}
