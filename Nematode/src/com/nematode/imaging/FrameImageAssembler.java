package com.nematode.imaging;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.nematode.gui.NematodeVideoPanel;

public class FrameImageAssembler implements FrameImageAssemblerInterface {

	@Override
	public DisplayFrameImageInterface createDisplayFrameImage(
			final BufferedImage image) {

		final BufferedImage displayImage = new BufferedImage(
				NematodeVideoPanel.ICON_WIDTH, NematodeVideoPanel.ICON_HEIGHT,
				BufferedImage.TYPE_INT_RGB);

		final Graphics displayImageGraphics = displayImage.getGraphics();
		final int startingXCoordinate = 0;
		final int startingYCoordinate = 0;

		displayImageGraphics.drawImage(image, startingXCoordinate,
				startingYCoordinate, NematodeVideoPanel.ICON_WIDTH,
				NematodeVideoPanel.ICON_HEIGHT, null);

		displayImageGraphics.dispose();

		return new DisplayFrameImage(displayImage);
	}

	@Override
	public VideoFrameImageInterface createVideoFrameImage(
			final BufferedImage image) {

		final VideoFrameImage videoFrameImage = new VideoFrameImage(image);
		return videoFrameImage;
	}

}