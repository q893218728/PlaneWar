package com.ly.entity;

import com.ly.constant.Constant;
import com.ly.core.*;
import com.ly.until.DataStore;
import com.ly.until.ImageMap;
import java.awt.*;
import java.util.Random;



public class Boss extends BaseSpirte implements Drawable, Moveable {
    private Image image;
    private boolean right,up;
    public Image[] wImages1 = {
            ImageMap.get("bosswarning"),ImageMap.get("w6")
    };
    public static boolean bosslive = true;
    public static  int blood = 2000;
    private static Image[] images = {
            ImageMap.get("boss1"), ImageMap.get("boss2"), ImageMap.get("boss3"),
            ImageMap.get("boss4"), ImageMap.get("boss5"), ImageMap.get("boss6"),
            ImageMap.get("boss7"), ImageMap.get("boss8"), ImageMap.get("boss9"),
    };

    public Boss() {
        this(200,-500);
        this.image = ImageMap.get("boss1");
    }

    public Boss(int x, int y) {
        super(x, y);

    }

    int i = 0;

    @Override
    public void draw(Graphics g) {

        move();
        g.drawImage(images[i++], getX(), getY(), image.getWidth(null), image.getHeight(null), null);

        if (i >= 8) {
            i = 0;
        }


        fire();
        g.setColor(new Color(0xD910C5));
        g.drawRoundRect(Constant.GAME_WIDTH/2 - image.getWidth(null)/2,50,image.getWidth(null),20,5,5);
        g.fillRoundRect(Constant.GAME_WIDTH/2 - image.getWidth(null)/2,50,image.getWidth(null)*blood/2000,20,5,5);
        g.setColor(Color.white);
        g.drawString("血量:"+blood, Constant.GAME_WIDTH/2 -30,65);



    }

    @Override
    public void move() {

        //boss是否向上移动
        if(up){
            setY( getY() - 3);
        }else{
            setY(getY()+3);
        }

        if(getY()<=0){
            up = false;
        }
        if(getY()>Constant.GAME_HEIGHT - image.getHeight(null)*2){
            up = true;
        }

        //boss是否向右移动
        if (right) {
            setX(getX() + 3);
        } else {
            setX(getX() - 3);
        }
        if (getX() >= Constant.GAME_WIDTH - image.getWidth(null)) {
            right = false;
        }
        if (getX() <= 0) {
            right = true;
        }
    }
    Integer angel = 0;
    public void fire(){
        Random random = new Random();
        if(random.nextInt(1000)>500){

            MyFrame myFrame = DataStore.get("myFrame");
            myFrame.enemyBulletList.add(new EnemyBullet(getX()+image.getWidth(null)/2-ImageMap.get("bossBullet").getWidth(null)/2,
                    getY()+image.getHeight(null)/2-ImageMap.get("bossBullet").getHeight(null)/2,
                    ImageMap.get("bossBullet"),
                    3,
                    angel

            ));
            angel += 30;
            if(angel >=360){
                angel = 30;
            }

        }


    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(getX(), getY(), image.getWidth(null), image.getHeight(null));
    }
}
