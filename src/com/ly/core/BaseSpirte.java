package com.ly.core;

import java.awt.*;

public class BaseSpirte {
    private int x;
    private int y;
    private Image image;

    public BaseSpirte() {
    }

    public BaseSpirte(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getRect() {
        return null;
    }
}
