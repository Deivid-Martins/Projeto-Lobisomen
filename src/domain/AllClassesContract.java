// interface sendo um contrato para todas as classes
// define os métodos que cada jogador precisa ter obrigatoriamente
package domain;

public interface AllClassesContract {
	String isDead(); // se o personagem está morto
	
	void defineDeathMessages(); // define as mensagens que aparecem na tela ao morrer
	
	String randomDeathMessage(); // randomiza as mensagens de morte antes de aparecerem na tela
	
	String cargoResumo(); // da um resumo do que aquele jogador pode fazer
	
	@Override
	String toString(); // imprime informações útreis

	teste
}
