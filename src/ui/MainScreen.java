package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

import game.BoardActions;
import game.MonsterActions;
import game.MonsterFileWork;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JPanel differentScreens;
	private JEditorPane gameText = new JEditorPane(new HTMLEditorKit().getContentType(),"");
	private JEditorPane combat = new JEditorPane(new HTMLEditorKit().getContentType(), "");
	private BoardActions bo = null;
    private Timer timer;
    private int delay = 0;
    private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private JTextField txtDescription;
    private JTextField txtAttackpower;
    private JTextField txtDefensivepower;
    private JTextField txtLoottable;
    private JTextField txtMonsterDifficulty;
    private JTextField txtAlwaysdrop;
    private JTextField txtSymbol;
    private int numberOfPresses = 0;
	
	
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
    	    int key = e.getKeyCode();
    	    boolean characterScreen = false;
    	        	    
    	    if (e.getID() == KeyEvent.KEY_PRESSED){
	    	       	    	    
	    	    if (key == KeyEvent.VK_UP) {
	    	    	
	    	    	if(bo == null || characterScreen == true){
	    	    		
	    	    	}else{		    	    	
		    	    	gameText.setText("<center>"+bo.gameLoop("up")+"</center>");
		    	    	// call for monster movement here via boardactions
		    	    	
	    	    	}	
	    	    }	    
	
	    	    if (key == KeyEvent.VK_RIGHT) {    	    	
	    	    	
	    	    	if(bo == null || characterScreen == true){
	    	    		
	    	    	}else{		    	    	
	    	    		gameText.setText("<center>"+bo.gameLoop("right")+"</center>");
	    	    	}
	
	    	    }
	
	    	    if (key == KeyEvent.VK_DOWN) {	    	    	
	    	    	
	    	    	if(bo == null || characterScreen == true){
	    	    		
	    	    	}else{		    	    	
	    	    		gameText.setText("<center>"+bo.gameLoop("down")+"</center>");
	    	    	}
	
	    	    }
	    	    
	    	    if (key == KeyEvent.VK_LEFT) {	    	    	
	    	    	
	    	    	if(bo == null || characterScreen == true){
	    	    		
	    	    	}else{		    	    	
	    	    		gameText.setText("<center>"+bo.gameLoop("left")+"</center>");
	    	    	}
	
	    	    }
	    	    // look around and show mentionable items as text (eg. monster near player)
	    	    if (key == KeyEvent.VK_L || characterScreen == true){
	    	    	
	    	    	if(bo == null){
	    	    		
	    	    	}else{
	    	    		// make a function which shows interesting items around the player.
	    	    		//gameText.setText("<center>"+bo.gameLoop("l")+"</center>");
	    	    	}
	    	    	
	    	    }
	    	    
	    	    // move to character screen, disable other button presses 
	    	    if (key == KeyEvent.VK_C){
	    	    	
	    	    	// if even then move to character screen, if not move out of character screen.
	    	    	if((numberOfPresses & 1) == 0){
	    	    		characterScreen = true;
						CardLayout cl = (CardLayout)(differentScreens.getLayout());
					    cl.show(differentScreens, "CHARACTERSCREEN");
					    numberOfPresses++;
	    	    	}else{
	    	    		characterScreen = false;
						CardLayout cl = (CardLayout)(differentScreens.getLayout());
					    cl.show(differentScreens, "GAMESCREEN");
					    gameText.setText("<center>"+bo.gameLoop("c")+"</center>");
					    numberOfPresses++;
	    	    	}
	    	    	
	    	    }
    	    
    	    }
            return false;
        }
    }

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 450, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		differentScreens = new JPanel();
		contentPane.add(differentScreens);
		differentScreens.setLayout(new CardLayout(0, 0));
		
		JPanel mainMenu = new JPanel();
		differentScreens.add(mainMenu, "MAINMENU");
		mainMenu.setBackground(Color.BLACK);
		mainMenu.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		mainMenu.add(verticalStrut);
		
		JLabel GameNameLabel = new JLabel("Labyrinth");
		GameNameLabel.setFont(new Font("Sitka Small Bold", Font.PLAIN, 18));
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
				
				bo = new BoardActions();
				bo.setMazeSize(1);
				bo.initializeBoard();
				
			    gameText.setText("<center>You hear the maze door close behind you.<br>"
			    		+ "Press 'down arrow' to move into the maze.</center>");
				
				CardLayout cl = (CardLayout)(differentScreens.getLayout());
			    cl.show(differentScreens, "GAMESCREEN");
			    
