import java.util.Scanner;

public class Human extends Player {

	private String name;

	public Human() {
		super();	
		Scanner temp = new Scanner(System.in);
		System.out.println("enter player name: ");
		this.name = temp.nextLine();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * this methods ask for user input. Will loop if wrong input
	 */
	public void playerChoice(){
		Scanner playerChoice = new Scanner(System.in);
		int scenario = rules();
		switch (scenario) {
		case 1:{		//Cant shoot and Cant shield
			do {
				System.out.println("shoot[1], guard[2],reload[3]: "); 
				System.out.println("Cant shoot and Cant shield ... ");
				choice = playerChoice.nextInt();
			}while ( choice == 1 || choice == 2 || choice < 1 ||  choice > 3);
			break;}			
		case 2:{		//Cant shoot 
			do {
				System.out.println("shoot[1], guard[2],reload[3]: "); 
				System.out.println("Cant shoot ... ");
				choice = playerChoice.nextInt();
			}while ( choice == 1 || choice < 1 ||  choice > 3);
			break;}		
		case 3:{		//Cant shield
			do {
				System.out.println("shoot[1], guard[2],reload[3]: "); 
				System.out.println("Cant shield ");
				choice = playerChoice.nextInt();
			}while ( choice == 2 || choice < 1 ||  choice > 3);
			break;}
		default:{		//Can shoot Can shield 
			do {
				System.out.println("shoot[1], guard[2],reload[3]: "); 
				choice = playerChoice.nextInt();
			} while (choice < 1 ||  choice > 3);
			break;}
		}	



	}




}
