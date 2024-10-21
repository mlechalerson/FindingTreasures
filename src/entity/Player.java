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

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
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
            y -= speed;

        }
        else if (keyH.downPressed){
            y += speed;
        }
        else if (keyH.leftPressed){
            direction = "left";
            x -= speed;

        }
        else if (keyH.rightPressed){
            direction = "right";
            x += speed;
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
        g2.drawImage(image, x, y, gp.TileSize, gp.TileSize, null);
    }
}
