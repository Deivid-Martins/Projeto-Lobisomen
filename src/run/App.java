package run;

import domain.*;
import java.util.Scanner;

public class App {
	public static void main(String[] args) { // Tudo isso é apenas testes de metodos, pode apagar tudo se quiserem
		Scanner input = new Scanner(System.in);
		Torturador t1 = new Torturador("Deivid", Status.Alive);
		Torturador t2 = new Torturador("Patricio", Status.Alive);
		System.out.println(t1);
		System.out.println(t2);
		t1.torturar(t2);
		System.out.println(t1);
		System.out.println(t2);
		
		Detetive d1 = new Detetive("Kayke",Status.Alive);
		System.out.println(d1.isDead());
		
		input.close();
	}
}
