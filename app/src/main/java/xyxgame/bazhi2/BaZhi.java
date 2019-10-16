package xyxgame.bazhi2;

import android.os.Bundle;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xyxgame.bazhi2.util.ListSKU;

public class BaZhi extends AppCompatActivity implements View.OnClickListener, WheelView.OnWheelItemSelectedListener, PurchasesUpdatedListener {

    private WheelView wheelView1, wheelView2, wheelView3, wheelView4;
    private List<String> strings_ri, strings_shi, strings_yue, strings_nian;
    private Button mbutton,fangsheng1,fangsheng2,fangsheng3;
    private TextView say;
    private BillingClient billingClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ba_zhi);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initData();
        setupBilling();

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

        fangsheng1=findViewById(R.id.fangsheng1);
        fangsheng2=findViewById(R.id.fangsheng2);
        fangsheng3=findViewById(R.id.fangsheng3);
        fangsheng1.setOnClickListener(this);
        fangsheng2.setOnClickListener(this);
        fangsheng3.setOnClickListener(this);

    }

    private void setupBilling() {
        billingClient = BillingClient.newBuilder(BaZhi.this).enablePendingPurchases().setListener(this).build();//检查是否可以正常连接支付
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(BillingResult billingResult) {

                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    // The BillingClient is ready. You can query purchases here.
                   // Toast.makeText(BaZhi.this,"BillingResult"+billingResult.getResponseCode(),Toast.LENGTH_LONG).show();
                    querySkuDetail();
                }
            }
            @Override
            public void onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.

                Toast.makeText(BaZhi.this,"无法开启支付",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void querySkuDetail() {

        final List<String> skuList = ListSKU.getList();
        SkuDetailsParams.Builder params = SkuDetailsParams.newBuilder();
            params.setSkusList(skuList).setType(BillingClient.SkuType.INAPP);
            billingClient.querySkuDetailsAsync(params.build(), new SkuDetailsResponseListener() {
                @Override
                public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> skuDetailsList) {
                    if (billingResult.getResponseCode()==BillingClient.BillingResponseCode.OK&&skuDetailsList!=null){

                        for (SkuDetails list:skuDetailsList){
                            Log.e("TAG", "onSkuDetailsResponse: "+list );

//                            ConsumeParams consumeParams = ConsumeParams.newBuilder()
//                                    .setPurchaseToken("AEuhp4KZEuIGpgYa6iCCX6xHD49NWCd_yMlvtNliAYK3YOuQjpvl4jb3iftbtPQmmXo=")
//                                    .build();
//                            billingClient.consumeAsync(consumeParams,new ConsumeResponseListener() {
//                                @Override
//                                public void onConsumeResponse(BillingResult billingResult, String outToken) {
//                                    if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
//                                        // Handle the success of the consume operation.
//                                        // For example, increase the number of coins inside the user's basket.
//                                        // Toast.makeText(BaZhi.this,"消耗成功",Toast.LENGTH_LONG).show();
//                                    }
//                                }});

                        }
                    }
                }
            });


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


                case R.id.fangsheng1:
                fangsheng_play(0);
                break;
                 case R.id.fangsheng2:
                fangsheng_play(1);
                break;
               case R.id.fangsheng3:
                 fangsheng_play(2);

                break;
            default:;
        }

    }

    private void fangsheng_play(final int point) {
        if (billingClient.isReady()) {//发起支付
            List<String> skuList = ListSKU.getList();
            SkuDetailsParams.Builder params = SkuDetailsParams.newBuilder();
            params.setSkusList(skuList).setType(BillingClient.SkuType.INAPP);
            billingClient.querySkuDetailsAsync(params.build(),
                    new SkuDetailsResponseListener() {
                        @Override
                        public void onSkuDetailsResponse(BillingResult result,
                                                         List<SkuDetails> skuDetailsList) {
                            // Process the result.
                            if (result.getResponseCode() == BillingClient.BillingResponseCode.OK && skuDetailsList != null) {

                                BillingFlowParams billingFlowParams=BillingFlowParams.newBuilder().setSkuDetails(skuDetailsList.get(point)).build();
                                billingClient.launchBillingFlow(BaZhi.this,billingFlowParams);
                                //Toast.makeText(BaZhi.this, "Ready:"+skuDetailsList.toString(), Toast.LENGTH_LONG).show();
                                say.setText(skuDetailsList.get(point).getDescription().toString()+"\n\n捐贈前默念多次：\n\n某某某，生于某年子月初一子时，居于某市某区某街某房，现委托此應用為我做放生功德，南無阿彌陀佛。\n\n我們在總金額每達到USD1000時進行一次YouTube放生直播");
                                Log.v("SKU",skuDetailsList.toString());

                             }

                        }
                    });
        } else {
        Toast.makeText(BaZhi.this, "xxxNO Ready", Toast.LENGTH_LONG).show();
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

    @Override
    public void onPurchasesUpdated(BillingResult billingResult, @Nullable List<Purchase> purchases) {//支付点击确认后获取的回调结果，获取支付结果
//        say.setText(""+billingResult.getResponseCode());
        if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK
                && purchases != null) {
            for (Purchase purchase : purchases) {
                 handlePurchase(purchase);
            }
        } else if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.USER_CANCELED) {
            // Handle an error caused by a user cancelling the purchase flow.
        }else if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED) {
            Toast.makeText(this,"强制停止Google Play商店应用，清除Google Play数据",Toast.LENGTH_LONG).show();
        }
        else {
            // Handle any other error codes.

        }
    }
    void handlePurchase(Purchase purchase) {//成功付款

        if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED) {
            // Acknowledge purchase and grant the item to the user  //確認購買並將商品授予用戶
            //消耗用品
            Log.e("purchase", "purchase: "+purchase.getPurchaseToken() );
            ConsumeParams consumeParams = ConsumeParams.newBuilder()
                    .setPurchaseToken(purchase.getPurchaseToken())
                    .setDeveloperPayload(purchase.getDeveloperPayload())
                    .build();
            billingClient.consumeAsync(consumeParams,new ConsumeResponseListener() {
                @Override
                public void onConsumeResponse(BillingResult billingResult, String outToken) {
                    if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                        // Handle the success of the consume operation.
                        // For example, increase the number of coins inside the user's basket.
                       // Toast.makeText(BaZhi.this,"消耗成功",Toast.LENGTH_LONG).show();
                    }
                }});
        }


         if (purchase.getPurchaseState() == Purchase.PurchaseState.PENDING) {
            // Here you can confirm to the user that they've started the pending
            // purchase, and to complete it, they should follow instructions that
            // are given to them. You can also choose to remind the user in the
            // future to complete the purchase if you detect that it is still
            // pending.
            //在這裡，您可以向用戶確認他們已經開始掛起
            //購買並完成購買，他們應該遵循以下說明
            //給他們。您也可以選擇在
            //如果您發現購買仍在進行中，將來可以完成購買
            //待定。
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        billingClient.endConnection();
    }
}
