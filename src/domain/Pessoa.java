package domain;

public class Pessoa {
	public static int pessoaLength = 1; // Variavel que pode ser a length, mas é usada para definir this.Id em cada usuário
	protected final int id; // Ajuda em momentos de escolha, como na votação
	protected String nome;
	protected Status status; // Define se alguem ou está Vivo ou Morto, e tudo mais que for definido no enum Status
	
	public Pessoa(String nome, Status status) {
		this.nome = nome;
		this.status = status;
		this.id = pessoaLength;
		pessoaLength++;
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
	
	/**
	 * Função que deixa alguem com Status == Status.Dead, apenas caso esteja viva
	 * Se a pessoa utilizada na função ja está morta, imprime um aviso e nada ocorre além disso
	 */
	public void killPessoa() {
		if(getStatus() != Status.Dead)
			this.status = Status.Dead;
		else
			System.out.println(nome + " ja está morto(a)...");
	}
}
