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
		} if (this.equals(alvo)) {
			System.out.println("Nada disso, seu papel é proteger as demais pessoas");
		} else {
			this.powerUsed = true;
			alvo.status = Status.Blessed;
			System.out.println("Você livrou " + alvo.nome + ", por uma noite, de todos os males. amém.");
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
}