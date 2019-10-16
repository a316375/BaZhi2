package xyxgame.bazhi2.Activity;

import android.content.SharedPreferences;
import android.graphics.Color;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xyxgame.bazhi2.Activity.util.SendMail;
import xyxgame.bazhi2.BaZhi;
import xyxgame.bazhi2.R;

public class Daishao_Activity extends AppCompatActivity implements PurchasesUpdatedListener {


    EditText editText0,editText1,editText2,editText3,editText4,editText5;
    String editText0s,editText1s,editText2s,editText3s,editText4s,editText5s;
    private TextView textView;
    private BillingClient billingClient;
    private SendMail sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daishao_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       initData();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
        setupBilling();
    }

    private void setupBilling() {

        billingClient = BillingClient.newBuilder(Daishao_Activity.this).enablePendingPurchases().setListener(this).build();//检查是否可以正常连接支付
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(BillingResult billingResult) {

                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    // The BillingClient is ready. You can query purchases here.
                    // Toast.makeText(BaZhi.this,"BillingResult"+billingResult.getResponseCode(),Toast.LENGTH_LONG).show();

                }
            }
            @Override
            public void onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.

                Toast.makeText(Daishao_Activity.this,"无法开启支付",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initData() {
        editText0=findViewById(R.id.e0);
        editText1=findViewById(R.id.e1);
        editText2=findViewById(R.id.e2);
        editText3=findViewById(R.id.e3);
        editText4=findViewById(R.id.e4);
        editText5=findViewById(R.id.e5);

        textView = findViewById(R.id.say);

        readString();

    }

    private void readString() {
        //1、获取Preferences
        SharedPreferences settings = getSharedPreferences("setting",0);
//2、取出数据
        editText0.setText(settings.getString("e0",""));
        editText1.setText(settings.getString("e1",""));
        editText2.setText(settings.getString("e2",""));
        editText3.setText(settings.getString("e3",""));
        editText4.setText(settings.getString("e4",""));
        editText5.setText(settings.getString("e5",""));
    }

    private void sendEmail() {

        editText0s=editText0.getText().toString();
        editText1s=editText1.getText().toString();
        editText2s=editText2.getText().toString();
        editText3s=editText3.getText().toString();
        editText4s=editText4.getText().toString();
        editText5s=editText5.getText().toString();

        saveString();

        if (editText0s.length()==0||editText1s.length()==0||editText2s.length()==0||
                editText3s.length()==0||editText4s.length()==0||editText5s.length()==0){
            textView.setText("注意：信息不能为空");
            textView.setTextColor(Color.RED);

        }else {
            //Getting content for email
//        String email = editTextEmail.getText().toString().trim();
//        String subject = editTextSubject.getText().toString().trim();
//        String message = editTextMessage.getText().toString().trim();
            String email = "316375076@qq.com";
            String subject = "回复|" + editText0s;
            String message = "事项|" + editText1s + "\n" + editText2s + "\n" + editText3s + "\n" + editText4s + "\n" + editText5s;


            //Creating SendMail object
            sm = new SendMail(this, email, subject, message, textView);

            daishao_play();
            //Executing sendmail to send email
            //sm.execute();
        }
//        Intent emails = new Intent(Intent.ACTION_SEND);
//        emails.putExtra(Intent.EXTRA_EMAIL, );
//        emails.putExtra(Intent.EXTRA_SUBJECT, "subject");
//        emails.putExtra(Intent.EXTRA_TEXT, "message");
//        emails.setType("message/rfc822");
//        startActivity(Intent.createChooser(emails, "Choose an Email client :"));+
//

    }

    private void saveString() {
//1、打开Preferences，名称为setting，如果存在则打开它，否则创建新的Preferences
        SharedPreferences settings = getSharedPreferences("setting", 0);
//2、让setting处于编辑状态
        SharedPreferences.Editor editor = settings.edit();
//3、存放数据
        editor.putString("e0",editText0s);
        editor.putString("e1",editText1s);
        editor.putString("e2",editText2s);
        editor.putString("e3",editText3s);
        editor.putString("e4",editText4s);
        editor.putString("e5",editText5s);
//4、完成提交
        editor.commit();


    }

    private void daishao_play() {
        if (billingClient.isReady()) {//发起支付
            List<String> skuList = new ArrayList<>();
            skuList.add("yb_1000");
            SkuDetailsParams.Builder params = SkuDetailsParams.newBuilder();
            params.setSkusList(skuList).setType(BillingClient.SkuType.INAPP);
            billingClient.querySkuDetailsAsync(params.build(),
                    new SkuDetailsResponseListener() {
                        @Override
                        public void onSkuDetailsResponse(BillingResult result,
                                                         List<SkuDetails> skuDetailsList) {
                            // Process the result.
                            if (result.getResponseCode() == BillingClient.BillingResponseCode.OK && skuDetailsList != null) {
                                BillingFlowParams billingFlowParams=BillingFlowParams.newBuilder().setSkuDetails(skuDetailsList.get(0)).build();
                                billingClient.launchBillingFlow(Daishao_Activity.this,billingFlowParams);
                            }

                        }
                    });
        } else {
            Toast.makeText(Daishao_Activity.this, "xxxNO Ready", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onPurchasesUpdated(BillingResult billingResult, @Nullable List<Purchase> purchases) {
        //支付点击确认后获取的回调结果，获取支付结果
//        say.setText(""+billingResult.getResponseCode());
        if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK
                && purchases != null) {
            for (Purchase purchase : purchases) {
                handlePurchase(purchase);
            }
        } else if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.USER_CANCELED) {
            // Handle an error caused by a user cancelling the purchase flow.
        } else {
            // Handle any other error codes.

        }
    }
    void handlePurchase(Purchase purchase) {//成功付款

        if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED) {
            // Acknowledge purchase and grant the item to the user  //確認購買並將商品授予用戶
            sm.execute();//发送邮件给我
            //消耗用品
            ConsumeParams consumeParams = ConsumeParams.newBuilder()
                    .setPurchaseToken(purchase.getPurchaseToken())
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
}
