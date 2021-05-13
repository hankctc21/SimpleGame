import javax.swing.ImageIcon;


public class Bow extends Sprite {

    public Bow(int x, int y) {
        super(x,y);
        image = new ImageIcon("src/bow.png");
        setLocation(x,y);
    }

}
