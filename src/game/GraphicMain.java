package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GraphicMain extends JFrame implements ActionListener {
	
	private static JButton hit   = new JButton("Hit Me");
	private static JButton stand = new JButton("Stand");
	private static JButton doubleDown  = new JButton("Double Down");
	private static JButton deal = new JButton("Deal");
	
	public static void main(String[] args) {

		System.out.println("welcome");
		JFrame f = new JFrame();
		f.setSize(1500,1500);
		f.setTitle("Blackjack");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	    
	    JPanel buttons = new JPanel();
       
	    buttons.add(hit);
        buttons.add(stand);
        buttons.add(doubleDown);
        buttons.add(deal);
        
        f.add(buttons);
        
        f.setVisible(true);
	}

	public void actionPerformed(ActionEvent b) {
		if(b.getSource() == hit) {
			
		}
		
	}

}