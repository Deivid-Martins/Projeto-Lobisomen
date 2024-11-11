package domain;

public class Filha extends Pessoa {
	protected Detetive pai; // a filha tem um pai que é um detetive
	
	/**
	 * Construtor de filhas
	 */
	public Filha() {
		super(); // herda de pessoa
		this.cargo = "Filha do Detetive"; // define o cargo
		
		// define as mensagens de morte
		this.deathMessages = new String[8];
		if(this.pai != null) { // verifica se ela tem pai
			defineDeathMessages();
		}
	}
	
	/**
	 * Define as mensagens de morte
	 */
	@Override
	public void defineDeathMessages() {
		deathMessages[0] = "Detetive fala: Eles juraram...";
		deathMessages[1] = "Se eu estender minhas mãos, será que alcanço os céus, papai?";
		deathMessages[2] = "É lua cheia hoje...ela está tão bonita...\nquero assistir seu luar...só mais um pouco...";
		deathMessages[3] = "A lua está tão linda esta noite... só\nmais um instante sob seu brilho, por favor...";
		deathMessages[4] = "Papai, vou ver as estrelas primeiro... não tenha pressa ta bom?";
		deathMessages[5] = "A lua nos vigia... como se estivesse esperando que eu voltasse para ela. E agora...";
		deathMessages[6] = "Se eu fechar os olhos, será que volto para os seus braços?";
		deathMessages[7] = "Queria ter dito adeus, papai...";
	}
	
	/**
	 * Retorna nome, status, cargo e pai do jogador
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + this.cargo + "\nPai nome: " + pai.getNome();
	}
	
	/**
	 * Define quem o pai da filha
	 * @param pai: pai da filha
	 */
	protected void defineDad(Detetive pai) {
		this.pai = pai;
	}

	/**
	 * Da um resumo do que o jogador pode fazer
	 */
	@Override
	public String cargoResumo() {
		return "Você é a Filha do Detetive\n"
			 + "Não esquente a cabeça, você não faz nada especial\n"
			 + "você só existe para fazer sentido alguns acontecimentos\n"
			 + "com o Detetive, boa sorte.";
	}
}
