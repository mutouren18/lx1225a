package com.example.hsq.lx1225.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hsq.lx1225.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class Main11Activity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 加载图片
     */
    private Button mBtFrescoLoadsmall;
    private LinearLayout mLlFresco;
    private LinearLayout mActivityFrescoAutoSize;
    private SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        initView();
    }

    private void initView() {
        mBtFrescoLoadsmall = (Button) findViewById(R.id.bt_fresco_loadsmall);
        mBtFrescoLoadsmall.setOnClickListener(this);
        mLlFresco = (LinearLayout) findViewById(R.id.ll_fresco);
        mActivityFrescoAutoSize = (LinearLayout) findViewById(R.id.activity_fresco_auto_size);
        //tvTitle.setText("动态展示图片");

        simpleDraweeView = new SimpleDraweeView(this);
        // 设置宽高比
        simpleDraweeView.setAspectRatio(3.0f);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_fresco_loadsmall:

                // 图片的地址
                Uri uri = Uri.parse("http://img4q.duitang.com/uploads/item/201304/27/20130427043538_wAfHC.jpeg");
                // 图片的请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .build();

                // 加载图片的控制
                PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setOldController(simpleDraweeView.getController())
                        .setImageRequest(request)
                        .build();

                // 加载图片
                simpleDraweeView.setController(controller);

                // 添加View到线性布局中
                mLlFresco.addView(simpleDraweeView);
                break;
        }
    }
}
