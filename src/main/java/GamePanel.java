import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.*;


public class GamePanel extends JPanel implements Runnable {


    public static int width;
    public static int height;

    private Thread thread;
    private boolean running = false;

    private BufferedImage img;
    private Graphics2D g;

    private GameStateMenager gsm;


    public GamePanel(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    public  void addNotify() {
        super.addNotify();

        if (thread == null) {
            thread = new Thread(this, "HankaGameThread");
            thread.start();
        }
    }

    public void run() {
        init();
        final double GAME_HERTZ = 60.0;
        final double TBU = 1000000000/GAME_HERTZ;

        final  int MUBR =5;

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS=60;
        final  double TTBR = 1000000000 / TARGET_FPS;

        int frameCaunt = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        int oldFrameCount = 0;

        while (running){
            double now =System.nanoTime();
            int updateCount = 0;
            while(((now - lastUpdateTime) > TBU) && (updateCount <MUBR)) {
                update();
                input();
                lastUpdateTime += TBU;
                updateCount++;
            }
            if (now - lastUpdateTime > TBU) {
                lastUpdateTime = now - TBU;
            }
            input();
            render();
            draw();
            lastRenderTime = now;
            frameCaunt++;

            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime) {
                if (frameCaunt != oldFrameCount){
                    System.out.println("NEW SECOND " + thisSecond + "  " +frameCaunt);
                    oldFrameCount = frameCaunt;
                }
                frameCaunt = 0;
                lastSecondTime = thisSecond;
            }
            while (now - lastRenderTime < TTBR && now - lastUpdateTime < TBU) {
                Thread.yield();

                try {
                    Thread.sleep(1);
                }catch(Exception e){
                    System.out.println("ERROR: Yielding thread");
                }
                now = System.nanoTime();

            }
        }
    }
    private void input(){

    }

    private void update() {

    }
    public void render(){

    }
    public void draw(){

    }

    public void init() {
        running = true;

        img = new BufferedImage(width, height, TYPE_INT_ARGB);
        g= (Graphics2D) img.getGraphics();
    }
}


