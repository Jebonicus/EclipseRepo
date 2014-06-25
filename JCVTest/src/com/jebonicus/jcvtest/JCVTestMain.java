package com.jebonicus.jcvtest;

import javax.swing.JFrame;

public class JCVTestMain extends JFrame {
	
	public JCVTestMain() {
		super("JCVTest");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JCVTestMain();
	}

}
