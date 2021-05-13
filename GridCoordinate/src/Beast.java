import javax.swing.ImageIcon;


public class Beast extends Sprite {

    public Beast(int x, int y) {
        super(x,y);
        image = new ImageIcon("src/beast.png");
        setLocation(x,y);
    }
}
