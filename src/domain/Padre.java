// classe que gerencia o padre do jogo
package domain;

public class Padre extends Pessoa{
	protected boolean powerUsed; // verifica se o poder do padre já foi usado
	
	/**
	 * Construtor de padre
	 */
	public Padre () {
		super(); // herda de pessoa
		this.powerUsed = false; // no inicio ele não usou o poder ainda
		this.cargo = "Padre"; // define o cargo
		
		// define as mensagens de morte
		this.deathMessages = new String[5];
		defineDeathMessages();
	}

	/**
	 * Define as mensagens de morte com base num array de strings
	 */
	@Override
	public void defineDeathMessages() {
		this.deathMessages[0] = "Que noite horrível para uma maldição.";
		this.deathMessages[1] = "A fé é frágil diante da escuridão...\nAté a luz se apaga sobre a maldição.";
		this.deathMessages[2] = "Pai, não me ouvistes hoje? Me ouves agora?";
		this.deathMessages[3] = "Rezamos por proteção... Mas a escuridão veio de dentro.";
		this.deathMessages[4] = "Que Deus me perdoe... Porque já não consigo.";
	}
	
	/**
	 * Abençoa um jogador alvo para que ele não possa morrer esta noite
	 * @param alvo: jogador que será abençoado pelo padre
	 */
	public void abencoar(Pessoa alvo) {
		if(alvo.getStatus() == Status.Dead) { // caso ele já esteja morto
			System.out.println(alvo.nome + " já morreu!");
		} 
		else if(this.equals(alvo)) { // caso ele tente se abençoar
			System.out.println("Você não consegue usar isso com você mesmo, seu papel é proteger as demais pessoas, jogador.");
		}
		else if(this.powerUsed == false) { // caso ele não tenha usado o poder ainda
			this.powerUsed = true; // usa o poder
			alvo.status = Status.Blessed; // abençoa o alvo
			System.out.println("Você livrou " + alvo.nome + ", por uma noite, de todos os males. amém.");
		} 
		else { // caso ele já tenha usado o poder
			System.out.println("Você ja usou o poder divino...");
		}
	}
	
	/**
	 * Menu de escolhas para que o padre possa escolher quem abençoar
	 * @param alvo: pessoa a qual ele pretende abençoar
	 */
	public void menu(Pessoa alvo) {
		int opc; // opção do usuário
		
		do {
			System.out.println("[1] - Abençoar\n[0] - Cancelar"); // prompt
			opc = input.nextInt(); // armazena a escolha
			
			switch(opc) {
			case 1:
				abencoar(alvo); 
				opc = 0;
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inexistente");
				break;
			}
		} while (opc != 0); // enquanto não for cancelar
	}
	
	/**
	 * Retorna o nome, status e cargo do jogador
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + cargo;
	}

	/**
	 * Da um resumo do cargo e o que o jogador pode fazer
	 */
	@Override
	public String cargoResumo() {
		return "Você é o Padre\n"
			 + "Você pode abençoar alguém uma unica vez, essa pessoa\n"
			 + "escolhida ficará imune a qualquer tipo de perigo\n"
			 + "durante a noite que você o abençoou. Você só pode fazer\n"
			 + "isso uma única vez, que Deus o proteja...";
	}
}
