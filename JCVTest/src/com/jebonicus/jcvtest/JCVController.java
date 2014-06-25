package com.jebonicus.jcvtest;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class JCVController {

	private JCVProcessor processor;
	private OpenCVFrameGrabber frameGrabber;
	protected boolean started;

	public JCVController() {
		try {
			frameGrabber = OpenCVFrameGrabber.createDefault(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Thread("Frame Grabber") {
			public void run() {
				while(true) {
					IplImage img = null;
					synchronized(JCVController.this) {
						if(!started) {
							try {
								JCVController.this.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						try {
							img = frameGrabber.grab();
						} catch (Exception e) {
							e.printStackTrace();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e1) {
							}
						}
					}
					if(img != null) {
						processor.imageAvailable(img);
					}
				}
			};
		}.start();
	}
	
	public void setProcessor(JCVProcessor processor) {
		this.processor = processor;
	}

	public void start() {
		try {
			frameGrabber.start();
			started = true;
			synchronized (this) {
				notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		try {
			started = false;
			synchronized (this) {
				frameGrabber.stop();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
