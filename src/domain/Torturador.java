package domain;

public class Torturador extends Pessoa {
	public boolean usedPower = false;

	public Torturador(String nome, Status status) {
		super(nome, status);
	}

	@Override
	public String killPessoa() {
		if (changeStatusDead())
			return "De tanto torturar pessoas, o Karma bateu na sua porta <3\nO corpo de " + nome + " Foi encontrado decaptado...";
		return null;
	}
}
