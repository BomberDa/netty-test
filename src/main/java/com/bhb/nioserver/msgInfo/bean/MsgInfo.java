package com.bhb.nioserver.msgInfo.bean;

import lombok.Data;

@Data
public class MsgInfo {
    private Integer infoNo;

    private String tradeChannel;

    private String tradeCode;

    private String sendMsg;

    private String rspMsg;

    private String excDesc;

    private String tradeFlag;

    private String tradeFlagDesc;

    private String sendTime;

    private String sendAddr;

  }