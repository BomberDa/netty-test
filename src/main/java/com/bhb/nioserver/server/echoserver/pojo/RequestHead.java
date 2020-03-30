package com.bhb.nioserver.server.echoserver.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
@XStreamAlias("Head")
public class RequestHead {
    private String Channel;
    private String TradNo;
    private String TradDate;
    private String TradTime;
    private String TradSerialNo;
    private String TradFlag;
    private String FileName;

}
