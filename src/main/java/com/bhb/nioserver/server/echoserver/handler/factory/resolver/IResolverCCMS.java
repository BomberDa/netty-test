package com.bhb.nioserver.server.echoserver.handler.factory.resolver;

import com.bhb.nioserver.msgInfo.bean.MsgInfo;
import com.bhb.nioserver.util.StringUtil;

/**
 * Created with IntelliJ IDEA.
 * User: 39601
 * Date: 2020/3/2
 * Time: 14:53
 * Description:
 */
public class IResolverCCMS implements IResolver{


    @Override
    public String getActionId(MsgInfo message) {
        String actionId = StringUtil.getSubStr(message.getSendMsg(), "<"+"TradNo"+">", "</TradNo>");
        return actionId;
    }

    @Override
    public boolean support(MsgInfo message) {
        String actionIdComm = this.getActionId(message);
        if(actionIdComm!=null){
            message.setTradeCode(actionIdComm);
            return true;
        }
        return false;
    }

    @Override
    public MsgInfo resolve(MsgInfo message) {
        return null;
    }
}
