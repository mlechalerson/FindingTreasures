package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Shovel extends SuperObject{
    public OBJ_Shovel(){
        name = "Shovel";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Shovel.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        collision = true;
    }
}
