package edu.game.Interface;

import edu.game.Component.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import edu.game.Component.Game;
import javax.swing.JLabel;

public class GameGui extends JFrame{
	private static JPanel imagePanel = new JPanel(new FlowLayout());
	private static JLabel firstImage = new JLabel();
	private static JLabel secondImage = new JLabel();
	
	private static JPanel startMenu = new JPanel(new FlowLayout());
	private JPanel gameOverMenu = new JPanel(new FlowLayout());
	private static JTextArea textArea = new JTextArea();
	private static JTextField txtName = new JTextField(15);
	private static JLabel lblName = new JLabel("Name");
	private static JButton btnShoot = new JButton("Shoot");
	private static JButton btnBlock = new JButton("Block");
	private static JButton btnReload = new JButton("Reload");
	private static JButton btnNewGame = new JButton("New Game");
	private static JButton btnStartGame = new JButton("Start Game");
	private static JButton btnExist = new JButton("Exit");
	private static Game newGame = new Game();


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
		add(startMenu, BorderLayout.SOUTH);
		setListener();
		setVisible(true);
	}

	public void setListener() {
		GameAction actionListener = new GameAction();
		btnShoot.addActionListener(actionListener);
		btnBlock.addActionListener(actionListener);
		btnReload.addActionListener(actionListener);
		btnStartGame.addActionListener(actionListener);
		btnNewGame.addActionListener(actionListener);
	}

	public void addPanelsToFrame() {
		createTopPanel();
		createImagePanel();
		addStarMenuButton();
	}
	
	public void createImagePanel() {
		add(imagePanel, BorderLayout.CENTER);
		imagePanel.add(firstImage);
		imagePanel.add(secondImage);
	}

	public void createTopPanel() {
		JScrollPane pane = new JScrollPane(textArea);
		add(pane, BorderLayout.NORTH);
		textArea.setEditable(false);
	}

	public static void addStarMenuButton() {
		startMenu.setVisible(false);
		imagePanel.setVisible(true);
		startMenu.add(lblName);
		startMenu.add(txtName);
		startMenu.add(btnStartGame);
		startMenu.remove(btnBlock);
		startMenu.remove(btnReload);
		startMenu.remove(btnShoot);
		startMenu.remove(btnNewGame);
		startMenu.remove(btnExist);
		startMenu.setVisible(true);
	}
	public static void addFightButton() {
		startMenu.setVisible(false);
		imagePanel.setVisible(true);
		startMenu.remove(lblName);
		startMenu.remove(txtName);
		startMenu.remove(btnStartGame);
		startMenu.remove(btnNewGame);
		startMenu.remove(btnExist);
		startMenu.add(btnBlock);
		startMenu.add(btnReload);
		startMenu.add(btnShoot);
		startMenu.setVisible(true);
	}
	public static void addNewGameButton() {
		startMenu.setVisible(false);
		startMenu.remove(lblName);
		startMenu.remove(txtName);
		startMenu.remove(btnStartGame);
		startMenu.remove(btnBlock);
		startMenu.remove(btnReload);
		startMenu.remove(btnShoot);
		startMenu.add(btnNewGame);
		startMenu.add(btnExist);
		startMenu.setVisible(true);
	}	
	public static JTextArea getTextArea() {
		return textArea;
	}
	public static Game getNewGame() {
		return newGame;
	}
	public static JPanel getStartMenu() {
		return startMenu;
	}

	public static void addFirstImage(ImageIcon x) {
		GameGui.firstImage.setIcon(x);
		imagePanel.add(firstImage);
	}
	
	public static void addSecondImage(ImageIcon x) {
		GameGui.secondImage.setIcon(x);
		imagePanel.add(secondImage);
	}

	public static void setSecondImage(JLabel secondImage) {
		GameGui.secondImage = secondImage;
	}
	
	public static void main(String[]args) {
		GameGui gui = new GameGui();
	}

}
