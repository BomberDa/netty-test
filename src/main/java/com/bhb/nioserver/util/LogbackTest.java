package com.bhb.nioserver.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: 39601
 * Date: 2020/3/3
 * Time: 15:23
 * Description:
 */
public class LogbackTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args) {
        LOGGER.trace("logback的--trace日志--输出了");
        LOGGER.debug("logback的--debug日志--输出了");
        LOGGER.info("logback的--info日志--输出了");
        LOGGER.warn("logback的--warn日志--输出了");
        LOGGER.error("logback的--error日志--输出了");
    }
}
