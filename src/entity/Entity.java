package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    protected GamePanel gp;
    public int worldX, worldY;
    public int speed;

    public BufferedImage left, left2, right, right2, up, up2, down, down2;
    public String direction;
    public int spriteCounter =0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public int maxLife = 0;
    public int life = 0;

    public Entity(GamePanel gp) {
        this.gp= gp;
    }
}
