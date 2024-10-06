package domain;

public class Pessoa {
	public static int length = 1;
	protected final int id;
	protected String nome;
	protected Status status;
	
	public Pessoa(String nome, Status status) {
		this.nome = nome;
		this.status = status;
		this.id = length;
		length++;
	}

	@Override
	public String toString() {
		return "Pessoa\nId: "+ id +"\nNome: " + nome + "\nStatus: " + status.getRelatorio();
	}

	public String getNome() {
		return nome;
	}

	public Status getStatus() {
		return status;
	}
	
	public void killPessoa() {
		if(getStatus() != Status.Dead)
			this.status = Status.Dead;
		else
			System.out.println(nome + " ja está morto(a)...");
	}
}
