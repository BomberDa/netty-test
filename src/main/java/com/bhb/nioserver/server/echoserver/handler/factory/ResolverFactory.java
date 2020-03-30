package com.bhb.nioserver.server.echoserver.handler.factory;

import com.bhb.nioserver.msgInfo.bean.MsgInfo;
import com.bhb.nioserver.server.echoserver.handler.factory.resolver.BusinessResolver110001;
import com.bhb.nioserver.server.echoserver.handler.factory.resolver.IResolver;
import org.apache.logging.log4j.message.Message;

import java.util.ArrayList;
import java.util.List;

public class ResolverFactory {
    public static List<IResolver> resolvers = new ArrayList();
    static {
        resolvers.add(new BusinessResolver110001());
    }

    // 根据解码后的消息，在工厂类处理器中查找可以处理当前消息的处理器
    public static IResolver getMessageResolver(MsgInfo message) {
        for (IResolver resolver : resolvers) {
            if (resolver.support(message)) {
                return resolver;
            }
        }
        throw new RuntimeException("cannot find resolver, message : " + message.getRspMsg());
    }
}
