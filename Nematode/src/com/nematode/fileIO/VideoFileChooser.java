package com.nematode.fileIO;

public class VideoFileChooser extends AbstractFileChooser {

	private static final long serialVersionUID = 1L;

	public VideoFileChooser() {
		this.setApproveButtonText("Open");
		this.setAcceptAllFileFilterUsed(false);
		this.addChoosableFileFilter(new VideoFileFilter());
	}
}
