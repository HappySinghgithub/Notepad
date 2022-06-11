package notepadapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

	JButton b1;  // add OK button on Help menu (About the notepad)
	About(){
		
		setBounds(250,100,750,550);  //   left,top,right,bottom  / set the size of Frame
		setLayout(null);   //  cannot use setBounds function until setLayout is null
		setTitle("About Notepad");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("notepadapp/windows.png")); // ImageIcon is use for Image ,getSystemResource select image in any directory
		Image i2 = i1.getImage().getScaledInstance(400,80,Image.SCALE_DEFAULT);  // getScaledInstance return the object of Image class
		ImageIcon i3 = new ImageIcon(i2);  // create ImageIcon class object
		JLabel l1 = new JLabel(i3);  // doesn't pass the object of Image class(i2) in JLabel. JLabel takes the object of only ImageIcon class(i3). So, we create object of ImageIcon class 
		l1.setBounds(150,40,400,80);   // set size of Image
		add(l1);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("notepadapp/notepad.png"));
		Image i5 = i4.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l2 = new JLabel(i6);
		l2.setBounds(50,180,70,70);
		add(l2);
		
		JLabel l3 = new JLabel("<html>Code for Interview<br>Notepad version 2021<br>Code for Interview, All Rights Reserved<br><br>Notepad is a word processing program<br>which allows channging of text in compiter file,<br>Notepad is a simple text editing for basic text editing program<br>which enables computer used to create documents</html>");
		l3.setBounds(150,130,500,300);  
		l3.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
		add(l3);
		JLabel l4 = new JLabel("<html>Amit Singh<br><br>");
		l4.setBounds(150,100,300,200);     //   left,top,right,bottom
		l4.setFont(new Font("GEORGIA",Font.BOLD,18));
		l4.setForeground(Color.GRAY);
		add(l4);
		
		b1= new JButton("OK");
		b1.setBounds(650,470,55,25);  // size of OK button
		b1.addActionListener(this); // add ActionListener to perform on OK button
		add(b1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {  // call actionPerformed to perform event
		this.setVisible(false); 
		
	}
	public static void main(String[] args) {

		new About().setVisible(true);
	}
}
