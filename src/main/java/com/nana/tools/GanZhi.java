package com.nana.tools;

import java.util.Calendar;

public final class GanZhi {
    // 天干和地支的序列
    private static final String[] TIAN_GAN = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    private static final String[] DI_ZHI = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};

    // 计算某个年份的天干地支
    public static String getYearTianGanDiZhi(int year) {
        int offset = year - 2637; // 从公元前2637年（甲子年）开始
        offset = Math.floorMod(offset, 60);
        String tianGan = TIAN_GAN[offset % 10];
        String diZhi = DI_ZHI[offset % 12];
        return tianGan + diZhi;
    }

    // 计算某个月份的天干地支
    public static String getMonthTianGanDiZhi(int year, int month) {
        // 通过判断年份来计算月干支
        int offset = (year - 2637) * 12 + month; // 假设从甲子年开始
        offset = Math.floorMod(offset, 60);
        String tianGan = TIAN_GAN[offset % 10];
        String diZhi = DI_ZHI[(month - 1) % 12];  // 月份从1开始
        return tianGan + diZhi;
    }

    // 计算某一天的天干地支
    public static String getDayTianGanDiZhi(int year, int month, int day) {
        // 计算从基准日（甲子日）到指定日期的偏移量
        int offset = (year - 2637) * 365 + (month - 1) * 30 + (day - 1);
        offset = Math.floorMod(offset, 60);
        String tianGan = TIAN_GAN[offset % 10];
        String diZhi = DI_ZHI[offset % 12];
        return tianGan + diZhi;
    }
}
