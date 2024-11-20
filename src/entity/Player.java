package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey =0;

    int counter2 =0;

    public Player(GamePanel gp, KeyHandler keyH, int dfbdfg) {
        screenX = gp.screenWidth/2 - (gp.TileSize/2);
        screenY = gp.screenHeight/2 - (gp.TileSize/2);
    }
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.TileSize/2);
        screenY = gp.screenHeight/2 - (gp.TileSize/2);

        solidArea = new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
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
            up = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/Bomba-up.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/Bomba-up-2.png")));
            down = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/Bomba-down.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/Bomba-down-2.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if (keyH.upPressed == true){
                direction = "up";
            } else if (keyH.downPressed == true){
                direction = "down";
        }
        else if (keyH.leftPressed == true){
            direction = "left";


        }
        else if (keyH.rightPressed == true){
            direction = "right";

        }

        spriteCounter++;
        if (spriteCounter > 12){
            if (spriteNum == 1){
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter =0;
        }
        //CHECK TILE COLLISION
        collisionOn = false;
        gp.cChecker.checkTile(this);

        // CHECK OBJECT COLLISION
         int objIndex = gp.cChecker.checkObject(this, true);
         pickUpObject(objIndex);

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
    public void pickUpObject(int i){
        if (i != 999) {
            String objectName = gp.obj[i].name;

            switch(objectName){
                case "Chest":
                    if (hasKey > 0){
                        gp.obj[i] = null;
                        hasKey--;
                    }
                    break;
                case "Key":
                    hasKey++;
                    gp.obj[i] = null;
                    break;
                case "Shovel":
                    gp.obj[i] = null;
                    break;
            }
        }
    }
    public void draw(Graphics g2){
//        g2.setColor(Color.white);
//
//        g2.fillRect(x, y, gp.TileSize, gp.TileSize);
        BufferedImage image = null;
        switch(direction){
            case "up":
                if (spriteNum == 1){


                image = up;}
                if (spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1){
                image = down;}
                if (spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1){
                image = left;}
                if (spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1){
                image = right;}
                if (spriteNum == 2){
                    image = right2;
                }
                break;

        }
        g2.drawImage(image, screenX, screenY, gp.TileSize, gp.TileSize, null);
    }
}
