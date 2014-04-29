import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class MainPanel extends JPanel {
	
	JPanel TitlePanel = new JPanel();
	JTextField Title = new JTextField("Default Name", 35);
	
	JPanel DisplayPanel;
	
	JButton addButton;
	
	AddJPanelButtonHandler AddJPanel;
	
	
	public MainPanel()
	{	
		//******************Container of items******************************
		setLayout(new BorderLayout());
		
		//******************Set the layout of Displayed Panel***************
		DisplayPanel = new JPanel();
		BoxLayout Box = new BoxLayout(DisplayPanel, BoxLayout.Y_AXIS);
		DisplayPanel.setLayout(Box);
		
		addMouseListener(new TextManipulationHandler());
		
		//******************Title panel*********************************
		Title.setHorizontalAlignment(JTextField.CENTER);
		Title.selectAll();
		TitlePanel.add(Title);
		Title.addActionListener(new TextManipulationHandler());
		
		TitlePanel.addMouseListener(new TextManipulationHandler());
		
		//************Add an AddCourseButton to DisplayPanel************
		addButton = new JButton("Super Add");
		AddJPanel = new AddJPanelButtonHandler();
		addButton.addActionListener(AddJPanel);
		
		//********* give Displayed panel scroll functionality*********PROBLEM
		JScrollPane jsp = new JScrollPane(DisplayPanel);
	    
		jsp.setPreferredSize(new Dimension(300,300));
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		// Add completely made panels to Container
		add(TitlePanel, BorderLayout.NORTH);
		add(addButton,BorderLayout.SOUTH);
		add(jsp, BorderLayout.CENTER);
	}
	
	public class TextManipulationHandler extends AbstractAction implements MouseListener
	{
	
		int xpos;
		int ypos;
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Title.setEditable(false);
		}
		
		public void mouseExited (MouseEvent e) { 
		 
		 }

		@Override
		public void mouseClicked(MouseEvent click) {
			xpos = click.getX();
			ypos = click.getY();
			
			if ((xpos != 0) && (ypos != 0))
			{
				Title.setEditable(false); 
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
	
	//========Custom action listener===========
	public class AddJPanelButtonHandler extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			DisplayPanel.add(Box.createRigidArea(new Dimension(0, 5)));
			CoursePanel newItem = new CoursePanel();
	        DisplayPanel.add(newItem);
	        DisplayPanel.revalidate();
			
		}
		
	}


}
