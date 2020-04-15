package edu.game.Interface;

import edu.game.Component.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class gameAction implements ActionListener{	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String callingButton = e.getActionCommand();
		if (callingButton.equalsIgnoreCase("Shoot")) {

			GameGui.getNewGame().shoot();
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());
		} 
		else if(callingButton.equalsIgnoreCase("Block")) {

			GameGui.getNewGame().guard();
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());			
		}
		else if(callingButton.equalsIgnoreCase("Reload")) {

			GameGui.getNewGame().reload();
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());
					
		}
		
	}		
	

}