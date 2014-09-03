package com.nematode.nullmodel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.unittesting.AssertTestCase;

public class NullNematodeVideoFrameTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeVideoFrameInterface.class,
				NullNematodeVideoFrame.class);
	}

	@Test
	public void testNoPublicConstructor() throws Exception {

		final Constructor<?>[] declaredConstructors = NullNematodeVideoFrame.class
				.getDeclaredConstructors();
		assertEquals(1, declaredConstructors.length);
		assertTrue(Modifier.isPrivate(declaredConstructors[0].getModifiers()));
	}

	@Test
	public void testNullReturnsCorrectObject() throws Exception {
		assertIsOfTypeAndGet(NullNematodeVideoFrame.class,
				NullNematodeVideoFrame.NULL);
	}

}
