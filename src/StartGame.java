    package Java学习.拓展GUI.Swing.贪吃蛇.src;

    import javax.swing.*;

    /**
     * 游戏的主要启动类:
     */
    public class StartGame {
        public StartGame() {
            //simple Frame
            JFrame frame = new JFrame("开始界面");
            frame.setBounds(100, 100, 900, 720);
            frame.setResizable(false);//窗口大小不能改变，不然游戏变形
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
            //一般的游戏都会放到面板上,
            frame.add(new GamePanel());
        }

        public static void main(String[] args) {
            new StartGame();
        }
    }
