package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GameMain extends JFrame implements ActionListener {
	private CardHand deck;

	JFrame f = new JFrame();
	
	private static JButton hit   = new JButton("Hit Me");
	private static JButton stand = new JButton("Stand");
	private static JButton doubleDown  = new JButton("Double Down");
	private static JButton deal = new JButton("Deal");
	
	private JLabel status = new JLabel(" ", JLabel.CENTER);
	
	CardHand player;
	
	public GameMain() {
			f.setSize(1500,1500);
			f.setTitle("Blackjack");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel buttons = new JPanel();
       
	    	buttons.add(hit);
        	buttons.add(stand);
        	buttons.add(doubleDown);
        	buttons.add(deal);
        	hit.addActionListener(this);
        	stand.addActionListener(this);
        	doubleDown.addActionListener(this);
        	deal.addActionListener(this);
        	//hit.setEnabled(false);
        	//stand.setEnabled(false);
        	//doubleDown.setEnabled(false);
        	//deal.setEnabled(true);
        	
        		    
	    	
			getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	        //getContentPane().add(main);
	        getContentPane().add(buttons);
	        getContentPane().add(status);
	        
			pack();
			f.add(buttons);	
        	f.setVisible(true);
	}

	public void actionPerformed(ActionEvent b) {
		if(b.getSource() == hit) {
			
		}
		
	}
	public static void main(String[] args) {
		new GameMain();
	}
}
