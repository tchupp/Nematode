package com.nematode.imaging;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.nematode.fileIO.ValidatedImageFileInterface;
import com.nematode.gui.NematodeVideoPanel;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.nullmodel.NullFrameImage;

public class VideoFrameBuilder implements VideoFrameBuilderInterface {

	private final NematodeVideoFrameInterface nematodeVideoFrame;

	public VideoFrameBuilder(
			final NematodeVideoFrameInterface nematodeVideoFrame) {
		this.nematodeVideoFrame = nematodeVideoFrame;
	}

	@Override
	public void buildNewFrameImageFromFile(
			final ValidatedImageFileInterface validatedImageFile) {

		if (validatedImageFile.isFileValid()) {
			final BufferedImage fileImage = validatedImageFile.getFileImage();

			final VideoFrameImageInterface videoFrameImage = createVideoFrameImage(fileImage);
			this.nematodeVideoFrame.setVideoFrameImage(videoFrameImage);

			final DisplayFrameImageInterface displayFrameImage = createDisplayFrameImage(fileImage);
			this.nematodeVideoFrame.setDisplayFrameImage(displayFrameImage);

		} else {
			this.nematodeVideoFrame.setVideoFrameImage(NullFrameImage.NULL);
			this.nematodeVideoFrame.setDisplayFrameImage(NullFrameImage.NULL);
		}
	}

	public DisplayFrameImageInterface createDisplayFrameImage(
			final BufferedImage fileImage) {

		final BufferedImage displayImage = new BufferedImage(
				NematodeVideoPanel.ICON_WIDTH, NematodeVideoPanel.ICON_HEIGHT,
				BufferedImage.TYPE_INT_RGB);

		final Graphics displayImageGraphics = displayImage.getGraphics();
		final int startingXCoordinate = 0;
		final int startingYCoordinate = 0;

		displayImageGraphics.drawImage(fileImage, startingXCoordinate,
				startingYCoordinate, NematodeVideoPanel.ICON_WIDTH,
				NematodeVideoPanel.ICON_HEIGHT, null);

		displayImageGraphics.dispose();

		return new DisplayFrameImage(displayImage);
	}

	public VideoFrameImageInterface createVideoFrameImage(
			final BufferedImage fileImage) {
		final VideoFrameImage videoFrameImage = new VideoFrameImage(fileImage);
		return videoFrameImage;
	}

	public NematodeVideoFrameInterface getNematodeVideoFrame() {
		return this.nematodeVideoFrame;
	}
}
