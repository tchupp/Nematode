package com.nematode.gui.main;

import com.nematode.gui.ExtendableJFrame;

public abstract class AbstractMainWindow extends ExtendableJFrame {

	private static final long serialVersionUID = 1L;

	public abstract void addListenerToPlayButton(final MainWindowActionListener listener);

	public abstract void addListenerToPauseButton(final MainWindowActionListener listener);

	public abstract void addListenerToOpenVideoButton(final MainWindowActionListener listener);

}
