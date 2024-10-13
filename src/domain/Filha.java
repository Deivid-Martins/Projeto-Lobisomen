package domain;

public class Filha extends Pessoa {
	protected String cargo;
	public Detetive pai;
	
	public Filha() {
		super();
		this.cargo = "Filha do Detetive";
		this.deathMessages = new String[8];
		if(this.pai != null) {
			defineDeathMessages();
		}
	}
	
	@Override
	public void defineDeathMessages() {
		deathMessages[0] = pai.getNome() + " fala: Eles juraram...";
		deathMessages[1] = "Se eu estender minhas mãos, será que alcanço os céus, papai?";
		deathMessages[2] = "É lua cheia hoje...ela está tão bonita...\nquero assistir seu luar...só mais um pouco...";
		deathMessages[3] = "A lua está tão linda esta noite... só\nmais um instante sob seu brilho, por favor...";
		deathMessages[4] = "Papai, vou ver as estrelas primeiro... não tenha pressa ta bom?";
		deathMessages[5] = "A lua nos vigia... como se estivesse esperando que eu voltasse para ela. E agora...";
		deathMessages[6] = "Se eu fechar os olhos, será que volto para os seus braços?";
		deathMessages[7] = "Queria ter dito adeus, papai...";
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
