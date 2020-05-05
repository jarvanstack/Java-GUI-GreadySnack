package Java学习.拓展GUI.Swing.贪吃蛇.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * 游戏的面板
 * //绘制面板，游戏中所有的东西都可用这个东西来画
 */
public class GamePanel extends JPanel implements ActionListener {
    /**
     * 一、定义数据：
     */

    int length;
    int[] snakeX = new int[600];//定义snake的x坐标
    int[] snakeY = new int[600];//定义蛇的Y坐标
    String direction;//方向
    boolean isStart;//暂停效果
    //定时器 100ms
    Timer timmer = new Timer(100, this);
    //食物的坐标
    int foodX;
    int foodY;
    /*
    问题：有2个 ，random 使用 util 包下的Random
     */
    Random random = new Random();
    boolean isFail = false; //判断死亡
    int score;//累计分数

    /**
     * 构造方法.
     * 三、事件监听和键盘监听
     * 的键盘监听.
     */
    public GamePanel() {
        init();//构造器里面调用init（）方法。
        //给Panel添加键盘监听=====================问题，添加失败，试试 设置是否获取焦点
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                System.out.println(e.getKeyChar());
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isStart = !isStart;//暂停效果，取反
                    if (isFail) {
                        isFail = false;
                    }
                    repaint();//刷新
                }
                //小蛇头的图片的转化
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    direction = "up";
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    direction = "down";
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    direction = "left";
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    direction = "right";
                }


            }
        });
        //给panel 添加定时器,
        /*
        新建一个线程，然后让他在while里循环，通过Thread.sleep(100)的方法来休眠线程。

         */
        timmer.start();//游戏一开始定时器就启动


    }

    //初始化数据
    public void init() {
        length = 3;
        snakeX[0] = 100;
        snakeY[0] = 100;//第一个头header的坐标
        snakeX[1] = 75;
        snakeY[1] = 100;//第2 body的坐标
        snakeX[2] = 50;
        snakeY[2] = 100;//第3 body的坐标
        direction = "right";
        isStart = false;
        foodX = 25 + random.nextInt(34) * 25;
        foodY = 75 + random.nextInt(24) * 25;


    }

    /**
     * 二、绘制图形
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {

        Data.header.paintIcon(this, g, 25, 11);//广告栏
        g.fillRect(25, 75, 850, 600);//矩形面板。
        this.setVisible(true);
        this.setBackground(new Color(139, 168, 20));

        //小蛇的头图片转化
        if (direction == "right") {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction == "left") {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction == "up") {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction == "down") {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        //把小蛇body画上去,使用的组件，画笔，x,y 位置。
        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }
        if (isStart == false) {
            g.setColor(new Color(255, 255, 255));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 300, 300);

        }
        //把食物画上去
        Data.food.paintIcon(this, g, foodX, foodY);
        //把 isFail的面板画上去,并得出分数
        if (isFail) {
            g.setColor(new Color(195, 68, 106));
            g.setFont(new Font("微软雅黑", Font.BOLD, 80));
            g.drawString("GAME OVER ", 200, 180);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("YOUR SCORE IS: " + score, 260, 400);
        }
        //把积分画上去
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 18));
        g.drawString("SCORE:" + score, 750, 35);
        g.drawString("LENGTH:" + length, 750, 50);

    }

    /**
     * 三、添加事件监听或者键盘监听：
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart) {
            //小蛇body移动到靠头的一个body
            //小蛇右移动--2，3重叠为什么？
//            for (int i = 1; i <= length; i++) {
//                middle = snakeX[i - 1];
//                snakeX[i] = middle;
//            }

            //身体跟进
            for (int i = length - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            //头的移动
            if (direction == "right") {
                snakeX[0] += 25;
                snakeY[0] += 0;
                if (snakeX[0] > 850) {
                    snakeX[0] = 25;
                }
            } else if (direction == "left") {
                snakeX[0] -= 25;
                snakeY[0] += 0;
                if (snakeX[0] <= 25) {
                    snakeX[0] = 850;
                }
            } else if (direction == "up") {
                snakeX[0] += 0;
                snakeY[0] -= 25;
                if (snakeY[0] <= 50) {
                    snakeY[0] = 650;
                }
            } else if (direction == "down") {
                snakeX[0] += 0;
                snakeY[0] += 25;
                if (snakeY[0] >= 650) {
                    snakeY[0] = 50;
                }
            }
            //吃食物
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                length++;//长度+1
                score = length * 10 - 30;//分数改变
                //初始化 食物坐标
                foodX = 25 + random.nextInt(34) * 25;
                foodY = 75 + random.nextInt(24) * 25;
            }
            //判断是否isFail死亡
            for (int i = 1; i < length; i++) {
                if (snakeX[i] == snakeX[0] && snakeY[i] == snakeY[0]) {
                    isFail = true;
                    isStart = false;
                }
            }

            repaint();//repaint()


        }
        //定时器开始
        timmer.start();
    }
}
