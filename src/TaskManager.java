import java.awt.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.awt.Desktop;

@SuppressWarnings("serial")
public class TaskManager extends JFrame {
	
	//JButton click = new JButton("Click Here");
	//JLabel alert = new JLabel("You Have Clicked A Label");
	
	// Menu options
	JMenuBar menubar;
	JMenu oneMenu;
	JMenuItem openItem, saveItem, exitItem;
	
	String[] outputText;
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	Name      : TaskManager
	Writer(s) : Jason Smith, Jeffrey Allen
	Purpose   : TaskManager Constructor
	Income    : n/a
	Outgoing  : n/a
	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public TaskManager()
	{
		MainPanel DisplayPanel = new MainPanel();
		
		//*************************Menu Section*************************
		menubar = new JMenuBar();
		this.setJMenuBar(menubar);

		oneMenu = new JMenu("File");
		menubar.add(oneMenu);

		openItem = new JMenuItem("Open");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		
		oneMenu.add(openItem);
		oneMenu.add(saveItem);
		oneMenu.add(exitItem);
		
		MenuListener menuListen = new MenuListener();
		openItem.addActionListener(menuListen);
		saveItem.addActionListener(menuListen);
		exitItem.addActionListener(menuListen);

		/***********Add clickable test label to MainPanel************
		click.setBounds(110,50,80,20);
		click.setBorderPainted(false); 
		click.setContentAreaFilled(false); 
		click.setFocusPainted(false); 
		click.setOpaque(false);
		alert.setBounds(70,100,180,20);
		add(click);
		add(alert);
		alert.setVisible(false);
		
		click.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent arg0) {
			alert.setVisible(true);
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		 */
		
		/*for (int i = 0; i < 1; i++) {
		    JButton b = new JButton("Initial Course"+i);
		    //b.setVisible(false);
		    // ***Not gonna work because gridlayout sets all cells the same size
		    // ***b.setSize(1, 1);
		    MainPanel.add(b);
		}*/

		add(DisplayPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500, 500);
		pack();
	    
	}
		
	
	private void saveFile()
	{
		//String inputText = managerName.getText();
		outputText = new String[10];
		//outputText[0] = inputText;
		
		try {
			PrintWriter outFile = new PrintWriter("taskSave.txt");
			outFile.println(outputText[0]);
			outFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test");
	}
	
	
	public class MenuListener extends AbstractAction{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == openItem)
			{
				final JFileChooser fc = new JFileChooser();

				JFileChooser fileChooser = new JFileChooser();
				
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				
				int result = fileChooser.showOpenDialog(new TaskManager());
				
				//System.out.println("Opening: " + managerName.getName() + ".");
				
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
			}
			else if (e.getSource() == saveItem)
			{
				saveFile();						
			}
			else if (e.getSource() == exitItem){
				 System.exit(0);
			}
			
		}
	}
	
}
