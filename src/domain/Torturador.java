package domain;

public class Torturador extends Pessoa {
	protected boolean usedPower = false;

	public Torturador() {
		super();
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
		if(alvo.status != Status.Dead) {
			if(this.usedPower == false) {
				usedPower = true;
				if (alvo instanceof Torturador) {
					Torturador target = (Torturador) alvo;
					System.out.println("Você arranca a pele de " + alvo.nome + " com uma faca e ele confessa que ele(a) é um(a) " + target.cargo + "\nApós angustiar mais um pouco, " + alvo.nome + " vem a óbito...");
					alvo.status = Status.Dying;
				}
			} else {
				System.out.println("Você ja usou seu poder, bobalhão!");
			}
		} else {
			System.out.println("Seu alvo ja está morto");
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
					break;
				case 0:
					break;
				default:
					System.out.println("Opção inexistente");
			}
		}
	}
}
