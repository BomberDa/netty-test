package com.bhb.nioserver.util;

public class StringUtil {
    /**
     * 获取子字符串，在src字符串中查找从fromStr 到 toStr 之间的字符串
     * @param src
     * @param fromStr
     * @param toStr
     * @return
     */
    public static String getSubStr(String src, String fromStr, String toStr){
        int startIndex = src.indexOf(fromStr);
        int length = fromStr.length();

        if(startIndex < 0)
            return null;
        int endIndex = src.indexOf(toStr, startIndex + length);
        return src.substring(startIndex + length, endIndex);
    }
}
