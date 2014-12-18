package com.nematode.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.nematode.gui.backend.VideoFrameDisplayInfoInterface;
import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.model.VideoFrameInterface;
import com.nematode.model.VideoFrameSequenceInterface;
import com.nematode.model.factory.FrameImageAssemblerInterface;

public class VideoPanelViewController implements VideoPanelViewControllerInterface {

	private final VideoPanel videoPanel;
	private final FrameImageAssemblerInterface frameImageAssembler;

	public VideoPanelViewController(final FrameImageAssemblerInterface frameImageAssembler) {
		this.frameImageAssembler = frameImageAssembler;
		this.videoPanel = new VideoPanel();
	}

	@Override
	public ExtendableJPanel getVideoPanel() {
		return this.videoPanel;
	}

	@Override
	public void updateDisplay(final VideoFrameDisplayInfoInterface displayInfo,
			final VideoFrameSequenceInterface videoSequence) {
		final VideoFrameInterface videoFrameAtNumber = videoSequence.getVideoFrame(displayInfo
				.getFrameNumber());
		final DisplayFrameImageInterface newDisplayImage = this.frameImageAssembler
				.createDisplayFrameImage(videoFrameAtNumber.getVideoFrameImage().getImage());

		final ImageIcon newImageIcon = new ImageIcon(newDisplayImage.getImage());
		final JLabel imageLabel = this.videoPanel.getImageLabel();
		imageLabel.setIcon(newImageIcon);
	}

	public FrameImageAssemblerInterface getFrameImageAssembler() {
		return this.frameImageAssembler;
	}

}
