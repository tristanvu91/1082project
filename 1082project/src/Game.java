import java.util.Scanner;

public class Game

{	
	private static int rounds;
	
	public Human player1 = new Human();
	public Computer comp = new Computer();



	public Game() {
		this.player1 = player1;
		this.comp = comp;
		rounds++;
		
		
	}

	public void startMatch() {
		
		Scanner playerChoice = new Scanner(System.in);

		do {
			comp.computerChoice();
			
			System.out.println("shoot[1], guard[2],reload[3]: ");  //TODO scanner input for integer
			player1.choice = playerChoice.nextInt();
			
			
			computeFight();
			
			
	        System.out.println("player life: " + player1.getLife());
	        System.out.println("player ammo: " + player1.getAmmo());
	        System.out.println("player Choice: " + player1.getChoice());
	        
	        System.out.println("computer life: " + comp.getLife());
	        System.out.println("player ammo: " + player1.getAmmo());
			System.out.println("computer Choice: " + comp.getChoice());
	        


		} while (hasWinner() != true);

		playerChoice.close();


	}
	
	//choice | 1 = shoot | 2 = guard | 3 = reload |
	
	public void computeFight() 
	
	{
		
		// Player cannot shoot with no ammo.

		if (player1.getChoice() == 1 && player1.getAmmo() == 0)
		{
			System.out.println("No Ammo to Shoot ... You must Reload First. ");
			player1.setChoice(0);
			
		}
		
		if (comp.getChoice() == 1 && comp.getAmmo() == 0)
		{
			System.out.println("No Ammo to Shoot ... You must Reload First.");
			comp.setChoice(0);
			
		}
		
		//Shooting
		
		if (player1.getChoice() == 1 && player1.getAmmo() != 0) {
			if(comp.getChoice() == 1 && comp.getAmmo() != 0) {
				
				player1.life  -= 1;
				comp.life  -= 1;
							
			}
			else if(comp.getChoice() == 2) {
				comp.life  -= 1;
			}
			else if(comp.getChoice() == 3) {
				comp.life  -= 1;
			}
		}
		
		// Guarding 
		
		else if (player1.getChoice() == 2) {
			if(comp.getChoice() == 1) {
				player1.life  -= 1;
			}
			else if(comp.getChoice() == 2) {
				
			}
			else if(comp.getChoice() == 3) {
				comp.setAmmo(0);
			}
		}
		
		//Reloading Process
		
		else if (player1.getChoice() == 3) {
			
			player1.setAmmo(0);
			
			if(comp.getChoice() == 1 && comp.getAmmo() != 0) {
				player1.life  -= 1;
			}
			else if(comp.getChoice() == 2) {
				
			}
			else if(comp.getChoice() == 3) {
				comp.setAmmo(0);
				
			}
		}
		
		
		
	}
	
	public boolean hasWinner() {
		
		boolean winner = true;
		
		if(player1.getLife() == 0 || comp.getLife() == 0) {
			if(player1.getLife() == comp.getLife()) {
				System.out.println("Draw!!");
				return winner;  // TODO 
			}
			else if (player1.getLife() == 0) {
				System.out.println("Computer win!!");
				return winner;  // TODO 
			}
			else if (comp.getLife() == 0) {
				System.out.println("Player win!!");
				return winner;  // TODO 
			}
		}
		return !winner ; 
	}



	
	
}