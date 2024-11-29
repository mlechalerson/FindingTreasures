package main;

import java.awt.*;

public class eventHandler {

    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
    public eventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;

    }
    public void checkEvent(){
            if (hit(27,20,"right") == true){
                damagePit(gp.gameState);
            }
            if (hit(27,12,"up") == true){healingPool(gp.gameState);}
    }
    public boolean hit(int eventCol, int eventRow, String reqDriection) {
        boolean hit = false;
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol * gp.TileSize + eventRect.x;
        eventRect.y = eventRow * gp.TileSize + eventRect.y;


        if (gp.player.solidArea.intersects(eventRect)) {
            if (gp.player.direction.contentEquals(reqDriection) || reqDriection.equals("any")) {
                hit = true;
            }
        }


        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x= eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }

    public void damagePit(int gameState){
        gp.gameState = gameState;
        gp.player.life -= 1;
    }
    public void healingPool(int gameState){
        if (gp.keyH.enterPressed == true){
            gp.gameState = gameState;
            gp.paused.message = "Odnawiasz zdrowie";
            gp.player.life = gp.player.maxLife;
        }

    }
}
