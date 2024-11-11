// classe que gerencia o jogo como um todo
package domain;

import java.util.Scanner;
import java.util.Random;

public class Config {
	private Scanner input; // scanner
	private Random random; // randomizer
	private DayOrNight dayOrNight; // verificador de dia e noite
	
	private Pessoa[] pessoas; // pessoas que estão jogando
	
	/**
	 * Construtor de Config
	 */
	public Config() {
		input = new Scanner(System.in);
		random  = new Random();
		dayOrNight  = new DayOrNight();
	}
	
	/**
	 * Da a introdução do jogo em formato de string
	 * @return string com a introdução do jogo
	 */
	private String getIntroducao() {
		return "Neste jogo o vilão é a bruxa, até o momento, não contaremos nada sobre oque cada classe faz,\n"
			 + "porém, cada pessoa receberá um resumo sobre como sua classe funcionará, peço que falem apenas\n"
			 + "no turno da noite, e outro aviso, os Aldeões, que são os \"Inocentes\" também receberão tarefas\n"
			 + "a noite, mas peço para que nenhum conte oque é, na segunda rodadas explicaremos como todas as\n"
			 + "categorias funcionam, então é isso, boa sorte a todos.";
	}
	
	/**
	 * Verifica se existe uma posição nula no array de jogadores
	 * @return boolean. sim caso nulo
	 */
	private boolean pessoasStillNull() {
		for(int i = 0; i < this.pessoas.length; i ++) {
			if(pessoas[i] == null)
				return true;
		}
		return false;
	}
	
	/**
	 * Verifica se os jogadores já tem o detetive
	 * @return boolean. sim caso tenha um detetive
	 */
	private boolean pessoasHaveDetetive() {
		for(int i = 0; i < this.pessoas.length; i ++) {
			if(pessoas[i] instanceof Detetive)
				return true;
		}
		return false;
	}
	
	/**
	 * Verifica se já tem bruxa no jogo
	 * @return boolean. sim caso haja bruxa
	 */
	private int pessoasHaveAllBruxa() {
		int quant = 0;
		for(int i = 0; i < this.pessoas.length; i ++) {
			if(pessoas[i] instanceof Bruxa)
				quant++;
		}
		return quant;
	}
	
	/**
	 * Verifica se há padres no jogo
	 * @return boolean. sim caso haja
	 */
	private int pessoasHaveAllPadre() {
		int quant = 0;
		for(int i = 0; i < this.pessoas.length; i ++) {
			if(pessoas[i] instanceof Padre)
				quant++;
		}
		return quant;
	}
	
	/**
	 * Verifica se há leprosos no jogo
	 * @return boolean. sim caso hajam
	 */
	private int pessoasHaveAllLeproso() {
		int quant = 0;
		for(int i = 0; i < this.pessoas.length; i ++) {
			if(pessoas[i] instanceof Leproso)
				quant++;
		}
		return quant;
	}
	
	/**
	 * Define os cargos que cada jogador vai ter
	 * @param pessoaLength: quantidade de pessoas jogando
	 * @param bruxa: número de bruxas do jogo
	 * @param detetive: de detetives
	 * @param padre: de padres
	 * @param leproso: e leprosos
	 */
	private void defCargos(int pessoaLength, int bruxa, int detetive, int padre, int leproso) {
		int filha = detetive; // detetive e filha tem o mesmo número
		int index; // index necessário
		int classe = 0; // número da classe que será adicionada
		
		// enquanto faltar algum cargo no jogo
		while((!pessoasHaveDetetive()) || pessoasHaveAllBruxa() != bruxa || pessoasHaveAllPadre() != padre || pessoasHaveAllLeproso() != leproso) {
			// prioridade do detetive
			// define o número da classe faltante
			if(!pessoasHaveDetetive())
				classe = 0;
			else if(pessoasHaveAllBruxa() != bruxa)
				classe = 1;
			else if(pessoasHaveAllPadre() != padre)
				classe = 2;
			else if(pessoasHaveAllLeproso() != leproso)
				classe = 3;
			
			index = random.nextInt(0, pessoaLength); // escolhe uma pessoa aleatória
			if(this.pessoas[index] == null) { // se for uma posição nula
				switch(classe) { // adiciona o cargo ao jogador
					case 0: // detetive
						if(detetive > 0) { // se ainda faltam detetives para adicionar
							this.pessoas[index] = new Detetive(); // adiciona o detetive
							detetive--; // faltam menos 1
							
							int saveDadIndex = index; // index do pai salvo
							for(int i = 0; i < this.pessoas.length; i ++) { // percorre o array de jogadores
								if(pessoas[i] == null && filha > 0) { // e caso encontre uma posição nula e ainda tenha filha para add
									this.pessoas[i] = new Filha(); // add filha
									
									// se se instanciou corretamente detetive e filha
									if (this.pessoas[i] instanceof Filha && this.pessoas[saveDadIndex] instanceof Detetive) {
										Filha f = (Filha) this.pessoas[i]; // cria um apontador para acessar os métodos da filha
										Detetive p = (Detetive) this.pessoas[saveDadIndex]; // mesma coisa no detetive
										f.defineDad(p); // define o pai da filha
										p.defineDaughter(f); // define a filha do pai
										f.defineDeathMessages(); // define as mensagens de morte da filha
										p.defineDeathMessages(); // define as mensagens de morte do detetive
									}
									filha --; // menos uma filha para se adicionar
								}
							}
						}
						break;
					
					// casos normais de adição de papéis:
					case 1:
						this.pessoas[index] = new Bruxa();
						break;
					case 2:
						this.pessoas[index] = new Padre();
						break;
					case 3:
						this.pessoas[index] = new Leproso();
						break;
					default:
						System.out.println("|| ERRO INESPERADO ||");
				}
			}
		}
		// se ainda tem posições que precisam ser preenchidas
		// todas elas viram aldeões
		if(pessoasStillNull()) {
			for(int i = 0; i < pessoas.length; i ++) {
				if(this.pessoas[i] == null) {
					this.pessoas[i] = new Aldeao();
				}
			}
		}
	}
	
