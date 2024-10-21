package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Bomba-sand.png")));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Bomba-sky.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(tile[1].image, 0, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 48, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 96, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 144, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 192, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 240, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 288, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 336, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 384, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 432, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 480, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 528, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 576, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 624, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 672, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 720, 0, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 0, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 48, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 96, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 144, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 192, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 240, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 288, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 336, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 384, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 432, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 480, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 528, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 576, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 624, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 672, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 720, 48, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 0, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 48, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 96, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 144, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 192, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 240, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 288, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 336, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 384, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 432, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 480, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 528, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 576, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 624, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 672, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 720, 96, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 0, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 48, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 96, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 144, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 192, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 240, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 288, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 336, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 384, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 432, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 480, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 528, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 576, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 624, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 672, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 720, 144, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 0, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 48, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 96, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 144, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 192, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 240, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 288, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 336, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 384, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 432, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 480, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 528, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 576, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 624, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 672, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[1].image, 720, 192, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 0, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 48, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 96, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 144, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 192, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 240, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 288, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 336, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 384, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 432, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 480, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 528, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 576, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 624, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 672, 240, gp.TileSize, gp.TileSize, null);
        g2.drawImage(tile[0].image, 720, 240, gp.TileSize, gp.TileSize, null);
    }

}
