package Java学习.拓展GUI.Swing.贪吃蛇.src;

import javax.swing.*;

//数据中心，图片
public class Data {
    //此处用来初始话图片
    public static String headerUrl = "D:/Program Files/JetBrains/test1/Lab/src/Java学习/拓展GUI/Swing/贪吃蛇/resource/img/header.png";
    public static String bodyUrl = "D:/Program Files/JetBrains/test1/Lab/src/Java学习/拓展GUI/Swing/贪吃蛇/resource/img/body.png";
    public static String downUrl = "D:/Program Files/JetBrains/test1/Lab/src/Java学习/拓展GUI/Swing/贪吃蛇/resource/img/down.png";
    public static String foodUrl = "D:/Program Files/JetBrains/test1/Lab/src/Java学习/拓展GUI/Swing/贪吃蛇/resource/img/food.png";
    public static String leftUrl = "D:/Program Files/JetBrains/test1/Lab/src/Java学习/拓展GUI/Swing/贪吃蛇/resource/img/left.png";
    public static String rightUrl = "D:/Program Files/JetBrains/test1/Lab/src/Java学习/拓展GUI/Swing/贪吃蛇/resource/img/right.png";
    public static String upUrl = "D:/Program Files/JetBrains/test1/Lab/src/Java学习/拓展GUI/Swing/贪吃蛇/resource/img/up.png";
    public static ImageIcon up = new ImageIcon(upUrl);
    public static ImageIcon down = new ImageIcon(downUrl);
    public static ImageIcon left = new ImageIcon(leftUrl);
    public static ImageIcon right = new ImageIcon(rightUrl);
    public static ImageIcon header = new ImageIcon(headerUrl);
    public static ImageIcon body = new ImageIcon(bodyUrl);
    public static ImageIcon food = new ImageIcon(foodUrl);


    public Data(long l) {

    }
}
