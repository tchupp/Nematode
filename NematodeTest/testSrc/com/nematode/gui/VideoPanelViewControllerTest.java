package com.nematode.gui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.junit.Test;

import com.nematode.gui.backend.MockVideoFrameDisplayInfo;
import com.nematode.image.MockDisplayFrameImage;
import com.nematode.image.MockFrameImageAssembler;
import com.nematode.image.MockVideoFrameImage;
import com.nematode.image.NullBufferedImage;
import com.nematode.model.MockVideoFrameSequence;
import com.nematode.unittesting.AssertTestCase;

public class VideoPanelViewControllerTest extends AssertTestCase {

	@Override
	protected void setUp() throws Exception {
		Loader.load(org.bytedeco.javacpp.opencv_core.class);
	}

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoPanelViewControllerInterface.class,
				VideoPanelViewController.class);
	}

	@Test
	public void testGetsNematodeVideoPanel() throws Exception {
		final VideoPanelViewController videoPanelViewController = new VideoPanelViewController(
				new MockFrameImageAssembler());

		assertIsOfTypeAndGet(VideoPanel.class, videoPanelViewController.getVideoPanel());
	}

	@Test
	public void testGetsFrameImageAssembler() throws Exception {
		final MockFrameImageAssembler frameImageAssembler = new MockFrameImageAssembler();
		final VideoPanelViewController viewController = new VideoPanelViewController(
				frameImageAssembler);
		assertSame(frameImageAssembler, viewController.getFrameImageAssembler());
	}

	@Test
	public void testUpdateDisplayImagePlacesCorrectImageOnPanel() throws Exception {
		final MockVideoFrameDisplayInfo mockDisplayInfo = new MockVideoFrameDisplayInfo();
		final int expectedFrameNumber = 3;
		mockDisplayInfo.setFrameNumber(expectedFrameNumber);

		final NullBufferedImage expectedVideoImage = new NullBufferedImage();
		final MockVideoFrameImage mockVideoFrameImage = new MockVideoFrameImage();
		final MockVideoFrame mockVideoFrame = new MockVideoFrame();

		mockVideoFrameImage.setBufferedImage(expectedVideoImage);
		mockVideoFrame.setVideoFrameImage(mockVideoFrameImage);

		final MockVideoFrameSequence mockVideoFrameSequence = new MockVideoFrameSequence();
		mockVideoFrameSequence.setFrameToReturn(mockVideoFrame);

		final NullBufferedImage expectedDisplayImage = new NullBufferedImage();
		final MockDisplayFrameImage mockDisplayFrameImage = new MockDisplayFrameImage();
		final MockFrameImageAssembler mockFrameImageAssembler = new MockFrameImageAssembler();

		mockDisplayFrameImage.setBufferedImage(expectedDisplayImage);
		mockFrameImageAssembler.setDisplayImageToReturn(mockDisplayFrameImage);

		final VideoPanelViewController viewController = new VideoPanelViewController(
				mockFrameImageAssembler);

		final VideoPanel videoPanel = assertIsOfTypeAndGet(VideoPanel.class,
				viewController.getVideoPanel());
		final JLabel imageLabel = videoPanel.getImageLabel();
		final ImageIcon imageLabelIconBefore = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());

		final BufferedImage defaultImage = assertIsOfTypeAndGet(BufferedImage.class,
				imageLabelIconBefore.getImage());
		assertNotSame(expectedDisplayImage, defaultImage);

		viewController.updateDisplay(mockDisplayInfo, mockVideoFrameSequence);

		assertTrue(mockVideoFrameSequence.wasGetVideoFrameCalled());
		assertTrue(mockDisplayInfo.wasGetFrameNumberCalled());
		assertEquals(expectedFrameNumber, mockVideoFrameSequence.getFrameNumberToGet());

		assertTrue(mockFrameImageAssembler.wasCreateDisplayFrameImageCalled());
		assertTrue(mockVideoFrame.wasGetVideoFrameImageCalled());
		assertSame(expectedVideoImage, mockFrameImageAssembler.getDisplayImageToUse());

		final ImageIcon imageLabelIconAfter = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());
		final NullBufferedImage actualImage = assertIsOfTypeAndGet(NullBufferedImage.class,
				imageLabelIconAfter.getImage());

		assertSame(expectedDisplayImage, actualImage);
	}

	@Test
	public void testShowImageCorrectlyDisplaysImageOnPanel() throws Exception {
		final NullBufferedImage expectedImage = new NullBufferedImage();
		final Mat expectedMat = Mat.createFrom(expectedImage);

		final VideoPanelViewController viewController = new VideoPanelViewController(
				new MockFrameImageAssembler());

		final VideoPanel videoPanel = assertIsOfTypeAndGet(VideoPanel.class,
				viewController.getVideoPanel());
		final JLabel imageLabel = videoPanel.getImageLabel();
		final ImageIcon imageLabelIconBefore = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());

		final BufferedImage defaultImage = assertIsOfTypeAndGet(BufferedImage.class,
				imageLabelIconBefore.getImage());

		assertNotSame(expectedImage, defaultImage);

		viewController.showImage(expectedMat);

		final ImageIcon imageLabelIconAfter = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());
		final NullBufferedImage actualImage = assertIsOfTypeAndGet(NullBufferedImage.class,
				imageLabelIconAfter.getImage());

		assertSame(expectedImage, actualImage);
	}
}
