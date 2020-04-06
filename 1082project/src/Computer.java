
public class Computer extends Player {
	
	private String name = "computer";
	Player comp = new Player();
			
	public void computerChoice(){
		choice = (int)(Math.random()*3)+1;		
		comp.rules();
	}

}
