package domain;

public class Detetive extends Pessoa{
	protected boolean usedPower = false;
	protected String cargo;
	protected Filha filha;
	
	public Detetive() {
		super();
		this.cargo = "Detetive";
		this.deathMessages = new String[4];
		if(filha != null) {
			defineDeathMessages();
		}
	}
	
	@Override
	public void defineDeathMessages() {
		deathMessages[0] = "Seja forte minha querida " + filha.getNome() + ", por mim... por nós";
		deathMessages[1] = "Seja uma boa garota, como sempre, ok?";
		deathMessages[2] = "Eu prometo, filha... ainda te verei crescer, só um pouco mais de longe.";
		deathMessages[3] = "Minha garotinha...não se preocupe...quando sentires só, olhe\npara as estrelas, e eu a olharei de volta...eu juro.";
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + this.cargo + "\nFilha nome: " + filha.getNome();
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
	
	protected void defineDaughter (Filha filha) {
		this.filha = filha;
	}
}
