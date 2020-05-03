package edu.game.Interface;

import edu.game.Component.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import edu.game.Component.Game;
import javax.swing.JLabel;

public class GameGui extends JFrame{
	private JPanel topPanel = new JPanel(new BorderLayout());
	private static JPanel bottomPanel = new JPanel(new FlowLayout());
	private static JTextArea textArea = new JTextArea();
	private static JTextField txtName = new JTextField(15);
	private static JLabel lblName = new JLabel("Name");
	private static JButton btnShoot = new JButton("Shoot");
	private static JButton btnBlock = new JButton("Block");
	private static JButton btnReload = new JButton("Reload");
	private static JButton btnContinue = new JButton("Continue");
	private static JButton btnStartGame = new JButton("Start Game");
	private static JButton btnExist = new JButton("Exist");
	private static Game game = new Game();
	
	//no argument constructor
	public GameGui() {		
		setTitle("Block, Shoot, Reload");
		setSize(600,600);
		textArea.setText("Welcome Player, to : Shoot, Shield, Reload!\n" +
				"Rules of the game: \n" +
				"--------------------\n" +
				"1: You start with 3 lives.\n" +
				"2: You cannot shoot if you do not have ammo.. Duh.\n" +
				"3: You cannot block more than 3 times in a row.\n"  +
				"*Caution: If you try to do more than 3 blocks, Your shield will break!\n" +
				"4: To win, you must deplete your oppenents health to zero!\n" +
				"Have fun, and remember to stay safe!\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addPanelsToFrame();
		setListener();
		setVisible(true);
		setResizable(false);
	}
	//actionLsitener
	public void setListener() {
		GameAction actionLsitener = new GameAction();
		btnShoot.addActionListener(actionLsitener);
		btnBlock.addActionListener(actionLsitener);
		btnReload.addActionListener(actionLsitener);
		btnStartGame.addActionListener(actionLsitener);
		btnContinue.addActionListener(actionLsitener);
		btnExist.addActionListener(actionLsitener);
	}
	//add panel to from - method
	public void addPanelsToFrame() {
		createTopPanel();
		createMenuPanel();
		add(topPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);		
	}
	//create top panel - method
	public void createTopPanel() {
		textArea.setEditable(false);
		topPanel.add(textArea);
	}
	//create bottom panel (menu) - method
	public static void createMenuPanel() {
		bottomPanel.setVisible(false);
		bottomPanel.add(lblName);
		bottomPanel.add(txtName);
		bottomPanel.add(btnStartGame);
		bottomPanel.remove(btnBlock);
		bottomPanel.remove(btnReload);
		bottomPanel.remove(btnShoot);
		bottomPanel.remove(btnContinue);
		bottomPanel.remove(btnExist);
		bottomPanel.setVisible(true);
	}
	//create bottom panel (fight button) - method
	public static void createFightPanel() {
		bottomPanel.setVisible(false);
		bottomPanel.remove(lblName);
		bottomPanel.remove(txtName);
		bottomPanel.remove(btnStartGame);
		bottomPanel.remove(btnContinue);
		bottomPanel.remove(btnExist);
		bottomPanel.add(btnBlock);
		bottomPanel.add(btnReload);
		bottomPanel.add(btnShoot);
		bottomPanel.setVisible(true);
	}
	//create bottom panel (Continue button) - method
	public static void createConitinuePanel() {
		bottomPanel.setVisible(false);
		bottomPanel.remove(lblName);
		bottomPanel.remove(txtName);
		bottomPanel.remove(btnStartGame);
		bottomPanel.remove(btnBlock);
		bottomPanel.remove(btnReload);
		bottomPanel.remove(btnShoot);
		bottomPanel.add(btnContinue);
		bottomPanel.add(btnExist);
		bottomPanel.setVisible(true);
	}
	//getters
	public static JTextArea getTextArea() {
		return textArea;
	}
	public static Game getGame() {
		return game;
	}
}
