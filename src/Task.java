import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Task extends JPanel {
	
	JLabel editLabel;
	JLabel deleteLabel;
	JCheckBox task;
	
	JLabelHandler labelEvent;
	
	public Task()
	{
		
		setLayout(new FlowLayout());
		
		setTaskName();
		
		addBasicButtons();
	}
	
	public String getText()
	{
		return task.getText();
	}
	
	public void setTaskName()
	{
		String name = null;
		name = JOptionPane.showInputDialog(null, "Task Name");
		
		if(name == null){
			return;
		}
		else{
			task = new JCheckBox(name);
			add(task);
		}
	}
	
	public void addBasicButtons()
	{
		labelEvent = new JLabelHandler();

		ImageIcon edit = new ImageIcon("edit.jpg");
		editLabel = new JLabel(edit);
		editLabel.addMouseListener(labelEvent);

		ImageIcon delete = new ImageIcon("delete.jpg");
		deleteLabel = new JLabel(delete);
		deleteLabel.addMouseListener(labelEvent);
		
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
