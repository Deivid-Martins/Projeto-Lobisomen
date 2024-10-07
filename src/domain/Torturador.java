package domain;

public class Torturador extends Pessoa {
	protected boolean usedPower = false;
	protected String cargo;

	public Torturador(String nome, Status status) {
		super(nome, status);
		this.cargo = "Torturador";
	}

	@Override
	public String isDead() {
		if (changeStatusDead())
			return "De tanto torturar pessoas, o Karma bateu na sua porta <3\nO corpo de " + nome + " Foi encontrado decaptado...";
		return null;
	}
	
	public void usePower(Pessoa alvo) {
		if(alvo.status != Status.Dead) {
			if(this.usedPower == false) {
				usedPower = true;
				if (alvo instanceof Torturador) {
					Torturador target = (Torturador) alvo;
					System.out.println("Você arranca a pele de " + alvo.nome + " com uma faca e ele confessa que ele(a) é um(a) " + target.cargo);
				}
			} else {
				System.out.println("Você ja usou seu poder, bobalhão!");
			}
		} else {
			System.out.println("Seu alvo ja está morto");
		}
	}
	
	@Override
	public String toString() {
		return "Pessoa\nId: "+ id +"\nNome: " + nome + "\nStatus: " + status.getRelatorio() + "\nCargo: " + cargo;
	}
}
