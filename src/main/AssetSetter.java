package main;

import object.OBJ_Chest;
import object.OBJ_Shovel;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void seObject(){
        gp.obj[0] = new OBJ_Chest();
        gp.obj[0].worldX = 23 * gp.TileSize;
        gp.obj[0].worldY = 7 * gp.TileSize;

        gp.obj[1] = new OBJ_Chest();
        gp.obj[1].worldX = 44 * gp.TileSize;
        gp.obj[1].worldY = 4 * gp.TileSize;

        gp.obj[2] = new OBJ_Chest();
        gp.obj[2].worldX = 3 * gp.TileSize;
        gp.obj[2].worldY = 44 * gp.TileSize;

        gp.obj[3] = new OBJ_Shovel();
        gp.obj[3].worldX = 35 * gp.TileSize;
        gp.obj[3].worldY = 20 * gp.TileSize;

        }
}
