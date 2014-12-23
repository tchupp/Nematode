package com.nematode.fileIO;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class VideoFileFilterTest extends AssertTestCase {

	@Test
	public void testExtendsFileFilter() throws Exception {
		assertExtends(FileFilter.class, VideoFileFilter.class);
	}

	@Test
	public void testAcceptReturnsTrueFor_AVI_and_MP4() throws Exception {
		final VideoFileFilter videoFileFilter = new VideoFileFilter();
		assertTrue(videoFileFilter.accept(new File("testResources/Videos/shortNematode_10mp4.mp4")));
		assertTrue(videoFileFilter.accept(new File("testResources/Videos/shortNematode_10avi.avi")));
	}

	@Test
	public void testAcceptReturnsTrueForDirectories() throws Exception {
		final VideoFileFilter videoFileFilter = new VideoFileFilter();
		assertTrue(videoFileFilter.accept(new File("testResources")));
		assertFalse(videoFileFilter.accept(new File("testResources/Text/testTxt.txt")));
	}

	@Test
	public void testGetsDescription() throws Exception {
		final VideoFileFilter videoFileFilter = new VideoFileFilter();
		assertEquals("AVI, and MP4 video files", videoFileFilter.getDescription());
	}
}
