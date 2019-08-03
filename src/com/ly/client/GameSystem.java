package com.ly.client;

import com.ly.core.MyFrame;
import com.ly.until.DataStore;

public class GameSystem {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        DataStore.put("myFrame",myFrame);
        myFrame.launchFrame();
    }
}
