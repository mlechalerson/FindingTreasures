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

    int counter2 =0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.TileSize/2);
        screenY = gp.screenHeight/2 - (gp.TileSize/2);

        solidArea = new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidArea.width=32;
        solidArea.height=32;

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
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/Bomba-left-2.png")));
            right = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/Bomba-right.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/Bomba-right-2.png")));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if (keyH.upPressed == true){
                direction = "left";
            } else if (keyH.downPressed == true){
                direction = "right";
        }
        else if (keyH.leftPressed == true){
            direction = "left";


        }
        else if (keyH.rightPressed == true){
            direction = "right";

        }
        //CHECK TILE COLLISION
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if (collisionOn == false){
            switch (direction){
                case "up": worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right": worldX += speed; break;
            }
        }}

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
