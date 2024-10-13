package domain;

public class Aldeao extends Pessoa{
	protected String cargo;
	
	public Aldeao() {
		super();
		this.cargo = "Aldeão";
		this.deathMessages = new String[6];
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
	public String isDead() {
		if(changeStatusDead()) {
			return getMessageDead();
		}
		return null;
	}
	
	private String getMessageDead() {
		return "Que interessante, um cara qualquer morreu, que diferença isso faz?\n" + nome + " está morto, ele era um Aldeão";
	}
}
