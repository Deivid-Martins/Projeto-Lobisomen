package domain;

public abstract class Pessoa {
	public static int pessoaLength; // Variavel que pode ser a length, mas é usada para definir this.Id em cada usuário
	protected final int id; // Ajuda em momentos de escolha, como na votação
	protected String nome;
	protected Status status; // Define se alguem ou está Vivo ou Morto, e tudo mais que for definido no enum Status
	
	public Pessoa(String nome, Status status) {
		this.nome = nome;
		this.status = status;
		pessoaLength++;
		this.id = pessoaLength;
	}
	
	public abstract String isDead();

	@Override
	public String toString() {
		return "Id: "+ id +"\nNome: " + nome + "\nStatus: " + status.getRelatorio();
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
	 * return: retorna se foi executada com sucesso ou não
	 */
	public boolean changeStatusDead() {
		if(getStatus() != Status.Dead) {
			this.status = Status.Dead;
			return true;
		}
		System.out.println(nome + " ja está morto(a)...");
		return false;
	}
}
