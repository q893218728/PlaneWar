package com.ly.entity;

import com.ly.constant.Constant;
import com.ly.core.BaseSpirte;
import com.ly.core.Drawable;
import com.ly.core.Moveable;
import com.ly.core.MyFrame;
import com.ly.until.DataStore;
import com.ly.until.ImageMap;

import java.awt.*;

public class Item extends BaseSpirte implements Drawable, Moveable {
    private Image image;
    private int type;

    private Image[] magics = {
            ImageMap.get("magic1"), ImageMap.get("magic2"), ImageMap.get("magic3"), ImageMap.get("magic4")
    };

    private Image[] hps = {
            ImageMap.get("addhp1"), ImageMap.get("addhp2"), ImageMap.get("addhp3"), ImageMap.get("addhp4")
    };

    private Image[] defenses = {
            ImageMap.get("defense1"), ImageMap.get("defense2"), ImageMap.get("defense3"), ImageMap.get("defense4"),
    };
    private boolean right;

    public Item() {
        this(0, 0, ImageMap.get("blood1"), 1);
    }

    public Item(int x, int y, Image image, int type) {
        super(x, y);
        this.image = image;
        this.type = type;
    }

    int i = 0;

    @Override
    public void draw(Graphics g) {
        if (type == 1) {
            g.drawImage(hps[i / 3], getX(), getY(), hps[0].getWidth(null), hps[0].getHeight(null), null);
            i++;
        }
        if (type == 2) {
            g.drawImage(magics[i / 3], getX(), getY(), magics[0].getWidth(null), magics[0].getHeight(null), null);
            i++;
        }
        if (type == 3) {
            g.drawImage(defenses[i / 3], getX(), getY(), defenses[0].getWidth(null), defenses[0].getHeight(null), null);
            i++;
        }
        if (i >= 9) {
            i = 0;
        }
        move();
        borederTest();
        collision();


    }

    @Override
    public void move() {
        if (right) {
            setX(getX() + 3);

        } else {
            setX(getX() - 3);
        }
        setY(getY() + 5);
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(getX(), getY(), image.getWidth(null), image.getHeight(null));
    }

    //和飞机的碰撞检测
    public void collision() {
        MyFrame myFrame = DataStore.get("myFrame");
        if (myFrame.myPlane.getRect().intersects(this.getRect())) {
            //飞机功能逻辑
            if (type == 1) {
                if (myFrame.myPlane.blood < 80) {
                    myFrame.myPlane.blood += 20;
                } else {
                    myFrame.myPlane.blood += 100 - myFrame.myPlane.blood;
                }
            }

            if (type == 2) {
                myFrame.myPlane.skill = 100;
            }

            if (type == 3) {
                Defense.ishudun = true;
            }


            myFrame.itemList.remove(this);
        }
    }

    public void borederTest() {
        if (getY() >= Constant.GAME_HEIGHT) {
            MyFrame myFrame = DataStore.get("myFrame");
            myFrame.itemList.remove(this);
        }

        if (getX() >= Constant.GAME_WIDTH) {
            right = false;
        }
        if (getX() <= 0) {
            right = true;
        }
    }




}
