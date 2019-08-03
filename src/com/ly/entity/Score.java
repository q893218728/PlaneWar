package com.ly.entity;

import com.ly.core.BaseSpirte;
import com.ly.core.Drawable;
import com.ly.until.ImageMap;

import java.awt.*;

public class Score extends BaseSpirte implements Drawable {

    private Image[] images = {
            ImageMap.get("0"),ImageMap.get("1"),ImageMap.get("2"),
            ImageMap.get("3"),ImageMap.get("4"),ImageMap.get("5"),
            ImageMap.get("6"),ImageMap.get("7"),ImageMap.get("8"),
            ImageMap.get("9"),
    };

    private Image[] scores = {
            ImageMap.get("score1"),ImageMap.get("score2"),ImageMap.get("score3")
    };

    public Score() {
    }
    int i = 0;
    @Override
    public void draw(Graphics g) {
         g.drawImage(scores[i/3],5,100,ImageMap.get("score1").getWidth(null),ImageMap.get("score1").getHeight(null),null);
         i++;
         if(i>=9){
             i=0;
         }
        int qian = Plane.mark/1000;
        int bai  = (Plane.mark - qian*1000)/100;
        int shi  = (Plane.mark %100)/10;
        int ge = Plane.mark%10;
        switch (qian){
            case 0:
                g.drawImage(ImageMap.get("0"),5,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 1:
                g.drawImage(ImageMap.get("1"),5,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 2:
                g.drawImage(ImageMap.get("2"),5,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 3:
                g.drawImage(ImageMap.get("3"),5,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 4:
                g.drawImage(ImageMap.get("4"),5,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 5:
                g.drawImage(ImageMap.get("5"),5,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 6:
                g.drawImage(ImageMap.get("6"),5,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 7:
                g.drawImage(ImageMap.get("7"),5,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 8:
                g.drawImage(ImageMap.get("8"),5,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 9:
                g.drawImage(ImageMap.get("9"),5,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
        }
        switch (bai){
            case 0:
                g.drawImage(ImageMap.get("0"),40,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 1:
                g.drawImage(ImageMap.get("1"),40,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 2:
                g.drawImage(ImageMap.get("2"),40,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 3:
                g.drawImage(ImageMap.get("3"),40,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 4:
                g.drawImage(ImageMap.get("4"),40,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 5:
                g.drawImage(ImageMap.get("5"),40,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 6:
                g.drawImage(ImageMap.get("6"),40,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 7:
                g.drawImage(ImageMap.get("7"),40,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 8:
                g.drawImage(ImageMap.get("8"),40,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 9:
                g.drawImage(ImageMap.get("9"),40,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
        };
        switch (shi){
            case 0:
                g.drawImage(ImageMap.get("0"),75,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 1:
                g.drawImage(ImageMap.get("1"),75,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 2:
                g.drawImage(ImageMap.get("2"),75,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 3:
                g.drawImage(ImageMap.get("3"),75,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 4:
                g.drawImage(ImageMap.get("4"),75,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 5:
                g.drawImage(ImageMap.get("5"),75,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 6:
                g.drawImage(ImageMap.get("6"),75,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 7:
                g.drawImage(ImageMap.get("7"),75,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 8:
                g.drawImage(ImageMap.get("8"),75,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 9:
                g.drawImage(ImageMap.get("9"),75,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
        };
        switch (ge){
            case 0:
                g.drawImage(ImageMap.get("0"),110,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 1:
                g.drawImage(ImageMap.get("1"),110,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 2:
                g.drawImage(ImageMap.get("2"),110,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 3:
                g.drawImage(ImageMap.get("3"),110,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 4:
                g.drawImage(ImageMap.get("4"),110,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 5:
                g.drawImage(ImageMap.get("5"),110,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 6:
                g.drawImage(ImageMap.get("6"),110,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 7:
                g.drawImage(ImageMap.get("7"),110,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 8:
                g.drawImage(ImageMap.get("8"),110,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
            case 9:
                g.drawImage(ImageMap.get("9"),110,130,ImageMap.get("0").getWidth(null),ImageMap.get("0").getHeight(null),null);
                break;
        };
    }
}
