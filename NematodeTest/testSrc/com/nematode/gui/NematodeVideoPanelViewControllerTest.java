package com.nematode.gui;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.junit.Test;

import com.nematode.image.MockDisplayFrameImage;
import com.nematode.image.MockVideoFrameHandler;
import com.nematode.model.DisplayFrameImageChangeObserver;
import com.nematode.model.VideoFrame;
import com.nematode.nullmodel.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class NematodeVideoPanelViewControllerTest extends AssertTestCase {

	private BufferedImage bufferedTestImage;

	@Override
	protected void setUp() throws Exception {
		final File testJpg = new File("testResources/Images/testJPG.jpg");
		this.bufferedTestImage = ImageIO.read(testJpg);
		super.setUp();
	}

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodePanelViewControllerInterface.class,
				NematodeVideoPanelViewController.class);
	}

	@Test
	public void testGetsNematodeVideoPanel() throws Exception {
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController(
				new MockVideoFrameHandler());

		assertIsOfTypeAndGet(NematodeVideoPanel.class,
				nematodeVideoPanelViewController.getNematodePanel());
	}

	@Test
	public void testGetVideoFrameHandler() throws Exception {
		final MockVideoFrameHandler expectedFrameHandler = new MockVideoFrameHandler();
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController(
				expectedFrameHandler);
		assertSame(expectedFrameHandler, nematodeVideoPanelViewController.getVideoFrameHandler());
	}

	@Test
	public void testGetsFrameObserver() throws Exception {
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController(
				new MockVideoFrameHandler());
		assertIsOfTypeAndGet(DisplayFrameImageChangeObserver.class,
				nematodeVideoPanelViewController.getFrameObserver());
	}

	@Test
	public void testConstructorAddsObserverToVideoFrameWithCorrectViewController() throws Exception {
		final VideoFrame videoFrame = new VideoFrame();
		final MockVideoFrameHandler mockFrameHandler = new MockVideoFrameHandler();
		mockFrameHandler.setVideoFrame(videoFrame);

		final NematodeVideoPanelViewController viewController = new NematodeVideoPanelViewController(
				mockFrameHandler);
		assertEquals(1, videoFrame.getListOfObservers().size());

		final DisplayFrameImageChangeObserver observer = assertIsOfTypeAndGet(
				DisplayFrameImageChangeObserver.class, viewController.getFrameObserver());

		final NematodePanelViewControllerInterface actualViewController = observer
				.getPanelViewController();
		assertSame(viewController, actualViewController);

		videoFrame.dispose();
		assertEquals(0, videoFrame.getListOfObservers().size());
	}

	@Test
	public void testUpdateImagePlacesCorrectImageOnPanel() throws Exception {

		final MockVideoFrame videoFrame = new MockVideoFrame();
		final MockDisplayFrameImage displayFrameImage = new MockDisplayFrameImage();
		displayFrameImage.setBufferedImage(this.bufferedTestImage);
		videoFrame.setDisplayFrameImage(displayFrameImage);

		final MockVideoFrameHandler mockFrameHandler = new MockVideoFrameHandler();
		mockFrameHandler.setVideoFrame(videoFrame);

		final NematodeVideoPanelViewController viewController = new NematodeVideoPanelViewController(
				mockFrameHandler);
		final NematodeVideoPanel videoPanel = assertIsOfTypeAndGet(NematodeVideoPanel.class,
				viewController.getNematodePanel());
		final JLabel imageLabel = videoPanel.getImageLabel();
		final ImageIcon imageLabelIconBefore = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());

		assertIsOfTypeAndGet(NullBufferedImage.class, imageLabelIconBefore.getImage());

		viewController.updateImage();

		final ImageIcon imageLabelIconAfter = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());
		final BufferedImage actualImage = assertIsOfTypeAndGet(BufferedImage.class,
				imageLabelIconAfter.getImage());
		assertSame(this.bufferedTestImage, actualImage);
	}
}
