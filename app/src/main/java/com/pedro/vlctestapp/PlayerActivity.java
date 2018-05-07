package com.pedro.vlctestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Toast;

import com.pedro.vlc.VlcListener;
import com.pedro.vlc.VlcVideoLibrary;

import java.util.Arrays;

/**
 * Created by pedro on 25/06/17.
 */
public abstract class PlayerActivity extends AppCompatActivity implements VlcListener {

    static final String EXTRA_URL = "URL";

    private static final int RESULT_CODE_ERROR = 800;
    private static final String KEY_ERROR = "ERROR";

    private VlcVideoLibrary vlcVideoLibrary;

    private String[] options = new String[]{":fullscreen"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_player);
        SurfaceView surfaceView = findViewById(R.id.activity_player_surface_view);
        vlcVideoLibrary = new VlcVideoLibrary(this, this, surfaceView);
        vlcVideoLibrary.setOptions(Arrays.asList(options));

        String endpoint = getIntent().getStringExtra(EXTRA_URL);
        vlcVideoLibrary.play(endpoint);
    }

    @Override
    public void onComplete() {
        Toast.makeText(this, "Playing", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        vlcVideoLibrary.stop();
        setResult(RESULT_CODE_ERROR, new Intent().putExtra(KEY_ERROR, "Error, make sure your endpoint is correct"));
        finish();
    }

}
