package com.nematode.gui;

import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ImageStoreTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ImageStoreInterface.class, ImageStore.class);
	}

	@Test
	public void testPlayButtonImageIsCorrectImage() throws Exception {
		final ImageStore imageStore = new ImageStore();
		final File playButtonImageFile = imageStore.getPlayButtonImageFile();

		assertTrue(playButtonImageFile.exists());
		assertImagesAreEqual(ImageIO.read(playButtonImageFile), imageStore.getPlayButtonImage());
	}

	@Test
	public void testPauseButtonImageIsCorrectImage() throws Exception {
		final ImageStore imageStore = new ImageStore();
		final File pauseButtonImageFile = imageStore.getPauseButtonImageFile();

		assertTrue(pauseButtonImageFile.exists());
		assertImagesAreEqual(ImageIO.read(pauseButtonImageFile), imageStore.getPauseButtonImage());
	}

	@Test
	public void testMainWindowImageIsCorrectImage() throws Exception {
		final ImageStore imageStore = new ImageStore();
		final File mainWindowBackgroundImageFile = imageStore.getMainWindowBackgroundImageFile();

		assertTrue(mainWindowBackgroundImageFile.exists());
		assertImagesAreEqual(ImageIO.read(mainWindowBackgroundImageFile),
				imageStore.getMainWindowBackgroundImage());
	}

	@Test
	public void testStopButtonImageIsCorrectImage() throws Exception {
		final ImageStore imageStore = new ImageStore();
		final File stopButtonImageFile = imageStore.getStopButtonImageFile();

		assertTrue(stopButtonImageFile.exists());
		assertImagesAreEqual(ImageIO.read(stopButtonImageFile), imageStore.getStopButtonImage());
	}
}
