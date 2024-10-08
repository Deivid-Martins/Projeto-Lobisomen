package domain;

public class Aldeao extends Pessoa{
	protected String cargo;
	
	public Aldeao() {
		super();
		this.cargo = "Aldeão";
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
