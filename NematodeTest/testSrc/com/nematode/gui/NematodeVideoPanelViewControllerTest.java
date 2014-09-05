package com.nematode.gui;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.junit.Test;

import com.nematode.imaging.MockVideoFrameImage;
import com.nematode.model.NematodeVideoFrame;
import com.nematode.model.VideoFrameImageChangeObserver;
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
				new MockNematodeVideoFrame());

		assertIsOfTypeAndGet(NematodeVideoPanel.class,
				nematodeVideoPanelViewController.getNematodePanel());
	}

	@Test
	public void testGetVideoFrame() throws Exception {
		final MockNematodeVideoFrame expectedNematodeVideoFrame = new MockNematodeVideoFrame();
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController(
				expectedNematodeVideoFrame);
		assertSame(expectedNematodeVideoFrame,
				nematodeVideoPanelViewController.getNematodeVideoFrame());
	}

	@Test
	public void testGetsFrameObserver() throws Exception {
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController(
				new MockNematodeVideoFrame());
		assertIsOfTypeAndGet(VideoFrameImageChangeObserver.class,
				nematodeVideoPanelViewController.getFrameObserver());
	}

	@Test
	public void testConstructorAddsObserverToVideoFrameWithCorrectViewController()
			throws Exception {
		final NematodeVideoFrame nematodeVideoFrame = new NematodeVideoFrame(
				new MockVideoFrameImage());
		final NematodeVideoPanelViewController viewController = new NematodeVideoPanelViewController(
				nematodeVideoFrame);
		assertEquals(1, nematodeVideoFrame.getListOfObservers().size());

		final VideoFrameImageChangeObserver observer = assertIsOfTypeAndGet(
				VideoFrameImageChangeObserver.class,
				viewController.getFrameObserver());

		final NematodePanelViewControllerInterface actualViewController = observer
				.getPanelViewController();
		assertSame(viewController, actualViewController);

		nematodeVideoFrame.dispose();
		assertEquals(0, nematodeVideoFrame.getListOfObservers().size());
	}

	@Test
	public void testUpdateImagePlacesCorrectImageOnPanel() throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final MockVideoFrameImage videoFrameImage = new MockVideoFrameImage();
		videoFrameImage.setBufferedImage(this.bufferedTestImage);
		videoFrame.setVideoFrameImage(videoFrameImage);
		final NematodeVideoPanelViewController viewController = new NematodeVideoPanelViewController(
				videoFrame);
		final NematodeVideoPanel videoPanel = assertIsOfTypeAndGet(
				NematodeVideoPanel.class, viewController.getNematodePanel());
		final JLabel imageLabel = videoPanel.getImageLabel();
		final ImageIcon imageLabelIconBefore = assertIsOfTypeAndGet(
				ImageIcon.class, imageLabel.getIcon());
		assertIsOfTypeAndGet(NullBufferedImage.class,
				imageLabelIconBefore.getImage());

		viewController.updateImage();

		final ImageIcon imageLabelIconAfter = assertIsOfTypeAndGet(
				ImageIcon.class, imageLabel.getIcon());
		final BufferedImage actualImage = assertIsOfTypeAndGet(
				BufferedImage.class, imageLabelIconAfter.getImage());
		assertSame(this.bufferedTestImage, actualImage);
	}
}