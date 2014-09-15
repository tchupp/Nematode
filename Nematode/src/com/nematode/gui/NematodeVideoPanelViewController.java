package com.nematode.gui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.nematode.imaging.VideoFrameHandlerInterface;
import com.nematode.model.DisplayFrameImageChangeObserver;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.model.NematodeVideoFrameObserverInterface;

public class NematodeVideoPanelViewController implements
NematodePanelViewControllerInterface {

	private final NematodeVideoPanel nematodeVideoPanel;
	private final NematodeVideoFrameInterface nematodeVideoFrame;
	private final DisplayFrameImageChangeObserver frameObserver;

	public NematodeVideoPanelViewController(
			final NematodeVideoFrameInterface nematodeVideoFrame) {
		this.nematodeVideoFrame = nematodeVideoFrame;
		this.frameObserver = new DisplayFrameImageChangeObserver(this);
		this.nematodeVideoFrame.addObserver(this.frameObserver);

		this.nematodeVideoPanel = new NematodeVideoPanel();
	}

	@Override
	public NematodePanel getNematodePanel() {
		return this.nematodeVideoPanel;
	}

	@Override
	public void updateImage() {
		final BufferedImage newImageForPanel = this.nematodeVideoFrame
				.getDisplayFrameImage().getImage();

		final JLabel imageLabel = this.nematodeVideoPanel.getImageLabel();
		imageLabel.setIcon(new ImageIcon(newImageForPanel));
	}

	public NematodeVideoFrameInterface getNematodeVideoFrame() {
		return this.nematodeVideoFrame;
	}

	public NematodeVideoFrameObserverInterface getFrameObserver() {
		return this.frameObserver;
	}

	@Override
	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return null;
	}

}
