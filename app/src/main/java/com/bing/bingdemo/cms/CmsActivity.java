package com.bing.bingdemo.cms;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bing.bingdemo.R;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

public class CmsActivity extends AppCompatActivity {

    EditText editText;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cms);
        editText = findViewById(R.id.editText);
        linearLayout = findViewById(R.id.parentLayout);
        View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    JSONObject object = new JSONObject(editText.getText().toString());
//                    drawViews(object);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
            }
        });

    }
    //自定义的代理事件监听器
    private static class OnClickListenerProxy implements View.OnClickListener {

        private View.OnClickListener object;

        private int MIN_CLICK_DELAY_TIME = 1000;

        private long lastClickTime = 0;

        private OnClickListenerProxy(View.OnClickListener object) {
            this.object = object;
        }

        @Override
        public void onClick(View v) {
            //点击时间控制
            Log.e("wubingzhao", "onClick哈哈哈");
            object.onClick(v);
//            long currentTime = Calendar.getInstance().getTimeInMillis();
//            if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
//                lastClickTime = currentTime;
//                Log.e("OnClickListenerProxy", "OnClickListenerProxy");
//                if (object != null) object.onClick(v);
//            }

        }
    }
    private void drawViews(JSONObject object){
        if(object == null){
            return;
        }
        linearLayout.removeAllViews();
        JSONArray rowsArray = object.optJSONArray("rows");
        for (int i = 0; i < rowsArray.length(); i++) {
            try {
                JSONObject rowObject = rowsArray.getJSONObject(i);
                int rowW = rowObject.optInt("width");
                int rowH = rowObject.optInt("height");
                FrameLayout layout = new FrameLayout(this);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) layout.getLayoutParams();
                if(layoutParams == null){
                    layoutParams = new FrameLayout.LayoutParams(rowW,rowH);
                }
                layoutParams.width = rowW;
                layoutParams.height = rowH;
                layout.setLayoutParams(layoutParams);
                layout.setBackgroundColor(Color.BLUE);

                JSONArray cellsArray = rowObject.optJSONArray("cells");
                for (int i1 = 0; i1 < cellsArray.length(); i1++) {
                    JSONObject cellObject = cellsArray.getJSONObject(i1);
                    int cellW = cellObject.optInt("width");
                    int cellH = cellObject.optInt("height");
                    FrameLayout cellLayout = new FrameLayout(this);
                    LinearLayout.LayoutParams cellLayoutParams = (LinearLayout.LayoutParams) cellLayout.getLayoutParams();
                    if(cellLayoutParams == null){
                        cellLayoutParams = new LinearLayout.LayoutParams(cellW,cellH);
                    }
                    cellLayoutParams.width = cellW;
                    cellLayoutParams.height = cellH;
                    cellLayout.setLayoutParams(cellLayoutParams);

                    cellLayout.setBackgroundColor(Color.GREEN);

                    JSONArray paramArray = cellObject.optJSONArray("items");
                    for (int i2 = 0; i2 < paramArray.length(); i2++) {
                        JSONObject paramObject = paramArray.getJSONObject(i2);
                        String type = paramObject.optString("type");
                        int paramW = paramObject.optInt("width");
                        int paramH = paramObject.optInt("height");
                        int x = paramObject.optInt("x");
                        int y = paramObject.optInt("y");
                        if("image".equals(type)){
                            String url = paramObject.optString("url");
                            ImageView imageView = new ImageView(this);

                            FrameLayout.LayoutParams tvParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                            if(tvParams == null){
                                tvParams = new FrameLayout.LayoutParams(paramW,paramH);
                            }
                            tvParams.leftMargin = x;
                            tvParams.topMargin = y;
                            imageView.setLayoutParams(tvParams);
                            imageView.setBackgroundColor(Color.BLACK);
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            Glide.with(this).load(url).into(imageView);
                            cellLayout.addView(imageView,tvParams);
                        }else if ("label".equals(type)){
                            String text = paramObject.optString("text");
                            int align = paramObject.optInt("align");
                            String textColor = paramObject.optString("textColor");
                            String bgColor = paramObject.optString("bgColor");
                            int gravity;
                            if(align == 1){
                                //上
                                gravity = Gravity.TOP;
                            }else if(align == 2){
                                //下
                                gravity = Gravity.BOTTOM;
                            }else if(align == 3){
                                //左
                                gravity = Gravity.LEFT;
                            }else if(align == 4){
                                //右
                                gravity = Gravity.RIGHT;
                            }else {
                                //居中
                                gravity = Gravity.CENTER;
                            }
                            TextView textView = new TextView(this);
                            FrameLayout.LayoutParams tvParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                            if(tvParams == null){
                                tvParams = new FrameLayout.LayoutParams(paramW,paramH);
                            }
                            tvParams.width = paramW;
                            tvParams.height = paramH;
                            tvParams.leftMargin = x;
                            tvParams.topMargin = y;
                            textView.setBackgroundColor(Color.parseColor(bgColor));
                            textView.setLayoutParams(tvParams);
                            textView.setTextColor(Color.parseColor(textColor));
                            textView.setGravity(gravity);
                            textView.setText(text);
                            cellLayout.addView(textView,tvParams);
                        }

                    }
                    layout.addView(cellLayout,cellLayoutParams);

                }
                linearLayout.addView(layout,layoutParams);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
