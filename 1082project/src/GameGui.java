import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

public class GameGui extends JFrame {

	private JPanel contentPane;
	JTextArea textArea = new JTextArea();
	Human human = new Human();
	Computer computer = new Computer();
	Player player = new Player();
	private JTextField nameTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGui frame = new GameGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public GameGui() {
		setTitle("Block, Shoot, Reload");
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
		setBounds(100, 100, 525, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel topPanel = new JPanel();
		
		topPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Fight Result", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(topPanel);
		topPanel.setLayout(new BorderLayout(0, 0));
		
		topPanel.add(textArea, BorderLayout.CENTER);
		JScrollPane pane = new JScrollPane(textArea); // gives the text area a scroll
		textArea.setEditable(false); // will not give access to user to type in textarea
		topPanel.add(pane, BorderLayout.CENTER);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Choose Your Fate: ", TitledBorder.LEFT, TitledBorder.TOP, null, Color.RED));
		topPanel.add(panel, BorderLayout.SOUTH);
		
		JLabel nameLbl = new JLabel("Name:");
		panel.add(nameLbl);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		nameTxt = new JTextField();
		panel_1.add(nameTxt);
		nameTxt.setColumns(10);
		
		
		JButton Block = new JButton("Block");
		Block.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Human human = new Human();
				Computer computer = new Computer();
				Player player = new Player();
				String name = nameTxt.getText();
				Game blockAction = new Game();
				blockAction.guard();
				textArea.append(name + ": " + human.getShield() + "\nComputer: " + computer.getShield() + "\n");
			}
		});
		panel.add(Block);
		
		JButton Shoot = new JButton("Shoot");
		Shoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(Shoot);
		
		JButton Reload = new JButton("Reload");
		Reload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		panel.add(Reload);
		


	}


	private void setListeners() {
		
		
	}

}
