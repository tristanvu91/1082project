package edu.game.Component;
public class Computer extends Player {

	private int choice;
	
	//generate random computer choice for the game [1]shoot[2]block[3]reload - methods
	public void computerChoice(){
		do {
			choice = (int)(Math.random()*3)+1;	
		} while ((choice == 1 && ammo == 0)|| (choice == 2 && shield == 0));	
	}
	//getter - methods
	public int getChoice() {
		return choice;
	}
}
