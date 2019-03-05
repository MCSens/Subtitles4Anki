package svp.playground;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import svp.util.FileChooser;

class ButtonFrame extends JFrame
{
  JButton bChange ; // reference to the button object

	  // constructor for ButtonFrame
	  ButtonFrame(String title) {
	    super( title );                     // invoke the JFrame constructor
	    setLayout( new GridLayout());      // set the layout manager
	    
	    JTextField subtitleFile = new JTextField();
	    add (subtitleFile );
	    bChange = new JButton("Select Subtitle File!"); // construct a JButton
	    add( bChange );                     // add the button to the JFrame
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
	    bChange.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e) { 
	        	System.out.println("Button geklickt");
	            String path = FileChooser.pickPath();
	            subtitleFile.setText(path);
	            System.out.println("Erhaltener Pfad: "+path);
	        } 
	    });
	    
	    JTextField audioFile = new JTextField();
	    add (audioFile );
	    bChange = new JButton("Select Audio File!"); // construct a JButton
	    add( bChange );                     // add the button to the JFrame
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
	    bChange.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e) { 
	        	System.out.println("Button geklickt");
	            String path = FileChooser.pickPath();
	            System.out.println("Erhaltener Pfad: "+path);
        	} 
    	});
  	}
  
	  public static void main ( String[] args ){
		  ButtonFrame frm = new ButtonFrame("Button Demo");
	  
		  frm.setSize( 150, 75 );     
		  frm.setVisible( true );   
	  }
}