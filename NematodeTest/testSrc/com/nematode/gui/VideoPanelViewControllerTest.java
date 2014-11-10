package com.nematode.gui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.junit.Test;

import com.nematode.gui.backend.MockVideoFrameDisplayInformation;
import com.nematode.image.MockDisplayFrameImage;
import com.nematode.image.MockFrameImageAssembler;
import com.nematode.image.MockVideoFrameHandler;
import com.nematode.image.MockVideoFrameImage;
import com.nematode.image.NullBufferedImage;
import com.nematode.model.DisplayFrameImageChangeObserver;
import com.nematode.model.MockVideoFrameSequence;
import com.nematode.model.VideoFrame;
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
	public void testGetsFrameObserver() throws Exception {
		final VideoPanelViewController videoPanelViewController = new VideoPanelViewController(
				new MockVideoFrameHandler(), new MockFrameImageAssembler());
		assertIsOfTypeAndGet(DisplayFrameImageChangeObserver.class,
				videoPanelViewController.getFrameObserver());
	}

	@Test
	public void testConstructorAddsObserverToVideoFrameWithCorrectViewController() throws Exception {
		final VideoFrame videoFrame = new VideoFrame();
		final MockVideoFrameHandler mockFrameHandler = new MockVideoFrameHandler();
		mockFrameHandler.setVideoFrame(videoFrame);

		final VideoPanelViewController viewController = new VideoPanelViewController(
				mockFrameHandler, new MockFrameImageAssembler());
		assertEquals(1, videoFrame.getListOfObservers().size());

		final DisplayFrameImageChangeObserver observer = assertIsOfTypeAndGet(
				DisplayFrameImageChangeObserver.class, viewController.getFrameObserver());

		final VideoPanelViewControllerInterface actualViewController = observer
				.getPanelViewController();
		assertSame(viewController, actualViewController);

		videoFrame.dispose();
		assertEquals(0, videoFrame.getListOfObservers().size());
	}

	@Test
	public void testUpdateVideoDisplayPlacesCorrectImageOnPanel() throws Exception {

		final MockVideoFrame videoFrame = new MockVideoFrame();
		final MockDisplayFrameImage displayFrameImage = new MockDisplayFrameImage();
		final NullBufferedImage expectedImage = new NullBufferedImage();

		displayFrameImage.setBufferedImage(expectedImage);
		videoFrame.setDisplayFrameImage(displayFrameImage);

		final MockVideoFrameHandler mockFrameHandler = new MockVideoFrameHandler();
		mockFrameHandler.setVideoFrame(videoFrame);

		final VideoPanelViewController viewController = new VideoPanelViewController(
				mockFrameHandler, new MockFrameImageAssembler());
		final VideoPanel videoPanel = assertIsOfTypeAndGet(VideoPanel.class,
				viewController.getVideoPanel());
		final JLabel imageLabel = videoPanel.getImageLabel();
		final ImageIcon imageLabelIconBefore = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());

		final BufferedImage defaultImage = assertIsOfTypeAndGet(BufferedImage.class,
				imageLabelIconBefore.getImage());
		assertNotSame(expectedImage, defaultImage);

		viewController.updateVideoDisplay();

		final ImageIcon imageLabelIconAfter = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());
		final NullBufferedImage actualImage = assertIsOfTypeAndGet(NullBufferedImage.class,
				imageLabelIconAfter.getImage());
		assertSame(expectedImage, actualImage);
	}

	@Test
	public void testUpdateDisplayImagePlacesCorrectImageOnPanel() throws Exception {
		final MockVideoFrameDisplayInformation mockDisplayInformation = new MockVideoFrameDisplayInformation();
		final int expectedFrameNumber = 3;
		mockDisplayInformation.setFrameNumber(expectedFrameNumber);

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

		viewController.updateDisplay(mockDisplayInformation, mockVideoFrameSequence);

		assertTrue(mockVideoFrameSequence.wasGetFrameCalled());
		assertTrue(mockDisplayInformation.wasGetFrameNumberCalled());
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
