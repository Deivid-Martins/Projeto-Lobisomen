// classe base de todas as pessoas do jogo
package domain;

import java.util.Random; // importante para aleatoriedade
import java.util.Scanner; // para entrada de dados

// todas as pessoas do jogo implementam os métodos que são definidos no contrato
public abstract class Pessoa implements AllClassesContract {
	protected Scanner input  = new Scanner(System.in); // para entrada de dados
	private Random random = new Random(); // para aleatoriedade
	
	protected String nome; // nome da pessoa
	protected Status status; // define se alguem ou está Vivo ou Morto, e tudo mais que for definido no enum Status
	protected int votos; // quantidade de votos recebidos para sair do jogo
	protected String[] deathMessages; // array contendo mensagens de morte
	protected String cargo; // nome do cargo da pessoa
	
	
	/**
	 * Construtor da classe Pessoa com nome como parâmetro
	 * @param nome: nome do jogador que será armazenado
	 */
	public Pessoa(String nome) {
		this.status = Status.Alive; // define que o jogador está vivo
		this.nome = nome; // armazena o nome da pessoa
	}
	
	/**
	 * Construtor implícito da classe Pessoa
	 */
	public Pessoa() {
		this.status = Status.Alive; // define que o jogador inicia vivo
		
		System.out.print("Defina o nome do jogador: "); // prompt
		this.nome = input.nextLine(); // define o nome do jogador
	}

	/**
	 * Retorna o nome e o status (vivo, morto, morrendo) do jogador
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + "\nStatus: " + status.getRelatorio();
	}

	/**
	 * Retorna o nome do jogador
	 * @return uma string com o nome da pessoa 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o status da pessoa (vivo, morto ou morrendo)
	 * @return um Status com o status do jogador
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * Randomiza a mensagem de morte que vai aparecer quando uma pessoa morrer
	 */
	public String randomDeathMessage() {  
		int index = random.nextInt(0, this.deathMessages.length); // define um index de 0 até o tanto de mensagens
		
		if(this.deathMessages[index] != null) // se a mensagem na posição randomizada não for nula
			return this.deathMessages[index]; // retorna a mensagem naquele index
		return null;
	}
	
	/**
	 * Executa uma captcha para o aldeão todas as noites
	 */
	public void menu() {
		int resposta = 0; // resposta do usuário 
		int num = random.nextInt(100, 900); // número do captcha
		
		System.out.println("CAPTCHA\nDigite " + num + " abaixo para verificar se você está vivo:"); // prompt
		
		while(resposta != num) { // enquanto a resposta não for o captcha 
			resposta = input.nextInt(); // armazena a resposta do usuário
			
			if(resposta != num) { // e se estiver errado
				System.out.println("Errado, digite " + num + " corretamente:"); // prompt
			}
		}
		System.out.println("CAPTCHA confirmado, volte para o seu lugar em silêncio.");
	}
	
	/** 
	 * Retorna uma mensagem de morte caso a pessoa realmente tenha morrido
	 */
	@Override
	public String isDead() {
		if (changeStatusDead()) // se foi possivel fazer esta pessoa morrer
			return randomDeathMessage(); // retorna a mensagem de morte
		return null;
	}
	
	
	/**
	 * Função que deixa alguem com Status == Status.Dead, apenas caso esteja viva
	 * Se a pessoa utilizada na função ja está morta, imprime um aviso e nada ocorre além disso
	 * return: retorna se foi executada com sucesso ou não
	 * ATENÇÃO, esta função jamais deve ser utilizada para matar uma pessoa, ela é utilizada na função especifica da classe
	 */
	protected boolean changeStatusDead() {
		if(getStatus() == Status.Dying) { // se ela estiver morrendo
			this.status = Status.Dead; // ela morre
			return true;
			
		} else if (getStatus() == Status.Dead) // se ela já está morta
			System.out.println(nome + " ja está morto(a)...");
		
		else if (getStatus() == Status.Alive) // se ela estiver viva
			System.out.println("Essa pessoa ainda não esta morrendo");
		
		else if (getStatus() == Status.Blessed) // se ela esvier abençoada
			System.out.println("Essa pessoa está abençoada nessa rodada");
		
		// caso não entre em nenhum if
		return false;
	}
}
