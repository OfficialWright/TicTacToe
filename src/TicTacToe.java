import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe extends JFrame implements ActionListener {
	// Initialization
	// Window sizing
	private final int WINDOW_WIDTH = 550;
	private final int WINDOW_HEIGHT = 550;
	// Components for window
	private JPanel panel = new JPanel();
	private JPanel panelTop = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JPanel panelBottom = new JPanel();
	// All games buttons
	private JButton pvpGame = new JButton("Player VS Player");
	private JButton newGame = new JButton("New Game");
	private JButton exitGame = new JButton("Exit");
	private JButton pvcGame = new JButton("Player VS Computer");
	private JButton buttonOne = new JButton("");
	private JButton buttonTwo = new JButton("");
	private JButton buttonThree = new JButton("");
	private JButton buttonFour = new JButton("");
	private JButton buttonFive = new JButton("");
	private JButton buttonSix = new JButton("");
	private JButton buttonSeven = new JButton("");
	private JButton buttonEight = new JButton("");
	private JButton buttonNine = new JButton("");
	// Variables
	private String letter = "";
    private int count = 0;
    private boolean pvc = false;
	
	public TicTacToe() {
		// Set the title
		setTitle("Tic Tac Toe Game");

		// Specify what happens when the close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Build the panel that contains the other components
		buildTopPanel();
		buildCenterPanel();
		buildBottomPanel();
		
		// Main panel layout
		panel.setLayout(new BorderLayout());
		
		// Setting grid layout of 3 rows and 3 columns for the buttons
		panelCenter.setLayout(new GridLayout(3,3));
		
		// Add the panels to main panel
		panel.add(panelTop, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(panelBottom, BorderLayout.SOUTH);
		
		// Adding main panel to content pane
		add(panel);
		
		// Sizing the window and displaying it
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
		
		// Requiring user to select game mode
		disableGame();
		newGame.setEnabled(false);
	}
	
	private void buildTopPanel() {
		// Adding components to top panel
		panelTop.add(pvpGame);
		panelTop.add(newGame);
		panelTop.add(pvcGame);
		
		// Settings for when pvp game button clicked
		pvpGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame.setEnabled(true);
				pvpGame.setEnabled(false);
				pvcGame.setEnabled(true);
				pvc = false;
				disableGame();
			}
		});
		// Settings to restart game when new game button clicked
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOne.setText("");
			    buttonOne.setEnabled(true);
			    buttonTwo.setText("");
			    buttonTwo.setEnabled(true);
			    buttonThree.setText("");
			    buttonThree.setEnabled(true);
			    buttonFour.setText("");
			    buttonFour.setEnabled(true);
			    buttonFive.setText("");
			    buttonFive.setEnabled(true);
			    buttonSix.setText("");
			    buttonSix.setEnabled(true);
			    buttonSeven.setText("");
			    buttonSeven.setEnabled(true);
			    buttonEight.setText("");
			    buttonEight.setEnabled(true);
			    buttonNine.setText("");
			    buttonNine.setEnabled(true);
			    count = 0;
			    // If new game clicked while in pvc mode make sure its set
			    if(pvcGame.isEnabled() == false) {
			    	pvc = true;
			    }
			}
		});
		// Settings for when pvc game button clicked
		pvcGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame.setEnabled(true);
				pvcGame.setEnabled(false);
				pvpGame.setEnabled(true);
				pvc = true;
				disableGame();
			}
		});
	}
	
	private void buildBottomPanel() {
		panelBottom.add(exitGame);
		
		// If exit is clicked disable view and dispose window
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
	}
	
	private void buildCenterPanel() {
		// Adding components to center panel
		panelCenter.add(buttonOne);
		panelCenter.add(buttonTwo);
		panelCenter.add(buttonThree);
		panelCenter.add(buttonFour);
		panelCenter.add(buttonFive);
		panelCenter.add(buttonSix);
		panelCenter.add(buttonSeven);
		panelCenter.add(buttonEight);
		panelCenter.add(buttonNine);
		
		// If any enabled button pressed run listener
		buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent a) {    
        // Calculate whos turn it is if in pvp mode
        if(count == 0 || count == 2 || count == 4 || count == 6 || count == 8){
            letter = "X";
        } else if(count == 1 || count == 3 || count == 5 || count == 7){
        	letter = "O";
        }
        // Counter goes up by 1
        count++;

        // Display X's or O's on the buttons
        if(a.getSource() == buttonOne){
        	buttonOne.setFont(new Font("Arial", Font.PLAIN, 45));
        	buttonOne.setText(letter);
        	buttonOne.setEnabled(false);
        } else if(a.getSource() == buttonTwo){
        	buttonTwo.setFont(new Font("Arial", Font.PLAIN, 45));
        	buttonTwo.setText(letter);
        	buttonTwo.setEnabled(false);
        } else if(a.getSource() == buttonThree){
        	buttonThree.setFont(new Font("Arial", Font.PLAIN, 45));
        	buttonThree.setText(letter);
        	buttonThree.setEnabled(false);
        } else if(a.getSource() == buttonFour){
        	buttonFour.setFont(new Font("Arial", Font.PLAIN, 45));
        	buttonFour.setText(letter);
        	buttonFour.setEnabled(false);
        } else if(a.getSource() == buttonFive){
        	buttonFive.setFont(new Font("Arial", Font.PLAIN, 45));
        	buttonFive.setText(letter);
        	buttonFive.setEnabled(false);
        } else if(a.getSource() == buttonSix){
        	buttonSix.setFont(new Font("Arial", Font.PLAIN, 45));
        	buttonSix.setText(letter);
        	buttonSix.setEnabled(false);
        } else if(a.getSource() == buttonSeven){
        	buttonSeven.setFont(new Font("Arial", Font.PLAIN, 45));
        	buttonSeven.setText(letter);
        	buttonSeven.setEnabled(false);
        } else if(a.getSource() == buttonEight){
        	buttonEight.setFont(new Font("Arial", Font.PLAIN, 45));
        	buttonEight.setText(letter);
        	buttonEight.setEnabled(false);
        } else if(a.getSource() == buttonNine){
        	buttonNine.setFont(new Font("Arial", Font.PLAIN, 45));
        	buttonNine.setText(letter);
        	buttonNine.setEnabled(false);
        }
        // Checks if player is a winner
        checkWinner(letter);
        
        // If player in pvc mode run this
        if (pvc == true) {
        	boolean reRoll = true;
        	letter = "O";
        	
        	// Auto run reRoll if computers selection is not an option
        	while(reRoll == true) {
        		int roll = new Random().nextInt(9)+1;
            	// Makes sure if the computers random number is a valid option
            	if(roll == 1 && buttonOne.getText().equals("")) {
            		buttonOne.setFont(new Font("Arial", Font.PLAIN, 45));
            		buttonOne.setText(letter);
                	buttonOne.setEnabled(false);
                	reRoll = false;
            	} else if(roll == 2 && buttonTwo.getText().equals("")) {
            		buttonTwo.setFont(new Font("Arial", Font.PLAIN, 45));
            		buttonTwo.setText(letter);
                	buttonTwo.setEnabled(false);
                	reRoll = false;
            	} else if(roll == 3 && buttonThree.getText().equals("")) {
            		buttonThree.setFont(new Font("Arial", Font.PLAIN, 45));
            		buttonThree.setText(letter);
                	buttonThree.setEnabled(false);
                	reRoll = false;
            	} else if(roll == 4 && buttonFour.getText().equals("")) {
            		buttonFour.setFont(new Font("Arial", Font.PLAIN, 45));
            		buttonFour.setText(letter);
                	buttonFour.setEnabled(false);
                	reRoll = false;
            	} else if(roll == 5 && buttonFive.getText().equals("")) {
            		buttonFive.setFont(new Font("Arial", Font.PLAIN, 45));
            		buttonFive.setText(letter);
                	buttonFive.setEnabled(false);
                	reRoll = false;
            	} else if(roll == 6 && buttonSix.getText().equals("")) {
            		buttonSix.setFont(new Font("Arial", Font.PLAIN, 45));
            		buttonSix.setText(letter);
                	buttonSix.setEnabled(false);
                	reRoll = false;
            	} else if(roll == 7 && buttonSeven.getText().equals("")) {
            		buttonSeven.setFont(new Font("Arial", Font.PLAIN, 45));
            		buttonSeven.setText(letter);
                	buttonSeven.setEnabled(false);
                	reRoll = false;
            	} else if(roll == 8 && buttonEight.getText().equals("")) {
            		buttonEight.setFont(new Font("Arial", Font.PLAIN, 45));
            		buttonEight.setText(letter);
                	buttonEight.setEnabled(false);
                	reRoll = false;
            	} else if(roll == 9 && buttonNine.getText().equals("")) {
            		buttonNine.setFont(new Font("Arial", Font.PLAIN, 45));
            		buttonNine.setText(letter);
                	buttonNine.setEnabled(false);
                	reRoll = false;
            	}
        	}
        	// Checks if computer won then add 1 to counter
        	checkWinner(letter);
        	count++;
        }
    }
	
	private void disableGame() {
		// Disables all buttons to show game is over
	    buttonOne.setEnabled(false);
	    buttonTwo.setEnabled(false);
	    buttonThree.setEnabled(false);
	    buttonFour.setEnabled(false);
	    buttonFive.setEnabled(false);
	    buttonSix.setEnabled(false);
	    buttonSeven.setEnabled(false);
	    buttonEight.setEnabled(false);
	    buttonNine.setEnabled(false);
	}
	
	private void checkWinner(String letter) {
		// Checks to see if the game is over or not
		if(buttonOne.getText().equals(letter) && buttonTwo.getText().equals(letter) && buttonThree.getText().equals(letter)) {
        	disableGame();
        	pvc = false;
        	JOptionPane.showMessageDialog(null, letter + " has won!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if(buttonFour.getText().equals(letter) && buttonFive.getText().equals(letter) && buttonSix.getText().equals(letter)) {
        	disableGame();
        	pvc = false;
        	JOptionPane.showMessageDialog(null, letter + " has won!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if(buttonSeven.getText().equals(letter) && buttonEight.getText().equals(letter) && buttonNine.getText().equals(letter)) {
        	disableGame();
        	pvc = false;
        	JOptionPane.showMessageDialog(null, letter + " has won!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if(buttonOne.getText().equals(letter) && buttonFour.getText().equals(letter) && buttonSeven.getText().equals(letter)) {
        	disableGame();
        	pvc = false;
        	JOptionPane.showMessageDialog(null, letter + " has won!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if(buttonTwo.getText().equals(letter) && buttonFive.getText().equals(letter) && buttonEight.getText().equals(letter)) {
        	disableGame();
        	pvc = false;
        	JOptionPane.showMessageDialog(null, letter + " has won!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if(buttonThree.getText().equals(letter) && buttonSix.getText().equals(letter) && buttonNine.getText().equals(letter)) {
        	disableGame();
        	pvc = false;
        	JOptionPane.showMessageDialog(null, letter + " has won!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if(buttonOne.getText().equals(letter) && buttonFive.getText().equals(letter) && buttonNine.getText().equals(letter)) {
        	disableGame();
        	pvc = false;
        	JOptionPane.showMessageDialog(null, letter + " has won!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if(buttonThree.getText().equals(letter) && buttonFive.getText().equals(letter) && buttonSeven.getText().equals(letter)) {
        	disableGame();
        	pvc = false;
        	JOptionPane.showMessageDialog(null, letter + " has won!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if(count > 8) {
        	disableGame();
        	pvc = false;
        	JOptionPane.showMessageDialog(null, "The game ended in a tie!", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
	}
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
	}
}