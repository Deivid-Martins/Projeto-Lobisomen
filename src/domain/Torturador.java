package domain;

public class Torturador extends Pessoa {
	protected boolean usedPower = false;
	protected String cargo;

	public Torturador(String nome, Status status) {
		super(nome, status);
		this.cargo = "Torturador";
	}
	
	/**
	 * changeStatusDead: troca o Status para Dead
	 * return: Mensagem de imersão, onde todas as classes devem ter a sua em específico, 
	 * 		   ou null caso não consigamos matar você hoje.
	 */
	@Override
	public String isDead() {
		if (changeStatusDead()) // Se foi possivel fazer esta pessoa morrer, executa o bloco de comandos abaixo
			return "De tanto torturar pessoas, o Karma bateu na sua porta <3\nO corpo de " + nome + " Foi encontrado decaptado...";
		return null;
	}
	
	/**
	 * Função que realiza o uso do poder do torturador e revela o cargo de alguem escolhido por ele, apenas uma vez
	 * @param alvo: Pessoa que sofrerá as consequências do Torturador
	 */
	public void torturar(Pessoa alvo) {
		if(alvo.status != Status.Dead) {
			if(this.usedPower == false) {
				usedPower = true;
				if (alvo instanceof Torturador) {
					Torturador target = (Torturador) alvo;
					System.out.println("Você arranca a pele de " + alvo.nome + " com uma faca e ele confessa que ele(a) é um(a) " + target.cargo + "\nApós angustiar mais um pouco, " + alvo.nome + " vem a óbito...");
					alvo.changeStatusDead();
				}
			} else {
				System.out.println("Você ja usou seu poder, bobalhão!");
			}
		} else {
			System.out.println("Seu alvo ja está morto");
		}
	}
}
