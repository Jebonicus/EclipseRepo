package com.jebonicus.jcvtest;

import org.bytedeco.javacpp.opencv_core.IplImage;

public interface ImageConsumer {
	void imageAvailable(IplImage image);
}
