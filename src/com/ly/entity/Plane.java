package com.ly.entity;

import com.ly.constant.Constant;
import com.ly.core.BaseSpirte;
import com.ly.core.Drawable;
import com.ly.core.Moveable;
import com.ly.core.MyFrame;
import com.ly.until.DataStore;
import com.ly.until.ImageMap;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends BaseSpirte implements Drawable, Moveable {
    private Image image;
    private int speed = 10 * Constant.GAME_SPEED;
    private boolean left, right, up, down;
    private boolean fire;
    private static int level = 1;
    public static int mark = 0;//分数
    public static int skill = 100;//大招容量
    public int blood = 100;
    private Image bloodImage = ImageMap.get("myplaneblood");
    private Blood b = new Blood();

    public Plane() {
        this(Constant.GAME_WIDTH/2 - ImageMap.get("my01").getWidth(null)/2, 400, ImageMap.get("my01"));
    }

    public Plane(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);
        move();
        borderTest();//边界检测
        fire();//发射子弹

        index++;//子弹减速器++
        b.draw(g);
        level(g);

        g.setColor(Color.white);
        //g.drawString("分数：" + Plane.mark,5,110);
        g.drawString("等级:level" + Plane.level,10,95);
    }

    /**
     * 飞机等级判断
     */

    public void level(Graphics g){

        if(mark >= 30 && mark <= 50){
            level = 2;
            if(mark == 30){

                g.drawImage(ImageMap.get("powerup"),Constant.GAME_WIDTH/2-ImageMap.get("powerup").getWidth(null)/2,
                        Constant.GAME_HEIGHT/2 - ImageMap.get("powerup").getHeight(null),
                        ImageMap.get("powerup").getWidth(null),
                        ImageMap.get("powerup").getHeight(null),
                        null
                        );
            }
        }

        if(mark > 50){
            level = 3;
            if(mark <= 51){
                g.drawImage(ImageMap.get("powerup"),Constant.GAME_WIDTH/2-ImageMap.get("powerup").getWidth(null)/2,
                        Constant.GAME_HEIGHT/2 - ImageMap.get("powerup").getHeight(null),
                        ImageMap.get("powerup").getWidth(null),
                        ImageMap.get("powerup").getHeight(null),
                        null
                );
            }
        }
    }

    @Override
    public void move() {
        if (up) {
            setY(getY() - speed);
        }
        if (down) {
            setY(getY() + speed);
        }
        if (left) {
            setX(getX() - speed);
        }
        if (right) {
            setX(getX() + speed);
        }

    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(getX(), getY(), image.getWidth(null), image.getHeight(null));
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            case KeyEvent.VK_J:
                fire = true;
                break;
            case KeyEvent.VK_O:
                break;

        }
    }

    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
            case KeyEvent.VK_J:
                fire = false;
                break;
            case KeyEvent.VK_O:

                if (skill >= 100) {
                    bigBang();
                    skill = 0;
                }

                break;

        }
    }

    /**
     * 边界检测
     */
    private void borderTest() {
        if (getX() <= 0) {
            setX(0);
        }
        if (getX() >= Constant.GAME_WIDTH - image.getWidth(null)) {
            setX(Constant.GAME_WIDTH - image.getWidth(null));
        }
        if (getY() >= Constant.GAME_HEIGHT - image.getHeight(null)) {
            setY(Constant.GAME_HEIGHT - image.getHeight(null));
        }
        if (getY() <= 30) {
            setY(30);
        }
    }

    /**
     * 发射子弹的方法
     */
    private int index = 0;//子弹减速器

    private void fire() {
        if (fire && index == 4) {
            MyFrame myFrame = DataStore.get("myFrame");
            if(level == 1){
                myFrame.bulletList.add(
                        new Bullet(
                                getX() + image.getWidth(null) / 2 - ImageMap.get("bullet").getWidth(null) / 2,
                                getY() - ImageMap.get("bullet").getHeight(null),
                                ImageMap.get("bullet")
                        ));
            }

            if(level == 2){
                for (int i = 0; i < 2 ; i++) {
                    myFrame.bulletList.add(
                            new Bullet(
                                    getX() - 5 + i*10 + image.getWidth(null) / 2 - ImageMap.get("bullet").getWidth(null) / 2,
                                    getY() - ImageMap.get("bullet").getHeight(null),
                                    ImageMap.get("bullet")

                            ));

                }
            }

           if(level ==3){
               for (int i = 0; i < 4 ; i++) {
                   myFrame.bulletList.add(
                           new Bullet(
                                   getX() - 15 + i*10 + image.getWidth(null) / 2 - ImageMap.get("bullet").getWidth(null) / 2,
                                   getY() - ImageMap.get("bullet").getHeight(null),
                                   ImageMap.get("bullet")

                           ));

               }
           }



        }
        if (index >= 4) {
            index = 0;
        }

    }

    private void bigBang() {

        MyFrame myFrame = DataStore.get("myFrame");
        myFrame.bigBangList.add(
                new BigBang(myFrame.myPlane.getX() - ImageMap.get("bigbang1").getWidth(null) / 2 + ImageMap.get("my01").getWidth(null) / 2,
                        myFrame.myPlane.getY() - ImageMap.get("bigbang1").getHeight(null),
                        ImageMap.get("bigbang1"))
        );


    }


    /**
     * 血条类
     */
    class Blood {

        void draw(Graphics g) {

            if (blood > 75) {
                g.setColor(Color.green);
            } else if (blood <= 70 && blood >= 30) {
                g.setColor(Color.yellow);
            } else {
                g.setColor(Color.red);
            }
            g.drawRoundRect(Constant.GAME_WIDTH -  100 , 120,70, 10,5,5);

            g.fillRoundRect( Constant.GAME_WIDTH - 100, 120,70 * blood / 100, 10,5,5);


            if (skill > 99) {
                g.setColor(new Color(0x5A00FF));
            } else if (skill < 99 && skill > 50) {
                g.setColor(new Color(0x4200FF));
            } else {
                g.setColor(new Color(0xFF0055));
            }
            g.drawRoundRect(Constant.GAME_WIDTH - 100,  100, 70, 10,5,5);
            g.fillRoundRect(Constant.GAME_WIDTH - 100,  100, 70 * skill / 100, 10,5,5);
            g.setColor(Color.white);
            g.drawString("HP:",Constant.GAME_WIDTH - 125,130);
            g.drawString("MP:",Constant.GAME_WIDTH - 125,110);
        }
    }


}
