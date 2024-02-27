package com.example.mdt;

import android.os.Bundle;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayInfo extends AppCompatActivity {
    TextView screenInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);
        Display display = getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        float density = metrics.density;
        int densityDpi = metrics.densityDpi;

        screenInfoTextView = findViewById(R.id.screen_info);
        screenInfoTextView.setText("Screen Width: " + width + "px\n" +
                "Screen Height: " + height + "px\n" +
                "Screen Density: " + density + "\n" +
                "Screen Resolution: " + densityDpi + "dpi");
        screenInfoTextView.setGravity(Gravity.CENTER);
    }
}
