package edu.game.Interface;

import edu.game.Component.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import edu.game.Component.Computer;
import edu.game.Component.Game;
import edu.game.Component.Human;
import edu.game.Component.Player;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

public class GameGui extends JFrame implements ActionListener{
	private JPanel topPanel = new JPanel(new BorderLayout());
	private JPanel bottomPanel = new JPanel(new FlowLayout());
	private JTextArea textArea = new JTextArea();
	private JTextField txtName = new JTextField(15);
	private JLabel lblName = new JLabel("Name");
	private JButton btnShoot = new JButton("Shoot");
	private JButton btnBlock = new JButton("Block");
	private JButton btnReload = new JButton("Reload");

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
		createTopPanel();
		createBottomPanel();
		setListener();
		setVisible(true);
	}

	private void setListener() {
		btnShoot.addActionListener(this);
		btnBlock.addActionListener(this);
		btnReload.addActionListener(this);
	}

	private void addPanelsToFrame() {
		add(topPanel);
		add(bottomPanel);
	}

	private void createBottomPanel() {
		add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.add(lblName);
		bottomPanel.add(txtName);
		bottomPanel.add(btnBlock);
		bottomPanel.add(btnReload);
		bottomPanel.add(btnShoot);
	}

	private void createTopPanel() {
		JScrollPane pane = new JScrollPane(textArea);
		add(pane, BorderLayout.CENTER);
		textArea.setEditable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String [] args) {
		GameGui gui = new GameGui();
	}
}
