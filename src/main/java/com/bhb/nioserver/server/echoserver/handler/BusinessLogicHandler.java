package com.bhb.nioserver.server.echoserver.handler;

import com.bhb.nioserver.msgInfo.bean.MsgInfo;
import com.bhb.nioserver.server.echoserver.handler.factory.ResolverFactory;
import com.bhb.nioserver.server.echoserver.handler.factory.resolver.IResolver;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Listing 2.1 EchoServerHandler
 *
 * @author <a href="mailto:norman.maurer@gmail.com">Norman Maurer</a>
 */
public class BusinessLogicHandler extends ChannelInboundHandlerAdapter {
    final static Logger logger = LoggerFactory.getLogger(BusinessLogicHandler.class);
    private MsgInfo msgInfo = new MsgInfo();
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //记录时间
        //记录ip地址
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        logger.debug("进入channelRead方法");
        msgInfo.setSendMsg(msg.toString());

        IResolver resolver = ResolverFactory.getMessageResolver(msgInfo);	// 获取消息处理器
        MsgInfo result = resolver.resolve(msgInfo);	// 对消息进行处理并获取响应数据

        ctx.writeAndFlush(result.getSendMsg());	// 将响应数据写入到处理器中

        //ctx.fireChannelRead(msg);
        //ctx.write(msg);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        logger.error(cause.getMessage());
        ctx.close();
    }
}