//			    CardLayout cl = (CardLayout)(differentScreens.getLayout());
//			    cl.show(differentScreens, "COMBATSCREEN");
			    //enteringCombatAnimationLines();
			    //enteringCombatAnimationSquare();
			    //enteringCombatAnimationText();
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
		lblUseTheArrowkeys.setFont(new Font("Sitka Small Bold", Font.PLAIN, 18));
		controlTextPanel.add(lblUseTheArrowkeys);
		lblUseTheArrowkeys.setHorizontalAlignment(SwingConstants.CENTER);
		lblUseTheArrowkeys.setForeground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Press the L key to look around.");
		lblNewLabel.setFont(new Font("Sitka Small Bold", Font.PLAIN, 18));
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
		
		JButton Addmonsters = new JButton("Monsters DEV");
		Addmonsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    CardLayout cl = (CardLayout)(differentScreens.getLayout());
			    cl.show(differentScreens, "MONSTERDEVSCREEN");
			}
		});
		Addmonsters.setBounds(346, 36, 100, 23);
		controlsMenuButtons.add(Addmonsters);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		controls.add(verticalStrut_4);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		controls.add(verticalStrut_5);
		
		JPanel gameScreen = new JPanel();
		differentScreens.add(gameScreen, "GAMESCREEN");
		gameScreen.setBackground(Color.BLACK);
		gameScreen.setLayout(new GridLayout(0, 1, 0, 0));

	    gameText.setText("<center>Small<br>Medium</center>");

	    Font font = new Font("monospaced", Font.PLAIN, 18);
	    String bodyRule = "body { font-family: " + font.getFamily() + "; " + "font-size: " + 18 + "pt; " + "color : white; }";
	    ((HTMLDocument)gameText.getDocument()).getStyleSheet().addRule(bodyRule);
		
		gameText.setBackground(Color.BLACK);
		gameText.setEditable(false);
		gameScreen.add(gameText);
		
		JPanel combatScreen = new JPanel();
		differentScreens.add(combatScreen, "COMBATSCREEN");
		combatScreen.setBackground(Color.BLACK);
		combatScreen.setLayout(new GridLayout(0, 1, 0, 0));
		
		((HTMLDocument)combat.getDocument()).getStyleSheet().addRule(bodyRule);

		combat.setEditable(false);
		combat.setBackground(Color.BLACK);
		combatScreen.add(combat);
		
		JPanel AddMonstersDEVSCREEN = new JPanel();
		differentScreens.add(AddMonstersDEVSCREEN, "MONSTERDEVSCREEN");
		AddMonstersDEVSCREEN.setBackground(Color.BLACK);
		AddMonstersDEVSCREEN.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel monsterAttributes = new JPanel();
		monsterAttributes.setBackground(Color.BLACK);
		AddMonstersDEVSCREEN.add(monsterAttributes);
		monsterAttributes.setLayout(new GridLayout(0, 1, 0, 0));
		
		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtName.setText("");
			}
		});
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("NAME");
		monsterAttributes.add(txtName);
		txtName.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtDescription.setText("");
			}
		});
		txtDescription.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescription.setText("DESCRIPTION");
		monsterAttributes.add(txtDescription);
		txtDescription.setColumns(10);
		
		txtAttackpower = new JTextField();
		txtAttackpower.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtAttackpower.setText("");
			}
		});
		txtAttackpower.setHorizontalAlignment(SwingConstants.CENTER);
		txtAttackpower.setText("ATTACKPOWER");
		monsterAttributes.add(txtAttackpower);
		txtAttackpower.setColumns(10);
		
		txtDefensivepower = new JTextField();
		txtDefensivepower.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtDefensivepower.setText("");
			}
		});
		txtDefensivepower.setText("DEFENSIVEPOWER");
		txtDefensivepower.setHorizontalAlignment(SwingConstants.CENTER);
		txtDefensivepower.setColumns(10);
		monsterAttributes.add(txtDefensivepower);
		
		txtLoottable = new JTextField();
		txtLoottable.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtLoottable.setText("");
			}
		});
		txtLoottable.setText("LOOT TABLE");
		txtLoottable.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoottable.setColumns(10);
		monsterAttributes.add(txtLoottable);
		
		txtMonsterDifficulty = new JTextField();
		txtMonsterDifficulty.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtMonsterDifficulty.setText("");
			}
		});
		txtMonsterDifficulty.setText("MONSTER DIFFICULTY");
		txtMonsterDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonsterDifficulty.setColumns(10);
		monsterAttributes.add(txtMonsterDifficulty);
		
		txtAlwaysdrop = new JTextField();
		txtAlwaysdrop.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtAlwaysdrop.setText("");
			}
		});
		txtAlwaysdrop.setText("ALWAYSDROP");
		txtAlwaysdrop.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlwaysdrop.setColumns(10);
		monsterAttributes.add(txtAlwaysdrop);
		
		txtSymbol = new JTextField();
		txtSymbol.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtSymbol.setText("");
			}
		});
		txtSymbol.setText("SYMBOL");
		txtSymbol.setHorizontalAlignment(SwingConstants.CENTER);
		txtSymbol.setColumns(10);
		monsterAttributes.add(txtSymbol);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(null);
		buttons.setBackground(Color.BLACK);
		AddMonstersDEVSCREEN.add(buttons);
		
		JButton btnAddToFile = new JButton("add to file");
		btnAddToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonsterFileWork monsters = new MonsterFileWork();
				monsters.setName(txtName.getText());
				monsters.setDescription(txtDescription.getText());
				monsters.setAttackPower(Integer.parseInt(txtAttackpower.getText()));
				monsters.setDefensivePower(Integer.parseInt(txtDefensivepower.getText()));
				monsters.setLootTable(Integer.parseInt(txtLoottable.getText()));
				monsters.setMonsterDifficulty(Integer.parseInt(txtMonsterDifficulty.getText()));
				monsters.setMonsterAlwaysDrop(Integer.parseInt(txtAlwaysdrop.getText()));
				monsters.setMonsterSymbol(txtSymbol.getText());
				monsters.addMonster();
				
				JOptionPane.showMessageDialog(AddMonstersDEVSCREEN ,"Monster added!");
				
			}
		});
		btnAddToFile.setBounds(347, 79, 100, 23);
		buttons.add(btnAddToFile);
		
		JPanel inventory = new JPanel();
		inventory.setBackground(Color.BLACK);
		differentScreens.add(inventory, "INVENTORYSCREEN");
		inventory.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		inventory.add(verticalStrut_6);
		
		JLabel label = new JLabel("Labyrinth");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		inventory.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		inventory.add(panel_1);
		
		JButton button = new JButton("");
		button.setSize(new Dimension(100, 30));
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(346, 0, 100, 30);
		panel_1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setSize(new Dimension(100, 30));
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(346, 41, 100, 30);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setSize(new Dimension(100, 30));
		button_2.setOpaque(false);
		button_2.setFocusPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBounds(346, 82, 100, 30);
		panel_1.add(button_2);
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		inventory.add(verticalStrut_7);
		
		Component verticalStrut_8 = Box.createVerticalStrut(20);
		inventory.add(verticalStrut_8);
		
		JPanel characterScreen = new JPanel();
		characterScreen.setBackground(Color.BLACK);
		differentScreens.add(characterScreen, "CHARACTERSCREEN");
		characterScreen.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component verticalStrut_9 = Box.createVerticalStrut(20);
		characterScreen.add(verticalStrut_9);
		
		JLabel label_1 = new JLabel("Labyrinth");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		characterScreen.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		characterScreen.add(panel_2);
		
		JButton button_3 = new JButton("");
		button_3.setSize(new Dimension(100, 30));
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setBounds(346, 0, 100, 30);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setSize(new Dimension(100, 30));
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setBounds(346, 41, 100, 30);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setSize(new Dimension(100, 30));
		button_5.setOpaque(false);
		button_5.setFocusPainted(false);
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);
		button_5.setBounds(346, 82, 100, 30);
		panel_2.add(button_5);
		
		Component verticalStrut_10 = Box.createVerticalStrut(20);
		characterScreen.add(verticalStrut_10);
		
		Component verticalStrut_11 = Box.createVerticalStrut(20);
		characterScreen.add(verticalStrut_11);

	}
	// Animation with lines when moving to combat
	public void enteringCombatAnimationLines(){
		int x = bo.getXSizeFromBoard();
		int y = bo.getYSizeFromBoard();
		
        ActionListener action = new ActionListener()
        {   
        	int size = x * y;
        	String animation = "";

        	int currentX = 0;
        	
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(size == 0)
                {
                    timer.stop();
                    try {
                        Thread.sleep(1000);
                      combat.setText(""); // end of animation
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                else
                {
       	
					if(currentX == 0){
                		animation = animation + "<center>/"; //when we start a line, center text
                		currentX++;
                	}else{
                		if(currentX == x-1){
                			animation = animation + "/<br></center>"; // when we reach end of line, put line break and end centering
                			currentX = 0;                			
                		}else{
                			animation = animation + "/"; // when not a the end or at the beginning, just put /
                			currentX++;
                		}
                	}

    				combat.setText(animation);                	
                    size--;
                }
            }
        };

        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();        

	}
	
	// Animation with square when moving to combat
	public void enteringCombatAnimationSquare(){
		int x = bo.getXSizeFromBoard();
		int y = bo.getYSizeFromBoard();
		
        ActionListener action = new ActionListener()
        {   
        	int size = x * y;
        	String animation = "";
        	String textToShow = "~";
        	
        	int currentX = 0;
        	int currentY = 0;
        	int currentLetter = 0;
        	
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(size == 0)
                {
                    timer.stop();                   
                    try {
                        Thread.sleep(1000);
                        combat.setText(""); // end of animation
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                else
                {
       	
					if(currentX == 0){
                		animation = animation + "<center>#"; //when we start a line, center text
                		currentX++;
                	}else{
                		if(currentX == x-1){
                			animation = animation + "#<br></center>"; // when we reach end of line, put line break and end centering
                			currentX = 0;
                			currentY++;
                		}else{
                			
                			// if currentY is 0 or y-1, then we make the edges of the square otherwise print a letter
                			if(currentY == 0 || currentY == y-1){
                				animation = animation + "#";
                			}else{               			
                			
	                			if(currentLetter < textToShow.length()){
	                				animation = animation + textToShow.charAt(currentLetter);
	                				currentLetter++;
	                			}else{
	                				currentLetter = 0;
	                				animation = animation + textToShow.charAt(currentLetter);
	                			}
                			
                			}
                			currentX++;
                		}
                	}

    				combat.setText(animation);                	
                    size--;
                }
            }
        };

        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();        

	}
	
	// Animation with square when moving to combat
	public void enteringCombatAnimationText(){
		int x = bo.getXSizeFromBoard();
		int y = bo.getYSizeFromBoard();
		
        ActionListener action = new ActionListener()
        {   
        	int size = x * y;
        	String animation = "<center>";
        	String textToShow = "..........**********";
        	
        	int currentX = 0;
        	int currentY = 0;
        	int currentLetter = 0;
        	
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(size == 0){
                	timer.stop();                   
                    try {
                        Thread.sleep(1000);
                        combat.setText(""); // end of animation
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }else{
        			if(currentLetter < textToShow.length()){
        				animation = animation + textToShow.charAt(currentLetter);
        				currentLetter++;
        				currentX++;
        			}else{
        				currentLetter = 0;
        				currentX++;
        				animation = animation + textToShow.charAt(currentLetter);
        				currentLetter++;
        			}
        			
        			if(currentX == x){
        				animation = animation + "<br>";
        				currentX = 0;
        				currentY++;
        			}
        			
        			if(currentY == y){
        				animation = animation + "</center>";
        			}        			

    				combat.setText(animation);                	
                    size--;
                }
            }
        };

        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();        

	}
}
