package com.bhb.nioserver.server.echoserver.pojo.msg110001;

import lombok.Data;

@Data
//@XStreamAlias("Body")
public class Body110001 {
    private String BASerialNo;
    private String CustomerID;
    private String BusinessType;
    private String IndustryType;
    private String CustomerType;
    private String OccurType;
    private String OrgiSerialNo;

}
