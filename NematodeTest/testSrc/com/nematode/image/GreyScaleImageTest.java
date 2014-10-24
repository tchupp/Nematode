package com.nematode.image;

import java.awt.image.BufferedImage;

import org.junit.Test;

import com.nematode.image.GreyScaleImage;
import com.nematode.nullmodel.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class GreyScaleImageTest extends AssertTestCase {

	@Test
	public void testExtendsBufferedImage() throws Exception {
		assertExtends(BufferedImage.class, GreyScaleImage.class);
	}

	@Test
	public void testImageTypeIsGray_SizeConstructor() throws Exception {
		final GreyScaleImage greyScaleImage = new GreyScaleImage(1, 1);

		assertEquals(BufferedImage.TYPE_BYTE_GRAY, greyScaleImage.getType());
	}

	@Test
	public void testImageTypeIsGray_CopyConstructor() throws Exception {
		final GreyScaleImage greyScaleImage = new GreyScaleImage(
				new NullBufferedImage());

		assertEquals(BufferedImage.TYPE_BYTE_GRAY, greyScaleImage.getType());
	}

}
