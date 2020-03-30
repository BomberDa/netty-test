package com.bhb.nioserver;

import com.bhb.nioserver.server.echoserver.EchoServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NioserverApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(NioserverApplication.class, args);
        new EchoServer().start();
    }

}
