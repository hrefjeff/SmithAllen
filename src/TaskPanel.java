import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaskPanel extends JPanel{

	JPanel ContentPanel = new JPanel();
	JTextField taskName = new JTextField("Task Name");
	
	JLabel editLabel;
	JLabel deleteLabel;
	JCheckBox task;
	
	JLabelHandler labelEvent;
	
	public TaskPanel(){
		
		//setLayout(new BorderLayout());
		
		//add(taskName, BorderLayout.NORTH);
		
		ContentPanel.setLayout(new BoxLayout(ContentPanel, BoxLayout.X_AXIS));
		
		String name = null;
		name = JOptionPane.showInputDialog(null, "Task Name");
		
		if(name == null){
			return;
		}
		else{
			task = new JCheckBox(name);
			ContentPanel.add(task);
		}
		
		//**********Add edit & delete buttons*******************
		labelEvent = new JLabelHandler();
		
		ImageIcon edit = new ImageIcon("edit.jpg");
		editLabel = new JLabel(edit);
		editLabel.addMouseListener(labelEvent);
		
		ImageIcon delete = new ImageIcon("delete.jpg");
		deleteLabel = new JLabel(delete);
		deleteLabel.addMouseListener(labelEvent);		
		
		add(ContentPanel);
		add(editLabel);
		add(deleteLabel);
	}
	
public class JLabelHandler extends AbstractAction implements MouseListener{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
		}
		
		public void mouseExited (MouseEvent e) { 
		 
		}

		@Override
		public void mouseClicked(MouseEvent click) {
			if(click.getSource() == editLabel){
				String name = task.getText();
				name = JOptionPane.showInputDialog(null, "SubTask Name", name);
		
				if(name == null){
					return;
				}
		
				else{
					task.setText(name);
				}
			} 
			else
			{
				// Delete the panel that calls this
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
