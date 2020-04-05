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
	
	
	

}
