package com.nematode.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.nematode.image.NullFrameImage;
import com.nematode.unittesting.AssertTestCase;

public class NullVideoFrameTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameInterface.class, NullVideoFrame.class);
	}

	@Test
	public void testNoPublicConstructor() throws Exception {

		final Constructor<?>[] declaredConstructors = NullVideoFrame.class
				.getDeclaredConstructors();
		assertEquals(1, declaredConstructors.length);
		assertTrue(Modifier.isPrivate(declaredConstructors[0].getModifiers()));
	}

	@Test
	public void testNullReturnsCorrectObject() throws Exception {
		assertIsOfTypeAndGet(NullVideoFrame.class, NullVideoFrame.NULL);
	}

	@Test
	public void testGetVideoFrameImageReturnsNullFrameImage() throws Exception {
		final VideoFrameInterface nullVideoFrame = NullVideoFrame.NULL;
		assertIsOfTypeAndGet(NullFrameImage.class, nullVideoFrame.getVideoFrameImage());
	}

}
