package com.jebonicus.jcvtest;

import org.bytedeco.javacpp.opencv_core.IplImage;

public class JCVProcessor1 extends JCVProcessor {

	public void imageAvailable(IplImage image) {
		fireImageAvailable(image);
	}

}
