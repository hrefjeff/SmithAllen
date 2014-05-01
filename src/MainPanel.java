import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class MainPanel extends JPanel {
	
	/**--------------------------------------------------- 
	 *                      Title Area
	 * ---------------------------------------------------
	 * 
	 * 
	 * 
	 * 
	 *                     Conent Panel
	 * 
	 * 
	 * 
	 * 
	 * ---------------------------------------------------
	 *                      Add Button
	 * --------------------------------------------------- */
	
	JPanel TitlePanel = new JPanel();

	public ImageIcon img = new ImageIcon("paper.jpg");
	JTextField Title = new JTextField("Default User", 35);
	
	JPanel ContentPanel;
	
	JButton addButton;
	
	AddJPanelButtonHandler AddJPanel;
	
	
	public MainPanel()
	{
		setLayout(new BorderLayout());
		
		//--------------Set the layout of Displayed Panel-------------------
		ContentPanel = new JPanel();
		ContentPanel.setBackground(Color.lightGray);
		BoxLayout Box = new BoxLayout(ContentPanel, BoxLayout.Y_AXIS);
		ContentPanel.setLayout(Box);
		
		addMouseListener(new TextManipulationHandler());
		
		//------------------Title panel-------------------------------------
		Title.setHorizontalAlignment(JTextField.CENTER);
		Title.selectAll();
		TitlePanel.add(Title);
		Title.addActionListener(new TextManipulationHandler());
		
		TitlePanel.addMouseListener(new TextManipulationHandler());
		
		//-------------Add an Add Button to Main Panel----------------------
		makeAddJButton();
		
		//---------- give Displayed panel scroll functionality--------------
		JScrollPane jsp = new JScrollPane(ContentPanel);
	    
		jsp.setPreferredSize(new Dimension(300,300));
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//---------------Put finished products into panel-------------------
		add(TitlePanel, BorderLayout.NORTH);
		add(addButton,BorderLayout.SOUTH);
		add(jsp, BorderLayout.CENTER);
	}
	
	public void makeAddJButton()
	{
		addButton = new JButton("Add Course");
		AddJPanel = new AddJPanelButtonHandler();
		addButton.addActionListener(AddJPanel);
	}
	
	public class AddJPanelButtonHandler extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			JButton buttonPressed = (JButton)e.getSource();
			String buttonName = buttonPressed.getText();
			
			System.out.println(buttonName);
			
			if (buttonName == "Add Course")
			{
				AddCourse();
			} 
			else if (buttonName == "Add Task") 
			{
				AddTask();
			}
			
		}
		
	}
	
	public void AddCourse()
	{
		ContentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		CoursePanel newItem = new CoursePanel();
    	ContentPanel.add(newItem);
    	ContentPanel.revalidate();
	}
	
	public void AddCourse(String courseName)
	{
		ContentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		CoursePanel newItem = new CoursePanel(courseName);
    	ContentPanel.add(newItem);
    	ContentPanel.revalidate();
	}
	
	public void AddTask()
	{
		ContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		TaskPanel newItem = new TaskPanel();
    	ContentPanel.add(newItem);
    	ContentPanel.revalidate();
	}
	
	//**************************************************************
	// Only if reading in from file will this fire
	//**************************************************************
	public void AddTask(String taskName)
	{
		ContentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		MainTask newItem = new MainTask(taskName);
    	ContentPanel.add(newItem);
    	ContentPanel.revalidate();
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

}
