package com.nematode.fileIO;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ImageFileChooserTest extends AssertTestCase {

	@Test
	public void testExtendsJFileChooser() throws Exception {
		assertExtends(AbstractFileChooser.class, ImageFileChooser.class);
	}

	@Test
	public void testFileChooserCorrectlyAssembled() throws Exception {
		final ImageFileChooser imageFileChooser = new ImageFileChooser();
		assertEquals("Open", imageFileChooser.getApproveButtonText());
		assertEquals(1, imageFileChooser.getChoosableFileFilters().length);
		assertIsOfTypeAndGet(ImageFileFilter.class,
				imageFileChooser.getChoosableFileFilters()[0]);
	}
}
