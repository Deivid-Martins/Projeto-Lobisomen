package domain;

public abstract class Tool {
	/**
	 * Função que checa se um numero esta entre os limite 'a' e 'b', se não estiver, lança uma RuntimeException
	 * @param a: Limite baixo
	 * @param b: Limite alto
	 * @param num: Valor informado pelo cliente
	 * @return: se estiver entre 'a' e 'b', retorna o 'num', se não, lança uma exeção
	 */
	public static int checkIntLimitado(int a, int b, int num) {
		if(num >= a && num <= b) {
			return num;
		}
		throw new IllegalArgumentException("Digite apenas numeros entre " + a + " e " + b);
	}
	
	public static void printArrayPessoa (Pessoa[] pessoas) {
		for(int i = 0; i < Pessoa.pessoaLength; i ++) {
			System.out.println(pessoas[i]);
			if(i < Pessoa.pessoaLength - 1) {
				System.out.println("|=====-------------");
			}
		}
	}
}
