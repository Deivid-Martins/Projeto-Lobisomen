package domain;

public class Bruxa extends Pessoa{
	protected boolean usedPowerTonight;
	protected String cargo;
	
	

	public Bruxa() {
		super();
		this.usedPowerTonight = false;
		this.cargo = "Bruxa";
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + cargo;
	}

	@Override
	public String isDead() {
		return "Que azar, alguém que deveria ser tão forte, mas que pelo sorteio, caiu com\n"
			+  "uma pessoa tao fraca, festejem, pois a Bruxa " + nome + " acaba de falecer!";
	}
	
	public void killSomeone(Pessoa alvo) {
		if(alvo.status != Status.Dead) {
			if(this.usedPowerTonight == false) {
				usedPowerTonight = true;
				System.out.println("Você agarra " + alvo.nome + " pelo pescoço e o joga em uma piscina de ácido.");
				alvo.changeStatusDead();
			} else {
				System.out.println("Você ja usou seu poder, querida");
			}
		} else {
			System.out.println("Esta pessoa ja morreu");
		}
	}
}
