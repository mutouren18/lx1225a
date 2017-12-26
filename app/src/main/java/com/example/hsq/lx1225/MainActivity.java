package com.example.hsq.lx1225;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hsq.lx1225.activity.Main10Activity;
import com.example.hsq.lx1225.activity.Main11Activity;
import com.example.hsq.lx1225.activity.Main3Activity;
import com.example.hsq.lx1225.activity.Main4Activity;
import com.example.hsq.lx1225.activity.Main5Activity;
import com.example.hsq.lx1225.activity.Main6Activity;
import com.example.hsq.lx1225.activity.Main7Activity;
import com.example.hsq.lx1225.activity.Main8Activity;
import com.example.hsq.lx1225.activity.Main9Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_fresco_spimg;
    private Button bt_fresco_crop;
    private Button bt_fresco_circleAndCorner;
    private Button bt_fresco_jpeg;
    private Button bt_fresco_gif;
    private Button bt_fresco_multi;
    private Button bt_fresco_listener;
    private Button bt_fresco_resize;
    private Button bt_fresco_modifyImg;
    private Button bt_fresco_autoSizeImg;

    // String url ="http://p4.gexing.com/G1/M00/3A/E3/rBABFFGpmDuhU-NSAAC_akAXq-0260.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Uri uri = Uri.parse(url);
//        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        //最简单的使用
        //draweeView.setImageURI(uri);

        initDate();


    }

    //初始化空间
    private void initDate() {
        bt_fresco_spimg = findViewById(R.id.bt_fresco_spimg);
        bt_fresco_crop = findViewById(R.id.bt_fresco_crop);
        bt_fresco_circleAndCorner = findViewById(R.id.bt_fresco_circleAndCorner);
        bt_fresco_jpeg = findViewById(R.id.bt_fresco_jpeg);
        bt_fresco_gif = findViewById(R.id.bt_fresco_gif);
        bt_fresco_multi = findViewById(R.id.bt_fresco_multi);
        bt_fresco_listener = findViewById(R.id.bt_fresco_listener);
        bt_fresco_resize = findViewById(R.id.bt_fresco_resize);
        bt_fresco_modifyImg = findViewById(R.id.bt_fresco_modifyImg);
        bt_fresco_autoSizeImg = findViewById(R.id.bt_fresco_autoSizeImg);

        bt_fresco_spimg.setOnClickListener(this);
        bt_fresco_crop.setOnClickListener(this);
        bt_fresco_circleAndCorner.setOnClickListener(this);
        bt_fresco_jpeg.setOnClickListener(this);
        bt_fresco_gif.setOnClickListener(this);
        bt_fresco_multi.setOnClickListener(this);
        bt_fresco_listener.setOnClickListener(this);
        bt_fresco_resize.setOnClickListener(this);
        bt_fresco_modifyImg.setOnClickListener(this);
        bt_fresco_autoSizeImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //Toast.makeText(MainActivity.this,v.getId()+"",Toast.LENGTH_LONG).show();
            //进度条
            case R.id.bt_fresco_spimg:
                //Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                startActivity(intent);
                break;
            // 图片的不同裁剪
            case R.id.bt_fresco_crop:
                Intent intent1 = new Intent(MainActivity.this, Main3Activity.class);

                startActivity(intent1);

                break;
            // 圆形和圆角图片
            case R.id.bt_fresco_circleAndCorner:
                Intent intent2 = new Intent(MainActivity.this, Main4Activity.class);

                startActivity(intent2);

                break;
            // 渐进式展示图片
            case R.id.bt_fresco_jpeg:
                Intent intent3 = new Intent(MainActivity.this, Main5Activity.class);

                startActivity(intent3);
                break;
            // GIF动画图片
            case R.id.bt_fresco_gif:
                Intent intent4 = new Intent(MainActivity.this, Main6Activity.class);

                startActivity(intent4);
                break;
            // 多图请求及图片复用
            case R.id.bt_fresco_multi:
                Intent intent5 = new Intent(MainActivity.this, Main7Activity.class);

                startActivity(intent5);
                break;
            // 图片加载监听
            case R.id.bt_fresco_listener:
                Intent intent6 = new Intent(MainActivity.this, Main8Activity.class);

                startActivity(intent6);
                break;
            // 图片修改和旋转
            case R.id.bt_fresco_resize:
                Intent intent7 = new Intent(MainActivity.this, Main9Activity.class);

                startActivity(intent7);
                break;
            // 修改图片
            case R.id.bt_fresco_modifyImg:
                Intent intent8 = new Intent(MainActivity.this, Main10Activity.class);

                startActivity(intent8);
                break;
            // 动态展示图片
            case R.id.bt_fresco_autoSizeImg:
                Intent intent9 = new Intent(MainActivity.this, Main11Activity.class);

                startActivity(intent9);
                break;
        }
    }
}
