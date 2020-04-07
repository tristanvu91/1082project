import java.util.Scanner;

public class Game{	
	private static int rounds;
	public Human player1;
	public Computer comp;

	//constructor
	public Game() {
		this.player1 = new Human();
		this.comp = new Computer();
		rounds++;		
	}

	// this methods start the game
	public void startMatch() {
		Scanner playerChoice = new Scanner(System.in);
		do {
			comp.computerChoice();
			System.out.println("shoot[1], guard[2],reload[3]: ");  //TODO scanner input for integer
			player1.playerChoice();
			computeFight();


			System.out.println("computer life: " + comp.getLife());
			System.out.println("player life: " + player1.getLife());
			System.out.println("--------------");	
			System.out.println("computer Choice: " + comp.getChoice());
			System.out.println("player Choice: " + player1.getChoice());
			System.out.println("--------------");	
			System.out.println("computer ammo: " + comp.ammo);
			System.out.println("player ammo: " + player1.ammo);
			System.out.println("--------------");
			System.out.println("computer shield: " + comp.shield);
			System.out.println("player shield: " + player1.shield);
			System.out.println("--------------");
			System.out.println("case number" + FightCase());


		} while (hasWinner() != true);
		playerChoice.close();
	}
	
	//this methods return an integer(1-9) for all possible fight scenario
	public int FightCase() {
		if (player1.choice == 1) {
			if (comp.choice == 1)				//Shoot VS Shoot
				return 1;
			else if (comp.choice == 2) {		//Shoot VS Shield
				return 2;}
			else if (comp.choice == 3) {		//Shoot VS Reload
				return 3;}
		}
		else if (player1.choice == 2)
			if (comp.choice ==1)				//Shield VS Shoot
				return 4;
			else if (comp.choice == 2) {		//Shield VS Shield
				return 5;}
			else if (comp.choice == 3) {		//Shield VS Reload
				return 6;}
			else if (player1.choice == 3)		//Reload VS Shoot
				if (comp.choice ==1)
					return 7;
				else if (comp.choice ==2) {		//Reload VS Shield
					return 8;}
				else if (comp.choice ==3) {		//Reload VS Reload
					return 9;
				}
		return 0;
	}
	
	//this methods compute data for all possible fight scenario
	public void computeFight() {
		int result = FightCase();
		switch(result) {
		case 1:{		//Shoot VS Shoot
			player1.life  -= 1;
			player1.ammo -= 1;
			player1.shield = 3;
			comp.life  -= 1;
			comp.ammo  -= 1;
			comp.shield  = 3;
			break;}		
		case 2:{		//Shoot VS Shield
			player1.ammo -= 1;
			player1.shield = 3;
			comp.shield  -= 1;
			break;}	
		case 3:{		//Shoot VS Reload
			player1.ammo -= 1;
			player1.shield = 3;
			comp.life  -= 1;
			comp.ammo  = 3;
			comp.shield  = 3;
			break;}
		case 4:{		//Shield VS Shoot
			player1.shield -= 1;
			comp.ammo  -= 1;
			comp.shield  = 3;
			break;}
		case 5:{		//Shield VS Shield
			player1.shield -= 1;
			comp.shield  -= 1;
			break;}
		case 6:{		//Shield VS Reload
			player1.shield -= 1;			
			comp.ammo  = 3;
			comp.shield  = 3;
			break;}
		case 7:{		//Reload VS Shoot
			player1.life  -= 1;
			player1.ammo = 3;
			player1.shield = 3;			
			comp.ammo  -= 1;
			comp.shield  = 3;
			break;}
		case 8:{		//Reload VS Shield
			player1.ammo = 3;
			player1.shield = 3;
			comp.shield  -= 1;
			break;}
		case 9:{		//Reload VS Reload
			player1.ammo = 3;
			player1.shield = 3;
			comp.ammo  = 3;
			comp.shield  = 3;
			break;}
		}
	}

	// this methods return "true" if a player life reach 0
	public boolean hasWinner() {
		if(player1.getLife() == 0 || comp.getLife() == 0) {
			if(player1.getLife() == comp.getLife()) {
				System.out.println("Draw!!");
				return true; 
			}
			else if (player1.getLife() == 0) {
				System.out.println("Computer win!!");
				return true;  
			}
			else if (comp.getLife() == 0) {
				System.out.println("Player win!!");
				return true; 
			}
		}
		return false; 
	}
}



