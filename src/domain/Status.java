package domain;

public enum Status {
	// enum que define que estado um player em específico está
	Dead("Morto"),
	Dying("Morrendo"),
	Alive("Vivo"),
	Blessed("Abençoado");
	
	
	private String relatorio; // Valor que sairá em prints, para mudar para o português
	
	Status(String relatorio) {
		this.relatorio = relatorio;
	}
	
	public String getRelatorio() {
		return this.relatorio;
	}
}
