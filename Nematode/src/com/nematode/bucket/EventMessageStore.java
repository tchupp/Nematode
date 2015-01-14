package com.nematode.bucket;

import java.util.ArrayList;

import com.nematode.gui.backend.StatusMessage;

public class EventMessageStore {

	private final ArrayList<StatusMessage> messageList;

	public EventMessageStore() {
		this.messageList = new ArrayList<StatusMessage>();
	}

	public ArrayList<StatusMessage> getMessageList() {
		return this.messageList;
	}

	public void addMessage(final StatusMessage message) {
		this.messageList.add(message);
	}

	public StatusMessage getLastMessage() {
		return this.messageList.get(this.messageList.size() - 1);
	}
}
