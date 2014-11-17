package com.nematode.fileIO;

import javax.swing.filechooser.FileFilter;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ImageFileChooserTest extends AssertTestCase {

	@Test
	public void testExtendsAbstractFileChooser() throws Exception {
		assertExtends(AbstractFileChooser.class, ImageFileChooser.class);
	}

	@Test
	public void testFileChooserCorrectlyAssembled() throws Exception {
		final ImageFileChooser imageFileChooser = new ImageFileChooser();

		assertEquals("Open", imageFileChooser.getApproveButtonText());

		final FileFilter[] choosableFileFilters = imageFileChooser.getChoosableFileFilters();
		assertEquals(1, choosableFileFilters.length);

		assertIsOfTypeAndGet(ImageFileFilter.class, choosableFileFilters[0]);
	}
}
