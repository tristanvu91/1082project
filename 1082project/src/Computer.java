
public class Computer extends Player {
	
	private String name = "computer";
			
	public void computerChoice(){
		choice = (int)(Math.random()*3)+1;		
		
	}

}
