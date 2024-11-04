package domain;

public class Padre extends Pessoa{
	protected boolean powerUsed = false;
	
	public Padre () {
		super();
		this.cargo = "Padre";
		defineDeathMessages();
	}

	@Override
	public void defineDeathMessages() {
		this.deathMessages = new String[5];
		this.deathMessages[0] = "Que noite horrível para uma maldição.";
		this.deathMessages[1] = "A fé é frágil diante da escuridão...\nAté a luz se apaga sobre a maldição.";
		this.deathMessages[2] = "Pai, não me ouvistes hoje? Me ouves agora?";
		this.deathMessages[3] = "Rezamos por proteção... Mas a escuridão veio de dentro.";
		this.deathMessages[4] = "Que Deus me perdoe... Porque já não consigo.";
	}
	
	public void abencoar(Pessoa alvo) {
		if(alvo.getStatus() == Status.Dead) {
			System.out.println(alvo.nome + " já morreu!");
		} else if(this.equals(alvo)) {
			System.out.println("Nada disso, seu papel é proteger as demais pessoas");
		} else if(this.powerUsed == false) {
			this.powerUsed = true;
			alvo.status = Status.Blessed;
			System.out.println("Você livrou " + alvo.nome + ", por uma noite, de todos os males. amém.");
		} else {
			System.out.println("Você ja usou o poder divino uma vez...");
		}
	}
	
	public void menu(Pessoa alvo) {
		System.out.println("[1] - Abençoar\n[0] - Cancelar");
		int opc = 1;
		while(opc != 0) {
			opc = input.nextInt();
			switch(opc) {
				case 1:
					abencoar(alvo); 
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
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + cargo;
	}

	@Override
	public String cargoResumo() {
		return "Você é o Padre\n"
			 + "Você pode abençoar alguém uma unica vez, essa pessoa\n"
			 + "escolhida ficará imune a qualquer tipo de homicidio\n"
			 + "durante a noite que você o abençoou. Você só pode fazer\n"
			 + "isso uma única vez, que Deus o proteja...";
	}
}
