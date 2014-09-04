package com.nematode.fileIO;

public class ImageFileChooser extends AbstractFileChooser {

	private static final long serialVersionUID = 1L;

	public ImageFileChooser() {
		this.setApproveButtonText("Open");
		this.setAcceptAllFileFilterUsed(false);
		this.addChoosableFileFilter(new ImageFileFilter());
	}
}
