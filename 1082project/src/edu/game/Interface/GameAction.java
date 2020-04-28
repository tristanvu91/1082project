package edu.game.Interface;

import edu.game.Component.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameAction implements ActionListener{	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Shoot")
				&& humanHasAmmo()){ //Shoot button called and check for ammo
			GameGui.getNewGame().shoot();
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());
			hasWinner();
		} 
		else if(e.getActionCommand().equalsIgnoreCase("Block")
				&& humanHasGuard()) { //Block button called and check for shield
			GameGui.getNewGame().guard();
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());
			hasWinner();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Reload")) { //Reload button called
			GameGui.getNewGame().reload();
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());
			hasWinner();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Start Game")) { //Start Game button called
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());
			GameGui.addFightButton();
		}
		else if(e.getActionCommand().equalsIgnoreCase("New Game")) { //New Game button called
			GameGui.addStarMenuButton();
			GameGui.getNewGame().setNewGame();
		}
	}
	//check for human ammo  -methods
	public boolean humanHasAmmo() {		
		if (GameGui.getNewGame().human.getAmmo() == 0 
				&& GameGui.getNewGame().human.getShield() == 0) {
			GameGui.getTextArea().append("Can't shoot or guard!!\n");
			return false;
		} else if (GameGui.getNewGame().human.getAmmo() == 0) {
			GameGui.getTextArea().append("Can't shoot!!\n");
			return false;
		}
		return true;		
	}
	//check for human shield  -methods
	public boolean humanHasGuard() {
		if (GameGui.getNewGame().human.getAmmo() == 0 
				&& GameGui.getNewGame().human.getShield() == 0) {
			GameGui.getTextArea().append("Can't shoot or guard!!\n");
			return false;
		} else if (GameGui.getNewGame().human.getShield() == 0) {
			GameGui.getTextArea().append("Can't guard!!\n");
			return false;
		}		
		return true;		
	}
	//searching for winner and display if has one -methods
	public void hasWinner() {
		if (GameGui.getNewGame().human.getLife() == 0 
				&& GameGui.getNewGame().computer.getLife() == 0) {
			GameGui.getTextArea().append("Draw!!\n");
			GameGui.addNewGameButton();
		} else if (GameGui.getNewGame().human.getLife() == 0) {
			GameGui.getTextArea().append("Computer win!!\n");
			GameGui.addNewGameButton();
		} else if (GameGui.getNewGame().computer.getLife() == 0) {
			GameGui.getTextArea().append("Human win!!\n");
			GameGui.addNewGameButton();
		}
	}	
}