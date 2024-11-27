package main;

import entity.Entity;

import javax.xml.namespace.QName;

public class Monster extends Entity {

    public Monster(GamePanel gp) {
        super(gp);

        name = "Garnuch";
        speed = 1;
        maxLife = 1;
        life = maxLife;
    }
}
