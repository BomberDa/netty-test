package com.bhb.nioserver.server.echoserver.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Listing 2.1 EchoServerHandler
 *
 * @author <a href="mailto:norman.maurer@gmail.com">Norman Maurer</a>
 */
public class MyServerHandlerAdapter extends ChannelInboundHandlerAdapter {
    final static Logger logger = LoggerFactory.getLogger(MyServerHandlerAdapter.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String str = (String) msg;
        if ("123".equalsIgnoreCase(str.substring(0, 3))) {
            ctx.pipeline().addBefore("echo", "second", new SecondServerHandler())
                    .addBefore("echo", "third", new ThirdServerHandler()).remove(this);
        }
        ctx.fireChannelRead(msg);
        //ctx.write(msg);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
