package com.bhb.nioserver.server.echoserver.pojo;

import com.bhb.nioserver.server.echoserver.pojo.msg110001.Body110001;
import com.bhb.nioserver.server.echoserver.pojo.msg110001.Request110001;
import com.thoughtworks.xstream.XStream;

public class Test {
    public static void main(String[] args) {
        Body110001 body = new Body110001();
        body.setBASerialNo("12345");
        body.setCustomerID("aaa");
        body.setOccurType("045");
        RequestHead head = new RequestHead();
        head.setChannel("CCMS");
        head.setTradNo("110001");
        head.setTradSerialNo("abc");
        Request110001 request = new Request110001();
        request.setBody(body);
        request.setHead(head);
       // XStream xStream = new XStream();
        //xStream.processAnnotations(Request110001.class);
        //String xml = xStream.toXML(request);
        //System.out.println(xml);
        Object b = request;
        System.out.println(b.getClass());
        XStream xStream = new XStream();
        xStream.processAnnotations(b.getClass());
        String xml = xStream.toXML(request);
        System.out.println(xml);
    }
}
