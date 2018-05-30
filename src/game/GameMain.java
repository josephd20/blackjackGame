package game;

import javax.swing.*;


public class GameMain {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setSize(1500,1500);
		f.setTitle("Blackjack");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton hitButton   = new JButton("Hit Me");
	    JButton stickButton = new JButton("Stick");
	    JButton dealButton  = new JButton("Deal");
	    
	    JPanel buttons = new JPanel();
       
	    buttons.add(hitButton);
        buttons.add(stickButton);
        buttons.add(dealButton);
        
        f.add(buttons);
        
        f.setVisible(true);
	}

}
