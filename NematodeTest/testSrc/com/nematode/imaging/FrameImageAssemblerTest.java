package com.nematode.imaging;

import java.awt.image.BufferedImage;

import org.junit.Test;

import com.nematode.gui.NematodeVideoPanel;
import com.nematode.nullmodel.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class FrameImageAssemblerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(FrameImageAssemblerInterface.class,
				FrameImageAssembler.class);
	}

	@Test
	public void testCreateDisplayImageReturnsCorrectlySizedFrame()
			throws Exception {
		final FrameImageAssembler imageAssembler = new FrameImageAssembler();

		final DisplayFrameImageInterface displayFrameImage = imageAssembler
				.createDisplayFrameImage(new NullBufferedImage());

		assertEquals(NematodeVideoPanel.ICON_WIDTH, displayFrameImage
				.getImage().getWidth());
		assertEquals(NematodeVideoPanel.ICON_HEIGHT, displayFrameImage
				.getImage().getHeight());
	}

	@Test
	public void testCreateVideoFrameImageReturnsCorrectlySizedFrame()
			throws Exception {

		final FrameImageAssembler imageAssembler = new FrameImageAssembler();

		final int expectedWidth = 56;
		final int expectedHeight = 56;
		final BufferedImage expectedImage = new BufferedImage(expectedWidth,
				expectedHeight, BufferedImage.TYPE_INT_RGB);

		final VideoFrameImageInterface frameImage = imageAssembler
				.createVideoFrameImage(expectedImage);

		assertSame(expectedImage, frameImage.getImage());
	}

}
