package com.nematode.model.factory;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.nematode.gui.VideoPanel;
import com.nematode.image.DisplayFrameImage;
import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.VideoFrameImage;
import com.nematode.image.VideoFrameImageInterface;

public class FrameImageAssembler implements FrameImageAssemblerInterface {

	public static int VIDEO_WIDTH = 1920;
	public static int VIDEO_HEIGHT = 1080;

	@Override
	public DisplayFrameImageInterface createDisplayFrameImage(final BufferedImage image) {

		final BufferedImage displayImage = new BufferedImage(VideoPanel.ICON_WIDTH,
				VideoPanel.ICON_HEIGHT, BufferedImage.TYPE_INT_RGB);

		final Graphics displayImageGraphics = displayImage.getGraphics();
		final int startingXCoordinate = 0;
		final int startingYCoordinate = 0;

		displayImageGraphics.drawImage(image, startingXCoordinate, startingYCoordinate,
				VideoPanel.ICON_WIDTH, VideoPanel.ICON_HEIGHT, null);

		displayImageGraphics.dispose();

		return new DisplayFrameImage(displayImage);
	}

	@Override
	public VideoFrameImageInterface createVideoFrameImage(final BufferedImage image) {
		final BufferedImage videoImage = new BufferedImage(VIDEO_WIDTH, VIDEO_HEIGHT,
				BufferedImage.TYPE_INT_RGB);

		final Graphics videoImageGraphics = videoImage.getGraphics();
		final int startingXCoordinate = 0;
		final int startingYCoordinate = 0;

		videoImageGraphics.drawImage(image, startingXCoordinate, startingYCoordinate, VIDEO_WIDTH,
				VIDEO_HEIGHT, null);

		videoImageGraphics.dispose();

		return new VideoFrameImage(videoImage);
	}
}