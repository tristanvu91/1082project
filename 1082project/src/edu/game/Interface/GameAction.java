package edu.game.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameAction implements ActionListener{	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Shoot")
				&& humanHasAmmo()){ //Shoot button called and check for ammo
			GameGui.getGame().shoot();
			GameGui.getTextArea().setText(GameGui.getGame().toString());
			hasWinner();
		} else if(e.getActionCommand().equalsIgnoreCase("Block")
				&& humanHasGuard()) { //Block button called and check for shield
			GameGui.getGame().guard();
			GameGui.getTextArea().setText(GameGui.getGame().toString());
			hasWinner();
		} else if(e.getActionCommand().equalsIgnoreCase("Reload")) { //Reload button called
			GameGui.getGame().reload();
			GameGui.getTextArea().setText(GameGui.getGame().toString());
			hasWinner();
		} else if(e.getActionCommand().equalsIgnoreCase("Start Game")) { //Start Game button called
			GameGui.getTextArea().setText(GameGui.getGame().toString());
			GameGui.createFightPanel();
		} else if(e.getActionCommand().equalsIgnoreCase("Continue")) { //New Game button called
			GameGui.createMenuPanel();
			GameGui.getGame().setNewGame();
		} else if(e.getActionCommand().equalsIgnoreCase("Exist")) { //Exist button called
			 System.exit(0);
		}
	}
	//check for human ammo  -methods
	public boolean humanHasAmmo() {		
		if (GameGui.getGame().human.getAmmo() == 0 
				&& GameGui.getGame().human.getShield() == 0) {
			GameGui.getTextArea().append("Can't shoot or guard!!\n");
			return false;
		} else if (GameGui.getGame().human.getAmmo() == 0) {
			GameGui.getTextArea().append("Can't shoot!!\n");
			return false;
		}
		return true;		
	}
	//check for human shield  -methods
	public boolean humanHasGuard() {
		if (GameGui.getGame().human.getAmmo() == 0 
				&& GameGui.getGame().human.getShield() == 0) {
			GameGui.getTextArea().append("Can't shoot or guard!!\n");
			return false;
		} else if (GameGui.getGame().human.getShield() == 0) {
			GameGui.getTextArea().append("Can't guard!!\n");
			return false;
		}		
		return true;		
	}
	//searching for winner and display if has one -methods
	public void hasWinner() {
		if (GameGui.getGame().human.getLife() == 0 
				&& GameGui.getGame().computer.getLife() == 0) {
			GameGui.getTextArea().append("Draw!!\n");
			GameGui.createConitinuePanel();
		} else if (GameGui.getGame().human.getLife() == 0) {
			GameGui.getTextArea().append("Computer win!!\n");
			GameGui.createConitinuePanel();
		} else if (GameGui.getGame().computer.getLife() == 0) {
			GameGui.getTextArea().append("Human win!!\n");
			GameGui.createConitinuePanel();
		}
	}	
}