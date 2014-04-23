import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

@SuppressWarnings("serial")
public class TaskManager extends JFrame implements ActionListener {
	
	JTextField managerName = new JTextField("Default Name", 35);
	
	JMenuBar menubar;
    JPanel MainPanel = new JPanel(new GridLayout(6,0));
    
	AddJPanelButtonHandler AddJPanel;
	
	/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	Name      : TaskManager
	Writer(s) : Jason Smith, Jeffrey Allen
	Purpose   : TaskManager Constructor
	Income    : n/a
	Outgoing  : n/a
	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	public TaskManager()
	{
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	    JScrollPane jsp = new JScrollPane(MainPanel);
	    
	    jsp.setPreferredSize(new Dimension(300,300));
	    jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		managerName.setHorizontalAlignment(JTextField.CENTER);
		managerName.selectAll();
		MainPanel.add(managerName);
		managerName.addActionListener(new TextManipulationHandler());
	    
		MainPanel.addMouseListener(new TextManipulationHandler());
		
	    JButton addButton = new JButton("Add Course Button");
	    AddJPanel = new AddJPanelButtonHandler();
	    addButton.addActionListener(AddJPanel);
	    MainPanel.add(addButton);
	    
	    //p.add(menubar, BorderLayout.NORTH);
	    
	    for (int i = 0; i < 1; i++) {
	        JButton b = new JButton("Initial Course"+i);
	        b.setVisible(false);
	        // ***Not gonna work because gridlayout sets all cells the same size
	        // ***b.setSize(1, 1);
	        MainPanel.add(b);
	    }

	    add(jsp, BorderLayout.CENTER);
	    setLocation(300, 300);
	    pack();
	    
	}
		
	// When button is pressed
	public void actionPerformed(ActionEvent e){
		return;
	}
	
	//========Custom action listener===========
	public class AddJPanelButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton b = new JButton("New Course");
	        MainPanel.add(b);
	        MainPanel.revalidate();
			
		}
		
	}

	public class TextManipulationHandler implements ActionListener, MouseListener
	{
	
		int xpos;
		int ypos;
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			managerName.setEditable(false);
		}
		
		 public void mouseExited (MouseEvent e) { 
		 
		 }

		@Override
		public void mouseClicked(MouseEvent click) {
			xpos = click.getX();
			ypos = click.getY();
			
			if ((xpos != 0) && (ypos != 0))
			{
				managerName.setEditable(false); 
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
 
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		} 
	}
}
