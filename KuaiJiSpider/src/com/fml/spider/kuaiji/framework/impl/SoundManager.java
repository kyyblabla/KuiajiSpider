/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji.framework.impl;

import com.fml.spider.kuaiji.framework.Sound;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author ky
 */
public class SoundManager implements Sound {

    private String soundPath;
    private boolean isPlaying = false;
    private Clip clip = null;

    Thread soundPlayer;

    public SoundManager(String path) {

        this.soundPath = path;

        soundPlayer = new Thread() {

            @Override
            public void run() {
                try {
                    // use one of the WAV of Windows installation
                    File tadaSound = new File(soundPath);
                    AudioInputStream audioInputStream = AudioSystem
                            .getAudioInputStream(new FileInputStream(tadaSound));
                    AudioFormat audioFormat = audioInputStream
                            .getFormat();
                    DataLine.Info dataLineInfo = new DataLine.Info(
                            Clip.class, audioFormat);
                    Clip clip = (Clip) AudioSystem
                            .getLine(dataLineInfo);
                    clip.open(audioInputStream);

                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {

                }
            }
        };

    }

    @Override
    public void play() {
        clip.start();
    }

    @Override
    public void stop() {
        clip.stop();
    }

    @Override
    public boolean isPlaying() {
        return clip.isRunning();
    }

    @Override
    public void setLoop(boolean loop) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
