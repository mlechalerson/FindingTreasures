package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Coin extends SuperObject{
    public OBJ_Coin(){
        name = "Coin";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Coin.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        collision = true;
    }
}
