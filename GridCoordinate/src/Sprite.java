import java.awt.*;

import javax.swing.ImageIcon;

public abstract class Sprite {
    private Point absolutePosition;
    private Point relativePosition;
    protected ImageIcon image;
    private static final int hop = 50;

    public Sprite(int x, int y) {
        relativePosition = new Point();
        absolutePosition = new Point();

        setLocation(x,y);
    }

    public boolean overlaps(Sprite other) {
    	Point p1 = getLocation();
    	Point p2 = other.getLocation();
    	if (p1.equals(p2)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public void setLocation(int x, int y) {
        relativePosition = new Point(x, y);
        absolutePosition = new Point(x * hop, y * hop);
    }

    public void setLocation(Point v) {
        if(v == null) {
            relativePosition = null;
            absolutePosition = null;
        } else {
            relativePosition = new Point(v.x, v.y);
            absolutePosition = new Point(v.x * hop, v.y * hop);
        }
    }

    public void draw(Graphics g) {
        	  if (absolutePosition != null && image != null) {
                  image.paintIcon(null, g, absolutePosition.x, absolutePosition.y);
        }
    }

    public Point getLocation() {
        return relativePosition;
    }
}
