package com.uai.workshop;

public class SoundManager {

    static SoundManager instance;

    private SoundManager(){

    }

    public static SoundManager getInstance(){
        if (instance == null){
            instance = new SoundManager();
        }
        return instance;
    }
}
