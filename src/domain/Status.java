package domain;

public enum Status {
	Dead(0,"Morto"),
	Alive(1, "Vivo"),
	Zombie(2, "Zumbi");
	
	private String relatorio;
	private int valor;
	
	Status(int valor, String relatorio) {
		this.valor = valor;
		this.relatorio = relatorio;
	}
	
	public String getRelatorio() {
		return this.relatorio;
	}
	
	public int getValor() {
		return this.valor;
	}
}
