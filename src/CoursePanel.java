import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class CoursePanel extends MainPanel {
	
	public CoursePanel()
	{
			super();
			Title.setText("Course Name");
			setMaximumSize(new Dimension(500, 300));
	}
	
	public CoursePanel(String courseName)
	{
			super();
			Title.setText(courseName);
			setMaximumSize(new Dimension(500, 300));
	}
	
	public void makeAddJButton()
	{
		addButton = new JButton("Add Task");
		AddJPanel = new AddJPanelButtonHandler();
		addButton.addActionListener(AddJPanel);
		
	}

}
