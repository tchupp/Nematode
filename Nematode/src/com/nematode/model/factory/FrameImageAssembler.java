package com.nematode.model.factory;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.nematode.gui.GuiConstants;
import com.nematode.image.DisplayFrameImage;
import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.VideoFrameImage;
import com.nematode.image.VideoFrameImageInterface;

public class FrameImageAssembler implements FrameImageAssemblerInterface {

	@Override
	public DisplayFrameImageInterface createDisplayFrameImage(final BufferedImage image) {

		final BufferedImage displayImage = new BufferedImage(GuiConstants.DISPLAY_WIDTH,
				GuiConstants.DISPLAY_HEIGHT, BufferedImage.TYPE_INT_RGB);

		final Graphics displayImageGraphics = displayImage.getGraphics();
		final int startingXCoordinate = 0;
		final int startingYCoordinate = 0;

		displayImageGraphics.drawImage(image, startingXCoordinate, startingYCoordinate,
				GuiConstants.DISPLAY_WIDTH, GuiConstants.DISPLAY_HEIGHT, null);

		displayImageGraphics.dispose();

		return new DisplayFrameImage(displayImage);
	}

	@Override
	public VideoFrameImageInterface createVideoFrameImage(final BufferedImage image) {
		final BufferedImage videoImage = new BufferedImage(GuiConstants.VIDEO_FRAME_WIDTH,
				GuiConstants.VIDEO_FRAME_HEIGHT, BufferedImage.TYPE_INT_RGB);

		final Graphics videoImageGraphics = videoImage.getGraphics();
		final int startingXCoordinate = 0;
		final int startingYCoordinate = 0;

		videoImageGraphics.drawImage(image, startingXCoordinate, startingYCoordinate,
				GuiConstants.VIDEO_FRAME_WIDTH, GuiConstants.VIDEO_FRAME_HEIGHT, null);

		videoImageGraphics.dispose();

		return new VideoFrameImage(videoImage);
	}
}
