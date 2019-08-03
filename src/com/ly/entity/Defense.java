package com.ly.entity;

import com.ly.core.BaseSpirte;
import com.ly.core.Drawable;
import com.ly.core.Moveable;
import com.ly.core.MyFrame;
import com.ly.until.DataStore;
import com.ly.until.ImageMap;

import java.awt.*;

public class Defense extends BaseSpirte implements Drawable, Moveable {

    public static boolean ishudun;
    private Image image;
    public Defense() {
        this(0,0,ImageMap.get("hudun"));
    }

    public Defense(int x, int y,Image image) {
        super(x, y);
        this.image = image;
    }

    int x = 0;
    @Override
    public void draw(Graphics g) {
        if (ishudun) {

            if (x < 300) {
                x++;

                g.drawImage(image, getX(), getY(),
                        image.getWidth(null),image.getHeight(null),
                        null);
            }

            if(x>=300){
                ishudun = false;
                x = 0;
            }
        }
        move();
        if(ishudun){
            collisiondefense();
            collisionEnemyPlane();
        }

    }

    @Override
    public void move() {
        MyFrame myFrame = DataStore.get("myFrame");
        setX(myFrame.myPlane.getX()- 15);
        setY(myFrame.myPlane.getY() - 20);
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(getX(), getY(), image.getWidth(null), image.getHeight(null));
    }

    public void collisiondefense(){

        MyFrame myFrame = DataStore.get("myFrame");
        for (EnemyBullet enemyBullet : myFrame.enemyBulletList) {
            if(enemyBullet.getRect().intersects(this.getRect())){
                myFrame.enemyBulletList.remove(enemyBullet);
            }
        }

    }

    public void collisionEnemyPlane(){
        MyFrame myFrame = DataStore.get("myFrame");
        for (EnemyPlane enemyPlane : myFrame.enemyPlaneList) {
            if(enemyPlane.getRect().intersects(this.getRect())){
                myFrame.enemyPlaneList.remove(enemyPlane);
                Bullet.explodes.add(new Explode(enemyPlane.getX()+enemyPlane.image.getWidth(null)/2-ImageMap.get("e1").getWidth(null)/2,
                        enemyPlane.getY()+enemyPlane.image.getHeight(null)/2 - ImageMap.get("e1").getHeight(null)/2,
                        1));
            }
        }
    }
}
