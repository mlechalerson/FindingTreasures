package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 3;

    public final int TileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = maxScreenCol * TileSize;
    public final int screenHeight = maxScreenRow * TileSize;

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = maxWorldCol * TileSize;
    public final int worldHeight = maxWorldRow * TileSize;

    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this,keyH);

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInternal = (double) 1000000000 /FPS;
        double nextDrawTime = System.nanoTime() + drawInternal;


        while (gameThread !=null){

            update();

            repaint();



            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;


                if (remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInternal;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void update(){

        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);

        player.draw(g2);

        g2.dispose();

    }
}
