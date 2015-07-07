import java.util.Random;


public class RandomPlayer extends Player{

	
	Random generator = new Random();
	private int xKoord;
	private int yKoord;
	char[][] test = new char[10][10];

	public RandomPlayer(String s, int max) {
		super(s, max);
		
	}

	public void shipplacement(){
		int anzahl = 0;
		while(anzahl < this.getMAX()){
			System.out.println(getWerbinich() + " Schiffe setzten");
			System.out.println("X-Koordinate:");
			xKoord = (generator.nextInt(10));
			System.out.println("Y-Koordinate:");
			yKoord = (generator.nextInt(10));
			test = getMap();
			test[xKoord][yKoord] = 'S';
			setMap(test);
			anzahl++;
			System.out.println("-\t-\t-");
		}
		returnMap();
	}
	
	public int xZug(){
		return generator.nextInt(10);
	}
	
	public int yZug(){
		return generator.nextInt(10);
	}
}
