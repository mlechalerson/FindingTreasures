package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public int speed;

    public BufferedImage left, left2, right, right2;
    public String direction;
    public Rectangle solidArea;
    public boolean collisionOn = false;
}
