package com.nematode.image;

import org.junit.Test;

import com.nematode.image.DisplayFrameImage;
import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.nullmodel.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class DisplayFrameImageTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(DisplayFrameImageInterface.class,
				DisplayFrameImage.class);
	}

	@Test
	public void testGetsImage() throws Exception {
		final NullBufferedImage bufferedImage = new NullBufferedImage();
		final DisplayFrameImage displayFrameImage = new DisplayFrameImage(
				bufferedImage);

		assertSame(bufferedImage, displayFrameImage.getImage());
	}

}
