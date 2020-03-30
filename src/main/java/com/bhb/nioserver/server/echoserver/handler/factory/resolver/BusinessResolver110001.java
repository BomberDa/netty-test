package com.bhb.nioserver.server.echoserver.handler.factory.resolver;

import com.bhb.nioserver.msgInfo.bean.MsgInfo;
import com.bhb.nioserver.msgInfo.service.InsertMsgInfo;
import com.bhb.nioserver.util.StringUtil;
import com.bhb.nioserver.util.TreadUtil;


public class BusinessResolver110001 extends IResolverCCMS {

    @Override
    public MsgInfo resolve(MsgInfo message) {
        String requestStr = message.getSendMsg();
        //业务处理
        try {

        }catch (Exception e){

        }finally {

        }
        TreadUtil.executorService.execute(new InsertMsgInfo(message));
        return null;
    }
}
