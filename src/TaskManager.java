import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TaskManager extends JFrame implements ActionListener {

    JPanel p = new JPanel(new GridLayout(6,0));
	AddJPanelButtonHandler AddJPanel;
	
	public TaskManager()
	{
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JScrollPane jsp = new JScrollPane(p);
	    
	    jsp.setPreferredSize(new Dimension(300,300));
	    jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

	    JButton addButton = new JButton("Add Button");
	    AddJPanel = new AddJPanelButtonHandler();
	    addButton.addActionListener(AddJPanel);
	    p.add(addButton);
	    
	    for (int i = 0; i < 2; i++) {
	        JButton b = new JButton("Initial Course");
	        p.add(b);
	    }

	    add(jsp, BorderLayout.CENTER);
	    setLocation(300, 300);
	    setVisible(true);
	    pack();

	    
	}
	
	public static void main(String[] args) {
		
		TaskManager mySched = new TaskManager();
		
		
    }
	
	// When button is pressed
	public void actionPerformed(ActionEvent e){
		return;
	}
	
	//========Custom action listener===========
	public class AddJPanelButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton b = new JButton("New Course");
	        p.add(b);
	        p.revalidate();
			
		}
		
	}
}
