package com.ly.core;

import com.ly.constant.Constant;
import com.ly.entity.*;
import com.ly.until.DataStore;
import com.ly.until.ImageMap;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyFrame extends Frame {

    public boolean gameOver = true;
    public boolean gameStart = false;
    public boolean addEnemyPlane = true;//是否添加敌方飞机，用于Boss出场
    private BackGround backGround = new BackGround();
    public final Plane myPlane = new Plane();
    public final List<Bullet> bulletList = new CopyOnWriteArrayList<>();
    public final List<EnemyPlane> enemyPlaneList = new CopyOnWriteArrayList<>();
    public final List<EnemyBullet> enemyBulletList = new CopyOnWriteArrayList<>();
    public final List<BigBang> bigBangList = new CopyOnWriteArrayList<>();
    public final List<Item> itemList = new CopyOnWriteArrayList<>();
    public Boss boss = new Boss();
    private Score score = new Score();
    public Defense defense = new Defense();
    private boolean daojishi = true;
    private final Image[] successImages = {
            ImageMap.get("success"), ImageMap.get("w6")
    };

    //画倒计时方法的减速器
    int countdown = 0;
    private final Image[] countDowns = {
            ImageMap.get("countdown3"), ImageMap.get("countdown2"), ImageMap.get("countdown1"), ImageMap.get("go")
    };


    private void countDown(Graphics g) {
        g.drawImage(countDowns[countdown / 18], Constant.GAME_WIDTH / 2 - ImageMap.get("countdown3").getWidth(null) / 2,
                Constant.GAME_HEIGHT / 2 - ImageMap.get("countdown3").getHeight(null) / 2,
                ImageMap.get("countdown3").getWidth(null),
                ImageMap.get("countdown3").getHeight(null),
                null);
        countdown++;
        if (countdown >= 72) {
            daojishi = false;
        }
    }

    //打bossHit方法，用来画boss警告的减速器
    int i = 0;
    //success方法，画胜利通关的
    int j = 0;
    int k = 0;

    private void success(Graphics g) {
        //如果打死boss后继续游戏，则让背景移动，继续添加飞机，并且不画通关图
        /*BackGround.bgimg = ImageMap.get("bg2");
        BackGround.speed = 5;
        System.out.println(BackGround.speed);
        addEnemyPlane = true;*/
        //如果打死boss后通过，则背景不恢复移动，不添加飞机，画通关图
        if (k < 96) {
            g.drawImage(successImages[j++ / 16],
                    Constant.GAME_WIDTH / 2 - ImageMap.get("success").getWidth(null) / 2,
                    Constant.GAME_HEIGHT / 2 - ImageMap.get("success").getHeight(null) / 2,
                    ImageMap.get("success").getWidth(null),
                    ImageMap.get("success").getHeight(null),
                    null);
            if (j >= 32) {
                j = 0;
            }
            k++;
        } else {
            g.drawImage(successImages[0],
                    Constant.GAME_WIDTH / 2 - ImageMap.get("success").getWidth(null) / 2,
                    Constant.GAME_HEIGHT / 2 - ImageMap.get("success").getHeight(null) / 2,
                    ImageMap.get("success").getWidth(null),
                    ImageMap.get("success").getHeight(null),
                    null);
        }


    }


    private void bossHit(Graphics g) {

        if (Plane.mark > 5 && Boss.bosslive) {
            boss.draw(g);
            if (boss.getY() > 0 - Constant.GAME_HEIGHT) {
                BackGround.speed = 0;
                addEnemyPlane = false;
            }

            if (boss.getY() < -ImageMap.get("boss1").getHeight(null)) {
                g.drawImage(boss.wImages1[i / 5],
                        Constant.GAME_WIDTH / 2 - ImageMap.get("bosswarning").getWidth(null) / 2,
                        Constant.GAME_HEIGHT / 2 - ImageMap.get("bosswarning").getHeight(null) / 2,
                        ImageMap.get("bosswarning").getWidth(null),
                        ImageMap.get("bosswarning").getHeight(null),
                        null);

                i++;
                if (i >= 10) {
                    i = 0;
                }
                /*g.drawImage(ImageMap.get("bosswarning"),
                        Constant.GAME_WIDTH/2 -ImageMap.get("bosswarning").getWidth(null)/2 ,
                        Constant.GAME_HEIGHT/2 - ImageMap.get("bosswarning").getHeight(null)/2,
                        ImageMap.get("bosswarning").getWidth(null),
                        ImageMap.get("bosswarning").getHeight(null),
                        null);*/
            }
        }
        //如果boss死了，置bosslive为空，并且boss指向null，使boss对象失去引用，而子弹和大招也不会碰到boss了，所以不会空指针了。
        if (!Boss.bosslive) {

            boss = null;
            success(g);
        }

    }

    private void gameover(Graphics g) {
        if (!gameStart && !gameOver) {
            backGround.draw(g);
            g.drawImage(ImageMap.get("gameover"),
                    Constant.GAME_WIDTH / 2 - ImageMap.get("gameover").getWidth(null) / 2,
                    Constant.GAME_HEIGHT / 2 - ImageMap.get("gameover").getHeight(null) / 2,
                    ImageMap.get("gameover").getWidth(null),
                    ImageMap.get("gameover").getHeight(null),
                    null);
        }
    }

    private void start(Graphics g) {
        if (!gameStart && gameOver) {
            backGround.draw(g);
            g.drawImage(ImageMap.get("start"),
                    Constant.GAME_WIDTH / 2 - ImageMap.get("start").getWidth(null) / 2,
                    Constant.GAME_HEIGHT / 2 - ImageMap.get("start").getHeight(null) / 2,
                    ImageMap.get("start").getWidth(null),
                    ImageMap.get("start").getHeight(null),
                    null);
        }

    }

    @Override
    public void paint(Graphics g) {
       /* if (checkPoint == 2) {
            backGround = new BackGround(0, 0, ImageMap.get("bg2"));
        }*/
        start(g);

        if (gameStart && !gameOver) {

            backGround.draw(g);
            if (daojishi) {
                countDown(g);
            } else {
                for (EnemyBullet enemyBullet : enemyBulletList) {
                    enemyBullet.draw(g);
                    enemyBullet.collision(myPlane);//敌方子弹撞我飞机判断

                }
                bossHit(g);//打boss
                if (myPlane.blood <= 0) {
                    gameOver = false;
                    gameStart = false;
                }

                if (addEnemyPlane) {
                    EnemyPlane.addEnemyPlane();
                }
                //画自己发的子弹
                for (Bullet bullet : bulletList) {
                    bullet.draw(g);
                    if (bullet.collision(enemyPlaneList)) {//我子弹撞敌方飞机判断
                        Plane.skill += 5;
                        if (Plane.skill >= 100) {
                            Plane.skill = 100;
                        }
                    }
                    if (boss.bosslive) {
                        bullet.collisionBoss(boss);//我子弹撞boss
                    }
                }

                //画敌方飞机

                for (EnemyPlane enemyPlane : enemyPlaneList) {
                    enemyPlane.draw(g);
                    enemyPlane.collision(myPlane);//敌机撞我方法
                }

                //画敌方飞机子弹



                //大招碰到飞机,boss
                for (BigBang bigBang : bigBangList) {
                    bigBang.draw(g);
                    bigBang.collision(enemyPlaneList);
                    if (boss.bosslive) {
                        bigBang.collisionBoss(boss);
                    }
                }


                //画爆炸
                for (Explode explode : Bullet.explodes) {
                    explode.draw(g);
                }

                //大招容器清空
                bigBangList.clear();


                myPlane.draw(g);
                //画装备
                for (Item item : itemList) {
                    item.draw(g);
                }

                g.setColor(Color.red);
            /*g.drawString("敌方飞机容量" + enemyPlaneList.size(), 10, 300);
            g.drawString("敌方子弹容量" + enemyBulletList.size(), 10, 320);
            g.drawString("我方子弹容量" + bulletList.size(), 10, 340);
            g.drawString("道具容量" + itemList.size(), 10, 360);
            g.drawString("boss血量" + Boss.blood, 10, 380);
            g.drawString("爆炸容量" + Bullet.explodes.size(), 10, 400);*/
                defense.draw(g);
                score.draw(g);
            }


        }

        //游戏结束继续游戏
        gameover(g);
    }


    /**
     * 加载窗口的方法
     */
    public void launchFrame() {
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//设置窗口大小
        this.setLocationRelativeTo(null);//设置窗口居中
        this.setTitle(Constant.GAME_TITLE);//设置窗口标题
        this.setResizable(false);//不允许更改窗口大小
        //可以关闭窗口

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.enableInputMethods(false);
        //匿名内部类 线程
        /*new Thread() {
            @Override
            public void run() {
                while (true) {
                    repaint();//无限调用paint方法
                    try {
                        Thread.sleep(35);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();*/
        GameThread gameThread = new GameThread();
        gameThread.start();
        //设置键盘监听器
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    myPlane.skill = 100;
                }
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    /*gameOver = true;
                    gameStart = false;*/
                    new GameThread().start();
                }
                myPlane.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                myPlane.keyReleased(e);
            }
        });

        //设置鼠标监听器
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //设置变量为可以调用start方法。游戏继续开始，自己的血量恢复
                gameStart = true;
                gameOver = false;
                myPlane.blood = 100;
            }
        });

        this.setVisible(true);//设置窗口显示,一定放在最后。
    }


    /**
     * 线程类(内部类)，启动画东西的线程
     */


    Image backImg = null;

    /**
     * 重写update方法，在底层添加一层白色的虚拟图片，用来避免图片闪烁
     *
     * @param g
     */
    @Override
    public void update(Graphics g) {
        if (backImg == null) {
            //虚拟图片不存在创建一个和窗口一样大的图片
            backImg = createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }

        Graphics backg = backImg.getGraphics();
        Color c = backg.getColor();
        backg.setColor(Color.white);
        backg.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//矩形填充
        backg.setColor(c);
        paint(backg);
        g.drawImage(backImg, 0, 0, null);
    }
}

class GameThread extends Thread {
    @Override
    public void run() {
        MyFrame myFrame = DataStore.get("myFrame");
        while (true) {
            myFrame.repaint();//无限调用paint方法
            try {
                Thread.sleep(35);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}