package io.infernodz.jplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    private Button mButtonPlay;
    private Button mButtonPause;
    private Button mButtonStop;
    private TextView mTextTrackInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        mButtonPlay = findViewById(R.id.btn_play);
        mButtonPause = findViewById(R.id.btn_pause);
        mButtonStop = findViewById(R.id.btn_stop);
        mTextTrackInfo = findViewById(R.id.tv_track_info);
    }
}
