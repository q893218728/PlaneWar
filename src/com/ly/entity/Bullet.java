package com.ly.entity;

import com.ly.constant.Constant;
import com.ly.core.BaseSpirte;
import com.ly.core.Drawable;
import com.ly.core.Moveable;
import com.ly.core.MyFrame;
import com.ly.until.DataStore;
import com.ly.until.ImageMap;
import javafx.scene.input.KeyCombination;

import javax.xml.crypto.Data;
import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bullet extends BaseSpirte implements Drawable, Moveable {
    private Image image;
    private int speed = 8 * Constant.GAME_SPEED;

    public Bullet() {
        this(0, 0, ImageMap.get("bullet"));
    }

    public Bullet(int x, int y, Image image) {
        super(x, y);
        this.image = image;

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);
        move();
        BorederTest();

    }

    @Override
    public void move() {

        setY(getY() - speed);
    }
    //子弹出界后从容器中删除
    public void BorederTest(){
        if(getY() <= 30 - image.getHeight(null)){
           MyFrame myFrame =  DataStore.get("myFrame");
           myFrame.bulletList.remove(this);
        }
    }

    /**
     * 碰撞检测
     */
    public static List<Explode> explodes = new CopyOnWriteArrayList<>();
    public boolean collision(List<EnemyPlane> enemyPlaneList){
       MyFrame myFrame =  DataStore.get("myFrame");

        for (EnemyPlane enemyPlane : enemyPlaneList) {
            if (enemyPlane.getRect().intersects(this.getRect())) {
                enemyPlaneList.remove(enemyPlane);
                myFrame.bulletList.remove(this);
                //myFrame.enemyPlaneLive = false;//设置敌方飞机状态死亡
                explodes.add(new Explode(
                        enemyPlane.getX()+enemyPlane.image.getWidth(null)/2-ImageMap.get("e1").getWidth(null)/2,
                        enemyPlane.getY()+enemyPlane.image.getHeight(null)/2 - ImageMap.get("e1").getHeight(null)/2,
                        1
                ));//新建一个爆炸类将坐标传走
                Random random = new Random();

                if(enemyPlane.type == 1){
                    Plane.mark ++;
                    if(random.nextInt(100)>90){
                        myFrame.itemList.add(new Item(
                                enemyPlane.getX(),
                                enemyPlane.getY(),
                                ImageMap.get("addhp1"),
                                1));
                    }

                }

                if(enemyPlane.type == 2){
                    Plane.mark += 5;
                    if(random.nextInt(100)>90){
                        myFrame.itemList.add(new Item(
                                enemyPlane.getX(),
                                enemyPlane.getY(),
                                ImageMap.get("magic1"),
                                2));
                    }

                }

                if(enemyPlane.type == 4){
                    Plane.mark += 10;
                    if(random.nextInt(100)>90){
                        myFrame.itemList.add(new Item(
                                enemyPlane.getX(),
                                enemyPlane.getY(),
                                ImageMap.get("defense1"),
                                3));
                    }
                }



                return true;
            }

        }
        return false;
    }

    public boolean collisionBoss(Boss boss){
        MyFrame myFrame =  DataStore.get("myFrame");
        if (boss.getRect().intersects(this.getRect())){
            if(boss.blood>3){
            boss.blood -= 3;
            Plane.mark++;
            Plane.skill++;
            if(Plane.skill>=100){
                Plane.skill = 100;
            }
            }else{
                boss.blood = 0;
                Boss.bosslive = false;
                Plane.mark += 1000;
                System.out.println(1);
                explodes.add(new Explode(
                        boss.getX()+ImageMap.get("boss1").getWidth(null)/2-ImageMap.get("bossexplode1").getWidth(null)/2,
                        boss.getY()+ImageMap.get("boss1").getHeight(null)/2 - ImageMap.get("bossexplode1").getHeight(null)/2,
                        2));
            }

            myFrame.bulletList.remove(this);

           return true;
        }

        return false;
    }


    @Override
    public Rectangle getRect() {
        return new Rectangle(getX(),getY(),image.getWidth(null),image.getHeight(null));
    }
}
