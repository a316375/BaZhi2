package xyxgame.bazhi2;

import android.os.Bundle;

import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class BaZhi extends AppCompatActivity implements View.OnClickListener, WheelView.OnWheelItemSelectedListener {

    private WheelView wheelView1, wheelView2, wheelView3, wheelView4;
    private List<String> strings_ri, strings_shi, strings_yue, strings_nian;
    private Button mbutton;
    private TextView say;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ba_zhi);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initData();


    }

    private void initData() {
        strings_nian = Arrays.asList(
                "甲子","乙丑","丙寅","丁卯","戊辰","已巳","庚午","辛未","壬申","癸酉",
                "甲戌","乙亥","丙子","丁丑","戊寅","已卯","庚辰","辛巳","壬午","癸未",
                "甲申","乙酉","丙戌","丁亥","戊子","已丑","庚寅","辛卯","壬辰","癸巳",
                "甲午","乙未","丙申","丁酉","戊戌","已亥","庚子","辛丑","壬寅","癸卯",
                "甲辰","乙巳","丙午","丁未","戊申","已酉","庚戌","辛亥","壬子","癸丑",
                "甲寅","乙卯","丙辰","丁巳","戊午","已未","庚申","辛酉","壬戌","癸亥");

        strings_ri = Arrays.asList(
                "甲子", "甲戌", "甲申", "甲午", "甲辰", "甲寅",
                "乙丑", "乙亥", "乙酉", "乙未", "乙巳", "乙卯",
                "丙寅", "丙子", "丙戌", "丙申", "丙午", "丙辰",
                "丁卯", "丁丑", "丁亥", "丁酉", "丁未", "丁巳",
                "戊辰", "戊寅", "戊子", "戊戌", "戊申", "戊午",
                "已巳", "已卯", "已丑", "已亥", "已酉", "已未",
                "庚午", "庚辰", "庚寅", "庚子", "庚戌", "庚申",
                "辛未", "辛巳", "辛卯", "辛丑", "辛亥", "辛酉",
                "壬申", "壬午", "壬辰", "壬寅", "壬子", "壬戌",
                "癸酉", "癸未", "癸巳", "癸卯", "癸丑", "癸亥"
        );
        strings_shi = Arrays.asList("甲子", "乙丑", "丙寅", "丁卯", "戊辰", "已巳", "庚午", "辛未", "壬申", "癸酉", "甲戌", "乙亥",
                "丙子", "丁丑", "戊寅", "已卯", "庚辰", "辛巳", "壬午", "癸未", "甲申", "乙酉", "丙戌", "丁亥",
                "戊子", "已丑", "庚寅", "辛卯", "壬辰", "癸巳", "甲午", "乙未", "丙申", "丁酉", "戊戌", "已亥",
                "庚子", "辛丑", "壬寅", "癸卯", "甲辰", "乙巳", "丙午", "丁未", "戊申", "已酉", "庚戌", "辛亥",
                "壬子", "癸丑", "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "已未", "庚申", "辛酉", "壬戌", "癸亥");
        strings_yue = Arrays.asList("丙寅", "丁卯", "戊辰", "已巳", "庚午", "辛未", "壬申", "癸酉", "甲戌", "乙亥",
                "丙子", "丁丑", "戊寅", "已卯", "庚辰", "辛巳", "壬午", "癸未", "甲申", "乙酉", "丙戌", "丁亥",
                "戊子", "已丑", "庚寅", "辛卯", "壬辰", "癸巳", "甲午", "乙未", "丙申", "丁酉", "戊戌", "已亥",
                "庚子", "辛丑", "壬寅", "癸卯", "甲辰", "乙巳", "丙午", "丁未", "戊申", "已酉", "庚戌", "辛亥",
                "壬子", "癸丑", "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "已未", "庚申", "辛酉", "壬戌", "癸亥", "甲子", "乙丑");

        wheelView1 = (WheelView) findViewById(R.id.wheelview1);
        wheelView1.setWheelAdapter(new ArrayWheelAdapter(this)); // 文本数据源
        wheelView1.setSkin(WheelView.Skin.Holo); // common皮肤/Holo
        wheelView1.setWheelData(strings_nian);  // 数据集合
        wheelView1.setSelection(1);//默认为1
        wheelView1.setOnWheelItemSelectedListener(this);


        wheelView2 = (WheelView) findViewById(R.id.wheelview2);
        wheelView2.setWheelAdapter(new ArrayWheelAdapter(this)); // 文本数据源
        wheelView2.setSkin(WheelView.Skin.Holo); // common皮肤/Holo
        wheelView2.setWheelData(strings_nian);  // 数据集合
        wheelView2.setSelection(1);//默认为1

        wheelView3 = (WheelView) findViewById(R.id.wheelview3);
        wheelView3.setWheelAdapter(new ArrayWheelAdapter(this)); // 文本数据源
        wheelView3.setSkin(WheelView.Skin.Holo); // common皮肤/Holo
        wheelView3.setWheelData(strings_nian);  // 数据集合
        wheelView3.setSelection(1);//默认为1
        wheelView3.setOnWheelItemSelectedListener(this);

        wheelView4 = (WheelView) findViewById(R.id.wheelview4);
        wheelView4.setWheelAdapter(new ArrayWheelAdapter(this)); // 文本数据源
        wheelView4.setSkin(WheelView.Skin.Holo); // common皮肤/Holo
        wheelView4.setWheelData(strings_nian);  // 数据集合
        wheelView4.setSelection(1);//默认为1

        mbutton = findViewById(R.id.button);
        mbutton.setOnClickListener(this);

        say = findViewById(R.id.say);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                // Toast.makeText(BaZhi.this,wheelView1.getSelectionItem()+"/"+wheelView2.getSelectionItem()+"/"+wheelView3.getSelectionItem()+"/"+wheelView4.getSelectionItem(),Toast.LENGTH_LONG).show();
                // Toast.makeText(BaZhi.this,BaZhiSay.Say(wheelView3.getSelectionItem().toString(),wheelView2.getSelectionItem().toString()),Toast.LENGTH_LONG).show();

                String nian = wheelView1.getSelectionItem().toString();
                String yue = wheelView2.getSelectionItem().toString();
                String ri = wheelView3.getSelectionItem().toString();
                String shi = wheelView4.getSelectionItem().toString();
                say.setText(BaZhiSay.WQLSay(yue, ri, shi)
                        +"\n\n"+BaZhiSay2.Say(wheelView1.getCurrentPosition())
                        +"\n\n"+ BaZhiSay3.Say(nian,shi)
                        +"\n\n"+ BaZhiSay4.Say(wheelView1.getCurrentPosition())
                        +"\n\n"+ BaZhiSay5.Say(ri,wheelView2.getCurrentPosition())
                );
                break;
        }
    }

    @Override
    public void onItemSelected(int position, Object o) {
        if (wheelView3.getSelectionItem().toString().startsWith("甲") || wheelView3.getSelectionItem().toString().startsWith("已")) {
            wheelView4.setWheelData(strings_shi.subList(0, 12));
        }
        ;
        if (wheelView3.getSelectionItem().toString().startsWith("乙") || wheelView3.getSelectionItem().toString().startsWith("庚")) {
            wheelView4.setWheelData(strings_shi.subList(12, 24));
        }
        ;
        if (wheelView3.getSelectionItem().toString().startsWith("丙") || wheelView3.getSelectionItem().toString().startsWith("辛")) {
            wheelView4.setWheelData(strings_shi.subList(24, 36));
        }
        ;
        if (wheelView3.getSelectionItem().toString().startsWith("丁") || wheelView3.getSelectionItem().toString().startsWith("壬")) {
            wheelView4.setWheelData(strings_shi.subList(36, 48));
        }
        ;
        if (wheelView3.getSelectionItem().toString().startsWith("戊") || wheelView3.getSelectionItem().toString().startsWith("癸")) {
            wheelView4.setWheelData(strings_shi.subList(48, 60));
        }
        ;

        //甲己之年丙作首
        //乙庚之岁戊为头
        //丙辛必定寻庚起
        //丁壬壬位顺行流
        //若问戊癸何方发
        //甲寅之上好追求
        if (wheelView1.getSelectionItem().toString().startsWith("甲") || wheelView1.getSelectionItem().toString().startsWith("已")) {
            wheelView2.setWheelData(strings_yue.subList(0, 12));
        }
        ;
        if (wheelView1.getSelectionItem().toString().startsWith("乙") || wheelView1.getSelectionItem().toString().startsWith("庚")) {
            wheelView2.setWheelData(strings_yue.subList(12, 24));
        }
        ;
        if (wheelView1.getSelectionItem().toString().startsWith("丙") || wheelView1.getSelectionItem().toString().startsWith("辛")) {
            wheelView2.setWheelData(strings_yue.subList(24, 36));
        }
        ;
        if (wheelView1.getSelectionItem().toString().startsWith("丁") || wheelView1.getSelectionItem().toString().startsWith("壬")) {
            wheelView2.setWheelData(strings_yue.subList(36, 48));
        }
        ;
        if (wheelView1.getSelectionItem().toString().startsWith("戊") || wheelView1.getSelectionItem().toString().startsWith("癸")) {
            wheelView2.setWheelData(strings_yue.subList(48, 60));
        }
        ;


    }
}
