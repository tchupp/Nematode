package com.nematode.gui;

import com.nematode.imaging.VideoFrameHandlerInterface;

public interface NematodePanelViewControllerInterface {

	public NematodePanel getNematodePanel();

	public void updateImage();

	public VideoFrameHandlerInterface getVideoFrameHandler();

}
