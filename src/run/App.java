package run;

import domain.*;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Torturador p1 = new Torturador("Deivid", Status.Alive);
		Torturador p2 = new Torturador("Patricio", Status.Zombie);
		System.out.println(p1);
		System.out.println(p2);
		p1.usePower(p2);
		
		input.close();
	}
}
