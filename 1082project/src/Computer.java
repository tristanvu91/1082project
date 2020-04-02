
public class Computer extends Player {
	
	private String name = "computer";
			
	public void computerChoice(){
		int computerChoice=(int)(Math.random()*3)+1;		
		super.choice = computerChoice;
		

	}

}
