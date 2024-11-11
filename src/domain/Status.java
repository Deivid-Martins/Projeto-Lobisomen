// enum que define que estado um player em específico está
package domain;

public enum Status {
	Dead("Morto"),
	Dying("Morrendo"),
	Alive("Vivo"),
	Blessed("Abençoado");
	
	private String relatorio; // valor que sairá em prints, para mudar para o português
	
	Status(String relatorio) {
		this.relatorio = relatorio;
	}
	
	public String getRelatorio() {
		return this.relatorio;
	}
}
