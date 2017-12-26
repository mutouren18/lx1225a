package com.example.hsq.lx1225.activity;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hsq.lx1225.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class Main6Activity extends AppCompatActivity {

    private SimpleDraweeView sdvFrescoGif;
    private Button bt_fresco_askImg;
    private Button bt_fresco_stopAnim;
    private Button bt_fresco_startAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        //获取空间
        sdvFrescoGif = findViewById(R.id.sdv_fresco_gif);
        bt_fresco_askImg = findViewById(R.id.bt_fresco_askImg);
        bt_fresco_stopAnim = findViewById(R.id.bt_fresco_stopAnim);
        bt_fresco_startAnim = findViewById(R.id.bt_fresco_startAnim);

        //获取动态图片
        bt_fresco_askImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Uri uri = Uri.parse("http://p0.ifengimg.com/pmop/2017/0715/5E2D0ECD7F2C468ADBA2319A00F65307EE61461F_size101_w400_h227.gif");

                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(false)
                        .setOldController(sdvFrescoGif.getController())
                        .build();

                sdvFrescoGif.setController(controller);
            }
        });
        //停止动画
        bt_fresco_stopAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animatable animatable = sdvFrescoGif.getController().getAnimatable();

                if(animatable != null && animatable.isRunning()) {
                    animatable.stop();
                }
            }
        });
        //开启动画
        bt_fresco_startAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animatable animatable = sdvFrescoGif.getController().getAnimatable();

                if(animatable != null && !animatable.isRunning()) {
                    animatable.start();
                }
            }
        });
    }
}
