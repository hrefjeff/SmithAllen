import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.awt.Desktop;

@SuppressWarnings("serial")
public class TaskManager extends JFrame {
	
	MainPanel DisplayPanel = new MainPanel();
	
	// Menu options
	JMenuBar menubar;
	JMenu oneMenu;
	JMenuItem newItem, openItem, saveItem, exitItem;
	
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
		setTitle("Task Manager");

		//----------------------Menu Section-----------------------------
		menubar = new JMenuBar();
		this.setJMenuBar(menubar);

		oneMenu = new JMenu("File");
		menubar.add(oneMenu);

		newItem  = new JMenuItem("New");
		openItem = new JMenuItem("Open");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		
		oneMenu.add(newItem);
		oneMenu.add(openItem);
		oneMenu.add(saveItem);
		oneMenu.add(exitItem);
		
		MenuListener menuListen = new MenuListener();
		newItem.addActionListener(menuListen);
		openItem.addActionListener(menuListen);
		saveItem.addActionListener(menuListen);
		exitItem.addActionListener(menuListen);
		
		setContentPane(DisplayPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500, 500);
		pack();
	    
	}	

	public class MenuListener extends AbstractAction{
		public void actionPerformed(ActionEvent e){
			
			if (e.getSource() == newItem)
			{
				newFile();
			}
			else if (e.getSource() == openItem)
			{
				openFile();
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
	
	private void newFile()
	{
		setVisible(false);
		TaskManager mySched = new TaskManager();
		mySched.setBounds(50,50,600,600);
		mySched.setVisible(true);
	}
	
	private void saveFile()
	{
		//String inputText = title.getText();
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
	
	private void openFile()
	{	

		JFileChooser fileChooser = new JFileChooser();
		
		File workingDirectory = new File(System.getProperty("user.dir"));
		fileChooser.setCurrentDirectory(workingDirectory);
		
		int result = fileChooser.showOpenDialog(new TaskManager());
		
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}

	}
	
}
