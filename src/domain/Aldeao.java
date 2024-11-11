// classe que gerencia os aldeões do jogo
package domain;

public class Aldeao extends Pessoa {
	
	/**
	 * Construtor de aldeão
	 */
	public Aldeao() {
		super(); // herda de pessoa
		
		this.cargo = "Aldeão"; // define o cargo
		this.deathMessages = new String[6]; // define a quantidade de mensagens de morte
		defineDeathMessages(); // define as mensagens de morte em si
	}

	/**
	 * Define as mensagens de morte com base num array com várias strings 
	 */
	@Override
	public void defineDeathMessages() {
		deathMessages[0] = "Mas...o padre disse que nenhum mal...";
		deathMessages[1] = "Eu esqueci de dizer... que amo a vovó... hoje...";
		deathMessages[2] = "Prometi que voltaria para casa cedo hoje...";
		deathMessages[3] = "Eles prometeram proteger a garotinha\ndele... mas ninguém pode salvar os jurados.";
		deathMessages[4] = "Apenas mais um dia... só mais um para dizer que os amo.";
		deathMessages[5] = "Pai, está frio aqui... você vai me buscar logo?";
	}
	
	/**
	 * Imprime o nome, status e cargo do aldeão
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + cargo;
	}

	/**
	 * Mostra um resumo do que o aldeão pode fazer
	 */
	@Override
	public String cargoResumo() {
		return "Vocè é um aldeão\n"
			 + "Seu papel é ficar vivo e descobrir quem é o vilão da partida\n"
			 + "Ao cair da noite, jogador, você receberá uma missão, apenas para que não\n"
			 + "notem que você não está fazendo nada a noite, não conte isso a eles.";
	}
}
