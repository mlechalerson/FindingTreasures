package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Heart extends SuperObject{
    GamePanel gp;
    public OBJ_Heart(GamePanel gp) {
        this.gp = gp;


        name = "Heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Full-heart.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/Half-heart.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/Empty-heart.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        collision = true;
    }
}
