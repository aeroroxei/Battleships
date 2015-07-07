import java.awt.Color;
import java.util.Scanner;

import ch.aplu.jgamegrid.GGMouse;
import ch.aplu.jgamegrid.GGMouseListener;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.tcp.TcpNodeListener;
import ch.aplu.tcp.TcpNodeState;



public class Battleships extends GameGrid {

	//private static char[][] map = new char[10][10];
	//private static char[][] enemyMap = new char[10][10];
	private static int hitsPlayer1 = 0;
	private static int hitsPlayer2 = 0;
	private final static int MAX_HIT = 1;
	private final static int MAX_KOORD = 9;
	private static int xKoord;
	private static int yKoord;
	private static Scanner scan = new Scanner(System.in); 
	

	
	public static void main(String args[]){
		System.out.println("Das Speil beginnt\n");
		
		Player spielerA = new Player("SpielerA",MAX_HIT);
		RandomPlayer spielerB = new RandomPlayer("SpielerB",MAX_HIT);
		int trefferjn;
		
		spielerA.shipplacement();
		spielerB.shipplacement();
		
		while (hitsPlayer1 != MAX_HIT && hitsPlayer2 != MAX_HIT){
			System.out.println("SpielerA schieﬂt:\n");
			xKoord = spielerA.xZug();
			yKoord = spielerA.yZug();
			trefferjn = spielerB.analyse(xKoord, yKoord);
			spielerA.enemyMapEntry(trefferjn, xKoord, yKoord);
			hitsPlayer1 += trefferjn;
			spielerA.returnMap();
			spielerA.returnEnemyMap();
			
			System.out.println("SpielerB schieﬂt:\n");
			xKoord = spielerB.xZug();
			yKoord = spielerB.yZug();
			trefferjn = spielerA.analyse(xKoord, yKoord);
			spielerB.enemyMapEntry(trefferjn, xKoord, yKoord);
			hitsPlayer2 += trefferjn;
			spielerB.returnMap();
			spielerB.returnEnemyMap();
		} // Ende while
		sieger();
		
	}
	
	private static void spiel(){
		 
	}
	
	private static void sieger(){
		if(hitsPlayer1 == MAX_HIT){
			System.out.println("SpielerA hat gewonnen");
		} else {
			System.out.println("SpielerB hat gewonnen");
		}
	}
	public Battleships(){

	}
	

	
	
	
}
