package domain;

public abstract class Tool {
	/**
	 * Função que checa se um numero esta entre os limite 'a' e 'b', se não estiver, lança uma RuntimeException
	 * @param a: Limite baixo
	 * @param b: Limite alto
	 * @param num: Valor informado pelo cliente
	 * @return: se estiver entre 'a' e 'b', retorna o 'num', se não, lança IllegalArgumentException
	 */
	public static int checkIntLimitado(int a, int b, int num) {
		if(num >= a && num <= b) {
			return num;
		}
		throw new IllegalArgumentException("Digite apenas numeros entre " + a + " e " + b);
	}
	
	public static void printArrayPessoa (Pessoa[] pessoas) {
		for(int i = 0; i < pessoas.length; i ++) {
			System.out.println(pessoas[i]);
			if(i < pessoas.length - 1) {
				System.out.println("|=====-------------");
			}
		}
	}
	
	public static void menuPessoas(Pessoa[] pessoas) {
		if(pessoas != null) {
			for(int i = 0; i < pessoas.length; i++) 
			{
				if(i == 0) {
					System.out.println("---------------");
				}
				if(pessoas[i] != null && pessoas[i].status != Status.Dead) {
					System.out.printf("[%d] - %s\n", i+1, pessoas[i].getNome()); // Exibe uma opção do array
				}
			}
			System.out.println("---------------");
		}
	}
}
