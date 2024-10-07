package domain;

public enum Status {
	// enum que define que estado um player em específico está
	Dead(0,"Morto"),
	Alive(1, "Vivo"),
	Zombie(2, "Zumbi");
	
	
	private String relatorio; // Valor que sairá em prints, para mudar para o português
	private int valor; // Valor para alteração e verificação mais rapida de escrever sobre o Status de alguem
	
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
