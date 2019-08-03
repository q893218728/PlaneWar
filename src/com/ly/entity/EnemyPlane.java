package com.ly.entity;

import com.ly.constant.Constant;
import com.ly.core.BaseSpirte;
import com.ly.core.Drawable;
import com.ly.core.Moveable;
import com.ly.core.MyFrame;
import com.ly.until.DataStore;
import com.ly.until.ImageMap;

import java.awt.*;
import java.util.Random;

public class EnemyPlane extends BaseSpirte implements Drawable, Moveable {
    public Image image;
    private int speed = 6 * Constant.GAME_SPEED;
    public int type = 1;

    public EnemyPlane() {
        this(0, 0, ImageMap.get("enemyPlane"), 1);
    }

    public EnemyPlane(int x, int y, Image image, int type) {
        super(x, y);
        this.image = image;
        this.type = type;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);
        move();
        borderTest();
        fire();

    }

    @Override
    public void move() {
        setY(getY() + speed);
    }

    //敌机出界后移除
    public void borderTest() {
        if (getY() >= Constant.GAME_HEIGHT) {
            MyFrame myFrame = DataStore.get("myFrame");
            myFrame.enemyPlaneList.remove(this);
        }
    }

    /**
     * 敌机发射子弹的方法
     */

    Random random = new Random();

    private void fire() {
        MyFrame myFrame = DataStore.get("myFrame");
        if (type == 1) {
            if (random.nextInt(1000) > 990 && getY() >= 0) {

                myFrame.enemyBulletList.add(new EnemyBullet(
                        getX() + image.getWidth(null) / 2 - ImageMap.get("enemyBullet").getWidth(null) / 2,
                        getY() + image.getHeight(null),
                        ImageMap.get("enemyBullet"),
                        1,
                        270

                ));
            }
        } else if (type == 2) {

                if (random.nextInt(1000) > 990 && getY() >= 0) {

                    myFrame.enemyBulletList.add(new EnemyBullet(
                            getX() + image.getWidth(null) / 2 - ImageMap.get("enemyBullet1").getWidth(null) / 2,
                            getY() + image.getHeight(null),
                            ImageMap.get("enemyBullet1"),
                            2,
                            270
                    ));

            }

        }else if(type == 4){
            if(random.nextInt(1000) > 990 && getY() >= 0){
                myFrame.enemyBulletList.add(new EnemyBullet(
                        getX() + image.getWidth(null) / 2 - ImageMap.get("enemyBullet2").getWidth(null) / 2,
                        getY() + image.getHeight(null),
                        ImageMap.get("enemyBullet2"),
                        4,
                        270
                ));
            }

        }


    }

    /**
     * 敌方飞机撞上我
     *
     * @param plane
     */
    public void collision(Plane plane) {
        MyFrame myFrame = DataStore.get("myFrame");
        if (plane.getRect().intersects(this.getRect())) {
            myFrame.myPlane.blood -= 10;
            myFrame.enemyPlaneList.remove(this);
        }
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(getX(), getY(), image.getWidth(null), image.getHeight(null));
    }

    /**
     * 添加敌机的方法
     */
    public static void addEnemyPlane() {
        MyFrame myFrame = DataStore.get("myFrame");
        Random random = new Random();
        if (random.nextInt(1000) > 975) {
            myFrame.enemyPlaneList.add(new EnemyPlane(random.nextInt(Constant.GAME_WIDTH - 59),
                    random.nextInt(200) + (-200),
                    ImageMap.get("enemyPlane"),
                    1));
        }
        Random random1 = new Random();
        if (random1.nextInt(1000) > 985) {
            myFrame.enemyPlaneList.add(new EnemyPlane(random.nextInt(Constant.GAME_WIDTH - 59),
                    random.nextInt(200) + (-200),
                    ImageMap.get("enemyPlane1"),
                    2));
        }
        Random random2 = new Random();
        if(random2.nextInt(1000) > 985){
            myFrame.enemyPlaneList.add(new EnemyPlane(random.nextInt(Constant.GAME_WIDTH - 59),
                    random.nextInt(200) + (-200),
                    ImageMap.get("enemyPlane2"),
                    4));
        }

    }
}
