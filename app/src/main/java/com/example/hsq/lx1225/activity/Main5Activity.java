package com.example.hsq.lx1225.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hsq.lx1225.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class Main5Activity extends AppCompatActivity {

    private SimpleDraweeView sdv_fresco_jpeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        sdv_fresco_jpeg = findViewById(R.id.sdv_fresco_jpeg);
        Button bt = findViewById(R.id.sdv_fresco_askImg);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 加载质量配置
                ProgressiveJpegConfig jpegConfig = new ProgressiveJpegConfig() {
                    @Override
                    public int getNextScanNumberToDecode(int scanNumber) {
                        return scanNumber + 2;
                    }

                    @Override
                    public QualityInfo getQualityInfo(int scanNumber) {
                        boolean isGoodEnough = (scanNumber >= 5);

                        return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
                    }
                };

                ImagePipelineConfig.newBuilder(Main5Activity.this).setProgressiveJpegConfig(jpegConfig).build();

                // 获取图片URL
                Uri uri = Uri.parse("http://cdn.duitang.com/uploads/item/201303/12/20130312021353_45Qix.jpeg");

                // 获取图片请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setProgressiveRenderingEnabled(true).build();

                DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setTapToRetryEnabled(true)
                        .setOldController(sdv_fresco_jpeg.getController())//使用oldController可以节省不必要的内存分配
                        .build();

                // 1设置加载的控制
                sdv_fresco_jpeg.setController(draweeController);
            }
        });
    }
}
