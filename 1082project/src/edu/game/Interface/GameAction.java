package edu.game.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameAction implements ActionListener{	
	public JLabel addImage = new JLabel();

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Shoot")
				&& humanHasAmmo()){ //Shoot button called and check for ammo
			ImageIcon icGun = new ImageIcon("gun.jpg");  // Displays picture when is clicked.
			GameGui.addFirstImage(icGun); // goes into GameGui Class to access the method "addFirstImage" and adds it to GameGui.imagePanel
			
			GameGui.getNewGame().shoot();
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());
			hasWinner();
		} 
		else if(e.getActionCommand().equalsIgnoreCase("Block")
				&& humanHasGuard()) { //Block button called and check for shield

			ImageIcon icShield = new ImageIcon("shield.jpg");  // Displays picture when is clicked.
			GameGui.addFirstImage(icShield); // goes into GameGui Class to access the method "addFirstImage" and adds it to GameGui.imagePanel
			
			GameGui.getNewGame().guard();
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());
			hasWinner();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Reload")) { //Reload button called
			
			ImageIcon icAmmo = new ImageIcon("ammo.jpg");  // Displays picture when is clicked.
			GameGui.addFirstImage(icAmmo); // goes into GameGui Class to access the method "addFirstImage" and adds it to GameGui.imagePanel
			
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
			GameGui.getTextArea().append("YOU LOSE!!\n");
			ImageIcon youLose = new ImageIcon("youlose.jpg");
			GameGui.addFirstImage(youLose);
			GameGui.addNewGameButton();
		} else if (GameGui.getNewGame().computer.getLife() == 0) {
			GameGui.getTextArea().append("YOU WIN!!\n");
			GameGui.addNewGameButton();
		}
	}	
}
