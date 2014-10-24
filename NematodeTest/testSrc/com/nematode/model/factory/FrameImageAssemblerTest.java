package com.nematode.model.factory;

import org.junit.Test;

import com.nematode.gui.NematodeVideoPanel;
import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.VideoFrameImageInterface;
import com.nematode.model.factory.FrameImageAssembler;
import com.nematode.model.factory.FrameImageAssemblerInterface;
import com.nematode.nullmodel.NullBufferedImage;
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

		assertEquals(NematodeVideoPanel.ICON_WIDTH, displayFrameImage.getImage().getWidth());
		assertEquals(NematodeVideoPanel.ICON_HEIGHT, displayFrameImage.getImage().getHeight());
	}

	@Test
	public void testCreateVideoFrameImageReturnsCorrectlySizedFrame() throws Exception {
		final FrameImageAssembler imageAssembler = new FrameImageAssembler();

		final VideoFrameImageInterface videoFrameImage = imageAssembler
				.createVideoFrameImage(new NullBufferedImage());

		assertEquals(FrameImageAssembler.VIDEO_WIDTH, videoFrameImage.getImage().getWidth());
		assertEquals(FrameImageAssembler.VIDEO_HEIGHT, videoFrameImage.getImage().getHeight());
	}

	@Test
	public void testStaticVideoFrameHeightAndWidth() throws Exception {
		assertEquals(1920, FrameImageAssembler.VIDEO_WIDTH);
		assertEquals(1080, FrameImageAssembler.VIDEO_HEIGHT);
	}

}
