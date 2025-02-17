package com.nana.service;

import java.time.LocalDate;

import com.nana.tools.GanZhi;
import com.nana.tools.ShenSha;
import com.nana.tools.WuXing;
import com.nana.tools.YiJi;

/**
 * 每日宜忌
 */
public class DosAndDontsApp {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        // 计算年份的天干地支
        String yearTianGanDiZhi = GanZhi.getYearTianGanDiZhi(localDate.getYear());
        // 计算月份的天干地支
        String monthTianGanDiZhi = GanZhi.getMonthTianGanDiZhi(localDate.getYear(), localDate.getMonthValue());
        // 计算日期的天干地支
        String dayTianGanDiZhi = GanZhi.getDayTianGanDiZhi(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
        System.out.println("天干地支: " + yearTianGanDiZhi + "年 " + monthTianGanDiZhi + "月 " + dayTianGanDiZhi + "日");

        // 计算五行
        String wuXing = WuXing.getWuXing(dayTianGanDiZhi);
        System.out.println("五行: " + wuXing);

        // 获取神煞
        String[] shenSha = ShenSha.getShenSha();
        System.out.println("吉神: " + shenSha[0]);
        System.out.println("凶神: " + shenSha[1]);

        // 生成宜忌
        String[] yiJi = YiJi.getYiJi(wuXing, shenSha);
        System.out.println("宜: " + yiJi[0]);
        System.out.println("忌: " + yiJi[1]);
    }
}
