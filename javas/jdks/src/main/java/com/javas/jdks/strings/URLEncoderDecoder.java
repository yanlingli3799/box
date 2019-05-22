package com.javas.jdks.strings;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDecoder {
    public static void main(String[] args) throws UnsupportedEncodingException {
        demo0();
        demo1();
        demo2();
        demo3();
    }

    private static void demo0() throws UnsupportedEncodingException {
        String s = "中国银行";
        System.out.println("字符串："+s);
        String encodeS = URLEncoder.encode(s,"GB2312");
        System.out.println("加密后："+encodeS);
        String decodeS = URLDecoder.decode(encodeS,"GB2312");
        System.out.println("解密后："+decodeS);
    }


    private static void demo1() throws UnsupportedEncodingException {
        String s = "中国银行";
        System.out.println("字符串："+s);
        String encodeS = URLEncoder.encode(s,"GB18030");
        System.out.println("加密后："+encodeS);
        String decodeS = URLDecoder.decode(encodeS,"GB18030");
        System.out.println("解密后："+decodeS);
    }

    private static void demo2() throws UnsupportedEncodingException {
        String s = "中国银行";
        System.out.println("字符串："+s);
        String encodeS = URLEncoder.encode(s,"GBK");
        System.out.println("加密后："+encodeS);
        String decodeS = URLDecoder.decode(encodeS,"GBK");
        System.out.println("解密后："+decodeS);
    }

    private static void demo3() throws UnsupportedEncodingException {
        String s = "中国银行";
        System.out.println("字符串："+s);
        String encodeS = URLEncoder.encode(s,"UTF8");
        System.out.println("加密后："+encodeS);
        String decodeS = URLDecoder.decode(encodeS,"UTF8");
        System.out.println("解密后："+decodeS);
    }


}
