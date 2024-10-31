package domain;

import java.util.Random;

public class Filha extends Pessoa {
	private Random random = new Random();
	
	protected Detetive pai;
	
	public Filha() {
		super();
		this.cargo = "Filha do Detetive";
		this.deathMessages = new String[8];
		if(this.pai != null) {
			defineDeathMessages();
		}
	}
	
	@Override
	public void defineDeathMessages() {
		deathMessages[0] = pai.getNome() + " fala: Eles juraram...";
		deathMessages[1] = "Se eu estender minhas mãos, será que alcanço os céus, papai?";
		deathMessages[2] = "É lua cheia hoje...ela está tão bonita...\nquero assistir seu luar...só mais um pouco...";
		deathMessages[3] = "A lua está tão linda esta noite... só\nmais um instante sob seu brilho, por favor...";
		deathMessages[4] = "Papai, vou ver as estrelas primeiro... não tenha pressa ta bom?";
		deathMessages[5] = "A lua nos vigia... como se estivesse esperando que eu voltasse para ela. E agora...";
		deathMessages[6] = "Se eu fechar os olhos, será que volto para os seus braços?";
		deathMessages[7] = "Queria ter dito adeus, papai...";
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + this.cargo + "\nPai nome: " + pai.getNome();
	}
	
	protected void defineDad(Detetive pai) {
		this.pai = pai;
	}

	@Override
	public String cargoResumo() {
		return "Você é a Filha do Detetive\n"
			 + "Não esquente a cabeça, você não faz nada especial\n"
			 + "você só existe para fazer sentido alguns acontecimentos\n"
			 + "com o Detetive, boa sorte.";
	}
}
