import javax.swing.ImageIcon;


public class Nephi extends Sprite {
	private boolean hasBow; //when nephi has a bow
	private boolean hasArrow;
	private ImageIcon hasBowIcon;
	private ImageIcon hasArrowIcon;
	private ImageIcon hasBowAndArrowIcon;
	private ImageIcon regularIcon;



    public Nephi(int x, int y) {
        super(x,y);
        image = new ImageIcon("src/nephi.png");
        setLocation(x,y);
        //initializes hasBow and hasArrow to false
        hasBow = false;
        hasArrow = false;
        hasBowAndArrowIcon = new ImageIcon("src/nephi_bow_arrow.png");
        hasArrowIcon = new ImageIcon("src/nephi_arrow.png");
        hasBowIcon = new ImageIcon("src/nephi_bow.png");

    }
    public boolean hasArrow() {

        return hasArrow;
    }

    public boolean hasBow() {

    	return hasBow;

    }
    public void pickUpArrow() {
    	hasArrow = true;
    	if(hasArrow == true && hasBow == true) {
    		image = hasBowAndArrowIcon;
    }
    	else{image = hasArrowIcon;
    	}
    }
    public void pickUpBow() {
    	hasBow = true;
    	if(hasBow == true && hasArrow == true) {
    		image = hasBowAndArrowIcon;
    }
    	else{image = hasBowIcon;
    }
    }
}
	