package com.hhk.ffmpegmombile_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.arthenica.mobileffmpeg.Config;
import com.arthenica.mobileffmpeg.FFmpeg;
import com.arthenica.mobileffmpeg.LogCallback;
import com.arthenica.mobileffmpeg.LogMessage;

public class MainActivity extends AppCompatActivity {

    TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_title = findViewById(R.id.tv_title);

        Config.enableLogCallback(new LogCallback() {
            @Override
            public void apply(LogMessage logMessage) {
                tv_title.append(logMessage.getText());
            }
        });

        int ret = FFmpeg.execute("-version");

        if(ret == 0)
            Toast.makeText(MainActivity.this, "execute Successed", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "execute Failed", Toast.LENGTH_SHORT).show();

    }
}