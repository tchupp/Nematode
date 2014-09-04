package com.nematode.nullmodel;

import java.awt.image.BufferedImage;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NullBufferedImageTest extends AssertTestCase {

	@Test
	public void testExtendsBufferedImage() throws Exception {
		assertExtends(BufferedImage.class, NullBufferedImage.class);
	}

	@Test
	public void testConstructorUsesCorrectArgumentsOnSuper() throws Exception {
		final NullBufferedImage nullBufferedImage = new NullBufferedImage();

		assertEquals(1, nullBufferedImage.getWidth());
		assertEquals(1, nullBufferedImage.getHeight());
		assertEquals(BufferedImage.TYPE_INT_ARGB, nullBufferedImage.getType());
	}
}
