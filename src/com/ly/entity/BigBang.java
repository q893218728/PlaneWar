package com.ly.entity;

import com.ly.core.BaseSpirte;
import com.ly.core.Drawable;
import com.ly.core.MyFrame;
import com.ly.until.DataStore;
import com.ly.until.ImageMap;

import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BigBang extends BaseSpirte implements Drawable {
    private Image image;
    private Image[] images = {
       ImageMap.get("bigbang1"),ImageMap.get("bigbang2")};

    public BigBang() {
        this(0, 0, ImageMap.get("bigbang1")
        );
    }

    public BigBang(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    public static boolean bigbanglive;

    int i = 0;

    @Override
    public void draw(Graphics g) {
        g.drawImage(images[0], getX(), getY(), image.getWidth(null), image.getHeight(null),
                null);
        /*i++;
        if (i >= 0 && i <= 5) {
            g.drawImage(images[0], getX(), getY(), image.getWidth(null), image.getHeight(null),
                    null);
        }

        if (i >= 5 && i <= 10) {
            g.drawImage(images[1], getX(), getY(), image.getWidth(null), image.getHeight(null),
                    null);
            i++;
        }

        if (i >= 11) {
            i = 0;
        }*/


    }


    //public List<Explode> explodes = new CopyOnWriteArrayList<>();

    public boolean collision(List<EnemyPlane> enemyPlaneList) {
        boolean x = false;
        MyFrame myFrame = DataStore.get("myFrame");
        for (EnemyPlane enemyPlane : myFrame.enemyPlaneList) {
            if (enemyPlane.getRect().intersects(this.getRect())) {
                enemyPlaneList.remove(enemyPlane);
                Bullet.explodes.add(new Explode(enemyPlane.getX(), enemyPlane.getY(),1));//新建一个爆炸类将坐标传走
                Plane.mark++;
                Plane.skill++;
                x = true;
            }

        }
        return x;
    }

    public void collisionBoss(Boss boss) {

        if(boss.getRect().intersects(this.getRect())){
            if(boss.blood>10){
                boss.blood -= 10;

            }else{
                boss.blood = 0;
                Boss.bosslive = false;
                Plane.mark += 1000;
                Bullet.explodes.add(new Explode(
                        boss.getX()+ImageMap.get("boss1").getWidth(null)/2-ImageMap.get("bossexplode1").getWidth(null)/2,
                        boss.getY()+ImageMap.get("boss1").getHeight(null)/2 - ImageMap.get("bossexplode1").getHeight(null)/2,
                        2));
            }


        }
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(getX(), getY(), ImageMap.get("bigbang1").getWidth(null), ImageMap.get("bigbang1").getHeight(null));
    }
}
