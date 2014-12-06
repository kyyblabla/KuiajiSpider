/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji.framework.impl;

import com.fml.spider.kuaiji.framework.Sound;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author ky
 */
public class SoundPlay implements Sound {

    private String currPath = null;
    private AudioStream as;
    private final Thread checkThread;
    private Boolean isPlaying = false;
    private boolean isLoop = false;

    public SoundPlay(String path) {
        this.currPath = path;
        checkThread = new Thread() {

            @Override
            public void run() {

                while (true) {
                    synchronized (isPlaying) {
                    
                       
                    }
                    
                    if (!isPlaying) {
                        playOver();
                        break;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Exception ex) {

                    }
                }
            }

        };

    }

    @Override
    public void play() {

        File f = new File(currPath);

        if (!f.exists()) {
            return;
        }

        if (isPlaying()) {
            return;
        }

        try {
            FileInputStream fileau = new FileInputStream(currPath);
            as = new AudioStream(fileau);
            AudioPlayer.player.start(as);
            checkThread.start();

        } catch (Exception e) {
           
        }

    }

    @Override
    public void stop() {

        AudioPlayer.player.stop(as);
        
    }

    @Override
    public boolean isPlaying() {

        return isPlaying;

    }

    @Override
    public void setLoop(boolean loop) {
        this.isLoop = loop;
    }

    public void playOver(){
        
        System.out.println("oooooooooo");
        if(isLoop){
            play();
        }
        
    }

}
