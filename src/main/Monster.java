package main;

import entity.Entity;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Monster extends Entity {
    String name;
    int damageAmount = 1;

    public Monster(GamePanel gp) {
        super(gp);
        this.gp = gp;

        name = "Garnuch";
        speed = 10;
        maxLife = 1;
        life = maxLife;

        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getMonsterImage();
    }

    public void getMonsterImage() {
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/monster/monster-up.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/monster/monster-up2.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/monster/monster-down.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/monster/monster-down2.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/monster/monster-left.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/monster/monster-left2.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/monster/monster-right.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/monster/monster-right2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        // Wybór kierunku ruchu
        int xDistance = gp.player.worldX - worldX;
        int yDistance = gp.player.worldY - worldY;
        // Priorytetowy ruch w kierunku gracza
        if (Math.abs(xDistance) > Math.abs(yDistance)) {
            // Poruszaj się w poziomie
            if (xDistance > 0) {
                direction = "right";
            } else {
                direction = "left";
            }
        } else {
            // Poruszaj się w pionie
            if (yDistance > 0) {
                direction = "down";
            } else {
                direction = "up";
            }
        }

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);

        // Poruszanie się, jeśli nie ma kolizji
        if (!collisionOn) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }
        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        int monsterIndex = gp.cChecker.checkObject(this, false);
        contactPlayer(monsterIndex);
    }

    public void contactPlayer(int index) {
        Rectangle monsterSolidArea = new Rectangle(worldX + solidArea.x, worldY + solidArea.y,
                solidArea.width, solidArea.height);
        Rectangle playerSolidArea = new Rectangle(gp.player.worldX + gp.player.solidArea.x,
                gp.player.worldY + gp.player.solidArea.y,
                gp.player.solidArea.width, gp.player.solidArea.height);

        if (monsterSolidArea.intersects(playerSolidArea)) {
            // Gracz traci pół serca (zakładając, że życie jest całkowitoliczbowe)
            gp.player.life -= 0.5;
            System.out.println("Monster attacked! Player life: " + gp.player.life);
    }}
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = spriteNum == 1 ? up : up2;
                break;
            case "down":
                image = spriteNum == 1 ? down: down2;
                break;
            case "left":
                image = spriteNum == 1 ? left : left2;
                break;
            case "right":
                image = spriteNum == 1 ? right : right2;
                break;
        }

        g2.drawImage(image, worldX, worldY, gp.TileSize, gp.TileSize, null);
    }
}

