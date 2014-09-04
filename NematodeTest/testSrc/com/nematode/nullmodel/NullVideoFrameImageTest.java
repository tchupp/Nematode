package com.nematode.nullmodel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.nematode.imaging.VideoFrameImageInterface;
import com.nematode.unittesting.AssertTestCase;

public class NullVideoFrameImageTest extends AssertTestCase {

	@Test
	public void testNoPublicConstructors() throws Exception {

		final Constructor<?>[] declaredConstructors = NullVideoFrameImage.class
				.getDeclaredConstructors();
		assertEquals(1, declaredConstructors.length);
		assertTrue(Modifier.isPrivate(declaredConstructors[0].getModifiers()));
	}

	@Test
	public void testGetsNullBufferedImage() throws Exception {
		final VideoFrameImageInterface nullVideoFrameImage = NullVideoFrameImage.NULL;

		assertIsOfTypeAndGet(NullBufferedImage.class,
				nullVideoFrameImage.getBufferedImage());
	}
}
