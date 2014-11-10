package com.nematode.gui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.nematode.gui.backend.VideoFrameDisplayInformationInterface;
import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.model.DisplayFrameImageChangeObserver;
import com.nematode.model.VideoFrameHandlerInterface;
import com.nematode.model.VideoFrameInterface;
import com.nematode.model.VideoFrameObserverInterface;
import com.nematode.model.VideoFrameSequenceInterface;
import com.nematode.model.factory.FrameImageAssemblerInterface;

public class VideoPanelViewController implements VideoPanelViewControllerInterface {

	private final VideoPanel videoPanel;
	private final VideoFrameInterface videoFrame;
	private final DisplayFrameImageChangeObserver frameObserver;
	private final VideoFrameHandlerInterface videoFrameHandler;
	private final FrameImageAssemblerInterface frameImageAssembler;

	public VideoPanelViewController(final VideoFrameHandlerInterface videoFrameHandler,
			final FrameImageAssemblerInterface frameImageAssembler) {
		this.videoFrameHandler = videoFrameHandler;
		this.frameImageAssembler = frameImageAssembler;
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
	public void updateVideoDisplay() {
		final BufferedImage newImageForPanel = this.videoFrame.getDisplayFrameImage().getImage();

		final JLabel imageLabel = this.videoPanel.getImageLabel();
		imageLabel.setIcon(new ImageIcon(newImageForPanel));
	}

	@Override
	public void updateDisplay(final VideoFrameDisplayInformationInterface displayInfo,
			final VideoFrameSequenceInterface videoSequence) {
		final VideoFrameInterface videoFrameAtNumber = videoSequence.getFrame(displayInfo
				.getFrameNumber());
		final DisplayFrameImageInterface newDisplayImage = this.frameImageAssembler
				.createDisplayFrameImage(videoFrameAtNumber.getVideoFrameImage().getImage());

		final ImageIcon newImageIcon = new ImageIcon(newDisplayImage.getImage());
		final JLabel imageLabel = this.videoPanel.getImageLabel();
		imageLabel.setIcon(newImageIcon);
	}

	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return this.videoFrameHandler;
	}

	public FrameImageAssemblerInterface getFrameImageAssembler() {
		return this.frameImageAssembler;
	}

	public VideoFrameObserverInterface getFrameObserver() {
		return this.frameObserver;
	}

}
