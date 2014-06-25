package com.jebonicus.jcvtest;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

public class JCVTestMain extends JFrame {
	
	private JCVControlPanel controlPanel = new JCVControlPanel();
	private JCVImagePanel imagePanel = new JCVImagePanel();
	
	private JCVProcessor processor = new JCVProcessor1();
	
	private JCVController controller = new JCVController();

	public JCVTestMain() {
		super("JCVTest");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(new GridBagLayout());
		add(controlPanel, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		add(imagePanel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0,0,0,0),0,0));
		
		controller.setProcessor(processor);
		controlPanel.setController(controller);
		processor.setOutput(imagePanel);
	}

	public static void main(String[] args) {
		new JCVTestMain();
	}

}
