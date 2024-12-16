package main;

import object.OBJ_Coin;
import object.OBJ_Heart;
import object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Paused {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    BufferedImage coinImage, heart_full, heart_half, heart_empty;

    public Paused(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
            OBJ_Coin coin = new OBJ_Coin();
            coinImage = coin.image;

        SuperObject heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_empty = heart.image3;
    }


    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawImage(coinImage, gp.TileSize/2, gp.TileSize * 2, gp.TileSize/2, gp.TileSize /2 , null);
        g2.drawString("x " + gp.player.hasCoin, 55, 120);
        //System.out.println(gp.player.hasKey);

        //PLAY STATE
        if (gp.gameState == gp.playState){
            drawPlayerLife();
        }
        //PAUSE STATE
        if (gp.gameState == gp.pauseState){
            drawPauseScreen();
            drawPlayerLife();

        }
        //DIALOGUE STATE
        if (gp.gameState == gp.dialogueState){
            drawDialogueScreen();
        }
    }
    public void drawPlayerLife() {

        int x = gp.TileSize/2;
        int y = gp.TileSize/2;
        int i=0;
        while(i < gp.player.maxLife/2){
            g2.drawImage(heart_empty, x, y, null);
            i++;
            x += gp.TileSize/2;
        }
        //RESET
        x = gp.TileSize/2;
        y = gp.TileSize/2;
        i=0;

        //DRAW CURRENT LIFE
        while(i < gp.player.life){
            g2.drawImage(heart_half, x, y, null);
            i++;
            if (i < gp.player.life){
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x+=gp.TileSize/2;
        }

    }
    public void drawDialogueScreen(){
        //WINDOW
        int x = gp.TileSize * 2;
        int y = gp.TileSize /2;
        int width = gp.screenWidth - (gp.TileSize*4);
        int height = gp.TileSize*5;
        drawSubWindow(x, y, width, height);
    }
    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0);
        g2.setColor(Color.black);
        g2.fillRoundRect(x, y, width, height, 35, 35);


    }
    public void drawPauseScreen(){
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y= gp.screenHeight/2;

        g2.drawString(text, x, y);
    }
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }


}
