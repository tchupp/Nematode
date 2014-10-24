package com.nematode.gui;

import com.nematode.model.VideoFrameHandlerInterface;

public interface NematodePanelViewControllerInterface {

	public ExtendableJPanel getNematodePanel();

	public void updateImage();

	public VideoFrameHandlerInterface getVideoFrameHandler();

}
