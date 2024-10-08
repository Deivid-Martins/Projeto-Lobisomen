package domain;

public class Detetive extends Pessoa{
	protected boolean usedPower = false;
	protected String cargo;
	
	public Detetive() {
		super();
		this.cargo = "Detetive";
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + this.cargo;
	}

	@Override
	public String isDead() {
		if(changeStatusDead())
			return getMessageDead();
		return null;
	}
	
	private String getMessageDead () {
		return "Após anos investigando, acabou falecendo sem ao menos descobrir quem está por trás de tudo\ndeixou sua filha para trás, isso se não tiver a esquecido de proteger, " + nome + " está morto! Ele era o Detetive";
	}
	
	public boolean checkFilhaAlive(Filha filha) {
		if(filha.status == Status.Dead) {
			return false;
		}
		return true;
	}
}
