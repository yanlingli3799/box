package com.javas.jdks.strings;

public class DataStringDealer {
    // 数字字符串操作效率比较


    public long useSubstring(String timeStampS){
        int to = timeStampS.length()-2;
        long start = System.nanoTime();
        System.out.println(timeStampS.substring(0,to));
        long end = System.nanoTime();
        return end-start;
    }

    public long useDivision(long timeStampL){
        long start = System.nanoTime();
        System.out.println(timeStampL/100);
        long end = System.nanoTime();
        return end-start;
    }

    public static void main(String[] args){
        long timeStampL = 1512546611634l;
        String timeStampS = "1512546611634";
        DataStringDealer dataStringDealer = new DataStringDealer();

        System.out.println("useSubstring use:"+dataStringDealer.useSubstring(timeStampS));
        System.out.println("useDivision use:"+dataStringDealer.useDivision(timeStampL));

    }
}
