package com.example.mdt;

import android.graphics.Typeface;
import android.os.Build;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Hardware extends AppCompatActivity {

    TextView textSystem_Info ,  txtRam;
    Button SystemInfo , Next;

    long bytesAvailable, megAvailable, gebAvailable;
    long internalBytesAvailable, internalMegAvailable, internalGebAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);

        initView();

        // Get external storage info
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        bytesAvailable = statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        megAvailable = bytesAvailable / (1024 * 1024);
        gebAvailable = megAvailable/1024;

        // Get internal storage info
        StatFs internalStatFs = new StatFs(Environment.getDataDirectory().getPath());
        internalBytesAvailable = internalStatFs.getBlockSizeLong() * internalStatFs.getAvailableBlocksLong();
        internalMegAvailable = internalBytesAvailable / (1024 * 1024);
        internalGebAvailable = internalMegAvailable/1024;
    }

    private void initView() {
        textSystem_Info = findViewById(R.id.System_Info);
        SystemInfo = findViewById(R.id.SystemInfo);
        txtRam = findViewById(R.id.txtRam);

        // set gravity to center for both TextViews
        txtRam.setGravity(Gravity.CENTER);
        textSystem_Info.setTextColor(getResources().getColor(android.R.color.black));
        txtRam.setTextColor(getResources().getColor(android.R.color.black));
        SystemInfo.setTextColor(getResources().getColor(android.R.color.black));
        textSystem_Info.setTypeface(null, Typeface.BOLD);
        txtRam.setTypeface(null, Typeface.BOLD);
        SystemInfo.setTypeface(null, Typeface.BOLD);


        SystemInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String information = getHardwareAndSoftwareInfo();

                textSystem_Info.setText(information);

                txtRam.setText(getMemoryInfo());


            }
        });
    }

    private String getMemoryInfo(){
        Context context = getApplicationContext();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);

        DecimalFormat twoDecimalFormate = new DecimalFormat( "#.##");

        String finalvalue = "";
        long totalMemory = memoryInfo.totalMem;

        double kb = totalMemory/1024.0;
        double mb = totalMemory/1048576.0;
        double gb = totalMemory/1073741824.0;
        double tb = totalMemory/1099511627776.0;

        if (tb>1){
            finalvalue = twoDecimalFormate.format(tb).concat(" TB");
        } else if (gb > 1) {
            finalvalue = twoDecimalFormate.format(gb).concat(" GB");

        }
        else if (mb > 1) {
            finalvalue = twoDecimalFormate.format(mb).concat(" MB");
        }
        else if (kb > 1){
            finalvalue = twoDecimalFormate.format(kb).concat(" KB");
        }
        else
        {
            finalvalue = twoDecimalFormate.format(totalMemory).concat(" Bytes");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RAM: ").append(finalvalue).append("\n").
                append("Available Internal/External free space: " + gebAvailable + "GB");
        return stringBuilder.toString();
    }





    private String getHardwareAndSoftwareInfo() {

        return  "MODEL" + " " + " = " + Build.MODEL + " \n" +
                "MANUFACTURER" + " " + " = " + Build.MANUFACTURER + "\n" +
                "BRAND" + " " + " = " + Build.BRAND + "\n" +
                "TYPE" + " " + " = " + Build.TYPE + "\n" +
                "USER" + " " + " = " + Build.USER + "\n" +
                "BASE" + " " + " = " + Build.VERSION_CODES.BASE + "\n" +
                "SDK" + " " + " = " + Build.VERSION.SDK+ "\n" +
                "BOARD" + " " + " = " + Build.BOARD + "\n" +
                "HOST" + " " + " = " + Build.HOST + "\n" +
                "FINGERPRINT" + " " + " = " + Build.FINGERPRINT + "\n" +
                "DISPLAY" + " " + " = " + Build.DISPLAY + "\n" +
                "HARDWARE" + " " + " = " + Build.HARDWARE + "\n" +
                "VERSIONCODE" + " " + " = " + Build.VERSION.RELEASE;
    }
}




