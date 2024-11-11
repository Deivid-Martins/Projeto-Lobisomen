// classe para gerenciar o leproso
package domain;

import java.util.Random; // para aleatoriedade

public class Leproso extends Pessoa{
	private Random random; // para aleatoriedade
	
	/**
	 * Construtor de leproso
	 */
	public Leproso() {
		super(); // herda de pessoa
		this.random = new Random(); // inicia o randomizador
		
		this.cargo = "Leproso"; // define o cargo
		
		// define as mensagens de morte
		this.deathMessages = new String[5];
		defineDeathMessages();
	}

	/**
	 * Define as mensagens de morte com base num array de strings 
	 */
	@Override
	public void defineDeathMessages() {
		this.deathMessages[0] = "Está tudo bem, já não sinto mais dor...";
		this.deathMessages[1] = "Mãe, Pai, não precisam mais chorar, já não dói mais...";
		this.deathMessages[2] = "Eu lamento... Eu prometi uma dança à Filha do detetive\nquando eu estivesse bom...";
		this.deathMessages[3] = "Acho que ja posso descansar...";
		this.deathMessages[4] = "Eu sabia... Sempre fui uma chama fraca...\nMas que queimou até o fim...";
	}
	
	/**
	 * Executa o captcha, assim como o aldeão
	 */
	public void menu() {
		int resposta = 0;
		int num = random.nextInt(100, 900);
		
		System.out.println("CAPTCHA\nDigite " + num + " abaixo para verificar se você está vivo:");
		
		while(resposta != num) {
			resposta = input.nextInt();
		
			if(resposta != num) {
				System.out.println("Errado, digite " + num + " corretamente:");
			}
		}
		System.out.println("CAPTCHA confirmado, volte para o seu lugar em silêncio.");
	}
	
	/**
	 * Imprime o nome, status e cargo do jogador
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + cargo;
	}

	/**
	 * Da um resumo do cargo do jogador
	 */
	@Override
	public String cargoResumo() {
		return "você é um Leproso\n"
			 + "Você não faz nada em especial enquanto vivo, mas quando\n"
			 + "o Vilão matar alguém desse tipo, ficará \"Tonto\" e caso\n"
			 + "ele tente matar alguém, acabará matando alguém aleatório.";
	}
}
