package com.ly.until;

import com.ly.constant.Constant;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;

public class ImageMap {
    private static final Map<String, Image> map = new HashMap<>();

    static {
        map.put("start",ImageUtil.getImage(Constant.IMG_PRE + "Start" + Constant.IMG_AFTER));
        map.put("gameover",ImageUtil.getImage(Constant.IMG_PRE + "gameover" + Constant.IMG_AFTER));
        map.put("success",ImageUtil.getImage(Constant.IMG_PRE + "success" + Constant.IMG_AFTER));
        map.put("countdown1",ImageUtil.getImage(Constant.IMG_PRE + "countdown1" + Constant.IMG_AFTER));
        map.put("countdown2",ImageUtil.getImage(Constant.IMG_PRE + "countdown2" + Constant.IMG_AFTER));
        map.put("countdown3",ImageUtil.getImage(Constant.IMG_PRE + "countdown3" + Constant.IMG_AFTER));
        map.put("go",ImageUtil.getImage(Constant.IMG_PRE + "go" + Constant.IMG_AFTER));
        map.put("bg1",ImageUtil.getImage(Constant.IMG_PRE + "bg1" + Constant.IMG_AFTER));
        map.put("bg2",ImageUtil.getImage(Constant.IMG_PRE + "bg2" + Constant.IMG_AFTER));
        map.put("my01",ImageUtil.getImage(Constant.IMG_PRE + "my_01" + Constant.IMG_AFTER));
        map.put("bullet",ImageUtil.getImage(Constant.IMG_PRE + "bullet" + Constant.IMG_AFTER));
        map.put("enemyPlane",ImageUtil.getImage(Constant.IMG_PRE + "enemyPlane" + Constant.IMG_AFTER));
        map.put("enemyPlane1",ImageUtil.getImage(Constant.IMG_PRE + "enemyPlane1" + Constant.IMG_AFTER));
        map.put("enemyPlane2",ImageUtil.getImage(Constant.IMG_PRE + "enemyPlane2" + Constant.IMG_AFTER));
        map.put("enemyBullet",ImageUtil.getImage(Constant.IMG_PRE + "enemyBullet" + Constant.IMG_AFTER));
        map.put("enemyBullet1",ImageUtil.getImage(Constant.IMG_PRE + "enemyBullet1" + Constant.IMG_AFTER));
        map.put("enemyBullet2",ImageUtil.getImage(Constant.IMG_PRE + "enemyBullet2" + Constant.IMG_AFTER));
        map.put("bossBullet",ImageUtil.getImage(Constant.IMG_PRE + "bossBullet" + Constant.IMG_AFTER));
        map.put("e1",ImageUtil.getImage("com/ly/img/explode/e1.png"));
        map.put("e2",ImageUtil.getImage("com/ly/img/explode/e2.png"));
        map.put("e3",ImageUtil.getImage("com/ly/img/explode/e3.png"));
        map.put("e4",ImageUtil.getImage("com/ly/img/explode/e4.png"));
        map.put("e5",ImageUtil.getImage("com/ly/img/explode/e5.png"));
        map.put("e6",ImageUtil.getImage("com/ly/img/explode/e6.png"));
        map.put("e7",ImageUtil.getImage("com/ly/img/explode/e7.png"));
        map.put("e8",ImageUtil.getImage("com/ly/img/explode/e8.png"));
        map.put("e9",ImageUtil.getImage("com/ly/img/explode/e9.png"));
        map.put("baozha1",ImageUtil.getImage("com/ly/img/explode/baozha1.png"));
        map.put("baozha2",ImageUtil.getImage("com/ly/img/explode/baozha2.png"));
        map.put("bigbang1",ImageUtil.getImage(Constant.IMG_PRE + "bigbang1" + Constant.IMG_AFTER));
        //map.put("bigbang2",ImageUtil.getImage(Constant.IMG_PRE + "bigbang2" + Constant.IMG_AFTER));
        //map.put("myplaneblood",ImageUtil.getImage(Constant.IMG_PRE + "myplaneblood" + Constant.IMG_AFTER));
        map.put("blood1",ImageUtil.getImage(Constant.IMG_PRE + "blood1" + Constant.IMG_AFTER));
        map.put("powerup",ImageUtil.getImage(Constant.IMG_PRE + "powerUp" + Constant.IMG_AFTER));

        //boos的图片
        map.put("boss1",ImageUtil.getImage("com/ly/img/boss/boss_A_01.png"));
        map.put("boss2",ImageUtil.getImage("com/ly/img/boss/boss_A_02.png"));
        map.put("boss3",ImageUtil.getImage("com/ly/img/boss/boss_A_03.png"));
        map.put("boss4",ImageUtil.getImage("com/ly/img/boss/boss_A_04.png"));
        map.put("boss5",ImageUtil.getImage("com/ly/img/boss/boss_A_05.png"));
        map.put("boss6",ImageUtil.getImage("com/ly/img/boss/boss_A_06.png"));
        map.put("boss7",ImageUtil.getImage("com/ly/img/boss/boss_A_07.png"));
        map.put("boss8",ImageUtil.getImage("com/ly/img/boss/boss_A_08.png"));
        map.put("boss9",ImageUtil.getImage("com/ly/img/boss/boss_A_09.png"));
        map.put("bosswarning",ImageUtil.getImage("com/ly/img/boss/bossWarning.png"));
        map.put("bossexplode1",ImageUtil.getImage("com/ly/img/boss/bossExplode1.png"));
        map.put("bossexplode2",ImageUtil.getImage("com/ly/img/boss/bossExplode2.png"));
        map.put("bossexplode3",ImageUtil.getImage("com/ly/img/boss/bossExplode3.png"));
        map.put("w1",ImageUtil.getImage("com/ly/img/boss/w1.png"));
        map.put("w2",ImageUtil.getImage("com/ly/img/boss/w2.png"));
        map.put("w3",ImageUtil.getImage("com/ly/img/boss/w3.png"));
        map.put("w4",ImageUtil.getImage("com/ly/img/boss/w4.png"));
        map.put("w5",ImageUtil.getImage("com/ly/img/boss/w5.png"));
        map.put("w6",ImageUtil.getImage("com/ly/img/boss/w6.png"));
        map.put("w7",ImageUtil.getImage("com/ly/img/boss/w7.png"));
        map.put("w8",ImageUtil.getImage("com/ly/img/boss/w8.png"));
        map.put("w9",ImageUtil.getImage("com/ly/img/boss/w9.png"));
        map.put("w10",ImageUtil.getImage("com/ly/img/boss/w10.png"));



        //道具图片
        map.put("magic1",ImageUtil.getImage(Constant.IMG_PRE + "addmagic1" + Constant.IMG_AFTER));
        map.put("magic2",ImageUtil.getImage(Constant.IMG_PRE + "addmagic2" + Constant.IMG_AFTER));
        map.put("magic3",ImageUtil.getImage(Constant.IMG_PRE + "addmagic3" + Constant.IMG_AFTER));
        map.put("magic4",ImageUtil.getImage(Constant.IMG_PRE + "addmagic4" + Constant.IMG_AFTER));
        map.put("addhp1",ImageUtil.getImage(Constant.IMG_PRE + "addHP1" + Constant.IMG_AFTER));
        map.put("addhp2",ImageUtil.getImage(Constant.IMG_PRE + "addHP2" + Constant.IMG_AFTER));
        map.put("addhp3",ImageUtil.getImage(Constant.IMG_PRE + "addHP3" + Constant.IMG_AFTER));
        map.put("addhp4",ImageUtil.getImage(Constant.IMG_PRE + "addHP4" + Constant.IMG_AFTER));
        map.put("hudun",ImageUtil.getImage(Constant.IMG_PRE + "hudun1" + Constant.IMG_AFTER));
        map.put("defense1",ImageUtil.getImage(Constant.IMG_PRE + "adddefense1" + Constant.IMG_AFTER));
        map.put("defense2",ImageUtil.getImage(Constant.IMG_PRE + "adddefense2" + Constant.IMG_AFTER));
        map.put("defense3",ImageUtil.getImage(Constant.IMG_PRE + "adddefense3" + Constant.IMG_AFTER));
        map.put("defense4",ImageUtil.getImage(Constant.IMG_PRE + "adddefense4" + Constant.IMG_AFTER));
        //分数图片
        map.put("score1",ImageUtil.getImage("com/ly/img/Score/score1.png"));
        map.put("score2",ImageUtil.getImage("com/ly/img/Score/score2.png"));
        map.put("score3",ImageUtil.getImage("com/ly/img/Score/score3.png"));
        map.put("0",ImageUtil.getImage("com/ly/img/Score/0.png"));
        map.put("1",ImageUtil.getImage("com/ly/img/Score/1.png"));
        map.put("2",ImageUtil.getImage("com/ly/img/Score/2.png"));
        map.put("3",ImageUtil.getImage("com/ly/img/Score/3.png"));
        map.put("4",ImageUtil.getImage("com/ly/img/Score/4.png"));
        map.put("5",ImageUtil.getImage("com/ly/img/Score/5.png"));
        map.put("6",ImageUtil.getImage("com/ly/img/Score/6.png"));
        map.put("7",ImageUtil.getImage("com/ly/img/Score/7.png"));
        map.put("8",ImageUtil.getImage("com/ly/img/Score/8.png"));
        map.put("9",ImageUtil.getImage("com/ly/img/Score/9.png"));







    }


    public static Image get(String key){
        return map.get(key);
    }
}
