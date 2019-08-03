package com.ly.entity;

import com.ly.constant.Constant;
import com.ly.core.Drawable;
import com.ly.core.Moveable;
import com.ly.core.BaseSpirte;
import com.ly.until.ImageMap;

import java.awt.*;

public class BackGround extends BaseSpirte implements Drawable, Moveable {
    public static Image bgimg;
    public static int speed = Constant.GAME_SPEED * 5;
    private int y1 = -ImageMap.get("bg1").getHeight(null);

    public BackGround() {
        this(0, 0, ImageMap.get("bg1"));
    }

    public BackGround(int x, int y, Image img) {
        super(x, y);
        this.bgimg = img;
    }


    @Override
    public void draw(Graphics g) {
        g.drawImage(bgimg, getX(), getY(), bgimg.getWidth(null), bgimg.getHeight(null), null);
        g.drawImage(bgimg, getX(), y1, bgimg.getWidth(null), bgimg.getHeight(null), null);
        move();
    }

    @Override
    public void move() {

        setY(getY() + speed);
        y1 += speed;

        if(getY() > bgimg.getHeight(null)){
            setY(y1-bgimg.getHeight(null));
        }
        if(y1 > bgimg.getHeight(null)){
            y1 = getY()-bgimg.getHeight(null);
        }
    }
}
