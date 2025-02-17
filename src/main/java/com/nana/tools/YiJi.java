package com.nana.tools;

public class YiJi {
    // 根据五行和神煞生成宜忌
    public static String[] getYiJi(String wuXing, String[] shenSha) {
        String[] yi = {};
        String[] ji = {};

        switch (wuXing) {
            case "木":
                yi = new String[]{"种植", "修造", "祈福", "结婚"};
                ji = new String[]{"动土", "安葬", "破土", "出行"};
                break;
            case "火":
                yi = new String[]{"祭祀", "祈福", "开业", "嫁娶"};
                ji = new String[]{"动土", "安葬", "修造", "出行"};
                break;
            case "土":
                yi = new String[]{"修造", "动土", "安葬", "祭祀"};
                ji = new String[]{"嫁娶", "出行", "开业", "破土"};
                break;
            case "金":
                yi = new String[]{"交易", "签约", "祈福", "结婚"};
                ji = new String[]{"动土", "安葬", "破土", "出行"};
                break;
            case "水":
                yi = new String[]{"祭祀", "祈福", "沐浴", "结婚"};
                ji = new String[]{"动土", "安葬", "修造", "出行"};
                break;
            default:
                yi = new String[]{"无"};
                ji = new String[]{"无"};
                break;
        }

        // 根据神煞调整宜忌
        if (shenSha[0].equals("天德")) {
            yi = new String[]{"结婚", "开业"};
        }
        if (shenSha[1].equals("白虎")) {
            ji = new String[]{"动土", "出行"};
        }

        return new String[]{String.join("、", yi), String.join("、", ji)};
    }
}
