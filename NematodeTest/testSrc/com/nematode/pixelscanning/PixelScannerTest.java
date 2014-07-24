package com.nematode.pixelscanning;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import junit.framework.TestCase;

import org.junit.Test;

import com.nematode.model.ScanningColorModel;
import com.nematode.model.ScanningReferenceColor;
import com.nematode.model.ScanningTolerancePercentage;

public class PixelScannerTest extends TestCase {

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
		Color nematodeColor = new Color(49, 55, 55);
		ScanningColorModel scanningColorModel = new ScanningColorModel(
				new ScanningReferenceColor(nematodeColor),
				new ScanningTolerancePercentage(5));

		PixelScanner pixelScanner = new PixelScanner(this.bufferedImage,
				scanningColorModel);

		int percentOfImageWithinTolerance = pixelScanner
				.getPercentOfImageWithinTolerance();

		assertEquals(10, percentOfImageWithinTolerance);
	}
}