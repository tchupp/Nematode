package com.nematode.gui;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class GuiConstantsTest extends AssertTestCase {

	@Test
	public void testDisplayHeightWidth() throws Exception {
		assertEquals(1600, GuiConstants.DISPLAY_WIDTH);
		assertEquals(900, GuiConstants.DISPLAY_HEIGHT);
	}

	@Test
	public void testVideoFrameHeightWidth() throws Exception {
		assertEquals(1920, GuiConstants.VIDEO_FRAME_WIDTH);
		assertEquals(1080, GuiConstants.VIDEO_FRAME_HEIGHT);
	}

}
