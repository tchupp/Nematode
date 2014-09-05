package com.nematode.gui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.model.NematodeVideoFrameObserverInterface;
import com.nematode.model.VideoFrameImageChangeObserver;

public class NematodeVideoPanelViewController implements
		NematodePanelViewControllerInterface {

	private final NematodeVideoPanel nematodeVideoPanel;
	private final NematodeVideoFrameInterface nematodeVideoFrame;
	private final VideoFrameImageChangeObserver frameObserver;

	public NematodeVideoPanelViewController(
			final NematodeVideoFrameInterface nematodeVideoFrame) {
		this.nematodeVideoFrame = nematodeVideoFrame;
		this.frameObserver = new VideoFrameImageChangeObserver(this);
		nematodeVideoFrame.addObserver(this.frameObserver);

		this.nematodeVideoPanel = new NematodeVideoPanel();
	}

	@Override
	public NematodePanel getNematodePanel() {
		return this.nematodeVideoPanel;
	}

	public NematodeVideoFrameInterface getNematodeVideoFrame() {
		return this.nematodeVideoFrame;
	}

	public NematodeVideoFrameObserverInterface getFrameObserver() {
		return this.frameObserver;
	}

	@Override
	public void updateImage() {
		final BufferedImage newImageForPanel = this.nematodeVideoFrame
				.getVideoFrameImage().getImage();

		final JLabel imageLabel = this.nematodeVideoPanel.getImageLabel();
		final ImageIcon imageIcon = new ImageIcon();
		imageIcon.setImage(newImageForPanel);
		imageLabel.setIcon(imageIcon);

	}
}
