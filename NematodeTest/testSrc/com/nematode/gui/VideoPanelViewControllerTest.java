package com.nematode.gui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.junit.Test;

import com.nematode.gui.backend.MockVideoFrameDisplayInfo;
import com.nematode.image.MockDisplayFrameImage;
import com.nematode.image.MockFrameImageAssembler;
import com.nematode.image.MockVideoFrameHandler;
import com.nematode.image.MockVideoFrameImage;
import com.nematode.image.NullBufferedImage;
import com.nematode.model.MockVideoFrameSequence;
import com.nematode.unittesting.AssertTestCase;

public class VideoPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoPanelViewControllerInterface.class,
				VideoPanelViewController.class);
	}

	@Test
	public void testGetsNematodeVideoPanel() throws Exception {
		final VideoPanelViewController videoPanelViewController = new VideoPanelViewController(
				new MockVideoFrameHandler(), new MockFrameImageAssembler());

		assertIsOfTypeAndGet(VideoPanel.class, videoPanelViewController.getVideoPanel());
	}

	@Test
	public void testGetVideoFrameHandler() throws Exception {
		final MockVideoFrameHandler expectedFrameHandler = new MockVideoFrameHandler();
		final VideoPanelViewController videoPanelViewController = new VideoPanelViewController(
				expectedFrameHandler, new MockFrameImageAssembler());
		assertSame(expectedFrameHandler, videoPanelViewController.getVideoFrameHandler());
	}

	@Test
	public void testGetsFrameImageAssembler() throws Exception {
		final MockFrameImageAssembler frameImageAssembler = new MockFrameImageAssembler();
		final VideoPanelViewController viewController = new VideoPanelViewController(
				new MockVideoFrameHandler(), frameImageAssembler);
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
				new MockVideoFrameHandler(), mockFrameImageAssembler);

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
}
