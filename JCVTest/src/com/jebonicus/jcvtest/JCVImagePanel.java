package com.jebonicus.jcvtest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.bytedeco.javacpp.opencv_core.IplImage;

public class JCVImagePanel extends JPanel implements ImageConsumer {

	private BufferedImage image;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image != null) {

			setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
			getRootPane().doLayout();
			g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), 0, 0, image.getWidth(), image.getHeight(), null);
		}
	}

	public void imageAvailable(IplImage image) {
		this.image = image.getBufferedImage();
		repaint();
	}

}
