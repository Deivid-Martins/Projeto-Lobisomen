package run;

import domain.*;

public class App {
	public static void main(String[] args) { // Tudo isso é apenas testes de metodos, pode apagar tudo se quiserem
		Bruxa b1 = new Bruxa();
		Detetive d1 = new Detetive();
		
		System.out.println(b1);
		System.out.println(d1);
		
		b1.killSomeone(d1);
		
		System.out.println(b1);
		System.out.println(d1);
	}
}
