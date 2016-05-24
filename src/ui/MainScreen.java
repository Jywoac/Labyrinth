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

public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 450, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel MainMenu = new JPanel();
		contentPane.add(MainMenu);
		MainMenu.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		MainMenu.add(verticalStrut);
		
		JLabel GameNameLabel = new JLabel("Labyrinth");
		MainMenu.add(GameNameLabel);
		GameNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel ButtonPanel = new JPanel();
		MainMenu.add(ButtonPanel);
		ButtonPanel.setLayout(null);
		
		JButton StartGameButton = new JButton("Start");
		StartGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BoardActions bo = new BoardActions();
			}
		});
		StartGameButton.setLocation(346, 0);
		StartGameButton.setSize(new Dimension(100, 30));
		ButtonPanel.add(StartGameButton);
		
		JButton ControlsMenuButton = new JButton("Controls");
		ControlsMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// move to controls menu
			}
		});
		ControlsMenuButton.setBounds(346, 41, 790, 31);
		ControlsMenuButton.setSize(new Dimension(100, 30));
		ButtonPanel.add(ControlsMenuButton);
		
		JButton ExitGameButton = new JButton("Exit");
		ExitGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		ExitGameButton.setBounds(346, 82, 790, 31);
		ExitGameButton.setSize(new Dimension(100, 30));
		ButtonPanel.add(ExitGameButton);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		MainMenu.add(verticalStrut_2);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		MainMenu.add(verticalStrut_1);
		

	}

}
