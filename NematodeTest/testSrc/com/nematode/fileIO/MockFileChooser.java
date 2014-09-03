package com.nematode.fileIO;

import java.awt.Component;
import java.awt.HeadlessException;

import javax.swing.JFileChooser;

public class MockFileChooser extends AbstractFileChooser {
	private static final long serialVersionUID = 1L;
	private int showDialogReturnValue = JFileChooser.CANCEL_OPTION;
	private boolean showDialogWasCalled;

	@Override
	public int showDialog(final Component parent, final String approveButtonText)
			throws HeadlessException {
		this.showDialogWasCalled = true;
		return this.showDialogReturnValue;
	}

	public void setShowDialogValueToReturn(final int showDialogReturnValue) {
		this.showDialogReturnValue = showDialogReturnValue;
	}

	public boolean wasShowDialogCalled() {
		return this.showDialogWasCalled;
	}
}
