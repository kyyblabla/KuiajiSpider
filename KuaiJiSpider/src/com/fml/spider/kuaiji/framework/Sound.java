/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji.framework;

/**
 *
 * @author ky
 */
public interface Sound {

   
    public void play();
    
    public void stop();
    
    public boolean isPlaying();
    
    public void setLoop(boolean loop);

}
