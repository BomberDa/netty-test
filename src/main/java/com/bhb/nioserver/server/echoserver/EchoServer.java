package com.bhb.nioserver.server.echoserver;

import com.bhb.nioserver.server.echoserver.handler.BusinessLogicHandler;
import com.bhb.nioserver.server.echoserver.handler.MyServerHandlerAdapter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;

import java.net.InetSocketAddress;

/**
 * Listing 2.2 EchoServer class
 *
 * @author <a href="mailto:norman.maurer@gmail.com">Norman Maurer</a>
 */
public class EchoServer {
    private final int port = 8000;
    static final EventExecutorGroup eventgroup = new DefaultEventExecutorGroup(100);

    public static void main(String[] args)
            throws Exception {
        new EchoServer().start();
    }

    public void start() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))   //.localAddress(8000)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("LineBasedFrameDecoder", new LineBasedFrameDecoder(10240));
                            ch.pipeline().addLast("StringDecoder", new StringDecoder());
                            ch.pipeline().addLast("encoder", new StringEncoder());
                           // ch.pipeline().addLast("myHandler", new MyServerHandlerAdapter());
                          //  ch.pipeline().addLast("echo", new EchoServerHandler());
                            ch.pipeline().addLast(eventgroup,new BusinessLogicHandler());
                        }
                    });
            //start
            ChannelFuture f = b.bind().sync();
            System.out.println(EchoServer.class.getName() +
                    " 服务已启动，监听端口： " + f.channel().localAddress());
            f.channel().closeFuture().sync();
            System.out.println("1111111111111111111");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // shutdown
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully().sync();
        }
    }
}
