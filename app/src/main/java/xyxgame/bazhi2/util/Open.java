package xyxgame.bazhi2.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Open {
    public static String a = "com.xyx.dlwj.pro";
    public static String b = "xyxgame.luopan";
    public static String c = "com.xyx.slfs";
    public static String d = "xyx.newmusic";
    public static String e = "xyxgame.faceAI";
    public static String f = "com.xyx.javadesignmode";

    public static void To(Context context, String string) {
        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(string);
        if (launchIntent != null) {
            context.startActivity(launchIntent);//null pointer check in case package name was not found
        } else {
//这里开始执行一个应用市场跳转逻辑，默认this为Context上下文对象
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            final String GOOGLE_PLAY = "com.android.vending";//这里对应的是谷歌商店，跳转别的商店改成对应的即可
            intent.setData(Uri.parse("market://details?id=" + string)); //跳转到应用市场，非Google Play市场一般情况也实现了这个接口
            intent.setPackage(GOOGLE_PLAY);
//存在手机里没安装应用市场的情况，跳转会包异常，做一个接收判断
            if (intent.resolveActivity(context.getPackageManager()) != null) { //可以接收
                context.startActivity(intent);
            } else { //没有应用市场，我们通过浏览器跳转到Google Play
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + string));
//这里存在一个极端情况就是有些用户浏览器也没有，再判断一次
                if (intent.resolveActivity(context.getPackageManager()) != null) { //有浏览器
                    context.startActivity(intent);
                } else { //天哪，这还是智能手机吗？
                    Toast.makeText(context, "您没安装应用市场，连浏览器也没有", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
