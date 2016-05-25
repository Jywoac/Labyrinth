package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import game.BoardActions;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private static JFrame f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					f = frame;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 450, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel differentScreens = new JPanel();
		contentPane.add(differentScreens);
		differentScreens.setLayout(new CardLayout(0, 0));
		
		JPanel mainMenu = new JPanel();
		differentScreens.add(mainMenu, "MAINMENU");
		mainMenu.setBackground(Color.BLACK);
		mainMenu.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		mainMenu.add(verticalStrut);
		
		JLabel GameNameLabel = new JLabel("Labyrinth");
		GameNameLabel.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		GameNameLabel.setForeground(Color.WHITE);
		mainMenu.add(GameNameLabel);
		GameNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		mainMenu.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton startGameButton = new JButton("");
		startGameButton.setOpaque(false);
		startGameButton.setContentAreaFilled(false);
		startGameButton.setBorderPainted(false);
		startGameButton.setFocusPainted(false);		
		startGameButton.setIcon(new ImageIcon(MainScreen.class.getResource("/start.png")));
		startGameButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/start_pressed.png")));
		startGameButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/start_rollover.png")));
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//BoardActions bo = new BoardActions();
				// move to mazeSize screen with a new card
			    CardLayout cl = (CardLayout)(differentScreens.getLayout());
			    cl.show(differentScreens, "GAMESIZEMENU");
			}
		});
		startGameButton.setLocation(346, 0);
		startGameButton.setSize(new Dimension(100, 30));
		buttonPanel.add(startGameButton);
		
		JButton controlsMenuButton = new JButton("");
		controlsMenuButton.setOpaque(false);
		controlsMenuButton.setContentAreaFilled(false);
		controlsMenuButton.setBorderPainted(false);
		controlsMenuButton.setFocusPainted(false);
		controlsMenuButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/controls_pressed.png")));
		controlsMenuButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/controls_rollover.png")));
		controlsMenuButton.setIcon(new ImageIcon(MainScreen.class.getResource("/controls.png")));
		controlsMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// move to controls screen with a new card
			    CardLayout cl = (CardLayout)(differentScreens.getLayout());
			    cl.show(differentScreens, "CONTROLSMENU");

			}
		});
		controlsMenuButton.setBounds(346, 41, 790, 31);
		controlsMenuButton.setSize(new Dimension(100, 30));
		buttonPanel.add(controlsMenuButton);
		
		JButton exitGameButton = new JButton("");
		exitGameButton.setOpaque(false);
		exitGameButton.setContentAreaFilled(false);
		exitGameButton.setBorderPainted(false);
		exitGameButton.setFocusPainted(false);
		exitGameButton.setIcon(new ImageIcon(MainScreen.class.getResource("/exit.png")));
		exitGameButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/exit_pressed.png")));
		exitGameButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/exit_rollover.png")));
		exitGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitGameButton.setBounds(346, 82, 790, 31);
		exitGameButton.setSize(new Dimension(100, 30));
		buttonPanel.add(exitGameButton);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		mainMenu.add(verticalStrut_2);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		mainMenu.add(verticalStrut_1);
		
		JPanel controls = new JPanel();
		controls.setBackground(Color.BLACK);
		differentScreens.add(controls, "CONTROLSMENU");
		controls.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		controls.add(verticalStrut_3);
		
		JPanel controlTextPanel = new JPanel();
		controlTextPanel.setBackground(Color.BLACK);
		controls.add(controlTextPanel);
		controlTextPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblUseTheArrowkeys = new JLabel("Use the arrowkeys to move.");
		lblUseTheArrowkeys.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		controlTextPanel.add(lblUseTheArrowkeys);
		lblUseTheArrowkeys.setHorizontalAlignment(SwingConstants.CENTER);
		lblUseTheArrowkeys.setForeground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Press the L key to look around.");
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		controlTextPanel.add(lblNewLabel);
		
		JPanel controlsMenuButtons = new JPanel();
		controlsMenuButtons.setLayout(null);
		controlsMenuButtons.setBackground(Color.BLACK);
		controls.add(controlsMenuButtons);
		
		JButton btnBack = new JButton("");
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		btnBack.setIcon(new ImageIcon(MainScreen.class.getResource("/back.png")));
		btnBack.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/back_pressed.png")));
		btnBack.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/back_rollover.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    CardLayout cl = (CardLayout)(differentScreens.getLayout());
			    cl.show(differentScreens, "MAINMENU");
			}
		});
		btnBack.setSize(new Dimension(100, 30));
		btnBack.setBounds(346, 82, 100, 30);
		controlsMenuButtons.add(btnBack);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		controls.add(verticalStrut_4);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		controls.add(verticalStrut_5);
		
		JPanel gameSizeChoosingMenu = new JPanel();
		gameSizeChoosingMenu.setBackground(Color.BLACK);
		differentScreens.add(gameSizeChoosingMenu, "GAMESIZEMENU");
		gameSizeChoosingMenu.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		gameSizeChoosingMenu.add(verticalStrut_6);
		
		JPanel textPanel = new JPanel();
		textPanel.setBackground(Color.BLACK);
		gameSizeChoosingMenu.add(textPanel);
		textPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblChooseTheSize = new JLabel("Choose the size of the maze");
		lblChooseTheSize.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		lblChooseTheSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseTheSize.setForeground(Color.WHITE);
		textPanel.add(lblChooseTheSize);
		
		JPanel mazeSizeButtons = new JPanel();
		mazeSizeButtons.setLayout(null);
		mazeSizeButtons.setBackground(Color.BLACK);
		gameSizeChoosingMenu.add(mazeSizeButtons);
		
		JButton backToMainMenu = new JButton("");
		backToMainMenu.setOpaque(false);
		backToMainMenu.setContentAreaFilled(false);
		backToMainMenu.setBorderPainted(false);
		backToMainMenu.setFocusPainted(false);
		backToMainMenu.setIcon(new ImageIcon(MainScreen.class.getResource("/back.png")));
		backToMainMenu.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/back_pressed.png")));
		backToMainMenu.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/back_rollover.png")));
		backToMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    CardLayout cl = (CardLayout)(differentScreens.getLayout());
			    cl.show(differentScreens, "MAINMENU");
			}
		});
		
		JButton smallMaze = new JButton("");
		smallMaze.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/small_pressed.png")));
		smallMaze.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/small_rollover.png")));
		smallMaze.setForeground(Color.BLACK);
		smallMaze.setBackground(Color.BLACK);
		smallMaze.setIcon(new ImageIcon(MainScreen.class.getResource("/small.png")));
		smallMaze.setOpaque(false);
		smallMaze.setContentAreaFilled(false);
		smallMaze.setBorderPainted(false);
		smallMaze.setFocusPainted(false);
		smallMaze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		smallMaze.setSize(new Dimension(100, 30));
		smallMaze.setBounds(236, 41, 100, 30);
		mazeSizeButtons.add(smallMaze);
		
		JButton mediumMaze = new JButton("");
		mediumMaze.setIcon(new ImageIcon(MainScreen.class.getResource("/medium.png")));
		mediumMaze.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/medium_pressed.png")));
		mediumMaze.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/medium_rollover.png")));
		mediumMaze.setOpaque(false);
		mediumMaze.setContentAreaFilled(false);
		mediumMaze.setBorderPainted(false);
		mediumMaze.setFocusPainted(false);
		mediumMaze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mediumMaze.setSize(new Dimension(100, 30));
		mediumMaze.setBounds(346, 41, 100, 30);
		mazeSizeButtons.add(mediumMaze);
		
		JButton bigMaze = new JButton("");
		bigMaze.setIcon(new ImageIcon(MainScreen.class.getResource("/large.png")));
		bigMaze.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/large_pressed.png")));
		bigMaze.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/large_rollover.png")));
		bigMaze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bigMaze.setSize(new Dimension(100, 30));
		bigMaze.setBounds(456, 41, 100, 30);
		bigMaze.setOpaque(false);
		bigMaze.setContentAreaFilled(false);
		bigMaze.setBorderPainted(false);
		bigMaze.setFocusPainted(false);
		mazeSizeButtons.add(bigMaze);
		backToMainMenu.setSize(new Dimension(100, 30));
		backToMainMenu.setBounds(346, 82, 100, 30);
		mazeSizeButtons.add(backToMainMenu);
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		gameSizeChoosingMenu.add(verticalStrut_7);
		
		Component verticalStrut_8 = Box.createVerticalStrut(20);
		gameSizeChoosingMenu.add(verticalStrut_8);
		

	}

}
