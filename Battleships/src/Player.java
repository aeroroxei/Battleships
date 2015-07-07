import java.util.Scanner;


public class Player {
	
	private  Scanner scan = new Scanner(System.in);
	private  int xKoord;
	private  int yKoord;
	private  char[][] map = new char[10][10];
	private  char[][] enemyMap = new char[10][10];
	private String werbinich;
	private int MAX;
	
	public Player(String s, int max){
		this.werbinich = s;
		this.setMap(fillMap(this.getMap()));
		this.enemyMap = fillMap(this.enemyMap);
		this.MAX = max;
	}
	
	
	public void shipplacement(){
		int anzahl = 0;
		while (anzahl < getMAX()){
			System.out.println(getWerbinich() + " Schiffe setzten");
			System.out.println("X-Koordinate:");
			xKoord = (scan.nextInt());
			System.out.println("Y-Koordinate:");
			yKoord = (scan.nextInt());
			this.getMap()[xKoord][yKoord] = 'S';
			anzahl++;
			System.out.println("-\t-\t-");
		}
		returnMap();
	}
	
	public int xZug(){
		System.out.println("X-Koordinate eingeben: ");
		return scan.nextInt();
	}
	
	public int yZug(){
		System.out.println("Y-Koordinate eingeben: ");
		return scan.nextInt();
	}
	
	public int analyse (int x, int y){
		if(getMap()[x][y] == 'S'){
			System.out.println("Treffer");
			return 1;
		} else {
			System.out.println("Kein Treffer");
			return 0;
		}
		
	}
	
	public void enemyMapEntry(int treffer, int x, int y){
		if(treffer == 1){
			enemyMap[x][y] = 'X';
		} else {
			enemyMap[x][y] = '*';
		}
	}
	
	public void returnEnemyMap(){
		System.out.println("Trefferkarte von "+ getWerbinich());
		System.out.println(" 0 1 2 3 4 5 6 7 8 9");
		for (int j=0;j<=9;j=j+1){
		for (int i=0;i<=9;i=i+1){
		if (i==0) {System.out.print(j+" "+enemyMap[i][j]+" ");}
		else {System.out.print(enemyMap[i][j]+" ");}
		} 
		System.out.println();
		} 
	}
	
	public void returnMap(){
		System.out.println("Seekarte von "+ getWerbinich());
		System.out.println(" 0 1 2 3 4 5 6 7 8 9");
		for (int j=0;j<=9;j=j+1){
		for (int i=0;i<=9;i=i+1){
		if (i==0) {System.out.print(j+" "+map[i][j]+" ");}
		else {System.out.print(map[i][j]+" ");}
		} 
		System.out.println();
		} 
	}
	
	private char[][] fillMap(char[][] enemyMap2) {
		for(int i = 0; i<10; i++){
			for(int j = 0; j<10 ; j++){
				enemyMap2[i][j] = '-';
			}
		}
		return enemyMap2;
	}


	


	public char[][] getMap() {
		return map;
	}


	public void setMap(char[][] map) {
		this.map = map;
	}


	public String getWerbinich() {
		return werbinich;
	}


	public int getMAX() {
		return MAX;
	}


	


	
}
