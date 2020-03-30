package com.bhb.nioserver.server.echoserver.handler;

import com.bhb.nioserver.msgInfo.bean.UserInfo;
import com.bhb.nioserver.msgInfo.service.UserInfoServiceImpl;
import com.bhb.nioserver.util.SpringUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Listing 2.1 EchoServerHandler
 *
 * @author <a href="mailto:norman.maurer@gmail.com">Norman Maurer</a>
 */
public class SecondServerHandler extends ChannelInboundHandlerAdapter {
    private UserInfoServiceImpl userInfoService;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        //ByteBuf in = (ByteBuf) msg;
        System.out.println(
                "SecondServer received: " + msg);
        //测试数据处理
        userInfoService = (UserInfoServiceImpl) SpringUtil.getBean("userInfoServiceImpl");
        UserInfo userInfo  = new UserInfo();
        userInfo.setUser_id("0001");
        userInfo.setUser_name("secondTest1");
        userInfo.setOrg_id(1);
        userInfoService.addUserInfo(userInfo);
        System.out.println("新增测试数据完成！！！");
        ctx.fireChannelRead(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
