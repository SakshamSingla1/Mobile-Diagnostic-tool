package com.example.mdt;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.time.LocalDate;

public class Calllog extends AppCompatActivity {
    private TextView call;
    private Button bcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calllog);
        call = findViewById(R.id.call);
        bcall = findViewById(R.id.bcall);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CALL_LOG}, PackageManager.PERMISSION_GRANTED);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setBcall(View view) {
        call.setText("Call Logging Started......");
        String stringOutput = " ";

        // Get the date for which we want to get the call logs
        LocalDate today = LocalDate.now();
        String dateString = today.toString();

        Uri uriCallLog = CallLog.Calls.CONTENT_URI;
        String[] projection = null;
        String selection = CallLog.Calls.DATE + "=?";
        String[] selectionArgs = new String[] { dateString };
        String sortOrder = CallLog.Calls.DATE + " DESC";

        @SuppressLint("Recycle") Cursor cursorCallLogs = getContentResolver().query(uriCallLog, projection, selection, selectionArgs, sortOrder);
        if (cursorCallLogs != null && cursorCallLogs.moveToFirst()) {
            do {
                @SuppressLint("Range") String stringNumber = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.NUMBER));
                @SuppressLint("Range") String stringName = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.CACHED_NAME));
                @SuppressLint("Range") String stringDuration = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.DURATION));
                @SuppressLint("Range") String stringType = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.TYPE));

                stringOutput += "Number: " + stringNumber + "\nName: " + stringName + "\nDuration: " + stringDuration + "\nType: " + stringType + "\n\n";
            } while (cursorCallLogs.moveToNext());
            cursorCallLogs.close();
        } else {
            stringOutput = "No call logs found";
        }
        call.setText(stringOutput);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PackageManager.PERMISSION_GRANTED) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission granted
            } else {
                // permission denied
            }
        }
    }
}
