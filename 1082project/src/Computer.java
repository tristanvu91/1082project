
public class Computer extends Player {
	
	private String name = "computer";
			
	
	public void computerChoice(){
		
		int scenario = rules();
		switch (scenario) {
		case 1:{
			do {
				choice = (int)(Math.random()*3)+1;
			}while ( choice == 2);
			break;}			
		case 2:{
			do {
				choice = (int)(Math.random()*3)+1;
			}while ( choice == 1);
			break;}		
		case 3:{
			do {
				choice = (int)(Math.random()*3)+1;
			}while ( choice == 1 || choice == 2);
			break;}
		default:{
			choice = (int)(Math.random()*3)+1;
			break;}
		}	
		
		

	}

}
