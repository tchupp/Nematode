package com.nematode.gui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.nematode.model.DisplayFrameImageChangeObserver;
import com.nematode.model.VideoFrameHandlerInterface;
import com.nematode.model.VideoFrameInterface;
import com.nematode.model.VideoFrameObserverInterface;

public class VideoPanelViewController implements VideoPanelViewControllerInterface {

	private final VideoPanel videoPanel;
	private final VideoFrameInterface videoFrame;
	private final DisplayFrameImageChangeObserver frameObserver;
	private final VideoFrameHandlerInterface videoFrameHandler;

	public VideoPanelViewController(final VideoFrameHandlerInterface videoFrameHandler) {
		this.videoFrameHandler = videoFrameHandler;
		this.videoFrame = this.videoFrameHandler.getVideoFrame();
		this.frameObserver = new DisplayFrameImageChangeObserver(this);
		this.videoFrame.addObserver(this.frameObserver);

		this.videoPanel = new VideoPanel();
	}

	@Override
	public ExtendableJPanel getVideoPanel() {
		return this.videoPanel;
	}

	@Override
	public void updateImage() {
		final BufferedImage newImageForPanel = this.videoFrame.getDisplayFrameImage().getImage();

		final JLabel imageLabel = this.videoPanel.getImageLabel();
		imageLabel.setIcon(new ImageIcon(newImageForPanel));
	}

	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return this.videoFrameHandler;
	}

	public VideoFrameObserverInterface getFrameObserver() {
		return this.frameObserver;
	}

}
