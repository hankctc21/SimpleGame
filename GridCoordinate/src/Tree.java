import javax.swing.ImageIcon;


public class Tree extends Sprite {

    public Tree(int x, int y) {
        super(x,y);
        image = new ImageIcon("src/tree.png");
        setLocation(x,y);
    }
}

