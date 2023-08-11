import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Caricatore_Immagini {
    BufferedImage image;
    public BufferedImage carica_immagini(String percorso){
        try {
            image= ImageIO.read(getClass().getResource(percorso));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return image;
    }
}
