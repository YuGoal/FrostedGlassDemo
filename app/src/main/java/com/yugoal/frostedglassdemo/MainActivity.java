package com.yugoal.frostedglassdemo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.yugoal.frostedglassdemo.util.FastBlurUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    private ImageView imageView;
    private ImageView imageView2;
    private Button btn_start;
    private Bitmap originBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        btn_start = (Button) findViewById(R.id.btn_start);
        Resources res=getResources();
        originBitmap= BitmapFactory.decodeResource(res, R.drawable.test);
        btn_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        long start = System.currentTimeMillis();
        Bitmap scaledBitmap, blurBitmap = null;
        int scaleRatio = 50;
        int loopCount = 100;
        for (int i=0; i<loopCount; i++) {
            scaledBitmap = Bitmap.createScaledBitmap(originBitmap,
                    originBitmap.getWidth() / scaleRatio,
                    originBitmap.getHeight() / scaleRatio,
                    false);
            blurBitmap = FastBlurUtil.doBlur(scaledBitmap, 8, true);
        }
        imageView2.setImageBitmap(blurBitmap);
        Log.d("blurtime", String.valueOf(System.currentTimeMillis() - start));
    }
}
