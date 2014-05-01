import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JPanel;


public class ContentPanel extends JPanel {
	
	public ContentPanel()
	{
		setLayout(new GridLayout(6,0));
	}
	
	public void AddSubTask()
	{
		add(Box.createRigidArea(new Dimension(0,4)));
		SubTask newSub = new SubTask();
		add(newSub);
		revalidate();
	}
	
	public void AddSubTask(String subtaskname)
	{
		add(Box.createRigidArea(new Dimension(0,4)));
		SubTask newSub = new SubTask(subtaskname);
		add(newSub);
		revalidate();
	}

}
