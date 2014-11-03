package com.nematode.gui;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class GuiConstantsTest extends AssertTestCase {

	@Test
	public void testDisplayHeightWidth() throws Exception {
		assertEquals(1680, GuiConstants.DISPLAY_WIDTH);
		assertEquals(945, GuiConstants.DISPLAY_HEIGHT);
	}

	@Test
	public void testVideoFrameHeightWidth() throws Exception {
		assertEquals(1920, GuiConstants.VIDEO_FRAME_WIDTH);
		assertEquals(1080, GuiConstants.VIDEO_FRAME_HEIGHT);
	}

	@Test
	public void testImagePaths() throws Exception {
		assertEquals("resources/gui/buttons/cropScanAreaButtonImage.png",
				GuiConstants.CROP_AREA_BUTTON_IMAGE_PATH);
	}

}
