import java.util.Scanner;

public class Game

{	
	public Human player1 = new Human();
	public Computer comp = new Computer();



	public void Fight() {
		
		Scanner playerChoice = new Scanner(System.in);

		do {
			comp.computerChoice();
			
			System.out.println("shoot[1], guard[2],reload[3]: ");  //TODO scanner input for integer
			player1.choice = playerChoice.nextInt();
			
			
			computeFight();
			
			System.out.println("computer life: " + comp.getLife());
	        System.out.println("player life: " + player1.getLife());
			System.out.println("computer Choice: " + comp.getChoice());
	        System.out.println("player Choice: " + player1.getChoice());


		} while (hasWinner() != true);

		playerChoice.close();


	}
	
	//choice | 1 = shoot | 2 = guard | 3 = reload |
	public void computeFight() { //TODO input vadilation - life/ammo - bounds 

		
		if (player1.getChoice() == 1) {
			if(comp.getChoice() == 1) {
				
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
		else if (player1.getChoice() == 2) {
			if(comp.getChoice() == 1) {
				player1.life  -= 1;
			}
			else if(comp.getChoice() == 2) {
				
			}
			else if(comp.getChoice() == 3) {
				
			}
		}
		
		else if (player1.getChoice() == 3) {
			
			if(comp.getChoice() == 1) {
				player1.life  -= 1;
			}
			else if(comp.getChoice() == 2) {
				
			}
			else if(comp.getChoice() == 3) {
				
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