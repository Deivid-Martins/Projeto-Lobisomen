package domain;

import java.util.Scanner;

public abstract class Pessoa {
	public Scanner input = new Scanner(System.in);
	
	protected String nome;
	protected Status status; // Define se alguem ou está Vivo ou Morto, e tudo mais que for definido no enum Status
	protected int votos;
	
	public Pessoa() {
		this.status = Status.Alive;
		System.out.print("Defina o nome do jogador: ");
		this.nome = input.nextLine();
	}
	
	public abstract String isDead();

	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio();
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
	 * ATENÇÃO, esta função jamais deve ser utilizada para matar uma pessoa, ela é utilizada na função especifica da classe
	 */
	protected boolean changeStatusDead() {
		if(getStatus() != Status.Dead) {
			this.status = Status.Dead;
			return true;
		}
		System.out.println(nome + " ja está morto(a)...");
		return false;
	}
}
