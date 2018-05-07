package com.pedro.vlctestapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_FULL_SCREEN_ACTIVITY = 101;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bStartStop = findViewById(R.id.b_start_stop);
        bStartStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_start_stop:
                startFullScreenActivity();
                break;
        }
    }

    private void startFullScreenActivity() {
        startActivityForResult(FullScreenActivity.createIntent(this,
                "rtsp://admin:@192.168.1.142"),
                REQUEST_CODE_FULL_SCREEN_ACTIVITY);
    }
}
