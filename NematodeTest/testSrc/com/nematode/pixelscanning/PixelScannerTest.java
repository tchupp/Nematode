package com.nematode.pixelscanning;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.nematode.model.ScanningColorModel;
import com.nematode.model.ScanningReferenceColor;
import com.nematode.model.ScanningTolerancePercentage;
import com.nematode.unittesting.AssertTestCase;

public class PixelScannerTest extends AssertTestCase {

	private BufferedImage bufferedImage;

	@Override
	protected void setUp() throws Exception {
		this.bufferedImage = ImageIO
				.read(new File(
						"D://Users/Theo/git/Nematode/NematodeTest/testResources/NematodeStill.jpg"));

		assertNotNull(this.bufferedImage);
	}

	@Test
	public void testCorrectlyCalculatesValuesToScanWith() throws Exception {
		final Color nematodeColor = new Color(49, 55, 55);
		final ScanningColorModel scanningColorModel = new ScanningColorModel(
				new ScanningReferenceColor(nematodeColor),
				new ScanningTolerancePercentage(5));

		final PixelScanner pixelScanner = new PixelScanner(this.bufferedImage,
				scanningColorModel);

		final int percentOfImageWithinTolerance = pixelScanner
				.getPercentOfImageWithinTolerance();

		fail("not yet implemented");

		assertEquals(10, percentOfImageWithinTolerance);
	}
}