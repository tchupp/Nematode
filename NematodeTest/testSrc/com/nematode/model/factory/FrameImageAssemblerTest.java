package com.nematode.model.factory;

import java.awt.image.BufferedImage;

import org.junit.Test;

import com.nematode.gui.GuiConstants;
import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.NullBufferedImage;
import com.nematode.image.VideoFrameImageInterface;
import com.nematode.unittesting.AssertTestCase;

public class FrameImageAssemblerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(FrameImageAssemblerInterface.class, FrameImageAssembler.class);
	}

	@Test
	public void testCreateDisplayImageReturnsCorrectlySizedFrame() throws Exception {
		final FrameImageAssembler imageAssembler = new FrameImageAssembler();

		final DisplayFrameImageInterface displayFrameImage = imageAssembler
				.createDisplayFrameImage(new NullBufferedImage());

		final BufferedImage newDisplayImage = displayFrameImage.getImage();
		assertEquals(GuiConstants.DISPLAY_WIDTH, newDisplayImage.getWidth());
		assertEquals(GuiConstants.DISPLAY_HEIGHT, newDisplayImage.getHeight());
	}

	@Test
	public void testCreateVideoFrameImageReturnsCorrectlySizedFrame() throws Exception {
		final FrameImageAssembler imageAssembler = new FrameImageAssembler();

		final VideoFrameImageInterface videoFrameImage = imageAssembler
				.createVideoFrameImage(new NullBufferedImage());

		assertEquals(GuiConstants.VIDEO_FRAME_WIDTH, videoFrameImage.getImage().getWidth());
		assertEquals(GuiConstants.VIDEO_FRAME_HEIGHT, videoFrameImage.getImage().getHeight());
	}

}
