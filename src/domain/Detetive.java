package domain;

public class Detetive extends Pessoa{
	protected boolean usedPower = false;
	
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
	
	public boolean checkFilhaAlive(Filha filha) {
		if(filha.status == Status.Dead) {
			return false;
		}
		return true;
	}
	
	protected void defineDaughter (Filha filha) {
		this.filha = filha;
	}
	
	public void investigar(Pessoa alvo) {
		if(alvo.status != Status.Dead) {
			if(this.usedPower == false) {
				usedPower = true;
				System.out.println("Você procura evidências de " + alvo.nome + " e descobre que ele(a) é um(a) " + alvo.cargo + ".");
			} else {
				System.out.println("Você ja usou seu poder, bobalhão!");
			}
		} else {
			System.out.println("Seu alvo ja está morto");
		}
	}
	
	public void menu(Pessoa alvo) {
		System.out.println("[1] - Investigar\n[0] - Cancelar");
		int opc = 1;
		while(opc != 0) {
			opc = input.nextInt();
			switch(opc) {
				case 1:
					investigar(alvo);
					break;
				case 0:
					break;
				default:
					System.out.println("Opção inexistente");
			}
		}
	}
}
