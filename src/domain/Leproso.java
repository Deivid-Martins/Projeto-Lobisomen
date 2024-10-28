package domain;

import java.util.Random;

public class Leproso extends Pessoa{
	private Random random = new Random();
	
	public Leproso() {
		super();
		this.cargo = "Leproso";
		this.deathMessages = new String[5];
		defineDeathMessages();
	}

	@Override
	public void defineDeathMessages() {
		this.deathMessages[0] = "Está tudo bem, já não sinto mais dor...";
		this.deathMessages[1] = "Mãe, Pai, não precisam mais chorar, já não dói mais...";
		this.deathMessages[2] = "Eu lamento... Eu prometi uma dança à Filha do detetive\nquando eu estivesse bom...";
		this.deathMessages[3] = "Acho que ja posso descansar...";
		this.deathMessages[4] = "Eu sabia... Sempre fui uma chama fraca...\nMas que queimou até o fim...";
	}
	
	public void menu() {
		int res = 0;
		int num = random.nextInt(100, 900);
		System.out.println("CAPTCHA\nDigite " + num + " abaixo para verificar se você está vivo:");
		while(res != num) {
			res = input.nextInt();
			if(res != num) {
				System.out.println("Errado, digite " + num + " corretamente:");
			}
		}
		System.out.println("CAPTCHA confirmado, volte para o seu lugar em silêncio.");
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + cargo;
	}
}
