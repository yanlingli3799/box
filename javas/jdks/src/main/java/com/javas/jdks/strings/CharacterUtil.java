package com.javas.jdks.strings;

import java.io.UnsupportedEncodingException;

public class CharacterUtil {

    private final static String GBK = "GBK";
    private final static String GB2312 = "GB2312";
    private final static String GB18030 = "GB18030";
    private final static String UTF8 = "UTF8";

    private final static String WHITE_SPACE = " ";

    // 是否全部为数字
    public static boolean isAllDigit(String str) {
        return str.matches("[0-9]{1,}");
    }

    // 是否全部为字母
    public static boolean isAllAlphabet(String str) {
        return str.matches("[a-z,A-Z]{1,}");
    }

    // 是否仅包含数字字母
    public static boolean isOnlyContainsDigitAlphabet(String str){
        return str.matches("[0-9,a-z,A-Z]{1,}");
    }

    // 是否仅包含数字字母下换线
    public static boolean isOnlyContainsDigitAlphabetUnderline(String str){
        return str.matches("[0-9,a-z,A-Z,_]{1,}");
    }

    // 是否包含空格
    public static boolean isContainsWhiteSpace(String str){
        return str.contains(WHITE_SPACE);
    }

    // 长度在某个闭区间范围内
    public static boolean isLengthInClosedInterval(int min,String str,int max){
        return str.length() >= min && str.length() <= max;
    }

    public static boolean isGBK(String str){
        return isSupportedCharset(str,GBK);
    }

    public static boolean isGB2312(String str){
        return isSupportedCharset(str,GB2312);
    }

    public static boolean isGB18030(String str){
        return isSupportedCharset(str,GB18030);
    }

    public static boolean isUTF8(String str){
        return isSupportedCharset(str,UTF8);
    }

    private static boolean isSupportedCharset(String str,String charsetName){
        try {
            return str.equals(new String(str.getBytes(charsetName),charsetName));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }


}
