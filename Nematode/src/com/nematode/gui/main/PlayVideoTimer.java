package com.nematode.gui.main;

import java.awt.event.ActionListener;

import com.nematode.gui.AbstractTimer;

public class PlayVideoTimer extends AbstractTimer {

	private static final long serialVersionUID = 1L;

	public PlayVideoTimer(final int delay, final ActionListener listener) {
		super(delay, listener);
	}

	@Override
	public void start() {
		super.start();
	}

	@Override
	public void stop() {
		super.stop();
	}
}
