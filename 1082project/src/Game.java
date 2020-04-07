import java.util.Scanner;

public class Game {
    private static int rounds = 1;

    public Human human;
    public Computer computer;

    public Game(Human human, Computer computer) {
        this.human = human;
        this.computer = computer;
    }

    public void startMatch() {
        Scanner playerChoice = new Scanner(System.in);

        do {
            computer.computerChoice();

            System.out.println("shoot[1], guard[2],reload[3]: ");  
            human.choice = playerChoice.nextInt();
            
            computeFight();
            
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
            
        } while (hasWinner() == false);

        playerChoice.close();
    }

    public void computeFight() {
		shoot();
		guard();
		reload();
		outOfBounds();
    }

    // Entering [1] will shoot
	private void shoot() {
		if (human.getChoice() == 1 && human.getAmmo() == 0) {
			System.out.println("No Ammo to Shoot ... You must Reload First. ");
		}

		if (computer.getChoice() == 1 && computer.getAmmo() == 0) {
			System.out.println("No Ammo to Shoot ... You must Reload First.");
		}

		if ((human.getChoice() == 1 && human.getAmmo() > 0) && (computer.getChoice() == 1 && computer.getAmmo() > 0)) {
			human.life -= 1;
			computer.life -= 1;
			human.setShield(0);
			computer.setShield(0);
		}

		if ((human.getChoice() == 1 && human.getAmmo() > 0 && computer.getChoice() == 2)) {
			human.setAmmo(human.getAmmo()-1);
			computer.setShield(computer.getShield() + 1);
		}

		if ((human.getChoice() == 1 && human.getAmmo() > 0 && computer.getChoice() == 3)) {
			computer.life -= 1;
			human.setShield(0);
			computer.setShield(0);
		}

		if ((computer.getChoice() == 1 && computer.getAmmo() > 0 && human.getChoice() == 2)) {
			computer.setAmmo(computer.getAmmo()-1);
			human.setShield(human.getShield() + 1);
		}

		if ((computer.getChoice() == 1 && computer.getAmmo() > 0 && human.getChoice() == 3)) {
			human.life -= 1;
			human.setShield(0);
			computer.setShield(0);
		}
	}

	//Entering [2] will guard.
	private void guard() {
		if (human.getChoice() == 2 && computer.getChoice() == 2) {
			System.out.println("Both players are guarding, nothing happens.");
			human.setShield(human.getShield() + 1);
			computer.setShield(computer.getShield() + 1);
		}

		if (human.getChoice() == 2 && computer.getChoice() == 3) {
			computer.setAmmo(computer.getAmmo()+1);
			human.setShield(human.getShield() + 1);
		}

		if (computer.getChoice() == 2 && human.getChoice() == 3) {
			human.setAmmo(human.getAmmo()+1);
			computer.setShield(computer.getShield() + 1);
		}
		if(human.getShield() > 3)
		{
			System.out.println("Cannot shield more than 3 times in a row. Your shield is now zero.");
			human.setShield(0);
		}
		if(computer.getShield() > 3)
		{
			System.out.println("Cannot shield more than 3 times in a row. Your shield is now zero.");
			computer.setShield(0);
		}
	}

	//Entering [3] will reload.
	private void reload() {
		if(human.getChoice() == 3 && computer.getChoice() == 1)  {
			human.setAmmo(human.getAmmo() + 1);
			human.setShield(0);
			computer.setShield(0);
		}
		if (computer.getChoice() == 3 && human.getChoice() == 3) {
			human.setAmmo(human.getAmmo()+1);
			computer.setAmmo(computer.getAmmo()+1);
			human.setShield(0);
			computer.setShield(0);
			System.out.println("Both players are relaoding, nothing happens.");
		}
	}

	private void outOfBounds() {
    	if (human.getChoice() < 0 || human.getChoice() > 3) {
			throw new IllegalArgumentException("Human is out of bounds for choice");
		}

		if (computer.getChoice() < 0 || computer.getChoice() > 3) {
			throw new IllegalArgumentException("Computer is out of bounds for choice");
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

		if (computer.getLife() == 0) {
			System.out.println("Human win!!");
			winner = true;
			return winner;
		}

        return winner;
    }
}
