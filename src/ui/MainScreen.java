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
import java.awt.CardLayout;

import game.BoardActions;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JEditorPane;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JEditorPane gameText = new JEditorPane(new HTMLEditorKit().getContentType(),"");
	private JEditorPane combat = new JEditorPane(new HTMLEditorKit().getContentType(), "");
	private BoardActions bo = null;
    private Timer timer;
    private int delay = 0;
    private static final long serialVersionUID = 1L;
	
	
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
    	    
    	    if (e.getID() == KeyEvent.KEY_PRESSED){
	    	       	    	    
	    	    if (key == KeyEvent.VK_UP) {
	    	    	gameText.setText("<center>"+bo.gameLoop("up")+"</center>");
	
	    	    }	    
	
	    	    if (key == KeyEvent.VK_RIGHT) {
	    	    	gameText.setText("<center>"+bo.gameLoop("right")+"</center>");
	
	    	    }
	
	    	    if (key == KeyEvent.VK_DOWN) {
	    	    	gameText.setText("<center>"+bo.gameLoop("down")+"</center>");
	
	    	    }
	    	    
	    	    if (key == KeyEvent.VK_LEFT) {
	    	    	gameText.setText("<center>"+bo.gameLoop("left")+"</center>");
	
	    	    }
	    	    
	    	    if (key == KeyEvent.VK_L){
	    	    	gameText.setText("<center>"+bo.gameLoop("l")+"</center>");
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
//				
//			    gameText.setText("<center>You hear the maze door close behind you.<br>"
//			    		+ "Press 'down arrow' to move into the maze.</center>");
//				
//				CardLayout cl = (CardLayout)(differentScreens.getLayout());
//			    cl.show(differentScreens, "GAMESCREEN");
			    
			    CardLayout cl = (CardLayout)(differentScreens.getLayout());
			    cl.show(differentScreens, "COMBATSCREEN");
			    //enteringCombatAnimationLines();
			    //enteringCombatAnimationSquare();
			    enteringCombatAnimationText();
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
