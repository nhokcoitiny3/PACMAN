package com.tiny.game.model;


import com.oracle.deploy.update.Updater;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class WavPlayer {
    private Clip clip;
    private boolean isRuning;

    public WavPlayer(String name) {
        try {
            URL url = getClass().getResource("/res/raw/" + name + ".wav");
            AudioInputStream stream = AudioSystem.getAudioInputStream(url);

            clip = AudioSystem.getClip();
            clip.open(stream);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

    }

    public void playSound() {
        if (clip != null && !clip.isRunning()) {
            isRuning =true;
            clip.start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (clip.isRunning()){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }
    }

    public void stopSound(){
        if (clip != null && clip.isRunning()){
            clip.stop();
        }
    }

    public void loop(int count){
        clip.loop(count);
    }

}
