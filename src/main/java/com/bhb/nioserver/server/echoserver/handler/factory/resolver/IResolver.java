package com.bhb.nioserver.server.echoserver.handler.factory.resolver;

import com.bhb.nioserver.msgInfo.bean.MsgInfo;

public interface IResolver {
	public String getActionId(MsgInfo message);
	public boolean support(MsgInfo message);
	public MsgInfo resolve(MsgInfo message);
}
