package domain;

public class Detetive extends Pessoa{
	protected boolean usedPower = false;
	protected String cargo;
	
	public Detetive(String nome, Status status) {
		super(nome, status);
		this.cargo = "Detetive";
	}

	@Override
	public String isDead() {
		if(changeStatusDead())
			return "Após anos investigando, acabou falecendo sem ao menos descobrir quem está por trás de tudo\ndeixou sua filha para trás, isso se não tiver a esquecido de proteger, " + nome + " está morto!";
		return null;
	}

	
	
}
