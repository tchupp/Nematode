package com.nematode.imaging;

import java.awt.image.BufferedImage;

import org.junit.Test;

import com.nematode.nullmodel.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class BlackAndWhiteImageTest extends AssertTestCase {

	@Test
	public void testExtendsBufferedImage() throws Exception {
		assertExtends(BufferedImage.class, BlackAndWhiteImage.class);
	}

	@Test
	public void testImageTypeIsBinary_SizeConstructor() throws Exception {
		final BlackAndWhiteImage blackAndWhiteImage = new BlackAndWhiteImage(1,
				1);

		assertEquals(BufferedImage.TYPE_BYTE_BINARY,
				blackAndWhiteImage.getType());
	}

	@Test
	public void testImageTypeIsBinary_CopyConstructor() throws Exception {
		final BlackAndWhiteImage blackAndWhiteImage = new BlackAndWhiteImage(
				new NullBufferedImage());

		assertEquals(BufferedImage.TYPE_BYTE_BINARY,
				blackAndWhiteImage.getType());
	}

}
