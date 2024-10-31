package domain;

public class DayOrNight {
	private int countDay;
	private int countNight;
	private boolean day;
	
	public DayOrNight() {
		this.countDay = 0;
		this.countNight = 0;
		this.day = false;
	}
	
	public void isNight(Pessoa[] pessoas) {
		
	}
	
	public void isDay(Pessoa[] pessoas) {
		getRelatorio(pessoas);
		this.countDay++;
		this.day == true;
	}
	
	private void getRelatorio(Pessoa[] pessoas) {
		int pessoasVivas = 0;
		for(int i = 0; i < pessoas.length; i ++) {
			if(pessoas[i].status == Status.Blessed)
				pessoas[i].status = Status.Alive;
			else if(pessoas[i].status == Status.Dying) {
				System.out.println("--------------");
				System.out.println(pessoas[i].getNome());
				System.out.println(pessoas[i].isDead());
				System.out.println("--------------");
			} else if(pessoas[i].status == Status.Alive || pessoas[i].status == Status.Blessed) {
				pessoasVivas++;
			}
		}
		System.out.println("Pessoas vivas restantes: " + pessoasVivas);
	}
}
