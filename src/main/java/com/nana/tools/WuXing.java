package com.nana.tools;

public final class WuXing {
    private static final String[] WU_XING = {"木", "木", "火", "火", "土", "土", "金", "金", "水", "水"};

    // 根据天干获取五行
    public static String getWuXing(String ganZhi) {
        final char gan = ganZhi.charAt(0);
        final int index = "甲乙丙丁戊己庚辛壬癸".indexOf(gan);
        return WU_XING[index];
    }
}
