package run;

import domain.*;

public class App {
	public static void main(String[] args) { // Tudo isso é apenas testes de metodos, pode apagar tudo se quiserem
		Config config = new Config();
		config.startGame();
		
		Tool.menuPessoas(config.getPessoas());
		Tool.printArrayPessoa(config.getPessoas());
	}
}
