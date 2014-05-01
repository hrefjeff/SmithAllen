import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class SubTask extends Task {
	
	public SubTask(){
		setLayout(new FlowLayout());
		
		setTaskName();
		
		setBasicButtons();
		
		setBackground(Color.BLUE);
	}
	
	public SubTask(String subtaskname)
	{
		super();
		
		task = new JCheckBox(subtaskname);
	}
}