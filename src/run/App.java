package run;

import domain.*;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Torturador p1 = new Torturador("Deivid", Status.Alive);
		System.out.println(p1);
		System.out.println(p1.killPessoa());
		System.out.println(p1);
		
		input.close();
	}
}
