import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class MainTask extends Task{
	
	JLabel addLabel;
	
	MainTaskHandler mainTaskEvent;
	
	public MainTask(){
	
		super();
		
		setBackground(Color.RED);
		
		//************Add an AddSubTaskButton*******************
		mainTaskEvent = new MainTaskHandler();
		ImageIcon add = new ImageIcon("add.jpg", "Add SubTask");
		addLabel = new JLabel(add);
		
		add(addLabel);
	}
	
	public MainTask(String taskName)
	{
		super();
		
		mainTaskEvent = new MainTaskHandler();
		
		ImageIcon add = new ImageIcon("add.jpg", "Add SubTask");
		addLabel = new JLabel(add);
		
		addLabel.addMouseListener(mainTaskEvent);
		
		add(addLabel);
	}
	
	public class AddJPanelButtonHandler extends AbstractAction{
	
		@Override
		public void actionPerformed(ActionEvent e){

			AddSubTask();

		}
	}
	
	public class MainTaskHandler extends AbstractAction implements MouseListener {
	
		@Override
		public void actionPerformed(ActionEvent e){
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			//AddSubTask();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
