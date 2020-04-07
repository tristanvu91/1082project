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

	public void playerChoice(){
		Scanner playerChoice = new Scanner(System.in);
		int scenario = rules();
		switch (scenario) {
		case 1:{
			do {
				choice = playerChoice.nextInt();
			}while ( choice == 2 );
			break;}			
		case 2:{
			do {
				choice = playerChoice.nextInt();
			}while ( choice == 1);
			break;}		
		case 3:{
			do {
				choice = playerChoice.nextInt();
			}while ( choice == 1 || choice == 2);
			break;}
		default:{
			choice = playerChoice.nextInt();
			break;}
		}	
		
		

}




}
