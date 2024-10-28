package domain;

import java.util.Random;

public class Aldeao extends Pessoa{
	private Random random = new Random();
	
	public Aldeao() {
		super();
		this.cargo = "Aldeão";
		this.deathMessages = new String[6];
		defineDeathMessages();
	}

	@Override
	public void defineDeathMessages() {
		deathMessages[0] = "Mas...o padre disse que nenhum mal...";
		deathMessages[1] = "Eu esqueci de dizer... que amo a vovó... hoje...";
		deathMessages[2] = "Prometi que voltaria para casa cedo hoje...";
		deathMessages[3] = "Eles prometeram proteger a garotinha\ndele... mas ninguém pode salvar os jurados.";
		deathMessages[4] = "Apenas mais um dia... só mais um para dizer que os amo.";
		deathMessages[5] = "Pai, está frio aqui... você vai me buscar logo?";
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + cargo;
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
}
