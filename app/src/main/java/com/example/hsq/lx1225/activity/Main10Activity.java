package com.example.hsq.lx1225.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
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
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

public class Main10Activity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView sdvFrescoModify;
    /**
     * 在图片上添加网格
     */
    private Button mBtFrescoModify;
    private LinearLayout mActivityFrescoModify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        initView();

    }

    private void initView() {
        sdvFrescoModify = (SimpleDraweeView) findViewById(R.id.sdv_fresco_modify);
        mBtFrescoModify = (Button) findViewById(R.id.bt_fresco_modify);
        mBtFrescoModify.setOnClickListener(this);
        mActivityFrescoModify = (LinearLayout) findViewById(R.id.activity_fresco_modify);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_fresco_modify:

                // 图片地址
                Uri uri = Uri.parse("http://c.hiphotos.baidu.com/image/pic/item/962bd40735fae6cd21a519680db30f2442a70fa1.jpg");

                // 修改图片
                Postprocessor postProcessor = new BasePostprocessor() {
                    @Override
                    public String getName() {
                        return "postProcessor";
                    }

                    @Override
                    public void process(Bitmap bitmap) {

                        for (int x = 0; x < bitmap.getWidth(); x += 2) {

                            for (int y = 0; y < bitmap.getHeight(); y += 2) {
                                bitmap.setPixel(x, y, Color.RED);
                            }
                        }
                    }
                };

                // 创建图片请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setPostprocessor(postProcessor)
                        .build();

                // 控制加载
                PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setOldController(sdvFrescoModify.getController())
                        .setImageRequest(request)
                        .build();

                // 加载图片
                sdvFrescoModify.setController(controller);
                break;
        }
    }
}
