package com.example.hsq.lx1225.activity;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hsq.lx1225.R;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_fresco_center;
    private Button bt_fresco_centercrop;
    private Button bt_fresco_focuscrop;
    private Button bt_fresco_centerinside;
    private Button bt_fresco_fitcenter;
    private Button bt_fresco_fitstart;
    private Button bt_fresco_fitend;
    private Button bt_fresco_fitxy;
    private Button bt_fresco_none;
    private SimpleDraweeView sdvFrescoCrop;
    private TextView tvFrescoExplain;
    private GenericDraweeHierarchyBuilder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        bt_fresco_center = findViewById(R.id.bt_fresco_center);
        bt_fresco_centercrop = findViewById(R.id.bt_fresco_centercrop);
        bt_fresco_focuscrop = findViewById(R.id.bt_fresco_focuscrop);
        bt_fresco_centerinside = findViewById(R.id.bt_fresco_centerinside);
        bt_fresco_fitcenter = findViewById(R.id.bt_fresco_fitcenter);
        bt_fresco_fitend = findViewById(R.id.bt_fresco_fitend);
        bt_fresco_fitstart = findViewById(R.id.bt_fresco_fitstart);
        bt_fresco_fitxy = findViewById(R.id.bt_fresco_fitxy);
        bt_fresco_none = findViewById(R.id.bt_fresco_none);
        sdvFrescoCrop = findViewById(R.id.sdv_fresco_crop);
        tvFrescoExplain = findViewById(R.id.tv_fresco_explain);

        bt_fresco_center.setOnClickListener(this);
        bt_fresco_centercrop.setOnClickListener(this);
        bt_fresco_focuscrop.setOnClickListener(this);
        bt_fresco_centerinside.setOnClickListener(this);
        bt_fresco_fitcenter.setOnClickListener(this);
        bt_fresco_fitend.setOnClickListener(this);
        bt_fresco_fitxy.setOnClickListener(this);
        bt_fresco_none.setOnClickListener(this);
        bt_fresco_fitstart.setOnClickListener(this);
        initData();
    }

    private void initData() {
        //tvTitle.setText("图片的不同裁剪");

        builder = new GenericDraweeHierarchyBuilder(getResources());
    }

    private void imageDisplay(GenericDraweeHierarchy hierarchy) {
        sdvFrescoCrop.setHierarchy(hierarchy);

        // 加载图片
        Uri uri = Uri.parse("http://img4q.duitang.com/uploads/item/201305/20/20130520115416_VrUUR.jpeg");
        sdvFrescoCrop.setImageURI(uri);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_fresco_center:
                // 设置描述
                tvFrescoExplain.setText("居中，无缩放");

                // 样式设置
                GenericDraweeHierarchy hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER).build();

                // 图片显示
                imageDisplay(hierarchy);
                break;
            // 保持宽高比缩小或放大，使得两边都大于或等于显示边界。居中显示
            case R.id.bt_fresco_centercrop:
                // 设置描述
                tvFrescoExplain.setText("保持宽高比缩小或放大，使得两边都大于或等于显示边界。居中显示");

                // 样式设置
                GenericDraweeHierarchy hierarchy1 = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build();

                // 图片显示
                imageDisplay(hierarchy1);
                break;
            // 同centerCrop, 但居中点不是中点，而是指定的某个点,这里我设置为图片的左上角那点
            case R.id.bt_fresco_focuscrop:
                // 设置描述
                tvFrescoExplain.setText("同centerCrop, 但居中点不是中点，而是指定的某个点,这里我设置为图片的左上角那点");

                // 样式设置
                PointF point = new PointF(0, 0);
                GenericDraweeHierarchy hierarchy2 = builder.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP)
                        .setActualImageFocusPoint(point).build();

                // 图片显示
                imageDisplay(hierarchy2);
                break;
            // 使两边都在显示边界内，居中显示。如果图尺寸大于显示边界，则保持长宽比缩小图片
            case R.id.bt_fresco_centerinside:
                // 设置描述
                tvFrescoExplain.setText("使两边都在显示边界内，居中显示。如果图尺寸大于显示边界，则保持长宽比缩小图片");

                // 样式设置
                GenericDraweeHierarchy hierarchy3 = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build();

                // 图片显示
                imageDisplay(hierarchy3);

                break;
            // 保持宽高比，缩小或者放大，使得图片完全显示在显示边界内。居中显示
            case R.id.bt_fresco_fitcenter:
                // 设置描述
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内。居中显示");

                // 样式设置
                GenericDraweeHierarchy hierarchy4 = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();

                // 图片显示
                imageDisplay(hierarchy4);
                break;
            // 保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界右下对齐
            case R.id.bt_fresco_fitend:
                // 设置描述
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界右下对齐");

                // 样式设置
                GenericDraweeHierarchy hierarchy5 = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_END).build();

                // 图片显示
                imageDisplay(hierarchy5);
                break;
            // 不保持宽高比，填充满显示边界
            case R.id.bt_fresco_fitxy:
                // 设置描述
                tvFrescoExplain.setText("不保持宽高比，填充满显示边界");

                // 样式设置
                GenericDraweeHierarchy hierarchy6 = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();

                // 图片显示
                imageDisplay(hierarchy6);
                break;
            // 如要使用title mode显示, 需要设置为none
            case R.id.bt_fresco_none:
                // 设置描述
                tvFrescoExplain.setText("如要使用title mode显示, 需要设置为none");

                // 样式设置
                GenericDraweeHierarchy hierarchy7 = builder.setActualImageScaleType(null).build();

                // 图片显示
                imageDisplay(hierarchy7);
                break;
            // 保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界左上对齐
            case R.id.bt_fresco_fitstart:
                // 设置描述
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界左上对齐");

                // 样式设置
                GenericDraweeHierarchy hierarchy8 = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).build();

                // 图片显示
                imageDisplay(hierarchy8);
                break;

        }

    }
}
