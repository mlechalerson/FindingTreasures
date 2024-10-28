package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.TileSize/2);
        screenY = gp.screenHeight/2 - (gp.TileSize/2);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = gp.TileSize * 23;
        worldY = gp.TileSize * 21;
        speed = 4;
        direction = "right";
    }
    public void getPlayerImage(){
        try{
            left = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/Bomba-left.png")));
            right = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/Bomba-right.png")));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyH.upPressed){
            worldY -= speed;

        }
        else if (keyH.downPressed){
            worldY += speed;
        }
        else if (keyH.leftPressed){
            direction = "left";
            worldX -= speed;

        }
        else if (keyH.rightPressed){
            direction = "right";
            worldX += speed;
        }

    }
    public void draw(Graphics g2){
//        g2.setColor(Color.white);
//
//        g2.fillRect(x, y, gp.TileSize, gp.TileSize);
        BufferedImage image = null;
        switch(direction){
            case "left":
                image = left;
                break;
            case "right":
                image = right;
                break;

        }
        g2.drawImage(image, screenX, screenY, gp.TileSize, gp.TileSize, null);
    }
}
