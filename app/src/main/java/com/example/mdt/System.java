package com.example.mdt;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class System extends AppCompatActivity {


        TextView System_Info;
        Button SystemInfo;
        long bytesAvailable, megAvailable;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_system);

            initView();
            StatFs statFs = new StatFs(Environment.getDownloadCacheDirectory().getPath());
            bytesAvailable = statFs.getBlockCountLong()  * statFs.getAvailableBlocksLong();

            megAvailable = bytesAvailable / (1024 * 1024);

        }
        private void initView() {
            System_Info = findViewById(R.id.System_Info);
            SystemInfo = findViewById(R.id.SystemInfo);
            SystemInfo.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    String information = getHardwareAndSoftwareInfo();
                    System_Info.setText(information);
                    System_Info.setGravity(Gravity.CENTER);
                }
            });
        }

        private String getHardwareAndSoftwareInfo() {

            return "DEVICE NAME" + " " + " = " + Build.MANUFACTURER + "\n" +
                    "MODEL" + " " + " = " + Build.MODEL + " \n" +
                    "ID" + " " + " = " + Build.ID + " \n" +
                    "USER" + " " + Build.USER;

        }

    }




