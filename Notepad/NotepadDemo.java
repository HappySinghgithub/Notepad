package notepadapp;

import javax.swing.*;

public class NotepadDemo extends JFrame {

	JMenuBar menubar = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu edit = new JMenu("Edit");
	JMenu help = new JMenu("Help");
	
	JMenuItem newFile = new JMenuItem("New");
	JMenuItem openFile = new JMenuItem("Open");
	JMenuItem saveFile = new JMenuItem("Save");
	JMenuItem print = new JMenuItem("Print");
	JMenuItem exit = new JMenuItem("Exit");
	
	JMenuItem cut = new JMenuItem("Cut");
	JMenuItem copy = new JMenuItem("Copy");
	JMenuItem paste = new JMenuItem("Paste");
	JMenuItem selectall = new JMenuItem("Select All");
	
	JMenuItem about = new JMenuItem("About");
	
	NotepadDemo(){
		
		setTitle("Notepad Application");
		setBounds(100,100,800,600);   // left,top,width,height
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon(getClass().getResource("notepad.jpg"));
		setIconImage(icon.getImage());
		
		setJMenuBar(menubar);  // add menu bar in notepad
		menubar.add(file);menubar.add(edit);menubar.add(help);
		file.add(newFile);file.add(openFile);file.add(saveFile);file.add(print);file.add(exit);
		edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectall);
		help.add(about);
		
	}
	public static void main(String[] args) {
	
		new NotepadDemo().setVisible(true);
	}
}
