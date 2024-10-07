package run;

import domain.*;
import java.util.Scanner;

public class App {
	public static void main(String[] args) { // Tudo isso é apenas testes de metodos, pode apagar tudo se quiserem
		Scanner input = new Scanner(System.in);
		Torturador t1 = new Torturador("Deivid", Status.Alive);
		Torturador t2 = new Torturador("Patricio", Status.Dead);
		Torturador t3 = new Torturador("Kayke", Status.Zombie);
		Torturador t4 = new Torturador("Kleber", Status.Alive);
		
		Torturador[] torturadores = {t1, t2, t3, t4};

		Tool.printArrayPessoa(torturadores);
		
		input.close();
	}
}
