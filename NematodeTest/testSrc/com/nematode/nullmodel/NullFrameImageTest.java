package com.nematode.nullmodel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.ProcessedFrameImageInterface;
import com.nematode.image.VideoFrameImageInterface;
import com.nematode.unittesting.AssertTestCase;

public class NullFrameImageTest extends AssertTestCase {

	@Test
	public void testImplementsInterfaces() throws Exception {
		assertImplementsInterfaces(NullFrameImage.class,
				DisplayFrameImageInterface.class,
				VideoFrameImageInterface.class,
				ProcessedFrameImageInterface.class);
	}

	@Test
	public void testNoPublicConstructors() throws Exception {

		final Constructor<?>[] declaredConstructors = NullFrameImage.class
				.getDeclaredConstructors();
		assertEquals(1, declaredConstructors.length);
		assertTrue(Modifier.isPrivate(declaredConstructors[0].getModifiers()));
	}

	@Test
	public void testGetsNullBufferedImage() throws Exception {
		final VideoFrameImageInterface nullVideoFrameImage = NullFrameImage.NULL;

		assertIsOfTypeAndGet(NullBufferedImage.class,
				nullVideoFrameImage.getImage());
	}

	@Test
	public void testNULLReturnsCorrectImplementationOfInterface()
			throws Exception {
		final VideoFrameImageInterface nullVideoFrameImage = NullFrameImage.NULL;
		final DisplayFrameImageInterface nullDisplayFrameImage = NullFrameImage.NULL;
		assertSame(nullVideoFrameImage, nullDisplayFrameImage);
	}
}
