package com.bhb.nioserver.server.echoserver.pojo.msg110001;

import com.bhb.nioserver.server.echoserver.pojo.RequestHead;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
@XStreamAlias("Request")
public class Request110001 {
    private RequestHead Head;
    private Body110001 Body;
}
