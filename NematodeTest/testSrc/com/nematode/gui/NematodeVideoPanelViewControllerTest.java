package com.nematode.gui;

import org.junit.Test;

import com.nematode.nullmodel.NullNematodeVideoFrame;
import com.nematode.unittesting.AssertTestCase;

public class NematodeVideoPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testGetsNematodeVideoPanel() throws Exception {
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController();

		assertIsOfTypeAndGet(NematodeVideoPanel.class,
				nematodeVideoPanelViewController.getNematodeVideoPanel());
	}

	@Test
	public void testGetVideoFrameReturns_NullVideoFrame_AfterConstruction()
			throws Exception {
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController();
		assertIsOfTypeAndGet(NullNematodeVideoFrame.class,
				nematodeVideoPanelViewController.getNematodeVideoFrame());
	}

	@Test
	public void testGetVideoFrameReturns_CorrectVideoFrame_AfterSet()
			throws Exception {
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController();

		final MockNematodeVideoFrame mockNematodeVideoFrame = new MockNematodeVideoFrame();
		nematodeVideoPanelViewController
				.setNematodeVideoFrame(mockNematodeVideoFrame);

		assertSame(mockNematodeVideoFrame,
				nematodeVideoPanelViewController.getNematodeVideoFrame());
	}

}
