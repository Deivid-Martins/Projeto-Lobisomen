// classe que gerencia a bruxa (vilã) do jogo
package domain;

public class Bruxa extends Pessoa{
	protected boolean usedPowerTonight; // verifica se ela já usou o poder (esta noite)
	protected boolean tonta; // verifica se ela está tonta
	
	public Bruxa() {
		super(); // herda de pessoa
		this.usedPowerTonight = false; // inicia sem ter usado o poder
		this.tonta = false; // inicia sem estr tonta
		this.cargo = "Bruxa"; // define o cargo
		
		// define as mensagens de morte
		this.deathMessages = new String[8];
		defineDeathMessages();
	}

	/**
	 * Define as mensagens de morte com base em um array de strings
	 */
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
	
	/**
	 * Retorna nome, status e cargo do jogador
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + cargo;
	}
	
	/**
	 * Mata um alvo específico
	 * @param alvo: pessoa que será morta
	 */
	public void killSomeone(Pessoa alvo) {
		if(!this.equals(alvo)) { // se não for uma tentativa de suicídio
			if(alvo.status != Status.Dead) { // se o alvo não estiver morto
				if(this.usedPowerTonight == false) { // se não usou o poder essa noite
					usedPowerTonight = true; //
					
					System.out.println("Você agarra " + alvo.nome + " pelo pescoço e o joga em uma piscina de ácido.");
					
					if(!(alvo.status == Status.Blessed)) { // se não estiver abençoado
						alvo.status = Status.Dying; // vai ficar morrendo
					
						if(alvo instanceof Leproso) { // e caso seja um leproso
							tonta = true; // a bruxa fica tonta
						}
					}
				} else {
					System.out.println("Você ja usou seu poder, querida");
				}
			} else {
				System.out.println("Esta pessoa ja morreu");
			}
		} else {
			System.out.println("Não permitimos suicídios aqui!");
		}
	}
	
	/**
	 * Verifica se realmente vai matar ou cancelar
	 * @param alvo: pessoa que vai se lascar
	 */
	public void menu(Pessoa alvo) {
		System.out.println("[1] - Matar\n[0] - Cancelar");
		int opc = 1;
		while(opc != 0) {
			opc = input.nextInt();
			switch(opc) {
				case 1:
					killSomeone(alvo);
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
	 * Da um resumo do cargo e especifica o que o jogador deve fazer
	 */
	@Override
	public String cargoResumo() {
		return "Você é um(a) Bruxo(a)\n"
			 + "Seu papel é matar a todos até que não reste mais\n"
			 + "participantes, toda a noite você poderá matar uma\n"
			 + "pessoa, mas cuidado com as consequências ao matar\n"
			 + "certas pessoas...\n"
			 + "Alguma(s) vez(es) sua vítima pode acabar ficando viva,\n"
			 + "talvez seja um milagre...";
	}
}
