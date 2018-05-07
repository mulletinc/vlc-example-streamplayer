package com.pedro.vlctestapp;

import android.content.Context;
import android.content.Intent;

public class FullScreenActivity extends PlayerActivity {

    public static Intent createIntent(Context context, String url) {
        return new Intent(context, FullScreenActivity.class)
                .putExtra(EXTRA_URL, url);
    }

}
