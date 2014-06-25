package com.jebonicus.jcvtest;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JCVControlPanel extends JPanel {

	private JCVController controller;
	
	public JCVControlPanel() {
		setLayout(new GridBagLayout());
		final JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false);
				new Thread() {
					public void run() {
						if("Start".equals(startButton.getText())) {
							controller.start();
							startButton.setText("Stop");
						} else {
							controller.stop();
							startButton.setText("Start");
						}
						startButton.setEnabled(true);
					};
				}.start();
			}
		});
		add(startButton , new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0,0,0,0), 0, 0));
	}

	public void setController(JCVController controller) {
		this.controller = controller;
	}

}
