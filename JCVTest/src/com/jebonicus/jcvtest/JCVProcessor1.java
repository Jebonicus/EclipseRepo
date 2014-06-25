package com.jebonicus.jcvtest;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacv.CanvasFrame;

public class JCVProcessor1 extends JCVProcessor {
	
	final CanvasFrame cf = new CanvasFrame("Input image");
	
	public JCVProcessor1() {
		
	}

	public void imageAvailable(IplImage image) {
		cf.showImage(image);

		IplImage imageGray = opencv_core.cvCreateImage(opencv_core.cvSize(image.width(), image.height()), opencv_core.IPL_DEPTH_8U, 1);
		opencv_imgproc.cvCvtColor(image, imageGray, opencv_imgproc.CV_BGR2GRAY );
        IplImage gray = new IplImage(imageGray);
        IplImage edge = opencv_core.cvCreateImage(opencv_core.cvSize(gray.width(), gray.height()), opencv_core.IPL_DEPTH_8U, 1);
        
        opencv_imgproc.cvCanny(gray, edge, 40, 120);
		
		fireImageAvailable(edge);
	}

}
