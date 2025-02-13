package com.nana.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public final class CountdownApp {

    public static void main(String[] args) {
        // 获取当前日期
        final LocalDate today = LocalDate.now();
        System.out.println("今天是: " + today);

        // 计算距离下一个周末的剩余天数
        final long daysToWeekend = getDaysToNextWeekend(today);
        System.out.println("距离下一个周末还有 " + daysToWeekend + " 天");

        // 定义假期或重要日期
        final Map<String, LocalDate> importantDates = new HashMap<>();
        importantDates.put("许凯生日", LocalDate.of(2025, 3, 5));
        importantDates.put("清明节", LocalDate.of(2025, 4, 4));
        importantDates.put("我的生日", LocalDate.of(2025, 4, 11));
        importantDates.put("劳动节", LocalDate.of(2025, 5, 1));
        importantDates.put("端午节", LocalDate.of(2025, 5, 31));
        importantDates.put("国庆节", LocalDate.of(2025, 10, 1));
        importantDates.put("阿信生日", LocalDate.of(2025, 12, 6));

        // 计算距离每个重要日期的剩余天数
        for (Map.Entry<String, LocalDate> entry : importantDates.entrySet()) {
            final long daysRemaining = ChronoUnit.DAYS.between(today, entry.getValue());
            if (daysRemaining >= 0) {
                System.out.println("距离 " + entry.getKey() + " 还有 " + daysRemaining + " 天");
            } else {
                System.out.println(entry.getKey() + " 已经过去了！");
            }
        }
    }

    /**
     * 计算距离下一个周末的剩余天数
     *
     * @param today 当前日期
     * @return 剩余天数
     */
    private static long getDaysToNextWeekend(LocalDate today) {
        // 获取当前星期几（1 = 周一, 7 = 周日）
        final int dayOfWeek = today.getDayOfWeek().getValue();

        // 如果今天是周六或周日，返回0
        if (dayOfWeek == 6 || dayOfWeek == 7) {
            return 0;
        }

        // 计算距离下一个周六的天数
        return 6 - dayOfWeek;
    }
}
