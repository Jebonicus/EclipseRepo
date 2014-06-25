package com.jebonicus.jcvtest;

import org.bytedeco.javacpp.opencv_core.IplImage;

public abstract class JCVProcessor implements ImageConsumer {

	private ImageConsumer imageConsumer;

	public void setOutput(ImageConsumer imageConsumer) {
		this.imageConsumer = imageConsumer;
	}
	
	protected void fireImageAvailable(IplImage image) {
		if(imageConsumer != null) {
			imageConsumer.imageAvailable(image);
		}
	}
	
}
