import javax.swing.ImageIcon;


public class Arrow extends Sprite {

    public Arrow(int x, int y) {
        super(x,y);
        image = new ImageIcon("src/arrow.png");
        setLocation(x,y);
    }

}
