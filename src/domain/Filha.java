package domain;

public class Filha extends Pessoa {
	protected String cargo;
	
	public Filha() {
		super();
		this.cargo = "Filha do Detetive";
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + this.cargo;
	}

	@Override
	public String isDead() {
		if(changeStatusDead()) {
			return getMessageDead();
		}
		return null;
	}
	
	private String getMessageDead () {
		return "Você era muito fraco, e seu pai ainda mais, ele não cumpriu a promessa\nde se livrar desta criatura a tempo, " + nome + " junta-se aos mortos, ela era a Filha do Detetive";
	}
}
