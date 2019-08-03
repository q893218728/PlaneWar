package com.ly.entity;

import com.ly.core.BaseSpirte;
import com.ly.core.Drawable;
import com.ly.core.Moveable;
import com.ly.until.ImageMap;
import java.awt.*;

public class Explode extends BaseSpirte implements Drawable, Moveable {
    public boolean islive = true;
    public int type;
    private final Image[] images = {ImageMap.get("e1"), ImageMap.get("e2"), ImageMap.get("e3"),
            ImageMap.get("e4"), ImageMap.get("e5"), ImageMap.get("e6"), ImageMap.get("e7"),
            ImageMap.get("e8"), ImageMap.get("e9")};
    private final Image[] bossExplodeImages = {
            ImageMap.get("bossexplode1"),ImageMap.get("bossexplode2"),ImageMap.get("bossexplode3"),
            ImageMap.get("bossexplode1"),ImageMap.get("bossexplode2"),ImageMap.get("bossexplode3"),
            ImageMap.get("bossexplode1"),ImageMap.get("bossexplode2"),ImageMap.get("bossexplode3")
    };

    public Explode() {

        this(0, 0,1);

    }

    public Explode(int x, int y,int type) {
        super(x, y);
        this.type = type;
    }

    int i = 0;

    @Override
    public void draw(Graphics g) {
        if(type == 1){
            if (islive) {
                g.drawImage(images[i],
                        getX(),
                        getY(),
                        ImageMap.get("baozha1").getWidth(null),
                        ImageMap.get("baozha1").getHeight(null),
                        null);
                i++;

                if (i >= 9) {
                    i = 0;
                    islive = false;
                }
            } else {
                Bullet.explodes.remove(this);
            }
        }

        if (type == 2){
            if(islive){
                g.drawImage(
                        bossExplodeImages[i],
                        getX(),
                        getY(),
                        ImageMap.get("bossexplode1").getWidth(null),
                        ImageMap.get("bossexplode1").getHeight(null),
                        null);
                 i++;
                 if(i>=9){
                     i = 0;
                     islive = false;
                 }
            }else{
                Bullet.explodes.remove(this);
            }
        }


    }


    @Override
    public void move() {

    }


}
