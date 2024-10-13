package domain;

public class Bruxa extends Pessoa{
	protected boolean usedPowerTonight;
	protected String cargo;
	
	public Bruxa() {
		super();
		this.usedPowerTonight = false;
		this.cargo = "Bruxa";
		this.deathMessages = new String[8];
	}

	@Override
	public void defineDeathMessages() {
		deathMessages[0] = "Pois a Noite é Escura e Cheia de Terrores.";
		deathMessages[1] = "Eu queimaria o mundo por ele...";
		deathMessages[2] = "Sinto muito pequeno...a mamãe não pode te seguir...";
		deathMessages[3] = "Desculpe, meu pequeno... mamãe não pode seguir você desta vez...";
		deathMessages[4] = "Deixe queimar...";
		deathMessages[5] = "Como fosforo em meio a queimada.";
		deathMessages[6] = "Vocês queimam as formigas, enquanto o formigueiro os devora";
		deathMessages[7] = "Queimar... não mudará nada... a noite continua escura...";
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
