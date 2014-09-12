package com.nematode.imaging;

import java.awt.image.BufferedImage;

import org.junit.Test;

import com.nematode.fileIO.MockValidatedImageFile;
import com.nematode.gui.MockNematodeVideoFrame;
import com.nematode.gui.NematodeVideoPanel;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.nullmodel.NullBufferedImage;
import com.nematode.nullmodel.NullFrameImage;
import com.nematode.unittesting.AssertTestCase;

public class VideoFrameBuilderTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameBuilderInterface.class,
				VideoFrameBuilder.class);
	}

	@Test
	public void testNematodeVideoFrame() throws Exception {
		final MockNematodeVideoFrame expectedNematodeVideoFrame = new MockNematodeVideoFrame();
		final VideoFrameBuilder videoFrameBuilder = new VideoFrameBuilder(
				expectedNematodeVideoFrame);

		final NematodeVideoFrameInterface actualNematodeVideoFrame = videoFrameBuilder
				.getNematodeVideoFrame();
		assertSame(expectedNematodeVideoFrame, actualNematodeVideoFrame);
	}

	@Test
	public void testBuildNewFrameImageFromFileSetsRealVideoFrame_ValidFile()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final VideoFrameBuilder videoFrameBuilder = new VideoFrameBuilder(
				videoFrame);

		final MockValidatedImageFile mockValidatedImageFile = new MockValidatedImageFile();
		mockValidatedImageFile.setIsFileValid(true);
		final BufferedImage expectedBufferedImage = new BufferedImage(100, 80,
				BufferedImage.TYPE_INT_RGB);
		mockValidatedImageFile.setFileImage(expectedBufferedImage);

		videoFrameBuilder.buildNewFrameImageFromFile(mockValidatedImageFile);

		final VideoFrameImage frameImage = assertIsOfTypeAndGet(
				VideoFrameImage.class, videoFrame.getVideoFrameImage());

		final BufferedImage actualImage = frameImage.getImage();
		assertSame(expectedBufferedImage, actualImage);
	}

	@Test
	public void testBuildNewFrameImageFromFileSetsNullVideoFrameImage_InvalidFile()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final VideoFrameBuilder videoFrameBuilder = new VideoFrameBuilder(
				videoFrame);

		final MockValidatedImageFile mockValidatedImageFile = new MockValidatedImageFile();
		mockValidatedImageFile.setIsFileValid(false);

		videoFrameBuilder.buildNewFrameImageFromFile(mockValidatedImageFile);

		assertIsOfTypeAndGet(NullFrameImage.class,
				videoFrame.getVideoFrameImage());
	}

	@Test
	public void testBuildNewFrameImageFromFileSetsRealDisplayImage_ValidFile()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final VideoFrameBuilder videoFrameBuilder = new VideoFrameBuilder(
				videoFrame);

		final MockValidatedImageFile mockValidatedImageFile = new MockValidatedImageFile();
		mockValidatedImageFile.setIsFileValid(true);

		videoFrameBuilder.buildNewFrameImageFromFile(mockValidatedImageFile);

		final DisplayFrameImage frameImage = assertIsOfTypeAndGet(
				DisplayFrameImage.class, videoFrame.getDisplayFrameImage());

		final BufferedImage actualImage = frameImage.getImage();
		assertEquals(NematodeVideoPanel.ICON_HEIGHT, actualImage.getHeight());
		assertEquals(NematodeVideoPanel.ICON_WIDTH, actualImage.getWidth());
	}

	@Test
	public void testBuildNewFrameImageFromFileSetsNullDisplayFrameImage_InvalidFile()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final VideoFrameBuilder videoFrameBuilder = new VideoFrameBuilder(
				videoFrame);

		final MockValidatedImageFile mockValidatedImageFile = new MockValidatedImageFile();
		mockValidatedImageFile.setIsFileValid(false);

		videoFrameBuilder.buildNewFrameImageFromFile(mockValidatedImageFile);

		assertIsOfTypeAndGet(NullFrameImage.class,
				videoFrame.getDisplayFrameImage());
	}

	@Test
	public void testCreateDisplayFrameImageHasCorrectDimentions()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final VideoFrameBuilder videoFrameBuilder = new VideoFrameBuilder(
				videoFrame);

		final DisplayFrameImageInterface displayFrameImage = videoFrameBuilder
				.createDisplayFrameImage(new NullBufferedImage());

		assertEquals(NematodeVideoPanel.ICON_WIDTH, displayFrameImage
				.getImage().getWidth());
		assertEquals(NematodeVideoPanel.ICON_HEIGHT, displayFrameImage
				.getImage().getHeight());
	}

	@Test
	public void testCreateVideoFrameImageRetainsImageSize() throws Exception {
		final int expectedWidth = 56;
		final int expectedHeight = 56;
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final VideoFrameBuilder videoFrameBuilder = new VideoFrameBuilder(
				videoFrame);

		final BufferedImage bufferedImage = new BufferedImage(expectedWidth,
				expectedHeight, BufferedImage.TYPE_INT_RGB);

		final VideoFrameImageInterface videoFrameImage = videoFrameBuilder
				.createVideoFrameImage(bufferedImage);

		assertEquals(expectedWidth, videoFrameImage.getImage().getWidth());
		assertEquals(expectedHeight, videoFrameImage.getImage().getHeight());
	}
}
