package io.infernodz.jplayer;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;

import java.util.List;

public class PlayerService extends MediaBrowserServiceCompat {

    private static final String TAG = PlayerService.class.getCanonicalName();

    // Service Commands
    private static final String CMD_PLAY = "cmd_play";
    private static final String CMD_PAUSE = "cmd_pause";
    private static final String CMD_STOP = "cmd_stop";

    private MediaSessionCompat mSession;
    private PlaybackStateCompat.Builder mPlaybackStateBuilder;
    // TODO: настройка метадаты
    private MediaMetadataCompat.Builder mMetadataBuilder;

    @Override
    public void onCreate() {
        super.onCreate();

        mSession = new MediaSessionCompat(this, TAG);
        mSession.setFlags(MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS);

        mPlaybackStateBuilder = new PlaybackStateCompat.Builder();
        mPlaybackStateBuilder.setActions(PlaybackStateCompat.ACTION_PLAY |
                PlaybackStateCompat.ACTION_PLAY_PAUSE |
                PlaybackStateCompat.ACTION_PAUSE |
                PlaybackStateCompat.ACTION_STOP);

        mSession.setPlaybackState(mPlaybackStateBuilder.build());

        mSession.setCallback(new JPlayerMediaSessionCallback(this));

        setSessionToken(mSession.getSessionToken());

        // TODO: когда правильно вызывать setActive
        mSession.setActive(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null) {
                switch(action) {
                    case CMD_PLAY:
                        break;
                    case CMD_PAUSE:
                        break;
                    case CMD_STOP:
                        break;
                    default:
                        // TODO: почему stopSelf() а не stop с освобождением ресурсов
                        stopSelf();
                        break;
                }
            } else {
                stopSelf();
            }
        } else {
            stopSelf();
        }
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {
        return null;
    }

    @Override
    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {

    }

    private final static class JPlayerMediaSessionCallback extends MediaSessionCompat.Callback {

        private final Context mContext;

        JPlayerMediaSessionCallback(@NonNull Context context) {
            mContext = context;
        }

        @Override
        public void onPlay() {

        }

        @Override
        public void onPause() {

        }

        @Override
        public void onStop() {

        }
    }
}
