// classe que gerencia o detetive do jogo
package domain;

public class Detetive extends Pessoa{
	protected boolean usedPower; // verifica se a pessoa já usou o poder essa noite
	
	protected Filha filha; // filha do detetive
	
	/**
	 * Construtor d detetive
	 */
	public Detetive() {
		super(); // herda de pessoa
		this.cargo = "Detetive"; // define o cargo
		this.usedPower = false; // ele ainda não usou seu poder
		
		// define as mensagens de morte
		this.deathMessages = new String[4];
		if(filha != null) { // verifica se ele realmente tem uma filha
			defineDeathMessages();
		}
	}
	
	/**
	 * Define as mensagens de morte com base em um array de strings
	 */
	@Override
	public void defineDeathMessages() {
		deathMessages[0] = "Seja forte minha querida filha, por mim... por nós";
		deathMessages[1] = "Seja uma boa garota, como sempre, ok?";
		deathMessages[2] = "Eu prometo, filha... ainda te verei crescer, só um pouco mais de longe.";
		deathMessages[3] = "Minha garotinha...não se preocupe...quando sentires só, olhe\npara as estrelas, e eu a olharei de volta...eu juro.";
	}
	
	/**
	 * Retorna nome, status, cargo e filha do jogador
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + this.cargo + "\nFilha nome: " + filha.getNome();
	}
	
	/**
	 * Verifica se a filha do detetive está viva
	 * @param filha: quem é a filha do detetive
	 * @return verdadeiro ou falso dependendo se a filha está viva ou morta
	 */
	public boolean checkFilhaAlive(Filha filha) {
		if(filha.status == Status.Dead) { // caso ela esteja morta
			return false;
		}
		return true;
	}
	
	/**
	 * Define quem é a filha do detetive
	 * @param filha: objeto para que seja definida a filha do detetive
	 */
	protected void defineDaughter (Filha filha) {
		this.filha = filha;
	}
	
	/**
	 * Inbestiga um jogador para saber qual é o seu cargo
	 * @param alvo: quem o jogador pretende investigar
	 */
	public void investigar(Pessoa alvo) {
		if(alvo.status != Status.Dead) { // se o alvo não estiver morto
			if(this.usedPower == false) { // se ele não usou o poder ainda
				usedPower = true; // ele usa o poder
				System.out.println("Você procura evidências de " + alvo.nome + " e descobre que ele(a) é um(a) " + alvo.cargo + ".");
			} else {
				System.out.println("Você ja usou seu poder, bobalhão!");
			}
		} else {
			System.out.println("Seu alvo ja está morto");
		}
	}
	
	/**
	 * Executa o menu para saber qual é o alvo do detetive
	 * @param alvo: pessoa escolhida
	 */
	public void menu(Pessoa alvo) {
		System.out.println("[1] - Investigar\n[0] - Cancelar");
		int opc = 1;
		while(opc != 0) {
			opc = input.nextInt();
			switch(opc) {
				case 1:
					investigar(alvo);
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
	 * Retorna a filha do detetive
	 * @return a filha do detetive
	 */
	public Filha getFilha() {
		return this.filha;
	}

	/**
	 * Da um resumo do cargo e comenta sobre o que o jogador pode fazer
	 */
	@Override
	public String cargoResumo() {
		return "Você é um detetive\n"
			 + "Seu papel é investigar e descobrir quem é o vilão\n"
			 + "Você também tem o poder que revela o cargo de alguém\n"
			 + "mas isso só pode ser usado uma única vez, e você também\n"
			 + "tem uma filha cujo se importa muito, cuida bem dela.";
	}
}