	/**
	 * Retorna a quantidade de jogadores
	 * @return inteiro com quantas pessoas estão em jogo
	 */
	public Pessoa[] getPessoas () {
		return this.pessoas;
	}
	
	/**
	 * O famoso input limitado
	 * @param limiteBaixo: o valor mais baixo possível
	 * @param limiteAlto: valor mais alto possível
	 * @return inteiro válido dentro dos limites
	 */
	public int intInputLimitado(int limiteBaixo, int limiteAlto){
		int opc; // Opção escolhida pelo usuário
		do {
			System.out.print("Informe um número: "); // Prompt
			opc = input.nextInt(); // Guarda a categoria
			
			// Caso seja um número inválido
			if(opc < limiteBaixo || opc > limiteAlto) 
			{ 
				System.out.printf("Digite um número válido! Só pode entre %d e %d!\n", limiteBaixo, limiteAlto);
			}
		} while(opc < limiteBaixo || opc > limiteAlto);
		return opc;
	}
	
	/**
	 * Verifica se ainda tem uma bruxa viva no jogo
	 * @return sim caso haja uma bruxa viva
	 */
	private boolean haveBruxaAlive() {
		for(int i = 0; i < this.pessoas.length; i ++)
			if(this.pessoas[i] instanceof Bruxa && !(this.pessoas[i].status == Status.Dead))
				return true;
		return false;
	}
	
	/**
	 * Verifica se ainda existem pelo menos 2 pessoas vivas que não são bruxas
	 * @return sim caso haja
	 */
	private boolean haveGoodPessoasAlive() {
		int count = 0;
		for(int i = 0; i < this.pessoas.length; i ++)
			if(!(this.pessoas[i] instanceof Bruxa) && pessoas[i].status != Status.Dead)
				count++;
		if(count >= 2)
			return true;
		return false;
	}
	
	/**
	 * Verifica se o jogo já tem que acabar ou não
	 * @return sim caso não haja mais bruxas ou quaisquer cargos
	 */
	private boolean endGame() {
		if(haveBruxaAlive() && haveGoodPessoasAlive())
			return true;
		return false;
	}
	
	/**
	 * Função onde inicia absolutamente tudo na main, nada além disso deve ser executado na main, aqui deve
	 * conter todas as regras para o funcionamento planejado
	 */
	public void startGame() {
		// introdução e inicio do jogo
		System.out.println("Bem Vindo a Aldeia");
		System.out.println(getIntroducao());
		System.out.print("Defina a quantia de jogadores: ");
		int pessoasLength = input.nextInt();
		
		if(pessoasLength <= 4) { // não da jogo (pouca gente)
			System.out.println("Vai ter nem graça com esse tanto de gente\nvá pra casa vá.");
		} 
		else if (pessoasLength <= 8) { // agora da jogo
			this.pessoas = new Pessoa[pessoasLength];
			int bruxa = 1;
			int detetive = 1; // Filha de brinde a cada Detetive
			int padre = 1;
			int leproso = 1;
			defCargos(pessoasLength, bruxa, detetive, padre, leproso); // define os cargos
		}
		else if (pessoasLength <= 15) {
			this.pessoas = new Pessoa[pessoasLength];
			int bruxa = 2;
			int detetive = 1;
			int padre = 2;
			int leproso = 2;
			defCargos(pessoasLength, bruxa, detetive, padre, leproso);
		} 
		else {
			this.pessoas = new Pessoa[pessoasLength];
			int bruxa = 3;
			int detetive = 1;
			int padre = 3;
			int leproso = 4;
			defCargos(pessoasLength, bruxa, detetive, padre, leproso);
		}
		
		System.out.println("\nDigite qualquer coisa para iniciar...");
		input.next();
		Tool.clearTerminal();
		
		while(endGame()) // enquanto ainda der jogo
			dayOrNight.loop(pessoas); // troca o dia pela noite e executa o que for necessário
		
		if(!haveBruxaAlive()) { // caso matarem a bruxa
			System.out.println("------------------ Bad Ending ------------------\n"
						   + "\"Uma Justa Injustiça\""
						   + "\n"
						   + "\n"
						     + "VOCÊS QUEIMARAM A BRUXA. CONSEQUISTES AGRADAR AO VOSSO DEUS?\n"
						     + "Filha: Jamais voltara os vossos olhos aos céus novamente.\n"
						     + "Detetive ou Torturador: Não mais houvera bons-dias, não mais houvera risos,não mais houvera\n"
						     + "piadas bobas. Aquilo que mais amará, agora é apenas uma lembrança desbotada. Vossa morada\n"
						     + "não mais jaz aquecida.\n"
						     + "Leproso: Sem as medicações do botânico, sucumbirá antes do alvorecer da primareva.\n"
						     + "Padre: Certamente ALGUM Deus está convosco.\n"
						     + "Aldeões: Graças a Deus, de volta ao inferno. Marcadod por pecados, jamais inteiros. Em\n"
						     + "dívida com os que ja foram, cobrai aqueles que dormem.");
			
		} else // caso morrerem
			System.out.println("------------------ Bad Ending ------------------\n"
					   + "\"Uma Justa Injustiça\""
					   + "\n"
					   + "\n"
					     + "VOCÊS SUCUMBIRAM PARA A BRUXA.");
	}
}
