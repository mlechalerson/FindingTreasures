package main;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 3;
    // SCREEN SETTINGS
    public final int TileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = maxScreenCol * TileSize;
    public final int screenHeight = maxScreenRow * TileSize;
    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;


    int FPS = 60;

    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Paused paused = new Paused(this);
    public eventHandler eHandler = new eventHandler(this);

    //ENTITY AND OBJECT
    public Player player = new Player(this,keyH);
    public SuperObject[] obj = new SuperObject[10];

    //GAME STATE
    public int gameState;
    public final int playState =1;
    public final int pauseState =2;
    public final int dialogueState =3;
    public final int gameOverState =4;
    public Monster monster;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }


    public void setupGame(){

        aSetter.seObject();
        boolean monsterPlaced = false;
        Random random = new Random();

        for (int attempt = 0; attempt < 100 && !monsterPlaced; attempt++) {
            int row = random.nextInt(maxWorldRow);
            int col = random.nextInt(maxWorldCol);

            if (tileM.mapTileNum[col][row] == 0) {
                monster = new Monster(this);
                monster.worldX = col * TileSize;
                monster.worldY = row * TileSize;
                monsterPlaced = true;
            }
        }
        if (!monsterPlaced) {
            System.out.println("Could not find a sand tile to place monster!");
            monster = null;
        }

        gameState = playState;
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


        if (gameState == playState) {
            player.update();

            // Aktualizacja potwora
            if (monster != null) {
                monster.update();
            }

            // Sprawdzenie, czy gracz nie stracił wszystkich punktów życia
            if (player.life <= 0) {
                gameState = gameOverState; // Dodaj nowy stan gry
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(255, 0, 0, 0));
        Graphics2D g2 = (Graphics2D) g;
        if (gameState == gameOverState) {
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, screenWidth, screenHeight);
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 70));
            String text = "Game Over";
            FontMetrics fm = g2.getFontMetrics();
            int textWidth = fm.stringWidth(text);
            int textHeight = fm.getHeight();
            int x = (screenWidth - textWidth) / 2;
            int y = screenHeight / 2;

            g2.drawString(text, x, y);
        } else {
        //TILE
        tileM.draw(g2);

        //OBJECT
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }
        if (monster != null) {
            monster.draw(g2);
        }

        //PLAYER
        player.draw(g2);


        // UI
        paused.draw(g2);
        g2.dispose();

    }}
}
