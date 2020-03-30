package com.bhb.nioserver.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: 39601
 * Date: 2020/3/2
 * Time: 15:25
 * Description: 获取线程池执行
 */
public class TreadUtil {
    public static ExecutorService executorService = Executors.newCachedThreadPool();
}
