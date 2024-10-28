package domain;

public class Bruxa extends Pessoa{
	protected boolean usedPowerTonight;
	protected boolean tonta;
	
	public Bruxa() {
		super();
		this.usedPowerTonight = false;
		this.tonta = false;
		this.cargo = "Bruxa";
		this.deathMessages = new String[8];
		defineDeathMessages();
	}

	@Override
	public void defineDeathMessages() {
		deathMessages[0] = "Pois a Noite é Escura e Cheia de Terrores.";
		deathMessages[1] = "Eu queimaria o mundo por ele...";
		deathMessages[2] = "Sinto muito pequeno...a mamãe não pode te seguir...";
		deathMessages[3] = "Desculpe, meu pequeno... mamãe não pode seguir você desta vez...";
		deathMessages[4] = "Deixe queimar...";
		deathMessages[5] = "Como fosforo em meio a queimada.";
		deathMessages[6] = "Vocês queimam as formigas, enquanto o formigueiro os devora";
		deathMessages[7] = "Queimar... não mudará nada... a noite continua escura...";
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + cargo;
	}
	
	public void killSomeone(Pessoa alvo) {
		if(alvo.status != Status.Dead) {
			if(this.usedPowerTonight == false) {
				if(!(alvo instanceof Leproso)) {
					usedPowerTonight = true;
					System.out.println("Você agarra " + alvo.nome + " pelo pescoço e o joga em uma piscina de ácido.");
					alvo.status = Status.Dying;
				} else {
					usedPowerTonight = true;
					System.out.println("Você agarra " + alvo.nome + " pelo pescoço e o joga em uma piscina de ácido.\nEle tinha lepra, consequências ocorrerão na proxima noite!");
					alvo.status = Status.Dying;
				}
			} else {
				System.out.println("Você ja usou seu poder, querida");
			}
		} else {
			System.out.println("Esta pessoa ja morreu");
		}
	}
	
	public void menu(Pessoa alvo) {
		System.out.println("[1] - Matar\n[0] - Cancelar");
		int opc = 1;
		while(opc != 0) {
			opc = input.nextInt();
			switch(opc) {
				case 1:
					killSomeone(alvo);
					break;
				case 0:
					break;
				default:
					System.out.println("Opção inexistente");
			}
		}
	}
}
