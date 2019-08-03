package com.ly.entity;

import com.ly.constant.Constant;
import com.ly.core.*;
import com.ly.until.DataStore;
import com.ly.until.ImageMap;

import java.awt.*;

public class EnemyBullet extends BaseSpirte implements Drawable, Moveable {
    private Image image;
    private int type;
    private int angel;
    private int speed = Constant.GAME_SPEED * 8;

    public EnemyBullet() {
        this(0, 0, ImageMap.get("enemyBullet"), 1,null);
    }

    public EnemyBullet(int x, int y, Image image, int type,Integer angel) {
        super(x, y);
        this.image = image;
        this.type = type;
        this.angel = angel;

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);
        move();
        borderTest();
    }





    @Override
    public void move() {
        if (type == 3) {
                setY(getY() + (int) ( 20*Math.sin(Math.toRadians(angel))));
                setX(getX() + (int) ( 20*Math.cos(Math.toRadians(angel))));
        } else {
            setY(getY() + speed);
        }


    }

    public void collision(Plane plane) {
        MyFrame myFrame = DataStore.get("myFrame");
        if (plane.getRect().intersects(this.getRect())) {
            myFrame.myPlane.blood -= 10;
            myFrame.enemyBulletList.remove(this);
        }
    }



    public void borderTest() {
        MyFrame myFrame = DataStore.get("myFrame");

        if(getX()<=0 ||getX()>=Constant.GAME_WIDTH||getY()>=Constant.GAME_HEIGHT||getY()<0){
            myFrame.enemyBulletList.remove(this);
        }
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(getX(), getY(), image.getWidth(null), image.getHeight(null));
    }


}

