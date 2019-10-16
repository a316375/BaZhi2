package xyxgame.bazhi2.luopan;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/10/31.
 */

public class Compass implements SensorEventListener {



    private SensorManager sensorManager;
    private ImageView mCompassImg;//指南针背景图
    private float mDirection=0;// 当前方向
    private TextView textView;//度数
    private RotateAnimation animation;
    Context mcontext;
    public Compass(Context context , ImageView compassImg, TextView textView) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        this.mCompassImg = compassImg;
        this.textView=textView;
        this.mcontext=context;

    }

    //注册传感器
    public void registerSensor() {
//注册方向传感器
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);

    }

    //解除传感器注册
    public void unregisterSensor(){
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()==Sensor.TYPE_ORIENTATION) {


            float Rote = (float) (int) (event.values[0] * 100) / 100;//当前角度
            textView.setText(Rote + "°");


// 以指南针图像中心为轴逆时针旋转degree度
            animation= new RotateAnimation(mDirection, -Rote,Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
// 在200毫秒之内完成旋转动作
            animation.setDuration(200);
// 开始旋转图像
            mCompassImg.startAnimation(animation);
// 保存旋转后的度数，currentDegree是一个在类中定义的float类型变量
            mDirection = -Rote;


        }

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}