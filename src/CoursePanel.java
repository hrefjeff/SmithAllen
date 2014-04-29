import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


@SuppressWarnings("serial")
public class CoursePanel extends JPanel {
	
	JTextField managerName = new JTextField("Default Name", 20);
	
	JPanel NamePanel = new JPanel();
	JPanel MainPanel = new JPanel();
	
	JButton addButton = new JButton("Add Task");
	AddJPanelButtonHandler AddJPanel;
	
	public CoursePanel()
	{
		setLayout(new BorderLayout());
		setMaximumSize(new Dimension(300, 300));
		
        Dimension expectedDimension = new Dimension(100, 100);

        MainPanel.setPreferredSize(expectedDimension);
        MainPanel.setMaximumSize(expectedDimension);
        MainPanel.setMinimumSize(expectedDimension);
		
		//******************Set the layout of main panel***************
		MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
		MainPanel.addMouseListener(new TextManipulationHandler());
		
		//******************Name panel*********************************
		managerName.setHorizontalAlignment(JTextField.CENTER);
		managerName.selectAll();
		NamePanel.add(managerName);
		managerName.addActionListener(new TextManipulationHandler());
		
		NamePanel.addMouseListener(new TextManipulationHandler());
		
		//************Add an AddCourseButton to MainJPanel************
		JButton addButton = new JButton("Add Task");
		AddJPanel = new AddJPanelButtonHandler();
		addButton.addActionListener(AddJPanel);
				
		// give Main panel scroll functionality
		JScrollPane jsp = new JScrollPane(MainPanel);
	    
		jsp.setPreferredSize(new Dimension(50,50));
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		// Add completely made panels to frame
		add(NamePanel, BorderLayout.NORTH);
		add(addButton,BorderLayout.SOUTH);
		add(jsp, BorderLayout.CENTER);
		
	}
	
	//========Custom action listener===========
	public class AddJPanelButtonHandler extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
			JButton b = new JButton("New Course");
	        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	        MainPanel.add(b);
	        MainPanel.revalidate();
			
		}
		
	}
	
	public class TextManipulationHandler extends AbstractAction implements MouseListener
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
