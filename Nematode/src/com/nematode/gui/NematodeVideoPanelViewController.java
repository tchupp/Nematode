package com.nematode.gui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.nematode.model.DisplayFrameImageChangeObserver;
import com.nematode.model.VideoFrameObserverInterface;
import com.nematode.model.VideoFrameHandlerInterface;
import com.nematode.model.VideoFrameInterface;

public class NematodeVideoPanelViewController implements NematodePanelViewControllerInterface {

	private final NematodeVideoPanel nematodeVideoPanel;
	private final VideoFrameInterface videoFrame;
	private final DisplayFrameImageChangeObserver frameObserver;
	private final VideoFrameHandlerInterface videoFrameHandler;

	public NematodeVideoPanelViewController(final VideoFrameHandlerInterface videoFrameHandler) {
		this.videoFrameHandler = videoFrameHandler;
		this.videoFrame = this.videoFrameHandler.getVideoFrame();
		this.frameObserver = new DisplayFrameImageChangeObserver(this);
		this.videoFrame.addObserver(this.frameObserver);

		this.nematodeVideoPanel = new NematodeVideoPanel();
	}

	@Override
	public ExtendableJPanel getNematodePanel() {
		return this.nematodeVideoPanel;
	}

	@Override
	public void updateImage() {
		final BufferedImage newImageForPanel = this.videoFrame.getDisplayFrameImage()
				.getImage();

		final JLabel imageLabel = this.nematodeVideoPanel.getImageLabel();
		imageLabel.setIcon(new ImageIcon(newImageForPanel));
	}

	@Override
	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return this.videoFrameHandler;
	}

	public VideoFrameObserverInterface getFrameObserver() {
		return this.frameObserver;
	}

}
