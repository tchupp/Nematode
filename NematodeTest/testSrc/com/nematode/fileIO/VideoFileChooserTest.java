package com.nematode.fileIO;

import javax.swing.filechooser.FileFilter;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class VideoFileChooserTest extends AssertTestCase {
	@Test
	public void testExtendsAbstractFileChooser() throws Exception {
		assertExtends(AbstractFileChooser.class, VideoFileChooser.class);
	}

	@Test
	public void testVideoFileChooserCorrectSetup() throws Exception {
		final VideoFileChooser videoFileChooser = new VideoFileChooser();

		assertEquals("Open", videoFileChooser.getApproveButtonText());

		final FileFilter[] choosableFileFilters = videoFileChooser.getChoosableFileFilters();
		assertEquals(1, choosableFileFilters.length);

		assertIsOfTypeAndGet(VideoFileFilter.class, choosableFileFilters[0]);
	}
}
