import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaskPanel extends JPanel{
	
	/**********************************
	 * 
	 * 			Tasktitle (JPanel)
	 * 
	 * ********************************
	 * 
	 * 
	 * 		ContentPanel (GridLayout)
	 * 
	 * 
	 * 
	 **********************************/
	
	MainTask taskTitle;
	ContentPanel subTaskWindow;
	
	JLabelHandler labelEvent;
	
	public TaskPanel()
	{
		setLayout(new BorderLayout());
		setBackground(Color.blue);
		
		taskTitle = new MainTask();
		taskTitle.addMouseListener(labelEvent);

		add(taskTitle, BorderLayout.NORTH);
		
		subTaskWindow = new ContentPanel();
		subTaskWindow.addMouseListener(labelEvent);

		add(subTaskWindow, BorderLayout.CENTER);
	}
	
	public void AddSubTask(){}
	
public class JLabelHandler extends AbstractAction implements MouseListener{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
		}
		
		public void mouseExited (MouseEvent e) { 
		 
		}

		@Override
		public void mouseClicked(MouseEvent click) {
			
			Task selectedTaskPanel = (Task) click.getSource();
			
			// edit task
			if(selectedTaskPanel.getName() == "editLabel"){
				String name = selectedTaskPanel.task.getText();
				name = JOptionPane.showInputDialog(null, "SubTask Name", name);
		
				if(name == null){
					return;
				}

				else{
					selectedTaskPanel.task.setText(name);
				}
			}
			// add task
			else if (selectedTaskPanel.getName() == "addLabel")
			{
				System.out.println("In here");
				subTaskWindow.AddSubTask();
			}
			// delete task
			else if (selectedTaskPanel.getName() == "deleteLabel")
			{
				setVisible(false);
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
