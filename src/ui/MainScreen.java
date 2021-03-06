package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.HeadlessException;
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
import game.Combat;
import game.Monster;
import game.MonsterActions;
import game.MonsterFileWork;
import game.PlayerCharacter;

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
import java.util.Random;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

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
    private JTextField txtWriteCharacterName;
    private PlayerCharacter playerCharacter = new PlayerCharacter();
    private JLabel pointsLeftLabel;
	private JButton plusHealthButton;
	private JButton minusHealthButton;
	private JButton plusAttackButton;
	private JButton minusAttackButton;
	private JButton plusMagicAttackButton;
	private JButton minusMagicAttackButton;
	private JButton plusDefenseButton;
	private JButton minusDefenseButton;
	private JButton plusMagicDefenseButton;
	private JButton minusMagicDefenseButton;
	private JButton startGameWithChar;
	private JLabel lblHvalue;	
	private JLabel lblAvalue;	
	private JLabel lblMAvalue;	
	private JLabel lblDvalue;	
	private JLabel lblMDvalue;
	private boolean inCombat = false;
	private JTextField txtHealth;
	private Combat c = new Combat();
	private String [][] monsterDatabase;
	private Monster monster = new Monster();
	private int shieldBuffCounter = 0;
	private JLabel lblEnemyName = new JLabel("New label");
	
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
	    	    		
	    	    		// if in combat, arrowkeys control combat ui instead of game ui
	    	    		if(inCombat == true){
	    	    			// CONTROL COMBAT UI HERE
	    	    		}else{	    	    		
	    	    			gameText.setText("<center>"+bo.gameLoop("up")+"</center>");
	    	    		}
	    	    	}	
	    	    }	    
	
	    	    if (key == KeyEvent.VK_RIGHT) {    	    	
	    	    	
	    	    	if(bo == null || characterScreen == true){
	    	    		
	    	    	}else{
	    	    		// if in combat, arrowkeys control combat ui instead of game ui
	    	    		if(inCombat == true){
	    	    			// CONTROL COMBAT UI HERE
	    	    		}else{	 
	    	    			gameText.setText("<center>"+bo.gameLoop("right")+"</center>");
	    	    		}
	    	    	}
	
	    	    }
	
	    	    if (key == KeyEvent.VK_DOWN) {	    	    	
	    	    	
	    	    	if(bo == null || characterScreen == true){
	    	    		
	    	    	}else{
	    	    		// if in combat, arrowkeys control combat ui instead of game ui
	    	    		if(inCombat == true){
	    	    			// CONTROL COMBAT UI HERE
	    	    		}else{	 
	    	    			gameText.setText("<center>"+bo.gameLoop("down")+"</center>");
	    	    		}
	    	    	}
	
	    	    }
	    	    
	    	    if (key == KeyEvent.VK_LEFT) {	    	    	
	    	    	
	    	    	if(bo == null || characterScreen == true){
	    	    		
	    	    	}else{
	    	    		// if in combat, arrowkeys control combat ui instead of game ui
	    	    		if(inCombat == true){
	    	    			// CONTROL COMBAT UI HERE
	    	    		}else{	 
	    	    			gameText.setText("<center>"+bo.gameLoop("left")+"</center>");
	    	    		}
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
	    	    	
    	    		// if in combat, arrowkeys control combat ui instead of game ui
    	    		if(inCombat == true){
    	    			// do nothing, c key is not used in combat
    	    		}else{	
	    	    	
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
	    	    
	    	    // move to inventory screen, disable buttons besides character and invetory
	    	    if (key == KeyEvent.VK_I){
	    	    	
    	    		// if in combat, arrowkeys control combat ui instead of game ui
    	    		if(inCombat == true){
    	    			// Do nothing, I key is not used in combat.
    	    		}else{
	    	    	
		    	    	// if even then move to character screen, if not move out of character screen.
		    	    	if((numberOfPresses & 1) == 0){
		    	    		characterScreen = true;
							CardLayout cl = (CardLayout)(differentScreens.getLayout());
						    cl.show(differentScreens, "INVENTORYSCREEN");
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
    	    
    	    }
    	    
    	    // check if a monster is near player, if it is move to combat.    	    
    	    if(bo.monsterNear() == true){
    	    	// randomly use one of the three moving to combat animations and then move to combat screen.
    	    	// remember to disable button presses for combat.
    	    	
    	    	inCombat = true;
    	    	
    	    	Random rand = new Random();
    	    	
    	    	int randomAnimation = rand.nextInt(2);
				CardLayout cl = (CardLayout)(differentScreens.getLayout());
    	    	
//				int x = 0;
//						
//				while(x<100){
//					System.out.println(monsterDatabase[0][x]);
//					x++;
//				}
				
				
    	    	switch(randomAnimation){
    	    		case 0:
    	    			// animations bugged atm
//    	    			cl.show(differentScreens, "COMBATSCREEN");
//    	    			enteringCombatAnimationLines();
    	    			
    	    			// combat
    	    			//cl.show(differentScreens, "ACTUALCOMBATSCREEN");
    	    			
    	    			int i = 0;    	    			
    	    			boolean found = false;
    	    			
    	    			while(found == false){
    	    				
    	    				// if monster in database is same as on board
    	    				// up stats to monster class for combat. 				
    	    				
    	    				System.out.println(i);
    	    				
    	    				System.out.println(monsterDatabase[i][7] + " and " + bo.getMonsterSymbol());
    	    				
    	    				if(monsterDatabase[i][7].equals(bo.getMonsterSymbol())){ 
    	    					
    	    					monster.setName(monsterDatabase[i][0]);
    	    					monster.setDesc(monsterDatabase[i][1]);
    	    					monster.setAP(Integer.parseInt(monsterDatabase[i][2]));
    	    					monster.setDP(Integer.parseInt(monsterDatabase[i][3]));
    	    					monster.setLootTable(Integer.parseInt(monsterDatabase[i][4]));
    	    					monster.setMonsterDiff(Integer.parseInt(monsterDatabase[i][5]));
    	    					monster.setAlwaysDrop(Integer.parseInt(monsterDatabase[i][6]));
    	    					monster.setSymbol(monsterDatabase[i][7]);
    	    					monster.setHealth(Integer.parseInt(monsterDatabase[i][8]));
    	    					monster.setxCoord(bo.monsterFoundCoordinateX());
    	    					monster.setyCoord(bo.monsterFoundCoordinateY());
    	    					
    	    					lblEnemyName.setText(monster.getName());
    	    					
    	    					found = true;
    	    					break;
    	    				}
    	    				i++;
    	    			}
    	    			
    	    			
					    break;
    	    		case 1:
//    	    			cl.show(differentScreens, "COMBATSCREEN");
//    	    			enteringCombatAnimationSquare();
    	    			// combat
    	    			//cl.show(differentScreens, "ACTUALCOMBATSCREEN");

    	    			int i1 = 0;    	    			
    	    			boolean found1 = false;
    	    			
    	    			while(found1 == false){
    	    				// if monster in database is same as on board
    	    				// up stats to monster class for combat.
    	    				
    	    				System.out.println(i1);
    	    				
    	    				System.out.println(monsterDatabase[i1][7] + " and " + bo.getMonsterSymbol());
    	    				
    	    				if(monsterDatabase[i1][7].equals(bo.getMonsterSymbol())){
    	    					
    	    					monster.setName(monsterDatabase[i1][0]);
    	    					monster.setDesc(monsterDatabase[i1][1]);
    	    					monster.setAP(Integer.parseInt(monsterDatabase[i1][2]));
    	    					monster.setDP(Integer.parseInt(monsterDatabase[i1][3]));
    	    					monster.setLootTable(Integer.parseInt(monsterDatabase[i1][4]));
    	    					monster.setMonsterDiff(Integer.parseInt(monsterDatabase[i1][5]));
    	    					monster.setAlwaysDrop(Integer.parseInt(monsterDatabase[i1][6]));
    	    					monster.setSymbol(monsterDatabase[i1][7]);
    	    					monster.setHealth(Integer.parseInt(monsterDatabase[i1][8]));
    	    					monster.setxCoord(bo.monsterFoundCoordinateX());
    	    					monster.setyCoord(bo.monsterFoundCoordinateY());
    	    					    	    			
    	    					lblEnemyName.setText(monster.getName());
    	    					
    	    					found1 = true;
    	    					break;
    	    				}
    	    				i1++;
    	    			}
	
    	    			break;
    	    		case 2:
//    	    			cl.show(differentScreens, "COMBATSCREEN");
//    	    			enteringCombatAnimationText();
    	    			// combat
    	    			//cl.show(differentScreens, "ACTUALCOMBATSCREEN");
    	    			
    	    			int i11 = 0;    	    			
    	    			boolean found11 = false;
    	    			
    	    			while(found11 == false){
    	    				
    	    				System.out.println(i11);
    	    				// monster symbol does not get the right symbol, gives floor......
    	    				System.out.println(monsterDatabase[i11][7] + " and " + bo.getMonsterSymbol());
    	    				
    	    				// if monster in database is same as on board
    	    				// up stats to monster class for combat.
    	    				if(monsterDatabase[i11][7].equals(bo.getMonsterSymbol())){
    	    					
    	    					monster.setName(monsterDatabase[i11][0]);
    	    					monster.setDesc(monsterDatabase[i11][1]);
    	    					monster.setAP(Integer.parseInt(monsterDatabase[i11][2]));
    	    					monster.setDP(Integer.parseInt(monsterDatabase[i11][3]));
    	    					monster.setLootTable(Integer.parseInt(monsterDatabase[i11][4]));
    	    					monster.setMonsterDiff(Integer.parseInt(monsterDatabase[i11][5]));
    	    					monster.setAlwaysDrop(Integer.parseInt(monsterDatabase[i11][6]));
    	    					monster.setSymbol(monsterDatabase[i11][7]);
    	    					monster.setHealth(Integer.parseInt(monsterDatabase[i11][8]));
    	    					monster.setxCoord(bo.monsterFoundCoordinateX());
    	    					monster.setyCoord(bo.monsterFoundCoordinateY());
    	    					    	    	
    	    					lblEnemyName.setText(monster.getName());
    	    					
    	    					found11 = true;
    	    					break;
    	    				}
    	    				i11++;
    	    			}
    	    			
    	    			break;
    	    			
    	    			//when player or enemy health reaches zero set combat to false and either move back to the board or show gameover screen.
    	    			//inCombat = false; // combat finished, move out of combat
    	    			
    	    	}
    	    	
    	    	
    	    	
    	    }else{
    	    	
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
        
        // ininitalize a default character
        playerCharacter.initializeCharacter();
        MonsterFileWork mon = new MonsterFileWork();
        monsterDatabase = mon.getAllMonsters(); // needed when attacking monsters
        
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
				
				CardLayout cl = (CardLayout)(differentScreens.getLayout());
			    cl.show(differentScreens, "CHARACTERSCREEN");				

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
		
		JLabel lblPressTheI = new JLabel("Press the \"i\" key to move to inventory.");
		lblPressTheI.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressTheI.setForeground(Color.WHITE);
		lblPressTheI.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		controlTextPanel.add(lblPressTheI);
		
		JLabel lblPressTheC = new JLabel("Press the \"c\" key to move to character screen.");
		lblPressTheC.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressTheC.setForeground(Color.WHITE);
		lblPressTheC.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		controlTextPanel.add(lblPressTheC);
		
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
		
		JPanel combatScreenTransition = new JPanel();
		differentScreens.add(combatScreenTransition, "COMBATSCREEN");
		combatScreenTransition.setBackground(Color.BLACK);
		combatScreenTransition.setLayout(new GridLayout(0, 1, 0, 0));
		
		((HTMLDocument)combat.getDocument()).getStyleSheet().addRule(bodyRule);

		combat.setEditable(false);
		combat.setBackground(Color.BLACK);
		combatScreenTransition.add(combat);
		
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
		
		txtHealth = new JTextField();
		txtHealth.setText("HEALTH");
		txtHealth.setHorizontalAlignment(SwingConstants.CENTER);
		txtHealth.setColumns(10);
		monsterAttributes.add(txtHealth);
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
				monsters.setHealth(Integer.parseInt(txtHealth.getText()));
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
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventory.setForeground(Color.WHITE);
		lblInventory.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		inventory.add(lblInventory);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		inventory.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox Head = new JComboBox();
		Head.setMaximumSize(new Dimension(100, 20));
		Head.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                String currentlyChosen =  (String) Head.getSelectedItem();
                int index = Head.getSelectedIndex(); // index is same in playercharacter and in inventory screen
                int attackOrDefenseOfItem = Integer.parseInt(playerCharacter.getHead()[index][1]);
                
                // add new value to item
                playerCharacter.setDefense(playerCharacter.getDefense() + attackOrDefenseOfItem);
                    
			}
		});
		panel_1.add(Head);
		
		JComboBox Chest = new JComboBox();
		Chest.setMaximumSize(new Dimension(100, 20));
		Chest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                String currentlyChosen =  (String) Chest.getSelectedItem();
                int index = Chest.getSelectedIndex(); // index is same in playercharacter and in inventory screen
                int attackOrDefenseOfItem = Integer.parseInt(playerCharacter.getChest()[index][1]);
                
                // add new value to item
                playerCharacter.setDefense(playerCharacter.getDefense() + attackOrDefenseOfItem);
			}
		});
		panel_1.add(Chest);
		
		JComboBox Pants = new JComboBox();
		Pants.setMaximumSize(new Dimension(100, 20));
		Pants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                String currentlyChosen =  (String) Pants.getSelectedItem();
                int index = Pants.getSelectedIndex(); // index is same in playercharacter and in inventory screen
                int attackOrDefenseOfItem = Integer.parseInt(playerCharacter.getPants()[index][1]);
                
                // add new value to item
                playerCharacter.setDefense(playerCharacter.getDefense() + attackOrDefenseOfItem);
			}
		});
		panel_1.add(Pants);
		
		JComboBox Feet = new JComboBox();
		Feet.setMaximumSize(new Dimension(100, 20));
		Feet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                String currentlyChosen =  (String) Feet.getSelectedItem();
                int index = Feet.getSelectedIndex(); // index is same in playercharacter and in inventory screen
                int attackOrDefenseOfItem = Integer.parseInt(playerCharacter.getFeet()[index][1]);
                
                // add new value to item
                playerCharacter.setDefense(playerCharacter.getDefense() + attackOrDefenseOfItem);
			}
		});
		panel_1.add(Feet);
		
		JComboBox Hands = new JComboBox();
		Hands.setMaximumSize(new Dimension(100, 20));
		Hands.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                String currentlyChosen =  (String) Hands.getSelectedItem();
                int index = Hands.getSelectedIndex(); // index is same in playercharacter and in inventory screen
                int attackOrDefenseOfItem = Integer.parseInt(playerCharacter.getHands()[index][1]);
                
                // add new value to item
                playerCharacter.setDefense(playerCharacter.getDefense() + attackOrDefenseOfItem);
			}
		});
		panel_1.add(Hands);
		
		JComboBox Mainhand = new JComboBox();
		Mainhand.setMaximumSize(new Dimension(100, 20));
		Mainhand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                String currentlyChosen =  (String) Mainhand.getSelectedItem();
                int index = Mainhand.getSelectedIndex(); // index is same in playercharacter and in inventory screen
                int attackOrDefenseOfItem = Integer.parseInt(playerCharacter.getMainHand()[index][1]);
                
                // add new value to item
                playerCharacter.setAttack(playerCharacter.getAttack() + attackOrDefenseOfItem);
			}
		});
		panel_1.add(Mainhand);
		
		JComboBox Off_hand = new JComboBox();
		Off_hand.setMaximumSize(new Dimension(100, 20));
		Off_hand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                String currentlyChosen =  (String) Off_hand.getSelectedItem();
                int index = Off_hand.getSelectedIndex(); // index is same in playercharacter and in inventory screen
                int attackOrDefenseOfItem = Integer.parseInt(playerCharacter.getOffHand()[index][1]);
                
                // add new value to item
                playerCharacter.setDefense(playerCharacter.getDefense() + attackOrDefenseOfItem);
			}
		});
		panel_1.add(Off_hand);
		
		JEditorPane MiscItems = new JEditorPane();
		panel_1.add(MiscItems);
		
		addItemsToSlot(Head,playerCharacter.getHead());
		addItemsToSlot(Chest,playerCharacter.getChest());
		addItemsToSlot(Pants,playerCharacter.getPants());
		addItemsToSlot(Feet,playerCharacter.getFeet());
		addItemsToSlot(Hands,playerCharacter.getHands());
		addItemsToSlot(Mainhand,playerCharacter.getMainHand());
		addItemsToSlot(Off_hand,playerCharacter.getOffHand());		
		
		Component verticalStrut_8 = Box.createVerticalStrut(20);
		inventory.add(verticalStrut_8);
		
		JPanel characterScreen = new JPanel();
		characterScreen.setBackground(Color.BLACK);
		differentScreens.add(characterScreen, "CHARACTERSCREEN");
		characterScreen.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel characterName = new JPanel();
		characterName.setBackground(Color.BLACK);
		characterScreen.add(characterName);
		characterName.setLayout(new GridLayout(0, 5, 0, 0));
		
		txtWriteCharacterName = new JTextField();
		txtWriteCharacterName.setBorder(null);
		txtWriteCharacterName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtWriteCharacterName.setText("");
			}
		});
		txtWriteCharacterName.setForeground(Color.WHITE);
		txtWriteCharacterName.setBackground(Color.BLACK);
		txtWriteCharacterName.setHorizontalAlignment(SwingConstants.CENTER);
		txtWriteCharacterName.setText("Write Character Name Here");
		txtWriteCharacterName.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		characterScreen.add(txtWriteCharacterName);
		txtWriteCharacterName.setColumns(1);
		
		JPanel characterStatNames = new JPanel();
		characterStatNames.setBackground(Color.BLACK);
		characterScreen.add(characterStatNames);
		characterStatNames.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblHealth = new JLabel("Health");
		lblHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth.setForeground(Color.WHITE);
		lblHealth.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		characterStatNames.add(lblHealth);
		
		JLabel lblAttack = new JLabel("Attack");
		characterStatNames.add(lblAttack);
		lblAttack.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttack.setForeground(Color.WHITE);
		lblAttack.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		
		JLabel lblMagicAttack = new JLabel("Magic Attack");
		lblMagicAttack.setHorizontalAlignment(SwingConstants.CENTER);
		lblMagicAttack.setForeground(Color.WHITE);
		lblMagicAttack.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		characterStatNames.add(lblMagicAttack);
		
		JLabel lblDefense = new JLabel("Defense");
		lblDefense.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefense.setForeground(Color.WHITE);
		lblDefense.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		characterStatNames.add(lblDefense);
		
		JLabel lblMagicdefense = new JLabel("Magic Defense");
		lblMagicdefense.setHorizontalAlignment(SwingConstants.CENTER);
		lblMagicdefense.setForeground(Color.WHITE);
		lblMagicdefense.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		characterStatNames.add(lblMagicdefense);
		
		lblHvalue = new JLabel(Integer.toString(playerCharacter.getHealth()));
		characterStatNames.add(lblHvalue);
		lblHvalue.setHorizontalAlignment(SwingConstants.CENTER);
		lblHvalue.setForeground(Color.WHITE);
		lblHvalue.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		
		lblAvalue = new JLabel(Integer.toString(playerCharacter.getAttack()));
		characterStatNames.add(lblAvalue);
		lblAvalue.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvalue.setForeground(Color.WHITE);
		lblAvalue.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		
		lblMAvalue = new JLabel(Integer.toString(playerCharacter.getMagicAttack()));
		characterStatNames.add(lblMAvalue);
		lblMAvalue.setHorizontalAlignment(SwingConstants.CENTER);
		lblMAvalue.setForeground(Color.WHITE);
		lblMAvalue.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		
		lblDvalue = new JLabel(Integer.toString(playerCharacter.getDefense()));
		characterStatNames.add(lblDvalue);
		lblDvalue.setHorizontalAlignment(SwingConstants.CENTER);
		lblDvalue.setForeground(Color.WHITE);
		lblDvalue.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		
		lblMDvalue = new JLabel(Integer.toString(playerCharacter.getMagicDefense()));
		characterStatNames.add(lblMDvalue);
		lblMDvalue.setHorizontalAlignment(SwingConstants.CENTER);
		lblMDvalue.setForeground(Color.WHITE);
		lblMDvalue.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		
		JPanel increaseAndDecrease = new JPanel();
		increaseAndDecrease.setBackground(Color.BLACK);
		characterScreen.add(increaseAndDecrease);
		increaseAndDecrease.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 11, 141, 50);
		increaseAndDecrease.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		plusHealthButton = new JButton("");
		plusHealthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// points added to health button, enable minus health button
	        	minusHealthButton.setEnabled(true);
	        	
	        	// remove one point from the pool
		        playerCharacter.setPointsLeft(playerCharacter.getPointsLeft()-1);
		        pointsLeftLabel.setText("Points left: "+playerCharacter.getPointsLeft());
		        
		        // add the point to chosen attribute
		        playerCharacter.setHealth(playerCharacter.getHealth()+5); // health changes in increments of 5 per point.
		        lblHvalue.setText(Integer.toString(playerCharacter.getHealth()));
		        		        
		        // if all points have been used, disable plus buttons
		        if(playerCharacter.getPointsLeft() == 0){		        	
		        	plusHealthButton.setEnabled(false);
		        	plusAttackButton.setEnabled(false);
		        	plusMagicAttackButton.setEnabled(false);
		        	plusDefenseButton.setEnabled(false);
		        	plusMagicDefenseButton.setEnabled(false);
		        	
		        }
	        
		        // if all points are spent and name has been given enable start button
		        if(playerCharacter.getName() != null && playerCharacter.getPointsLeft() == 0){
		        	startGameWithChar.setEnabled(true);
		        }else{
		        	startGameWithChar.setEnabled(false);
		        }
				
			}
		});
		panel.add(plusHealthButton);
		plusHealthButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/plus_30_pressed.png")));
		plusHealthButton.setIcon(new ImageIcon(MainScreen.class.getResource("/plus_30.png")));
		plusHealthButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/plus_30_rollover.png")));
		plusHealthButton.setOpaque(false);
		plusHealthButton.setFocusPainted(false);
		plusHealthButton.setContentAreaFilled(false);
		plusHealthButton.setBorderPainted(false);
		
		minusHealthButton = new JButton("");
		minusHealthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		        // if health is reduced to minimum, disable minus button.
		        if(playerCharacter.getMinHealth() == playerCharacter.getHealth()-5){
		        	minusHealthButton.setEnabled(false);
		        }else{

					// disable start button
					startGameWithChar.setEnabled(false);
					
					// more points are added to the pool, activate plus buttons
		        	plusHealthButton.setEnabled(true);
		        	plusAttackButton.setEnabled(true);
		        	plusMagicAttackButton.setEnabled(true);
		        	plusDefenseButton.setEnabled(true);
		        	plusMagicDefenseButton.setEnabled(true);
				
			        playerCharacter.setPointsLeft(playerCharacter.getPointsLeft()+1);
			        pointsLeftLabel.setText("Points left: "+playerCharacter.getPointsLeft());
			        
			        playerCharacter.setHealth(playerCharacter.getHealth()-5); // health changes in increments of 5 per point.
			        lblHvalue.setText(Integer.toString(playerCharacter.getHealth()));
			        		        
			        // if all points are refunded, disable minus buttons
			        if(playerCharacter.getPointsLeft() == playerCharacter.getPointsToUse()){
			        	minusHealthButton.setEnabled(false);
			        	minusAttackButton.setEnabled(false);
			        	minusMagicAttackButton.setEnabled(false);
			        	minusDefenseButton.setEnabled(false);
			        	minusMagicDefenseButton.setEnabled(false);
			        }
		        }
		        
			}
		});
		panel.add(minusHealthButton);
		minusHealthButton.setIcon(new ImageIcon(MainScreen.class.getResource("/minus_30.png")));
		minusHealthButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/minus_30_pressed.png")));
		minusHealthButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/minus_30_rollover.png")));
		minusHealthButton.setOpaque(false);
		minusHealthButton.setFocusPainted(false);
		minusHealthButton.setContentAreaFilled(false);
		minusHealthButton.setBorderPainted(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(166, 11, 141, 50);
		increaseAndDecrease.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		plusAttackButton = new JButton("");
		plusAttackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// points added to button, enable minus button
	        	minusAttackButton.setEnabled(true);
	        	
	        	// remove one point from the pool
		        playerCharacter.setPointsLeft(playerCharacter.getPointsLeft()-1);
		        pointsLeftLabel.setText("Points left: "+playerCharacter.getPointsLeft());
		        
		        // add the point to chosen attribute
		        playerCharacter.setAttack(playerCharacter.getAttack()+1); // health changes in increments of 5 per point.
		        lblAvalue.setText(Integer.toString(playerCharacter.getAttack()));
		        		        
		        // if all points have been used, disable plus buttons
		        if(playerCharacter.getPointsLeft() == 0){		        	
		        	plusHealthButton.setEnabled(false);
		        	plusAttackButton.setEnabled(false);
		        	plusMagicAttackButton.setEnabled(false);
		        	plusDefenseButton.setEnabled(false);
		        	plusMagicDefenseButton.setEnabled(false);
		        	
		        }
		        
		        // if all points are spent and name has been given enable start button
		        if(playerCharacter.getName() != null && playerCharacter.getPointsLeft() == 0){
		        	startGameWithChar.setEnabled(true);
		        }else{
		        	startGameWithChar.setEnabled(false);
		        }
				
			}
		});
		plusAttackButton.setIcon(new ImageIcon(MainScreen.class.getResource("/plus_30.png")));
		plusAttackButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/plus_30_pressed.png")));
		plusAttackButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/plus_30_rollover.png")));
		plusAttackButton.setOpaque(false);
		plusAttackButton.setFocusPainted(false);
		plusAttackButton.setContentAreaFilled(false);
		plusAttackButton.setBorderPainted(false);
		panel_2.add(plusAttackButton);
		
		minusAttackButton = new JButton("");
		minusAttackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        // if attack is reduced to minimum, disable minus button.
		        if(playerCharacter.getMinAttack() == playerCharacter.getAttack()-1){
		        	minusAttackButton.setEnabled(false);
		        }else{
					
					// disable start button
					startGameWithChar.setEnabled(false);
					
					// more points are added to the pool, activate plus buttons
		        	plusHealthButton.setEnabled(true);
		        	plusAttackButton.setEnabled(true);
		        	plusMagicAttackButton.setEnabled(true);
		        	plusDefenseButton.setEnabled(true);
		        	plusMagicDefenseButton.setEnabled(true);
					
			        playerCharacter.setPointsLeft(playerCharacter.getPointsLeft()+1);
			        pointsLeftLabel.setText("Points left: "+playerCharacter.getPointsLeft());
			        
			        playerCharacter.setAttack(playerCharacter.getAttack()-1);
			        lblAvalue.setText(Integer.toString(playerCharacter.getAttack()));
			        		        
			        // if all points are refunded, disable minus buttons
			        if(playerCharacter.getPointsLeft() == playerCharacter.getPointsToUse()){
			        	minusHealthButton.setEnabled(false);
			        	minusAttackButton.setEnabled(false);
			        	minusMagicAttackButton.setEnabled(false);
			        	minusDefenseButton.setEnabled(false);
			        	minusMagicDefenseButton.setEnabled(false);
			        }
		        }
			}
		});
		minusAttackButton.setIcon(new ImageIcon(MainScreen.class.getResource("/minus_30.png")));
		minusAttackButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/minus_30_pressed.png")));
		minusAttackButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/minus_30_rollover.png")));
		minusAttackButton.setOpaque(false);
		minusAttackButton.setFocusPainted(false);
		minusAttackButton.setContentAreaFilled(false);
		minusAttackButton.setBorderPainted(false);
		panel_2.add(minusAttackButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(324, 11, 141, 50);
		increaseAndDecrease.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		plusMagicAttackButton = new JButton("");
		plusMagicAttackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// points added to button, enable minus button
	        	minusMagicAttackButton.setEnabled(true);
	        	
	        	// remove one point from the pool
		        playerCharacter.setPointsLeft(playerCharacter.getPointsLeft()-1);
		        pointsLeftLabel.setText("Points left: "+playerCharacter.getPointsLeft());
		        
		        // add the point to chosen attribute
		        playerCharacter.setMagicAttack(playerCharacter.getMagicAttack()+1); // health changes in increments of 5 per point.
		        lblMAvalue.setText(Integer.toString(playerCharacter.getMagicAttack()));
		        		        
		        // if all points have been used, disable plus buttons
		        if(playerCharacter.getPointsLeft() == 0){		        	
		        	plusHealthButton.setEnabled(false);
		        	plusAttackButton.setEnabled(false);
		        	plusMagicAttackButton.setEnabled(false);
		        	plusDefenseButton.setEnabled(false);
		        	plusMagicDefenseButton.setEnabled(false);
		        	
		        }
		        
		        // if all points are spent and name has been given enable start button
		        if(playerCharacter.getName() != null && playerCharacter.getPointsLeft() == 0){
		        	startGameWithChar.setEnabled(true);
		        }else{
		        	startGameWithChar.setEnabled(false);
		        }
			}
		});
		plusMagicAttackButton.setIcon(new ImageIcon(MainScreen.class.getResource("/plus_30.png")));
		plusMagicAttackButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/plus_30_pressed.png")));
		plusMagicAttackButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/plus_30_rollover.png")));
		plusMagicAttackButton.setOpaque(false);
		plusMagicAttackButton.setFocusPainted(false);
		plusMagicAttackButton.setContentAreaFilled(false);
		plusMagicAttackButton.setBorderPainted(false);
		panel_3.add(plusMagicAttackButton);
		
		minusMagicAttackButton = new JButton("");
		minusMagicAttackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        
		        // if magic attack is reduced to minimum, disable minus button.
		        if(playerCharacter.getMinMagicAttack() == playerCharacter.getMagicAttack()-1){
		        	minusMagicAttackButton.setEnabled(false);
		        }else{
					
					// disable start button
					startGameWithChar.setEnabled(false);
					
					// more points are added to the pool, activate plus buttons
		        	plusHealthButton.setEnabled(true);
		        	plusAttackButton.setEnabled(true);
		        	plusMagicAttackButton.setEnabled(true);
		        	plusDefenseButton.setEnabled(true);
		        	plusMagicDefenseButton.setEnabled(true);
					
			        playerCharacter.setPointsLeft(playerCharacter.getPointsLeft()+1);
			        pointsLeftLabel.setText("Points left: "+playerCharacter.getPointsLeft());
			        
			        playerCharacter.setMagicAttack(playerCharacter.getMagicAttack()-1);
			        lblMAvalue.setText(Integer.toString(playerCharacter.getMagicAttack()));
			        		        
			        // if all points are refunded, disable minus buttons
			        if(playerCharacter.getPointsLeft() == playerCharacter.getPointsToUse()){
			        	minusHealthButton.setEnabled(false);
			        	minusAttackButton.setEnabled(false);
			        	minusMagicAttackButton.setEnabled(false);
			        	minusDefenseButton.setEnabled(false);
			        	minusMagicDefenseButton.setEnabled(false);
			        }
		        }
			}
		});
		minusMagicAttackButton.setIcon(new ImageIcon(MainScreen.class.getResource("/minus_30.png")));
		minusMagicAttackButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/minus_30_pressed.png")));
		minusMagicAttackButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/minus_30_rollover.png")));
		minusMagicAttackButton.setOpaque(false);
		minusMagicAttackButton.setFocusPainted(false);
		minusMagicAttackButton.setContentAreaFilled(false);
		minusMagicAttackButton.setBorderPainted(false);
		panel_3.add(minusMagicAttackButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(482, 11, 141, 50);
		increaseAndDecrease.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		plusDefenseButton = new JButton("");
		plusDefenseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// points added to button, enable minus button
	        	minusDefenseButton.setEnabled(true);
	        	
	        	// remove one point from the pool
		        playerCharacter.setPointsLeft(playerCharacter.getPointsLeft()-1);
		        pointsLeftLabel.setText("Points left: "+playerCharacter.getPointsLeft());
		        
		        // add the point to chosen attribute
		        playerCharacter.setDefense(playerCharacter.getDefense()+1); // health changes in increments of 5 per point.
		        lblDvalue.setText(Integer.toString(playerCharacter.getDefense()));
		        		        
		        // if all points have been used, disable plus buttons
		        if(playerCharacter.getPointsLeft() == 0){		        	
		        	plusHealthButton.setEnabled(false);
		        	plusAttackButton.setEnabled(false);
		        	plusMagicAttackButton.setEnabled(false);
		        	plusDefenseButton.setEnabled(false);
		        	plusMagicDefenseButton.setEnabled(false);
		        	
		        }
		        
		        // if all points are spent and name has been given enable start button
		        if(playerCharacter.getName() != null && playerCharacter.getPointsLeft() == 0){
		        	startGameWithChar.setEnabled(true);
		        }else{
		        	startGameWithChar.setEnabled(false);
		        }
				
			}
		});
		plusDefenseButton.setIcon(new ImageIcon(MainScreen.class.getResource("/plus_30.png")));
		plusDefenseButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/plus_30_pressed.png")));
		plusDefenseButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/plus_30_rollover.png")));
		plusDefenseButton.setOpaque(false);
		plusDefenseButton.setFocusPainted(false);
		plusDefenseButton.setContentAreaFilled(false);
		plusDefenseButton.setBorderPainted(false);
		panel_4.add(plusDefenseButton);
		
		minusDefenseButton = new JButton("");
		minusDefenseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        
		        // if magic attack is reduced to minimum, disable minus button.
		        if(playerCharacter.getMinDefense() == playerCharacter.getDefense()-1){
		        	minusDefenseButton.setEnabled(false);
		        }else{
					
					// disable start button
					startGameWithChar.setEnabled(false);
					
					// more points are added to the pool, activate plus buttons
		        	plusHealthButton.setEnabled(true);
		        	plusAttackButton.setEnabled(true);
		        	plusMagicAttackButton.setEnabled(true);
		        	plusDefenseButton.setEnabled(true);
		        	plusMagicDefenseButton.setEnabled(true);
					
			        playerCharacter.setPointsLeft(playerCharacter.getPointsLeft()+1);
			        pointsLeftLabel.setText("Points left: "+playerCharacter.getPointsLeft());
			        
			        playerCharacter.setDefense(playerCharacter.getDefense()-1);
			        lblDvalue.setText(Integer.toString(playerCharacter.getDefense()));
			        		        
			        // if all points are refunded, disable minus buttons
			        if(playerCharacter.getPointsLeft() == playerCharacter.getPointsToUse()){
			        	minusHealthButton.setEnabled(false);
			        	minusAttackButton.setEnabled(false);
			        	minusMagicAttackButton.setEnabled(false);
			        	minusDefenseButton.setEnabled(false);
			        	minusMagicDefenseButton.setEnabled(false);
			        }		        
		        }			
			}
		});
		minusDefenseButton.setIcon(new ImageIcon(MainScreen.class.getResource("/minus_30.png")));
		minusDefenseButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/minus_30_pressed.png")));
		minusDefenseButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/minus_30_rollover.png")));
		minusDefenseButton.setOpaque(false);
		minusDefenseButton.setFocusPainted(false);
		minusDefenseButton.setContentAreaFilled(false);
		minusDefenseButton.setBorderPainted(false);
		panel_4.add(minusDefenseButton);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(639, 11, 141, 50);
		increaseAndDecrease.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		plusMagicDefenseButton = new JButton("");
		plusMagicDefenseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// CHECK PLUS AND MINUS BUTTON LOGIC, STILL BUGGED
				
				// points added to button, enable minus button
	        	minusMagicDefenseButton.setEnabled(true);
	        	
	        	// remove one point from the pool
		        playerCharacter.setPointsLeft(playerCharacter.getPointsLeft()-1);
		        pointsLeftLabel.setText("Points left: "+playerCharacter.getPointsLeft());
		        
		        // add the point to chosen attribute
		        playerCharacter.setMagicDefense(playerCharacter.getMagicDefense()+1); // health changes in increments of 5 per point.
		        lblMDvalue.setText(Integer.toString(playerCharacter.getMagicDefense()));
		        		        
		        // if all points have been used, disable plus buttons
		        if(playerCharacter.getPointsLeft() == 0){		        	
		        	plusHealthButton.setEnabled(false);
		        	plusAttackButton.setEnabled(false);
		        	plusMagicAttackButton.setEnabled(false);
		        	plusDefenseButton.setEnabled(false);
		        	plusMagicDefenseButton.setEnabled(false);
		        	
		        }
		        
		        // if all points are spent and name has been given enable start button
		        if(playerCharacter.getName() != null && playerCharacter.getPointsLeft() == 0){
		        	startGameWithChar.setEnabled(true);
		        }else{
		        	startGameWithChar.setEnabled(false);
		        }
			}
		});
		plusMagicDefenseButton.setIcon(new ImageIcon(MainScreen.class.getResource("/plus_30.png")));
		plusMagicDefenseButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/plus_30_pressed.png")));
		plusMagicDefenseButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/plus_30_rollover.png")));
		plusMagicDefenseButton.setOpaque(false);
		plusMagicDefenseButton.setFocusPainted(false);
		plusMagicDefenseButton.setContentAreaFilled(false);
		plusMagicDefenseButton.setBorderPainted(false);
		panel_5.add(plusMagicDefenseButton);
		
		minusMagicDefenseButton = new JButton("");
		minusMagicDefenseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        // if magic attack is reduced to minimum, disable minus button.
		        if(playerCharacter.getMinDefense() == playerCharacter.getDefense()-1){
		        	minusMagicDefenseButton.setEnabled(false);
		        }else{
					
					// disable start button
					startGameWithChar.setEnabled(false);
					
					// more points are added to the pool, activate plus buttons
		        	plusHealthButton.setEnabled(true);
		        	plusAttackButton.setEnabled(true);
		        	plusMagicAttackButton.setEnabled(true);
		        	plusDefenseButton.setEnabled(true);
		        	plusMagicDefenseButton.setEnabled(true);
					
			        playerCharacter.setPointsLeft(playerCharacter.getPointsLeft()+1);
			        pointsLeftLabel.setText("Points left: "+playerCharacter.getPointsLeft());
			        
			        playerCharacter.setMagicDefense(playerCharacter.getMagicDefense()-1);
			        lblMDvalue.setText(Integer.toString(playerCharacter.getMagicDefense()));
			        		        
			        // if all points are refunded, disable minus buttons
			        if(playerCharacter.getPointsLeft() == playerCharacter.getPointsToUse()){
			        	minusHealthButton.setEnabled(false);
			        	minusAttackButton.setEnabled(false);
			        	minusMagicAttackButton.setEnabled(false);
			        	minusDefenseButton.setEnabled(false);
			        	minusMagicDefenseButton.setEnabled(false);
			        }

		        }
			}
		});
		minusMagicDefenseButton.setIcon(new ImageIcon(MainScreen.class.getResource("/minus_30.png")));
		minusMagicDefenseButton.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/minus_30_pressed.png")));
		minusMagicDefenseButton.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/minus_30_rollover.png")));
		minusMagicDefenseButton.setOpaque(false);
		minusMagicDefenseButton.setFocusPainted(false);
		minusMagicDefenseButton.setContentAreaFilled(false);
		minusMagicDefenseButton.setBorderPainted(false);
		panel_5.add(minusMagicDefenseButton);
		
		startGameWithChar = new JButton("");
		startGameWithChar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// set character values 
				playerCharacter.setName(txtWriteCharacterName.getText());
				playerCharacter.setHealth(Integer.parseInt(lblHvalue.getText()));
				playerCharacter.setAttack(Integer.parseInt(lblAvalue.getText()));
				playerCharacter.setMagicAttack(Integer.parseInt(lblMAvalue.getText()));
				playerCharacter.setDefense(Integer.parseInt(lblDvalue.getText()));
				playerCharacter.setMagicDefense(Integer.parseInt(lblMDvalue.getText()));
				
				txtWriteCharacterName.setEditable(false); // once game starts character name cannot be changed.
				
				// add points left thing 
				// add button listeners and change the values when plus minus buttons are pressed
				// change listener for start button so that it can only be pressed when name is given and points are spent.
				
				
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
			    
			    // set all buttons invisible once player has distributed all points.			    
			    increaseAndDecrease.setVisible(false);
			    pointsLeftLabel.setVisible(false);
				
			}
		});
		startGameWithChar.setIcon(new ImageIcon(MainScreen.class.getResource("/start.png")));
		startGameWithChar.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/start_pressed.png")));
		startGameWithChar.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/start_rollover.png")));
		startGameWithChar.setSize(new Dimension(100, 30));
		startGameWithChar.setOpaque(false);
		startGameWithChar.setFocusPainted(false);
		startGameWithChar.setContentAreaFilled(false);
		startGameWithChar.setBorderPainted(false);
		startGameWithChar.setBounds(346, 72, 100, 30);
		increaseAndDecrease.add(startGameWithChar);
		
		pointsLeftLabel = new JLabel("Points left: "+playerCharacter.getPointsLeft());
		pointsLeftLabel.setForeground(Color.WHITE);
		pointsLeftLabel.setBackground(Color.BLACK);
		pointsLeftLabel.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		pointsLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		characterScreen.add(pointsLeftLabel);
		
		// minusbuttons in character screen always start disabled.
    	minusHealthButton.setEnabled(false);
    	minusAttackButton.setEnabled(false);
    	minusMagicAttackButton.setEnabled(false);
    	minusDefenseButton.setEnabled(false);
    	minusMagicDefenseButton.setEnabled(false);
    	
    	// start game buttons starts as false since points need to be distributed and name need to be given.
    	startGameWithChar.setEnabled(false);
    	
    	JPanel actualCombat = new JPanel();
    	actualCombat.setBackground(Color.BLACK);
    	differentScreens.add(actualCombat, "ACTUALCOMBATSCREEN");
    	actualCombat.setLayout(new GridLayout(5, 1, 0, 0));    	

    	lblEnemyName.setHorizontalAlignment(SwingConstants.CENTER);
    	lblEnemyName.setFont(new Font("Sitka Small", Font.PLAIN, 18));
    	lblEnemyName.setForeground(Color.WHITE);
    	actualCombat.add(lblEnemyName);
    	
    	JLabel lblAttackResult = new JLabel(" ");
    	lblAttackResult.setHorizontalAlignment(SwingConstants.CENTER);
    	lblAttackResult.setForeground(Color.WHITE);
    	lblAttackResult.setFont(new Font("Sitka Small", Font.PLAIN, 18));
    	actualCombat.add(lblAttackResult);
    	
    	JLabel lblPlayer = new JLabel("Player");
    	lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
    	lblPlayer.setForeground(Color.WHITE);
    	lblPlayer.setFont(new Font("Sitka Small", Font.PLAIN, 18));
    	actualCombat.add(lblPlayer);
    	
    	JPanel combatButtons = new JPanel();
    	combatButtons.setBackground(Color.BLACK);
    	actualCombat.add(combatButtons);
    	combatButtons.setLayout(new GridLayout(0, 2, 0, 0));

    	JLabel lblBuffsAndDebuffs = new JLabel("New label");
    	lblBuffsAndDebuffs.setBackground(Color.WHITE);
    	lblBuffsAndDebuffs.setForeground(Color.WHITE);
    	lblBuffsAndDebuffs.setHorizontalAlignment(SwingConstants.CENTER);
    	lblBuffsAndDebuffs.setFont(new Font("Sitka Small", Font.PLAIN, 18));
    	actualCombat.add(lblBuffsAndDebuffs);
    	lblBuffsAndDebuffs.setText("");
    	
    	JButton Attack = new JButton("");
    	Attack.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {    			
    			
    			// attack done against monster
    			int healthBeforeAttack = monster.getHealth();
    			
    			monster.setHealth(c.attack(playerCharacter.getAttack(), monster.getHealth(), monster.getDP()));
    			
    			lblAttackResult.setText(Integer.toString(healthBeforeAttack - monster.getHealth()));
    			
    			// monster defeated, move out of combat.
    			if(monster.getHealth() <= 0){
    				
    				inCombat = false;
    				
    				lblEnemyName.setText("DEAD");
    				lblAttackResult.setText("YOU WIN!");
    				
    				try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
					CardLayout cl = (CardLayout)(differentScreens.getLayout());
				    cl.show(differentScreens, "GAMESCREEN");
    			}else{    			
    			
	    			// monster does their attack	    			
	    			playerCharacter.setHealth(c.attack(monster.getAP(), playerCharacter.getHealth(), playerCharacter.getDefense()));
	    			
	    			// check if player has died.
	    			if(playerCharacter.getHealth() <= 0){
	    				
	    				lblPlayer.setText("DEAD");
	    				lblAttackResult.setText("GAME OVER!");
	    				
	    				try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    				
						CardLayout cl = (CardLayout)(differentScreens.getLayout());
					    cl.show(differentScreens, "MAINMENU");
	    				
	    			}
	    			
	    			shieldBuffCounter--;
	    			
	    			// clears all buffs
	    			if(shieldBuffCounter == 0){
	    				lblBuffsAndDebuffs.setText("");
	    			}
	    			
    			}
    		}
    	});
    	Attack.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/attack_pressed.png")));
    	Attack.setIcon(new ImageIcon(MainScreen.class.getResource("/attack.png")));
    	Attack.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/attack_rollover.png")));
    	Attack.setOpaque(false);
    	Attack.setFocusPainted(false);
    	Attack.setContentAreaFilled(false);
    	Attack.setBorderPainted(false);
    	combatButtons.add(Attack);
    	
    	JButton Defend = new JButton("");
    	Defend.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			

    			// player defends, increase defense by 50 for the next 3 monster attacks.
    			lblBuffsAndDebuffs.setText(lblBuffsAndDebuffs.getText() + "Shielded +50 defense");    			
    			playerCharacter.setDefense(playerCharacter.getDefense() + 50);
    			shieldBuffCounter = 3;

    			// monster does their attack	    			
    			playerCharacter.setHealth(c.attack(monster.getAP(), playerCharacter.getHealth(), playerCharacter.getDefense()));
    			
    			// check if player has died.
    			if(playerCharacter.getHealth() <= 0){
    				
    				lblPlayer.setText("DEAD");
    				lblAttackResult.setText("GAME OVER!");
    				
    				try {
						Thread.sleep(3000);
					} catch (InterruptedException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}
    				
					CardLayout cl = (CardLayout)(differentScreens.getLayout());
				    cl.show(differentScreens, "MAINMENU");
    				
    			}   			
    			
    		}
    	});
    	Defend.setIcon(new ImageIcon(MainScreen.class.getResource("/defend.png")));
    	Defend.setPressedIcon(new ImageIcon(MainScreen.class.getResource("/defend_pressed.png")));
    	Defend.setRolloverIcon(new ImageIcon(MainScreen.class.getResource("/defend_rollover.png")));
    	Defend.setOpaque(false);
    	Defend.setFocusPainted(false);
    	Defend.setContentAreaFilled(false);
    	Defend.setBorderPainted(false);
    	combatButtons.add(Defend);


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
                    
                    CardLayout cl = (CardLayout)(differentScreens.getLayout());
	    			cl.show(differentScreens, "ACTUALCOMBATSCREEN");
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
                    
                    CardLayout cl = (CardLayout)(differentScreens.getLayout());
	    			cl.show(differentScreens, "ACTUALCOMBATSCREEN");
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
                    CardLayout cl = (CardLayout)(differentScreens.getLayout());
	    			cl.show(differentScreens, "ACTUALCOMBATSCREEN");
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
	
	public void addItemsToSlot(JComboBox<String> slot, String[][] items){
		
		// empty combobox and then refill it with new items.
		slot.removeAllItems();
		
		int x = 0;
		boolean endReached = false;
		
		while(endReached == false){		
			
			try{
				
				// currently only adds the name of the item, stats are not displayed on inventory screen.
				slot.addItem(items[x][0]);
				x++;
				
			}catch(IndexOutOfBoundsException e){
				
				endReached = true;
			}
			
		}
		
	}
}
