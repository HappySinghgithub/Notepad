package notepadapp;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
public class Notepad extends JFrame implements ActionListener {

	JTextArea area;
	JScrollPane scroll;
	String text;
	Notepad()
	{
		setBounds(150,50,1050,650);  //   left,top,right,bottom
		setTitle("My Notepad");
		JMenuBar menubar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		
		JMenuItem newFile = new JMenuItem("New");
		newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));  //create shortcut key 
		newFile.addActionListener(this);  // add ActionListener to perform event
		
		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		open.addActionListener(this);  // add ActionListener to perform event
		
		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		save.addActionListener(this);
		
		JMenuItem print = new JMenuItem("Print");
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		print.addActionListener(this);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		exit.addActionListener(this);
		
		file.add(newFile);file.add(open);file.add(save);file.add(print);file.add(exit);  // add menuitem in menu
		
		JMenu edit = new JMenu("Edit");
		
		JMenuItem cut = new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		cut.addActionListener(this);
		
		JMenuItem copy = new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		copy.addActionListener(this);
		
		JMenuItem paste = new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		paste.addActionListener(this);
		
		JMenuItem selectall = new JMenuItem("Select All");
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		selectall.addActionListener(this);
		
		edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectall);  // add menu item in edit menu
		
		JMenu help = new JMenu("Help");
		
		JMenuItem about = new JMenuItem("About the Notepad");
		about.addActionListener(this);
		help.add(about);
		
		
		menubar.add(file);menubar.add(edit);menubar.add(help);   // add menu in menuBar
		setJMenuBar(menubar);
		
		area = new JTextArea();
		area.setFont(new Font("SANS_SERIF",Font.PLAIN,20)); // size or design of text change
		area.setLineWrap(true);   // change line in textField
		
		scroll = new JScrollPane(area);
		scroll.setBorder(BorderFactory.createEmptyBorder());  // delete border on top textField
		add(scroll,BorderLayout.CENTER);
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
		
			if(e.getActionCommand().equals("New")) {  // Action Perform on new button
				area.setText("");  // when you create empty string, new text open, when you click on new
			}
			else if(e.getActionCommand().equals("Open")) {
				JFileChooser chooser = new JFileChooser();
				chooser.setAcceptAllFileFilterUsed(false);  // not choose all file in extension,  like .java,.pdf.xml etc
				FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files","txt"); // only .txt extension file will be open
			//	FileNameExtensionFileter is present in swing.FileChooser package
				chooser.addChoosableFileFilter(restrict);
				
				int action = chooser.showOpenDialog(this);
				if(action != JFileChooser.APPROVE_OPTION) {
					return;
				}
				File file = chooser.getSelectedFile();  // getSelectedFile return the object of File class
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));  // to read the file in File class
					area.read(reader, null);  // paste the data in textField which you pick from the File class
				}
				catch(Exception ee) {}
			}
			else if(e.getActionCommand().equals("Save")) {
				JFileChooser saveas = new JFileChooser();  // FileChooser open all file directory
				saveas.setApproveButtonText("Save");
				int action = saveas.showOpenDialog(this);  // showOpenDialog check to which button you click
				if(action!= JFileChooser.APPROVE_OPTION) {
					return;
				}
				File filename = new File(saveas.getSelectedFile()+ ".txt");   // extension file is in IO package   // .txt extension will be created
				BufferedWriter outFile = null;  // bufferedWriter write file
				try {
					outFile = new BufferedWriter(new FileWriter(filename));
					area.write(outFile);
				}catch (Exception ee) {}
			}
			else if(e.getActionCommand().equals("Print")) {
				try {
				area.print();  // Print function is equal to getActionCommand then call print function
				}catch(Exception ee) {}
			}else if(e.getActionCommand().equals("Exit")) {
				System.exit(0);  // if getActionCommand is equal to exit then close the project by passing 0
			}
			else if(e.getActionCommand().equals("Cut")) {
				text = area.getSelectedText(); // first we select the text area to cut the variable of the String(text)
				area.replaceRange("", area.getSelectionStart(),area.getSelectionEnd()); // replaceRange will clear the text area. so the String is kept empty
			}
			else if(e.getActionCommand().equals("Copy")) {
				text = area.getSelectedText(); // whatever is selected under the text area is now copied to the variable of the String(text)
			}
			else if(e.getActionCommand().equals("Paste")){
				area.insert(text, area.getCaretPosition());  // getCaretPostion will paste where the cursor is present
			//	insert function is used for paste to String variable (text)
			}
			else if(e.getActionCommand().equals("Select All")) {
				area.selectAll();
			}
			else if(e.getActionCommand().equals("About the Notepad")) {
				new About().setVisible(true);
			}
		}
		public static void main(String[] args) {
		
			new Notepad().setVisible(true);
	}
}
