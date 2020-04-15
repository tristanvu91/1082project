package edu.game.Component;


public class Game {
	private static int rounds = 1;

	public Human human = new Human();
	public Computer computer = new Computer();


	public Game() {
		super();
		this.human = human;
		this.computer = computer;
	}

	public Game(Human human, Computer computer) {
		this.human = human;
		this.computer = computer;
	}

	public void startMatch() {

			System.out.println("Round: " + rounds++);
			System.out.println("Player Counters: ");
			System.out.println("---------------------");
			System.out.println("player life: " + human.getLife());
			System.out.println("player ammo: " + human.getAmmo());
			System.out.println("player Choice: " + human.getChoice());
			System.out.println("player shield: " + human.getShield());
			System.out.println();

			System.out.println("Computer Counters: ");
			System.out.println("---------------------");
			System.out.println("computer life: " + computer.getLife());
			System.out.println("computer ammo: " + computer.getAmmo());
			System.out.println("computer Choice: " + computer.getChoice());
			System.out.println("computer shield: " + computer.getShield());
			System.out.println();

	}

	public void computeFight() {
		shoot();
		guard();
		reload();
	}

	// Entering [1] will shoot
	public void shoot() {		
		human.setChoice(1);
		computer.computerChoice();
		if(computer.getChoice() == 1) {				
			human.life  -= 1;
			human.ammo -= 1;
			human.shield = 3;

			computer.life  -= 1;
			computer.ammo  -= 1;
			computer.shield  = 3;							
		}
		else if(computer.getChoice() == 2) {	
			human.ammo -= 1;
			human.shield = 3;				

			computer.shield  -= 1;				
		}			
		else if(computer.getChoice() == 3) {
			human.ammo -= 1;
			human.shield = 3;

			computer.life  -= 1;
			computer.ammo  = 3;
			computer.shield  = 3;
		}
	}

	//Entering [2] will guard.
	public void guard() {		
		human.setChoice(2);
		computer.computerChoice();
		if(computer.getChoice() == 1) {
			human.shield -= 1;

			computer.ammo  -= 1;
			computer.shield  = 3;
		}
		else if(computer.getChoice() == 2) {
			human.shield -= 1;

			computer.shield  -= 1;
		}
		else if(computer.getChoice() == 3) {
			human.shield -= 1;

			computer.ammo  = 3;
			computer.shield  = 3;			
		}
	}

	//Entering [3] will reload.
	public void reload() {
		human.setChoice(2);
		computer.computerChoice();
		if(computer.getChoice() == 1) {
			human.life  -= 1;
			human.ammo = 3;
			human.shield = 3;

			computer.ammo  -= 1;
			computer.shield  = 3;
		}
		else if(computer.getChoice() == 2) {
			human.ammo = 3;
			human.shield = 3;

			computer.shield  -= 1;
		}
		else if(computer.getChoice() == 3) {
			human.ammo = 3;
			human.shield = 3;

			computer.ammo  = 3;
			computer.shield  = 3;			
		}
	}

	public boolean hasWinner() {
		boolean winner = false;

		if (human.getLife() == 0 && computer.getLife() == 0) {
			System.out.println("Draw!!");
			winner = true;
			return winner;
		}

		if (human.getLife() == 0) {
			System.out.println("Computer win!!");
			winner = true;
			return winner;
		}

		if (human.getLife() == 0) {
			System.out.println("Human win!!");
			winner = true;
			return winner;
		}

		return winner;
	}

	@Override
	public String toString() {
		String message = 	"Round: " + (rounds++) + "\n" +
				"Player Counters: " + "\n" +
				"---------------------" + "\n" +
				"player life: " + human.getLife()+ "\n" +
				"player ammo: " + human.getAmmo()+ "\n" +
				"player Choice: " + human.getChoice()+ "\n" +
				"player shield: " + human.getShield()+ "\n\n" +

				"Computer Counters: "+ "\n" +
				"---------------------"+ "\n" +
				"computer life: " + computer.getLife()+ "\n" +
				"computer ammo: " + computer.getAmmo()+ "\n" +
				"computer Choice: " + computer.getChoice()+ "\n" +
				"computer shield: " + computer.getShield()+ "\n" ;

				return message;
	}



}
