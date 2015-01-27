package com.nematode.bucket;

import com.nematode.gui.ImageStoreInterface;
import com.nematode.gui.console.EventMessageStore;
import com.nematode.gui.console.EventMessageStoreInterface;

public class StratagyBucket {

	private static EventMessageStoreInterface eventMessageStore = new EventMessageStore();
	private static ImageStoreInterface imageStore;

	private StratagyBucket() {
	}

	public static EventMessageStoreInterface getEventMessageStore() {
		return StratagyBucket.eventMessageStore;
	}

	public static void setEventMessageStore(final EventMessageStoreInterface eventMessageStore) {
		StratagyBucket.eventMessageStore = eventMessageStore;
	}

	public static ImageStoreInterface getImageStore() {
		return StratagyBucket.imageStore;
	}

	public static void setImageStore(final ImageStoreInterface imageStore) {
		StratagyBucket.imageStore = imageStore;
	}
}
