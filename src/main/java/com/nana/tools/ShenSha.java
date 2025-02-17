package com.nana.tools;

import java.util.Random;

public class ShenSha {
    private static final String[] JI_SHEN = {"天德", "月德", "天喜", "三合"};
    private static final String[] XIONG_SHEN = {"白虎", "五鬼", "劫煞", "灾煞"};

    // 随机获取吉神和凶神
    public static String[] getShenSha() {
        final Random random = new Random();
        final String jiShen = JI_SHEN[random.nextInt(JI_SHEN.length)];
        final String xiongShen = XIONG_SHEN[random.nextInt(XIONG_SHEN.length)];
        return new String[]{jiShen, xiongShen};
    }
}
