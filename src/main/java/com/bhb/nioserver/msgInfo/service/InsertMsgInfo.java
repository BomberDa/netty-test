package com.bhb.nioserver.msgInfo.service;

import com.bhb.nioserver.msgInfo.bean.MsgInfo;
import com.bhb.nioserver.util.SpringUtil;

import java.security.PublicKey;

/**
 * Created with IntelliJ IDEA.
 * User: 39601
 * Date: 2020/3/2
 * Time: 15:41
 * Description:
 */
public class InsertMsgInfo implements Runnable{
    private MsgInfo info;
    public InsertMsgInfo(MsgInfo info){
        this.info =info;
    }
     @Override
    public void run() {
        UserInfoServiceImpl userInfoService = (UserInfoServiceImpl) SpringUtil.getBean("userInfoServiceImpl");
        //插入数据库记录表
    }
}
