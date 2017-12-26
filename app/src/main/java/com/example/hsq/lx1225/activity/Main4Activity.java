package com.example.hsq.lx1225.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hsq.lx1225.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

public class Main4Activity extends AppCompatActivity {

    private GenericDraweeHierarchyBuilder builder;
    private Button bt_fresco_circle;
    private Button bt_fresco_corner;
    private RoundingParams parames;
    private SimpleDraweeView sdvFrescoCircleandcorner;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initData();
        bt_fresco_circle = findViewById(R.id.bt_fresco_circle);
        bt_fresco_corner = findViewById(R.id.bt_fresco_corner);
        sdvFrescoCircleandcorner = findViewById(R.id.sdv_fresco_circleandcorner);
        bt_fresco_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 设置圆形图片
                parames = RoundingParams.asCircle();
                GenericDraweeHierarchy hierarchy = builder.setRoundingParams(parames).build();
                sdvFrescoCircleandcorner.setHierarchy(hierarchy);

                sdvFrescoCircleandcorner.setImageURI(uri);
            }
        });
        bt_fresco_corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parames = RoundingParams.fromCornersRadius(50f);
                parames.setOverlayColor(getResources().getColor(android.R.color.holo_red_light));//覆盖层
                parames.setBorder(getResources().getColor(android.R.color.holo_blue_light), 5);//边框

                GenericDraweeHierarchy hierarchy = builder.setRoundingParams(parames).build();
                sdvFrescoCircleandcorner.setHierarchy(hierarchy);

                // 加载图片
                sdvFrescoCircleandcorner.setImageURI(uri);
            }
        });
    }

    private void initData() {
        uri = Uri.parse("http://img4q.duitang.com/uploads/item/201305/20/20130520115416_VrUUR.jpeg");

        builder = new GenericDraweeHierarchyBuilder(getResources());
    }
}
