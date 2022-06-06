package com.rulhouse.callbackpractice;

public class PlayMusic {
    Long time = 2000L;

    private MusicStateListener musicStateListener;

    interface MusicStateListener {
        void onStart();
        void onFinished();
    }

    void setMusicStateListener(MusicStateListener musicStateListener) {
        this.musicStateListener = musicStateListener;
    }

    void playMusic() {
        musicStateListener.onStart();
        Thread playMusicThread = new Thread(playMusicTask);
        playMusicThread.start();
    }

    private final Runnable playMusicTask = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(time);
                musicStateListener.onFinished();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}
