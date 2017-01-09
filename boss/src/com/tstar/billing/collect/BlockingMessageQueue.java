package com.tstar.billing.collect;

import java.io.Serializable;

import com.tstar.billing.business.CdrLogBus;
import com.tstar.billing.model.IMessageQueue;
import com.tstar.billing.model.Queues;
import com.tstar.ocs.model.CdrLog;

public class BlockingMessageQueue implements IMessageQueue {

	public void connect() {}

	public void disconnect() {}

	public Serializable receive() throws Exception {
		return Queues.queueDecoding.take();
	}

	public void send(Serializable obj) throws Exception {
		CdrLogBus.save((CdrLog)obj);
		Queues.queueDecoding.put((CdrLog)obj);
	}

}
