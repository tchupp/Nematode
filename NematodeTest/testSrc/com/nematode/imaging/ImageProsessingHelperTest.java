package com.nematode.imaging;

import java.awt.image.BufferedImage;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ImageProsessingHelperTest extends AssertTestCase {

	@Test
	public void testConvertsImageToGreyScale() throws Exception {
		final ImageProsessingHelper imageProsessingHelper = new ImageProsessingHelper();
		final BufferedImage inputImage = new BufferedImage(50, 50,
				BufferedImage.TYPE_INT_ARGB);

		final BufferedImage convertedImage = imageProsessingHelper
				.convertImageToGrayScale(inputImage);

		assertEquals(BufferedImage.TYPE_BYTE_GRAY, convertedImage.getType());
	}
}