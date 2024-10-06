package App;

import domain.*;

public class App {
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("Deivid", Status.Alive);
		Pessoa p2 = new Pessoa("Erika", Status.Alive);
		Pessoa p3 = new Pessoa("Kayke", Status.Dead);
		Pessoa p4 = new Pessoa("Patricio", Status.Zombie);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(Pessoa.pessoaLength);
	}
}
