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

	@Override
	public String cargoResumo() {
		return "Vocè é um aldeão\n"
			 + "Seu papel é ficar vivo e descobrir quem é o vilão da partida\n"
			 + "A noite você receberá uma taferinha boba, apenas para que não\n"
			 + "notem que você não está fazendo nada a noite, não conte isso a eles.";
	}
}
