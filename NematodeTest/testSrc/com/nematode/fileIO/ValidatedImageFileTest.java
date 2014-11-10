package com.nematode.fileIO;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.nematode.image.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class ValidatedImageFileTest extends AssertTestCase {

	private File validFile;
	private File invalidFile;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.validFile = new File("testResources/Images/testBMP.bmp");
		this.invalidFile = new File("");
	}

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ValidatedImageFileInterface.class,
				ValidatedImageFile.class);
	}

	@Test
	public void testGetsFile() throws Exception {
		final ValidatedImageFile validatedImageFile = new ValidatedImageFile(
				this.invalidFile);

		assertSame(this.invalidFile, validatedImageFile.getImageFile());
	}

	@Test
	public void testGetImageReturnsCorrectImageForValidFile() throws Exception {
		final ValidatedImageFile validatedImageFile = new ValidatedImageFile(
				this.validFile);

		final BufferedImage expectedFileImage = ImageIO.read(this.validFile);
		final BufferedImage actualFileImage = validatedImageFile.getFileImage();
		assertEquals(expectedFileImage.getHeight(), actualFileImage.getHeight());
		assertEquals(expectedFileImage.getWidth(), actualFileImage.getWidth());
		assertEquals(expectedFileImage.getType(), actualFileImage.getType());

	}

	@Test
	public void testGetImageReturnsNullBufferedImageForInvalidFile()
			throws Exception {
		final ValidatedImageFile validatedImageFile = new ValidatedImageFile(
				this.invalidFile);

		final BufferedImage actualFileImage = validatedImageFile.getFileImage();
		assertIsOfTypeAndGet(NullBufferedImage.class, actualFileImage);
	}

	@Test
	public void testIsFileValidReturnsTrueForValidFile() throws Exception {
		final ValidatedImageFile validatedImageFile = new ValidatedImageFile(
				this.validFile);

		assertTrue(validatedImageFile.isFileValid());
	}

	@Test
	public void testIsFileValidReturnsFalseForInvalidFile() throws Exception {
		final ValidatedImageFile validatedImageFile = new ValidatedImageFile(
				this.invalidFile);

		assertFalse(validatedImageFile.isFileValid());
	}
}
