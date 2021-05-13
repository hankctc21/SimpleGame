import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;


public class Forest extends JPanel implements KeyListener {
//	private ArrayList<Tree> trees;
    private List<Tree> trees;
    private List<Sprite> sprites;
    private Nephi nephi;
    private Bow bow;
    private Arrow arrow;
    private Beast beast;
    private int numRows;
    private int numCols;
    public boolean hit;
    public static final int CELL_SIZE = 50;

    public Forest() {
        trees = new ArrayList<Tree>();
        sprites = new ArrayList<Sprite>();
        numRows = 7;
        numCols = 7;
        createTrees();
        nephi = new Nephi(3,5);
        bow = new Bow(1,2);
        arrow = new Arrow(4,5);
        beast = new Beast(4,4);
        hit = false;
        addKeyListener(this);

        	sprites.addAll(trees);
        	sprites.add(nephi);
        	sprites.add(beast);
        	sprites.add(bow);
        	sprites.add(arrow);


    }



    private void createTrees() {
        Tree tree1 = new Tree(1,1);
        Tree tree2 = new Tree(2,2);
        Tree tree3 = new Tree(3,3);
        Tree tree4 = new Tree(2,4);
        Tree tree5 = new Tree(1,5);
        Tree tree6 = new Tree(4,1);
        Tree tree7 = new Tree(5,2);
        Tree tree8 = new Tree(4,3);
        Tree tree9 = new Tree(3,4);
        Tree tree10 = new Tree(5,5);

        trees.add(tree1);
        trees.add(tree2);
        trees.add(tree3);
        trees.add(tree4);
        trees.add(tree5);
        trees.add(tree6);
        trees.add(tree7);
        trees.add(tree8);
        trees.add(tree9);
        trees.add(tree10);
    }

    private void shoot(int k) {
    	if(nephi.hasArrow() && nephi.hasBow()) {
    		hit = false;
        	if(k == KeyEvent.VK_N) {
	    		if(nephi.getLocation().getX() == beast.getLocation().getX()) {
	            	if(beast.getLocation().getY() < nephi.getLocation().getY()) {
	                	hit = true;
	                	System.out.println("hit is true1");
	                	JOptionPane.showMessageDialog(null, "Congrats! Nephi slayed the best!");
	            	}
	            	else {
	            		hit = false;
	                	System.out.println("hit is false1");
	                	JOptionPane.showMessageDialog(null, "Oops! Nephie missed the shot!");

	            	}

	            }
	    		else {
            		hit = false;
                	System.out.println("hit is false1");
                	JOptionPane.showMessageDialog(null, "Oops! Nephie missed the shot!");


            	}
    		}
        	else if(k == KeyEvent.VK_S){
        		if(nephi.getLocation().getX() == beast.getLocation().getX()) {
                	if(beast.getLocation().getY() > nephi.getLocation().getY()) {
                    	hit = true;
	                	System.out.println("hit is true2");
	                	JOptionPane.showMessageDialog(null, "Congrats! Nephi slayed the best!");

                	}
                	else {
                		hit = false;
                    	System.out.println("hit is false2");
	                	JOptionPane.showMessageDialog(null, "Oops! Nephie missed the shot!");


                	}

                }
        		else {
            		hit = false;
                	System.out.println("hit is false2");
                	JOptionPane.showMessageDialog(null, "Oops! Nephie missed the shot!");


            	}
        	}
        	else if(k == KeyEvent.VK_E){
        		 if(nephi.getLocation().getY() == beast.getLocation().getY()) {
                 	if(beast.getLocation().getX() > nephi.getLocation().getX()) {
                     	hit = true;
	                	System.out.println("hit is true3");
	                	JOptionPane.showMessageDialog(null, "Congrats! Nephi slayed the best!");

                 	}
                 	else {
                 		hit = false;
                     	System.out.println("hit is false3");
	                	JOptionPane.showMessageDialog(null, "Oops! Nephie missed the shot!");

                 	}

                 }
        		 else {
              		hit = false;
                 	System.out.println("hit is false3");
                	JOptionPane.showMessageDialog(null, "Oops! Nephie missed the shot!");


              	}
        	}
        	else if(k == KeyEvent.VK_W){
        		 if(nephi.getLocation().getY() == beast.getLocation().getY()) {
                 	if(beast.getLocation().getX() < nephi.getLocation().getX()) {
                     	hit = true;
	                	System.out.println("hit is true4");
	                	JOptionPane.showMessageDialog(null, "Congrats! Nephi slayed the best!");                	}
                 	else {
                  		hit = false;
                     	System.out.println("hit is false4");
	                	JOptionPane.showMessageDialog(null, "Oops! Nephie missed the shot!");


                  	}

                 }
        		 else {
              		hit = false;
                 	System.out.println("hit is false4");
                	JOptionPane.showMessageDialog(null, "Oops! Nephie missed the shot!");


              	}
        	}

    	}
    	else {
        	System.out.println("No A and B");
        	JOptionPane.showMessageDialog(null, "Nephi must have both the bow and before he can shoot anything.");

    	}

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0,500,500);
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, 50 * numCols, 50 * numRows);
//        for(int i = 0; i < trees.size(); i++) {
//            trees.get(i).draw(g);
//        }
        for(Sprite s : sprites) {
        	s.draw(g);
        }
//        nephi.draw(g);
//        bow.draw(g);
//        beast.draw(g);
//        arrow.draw(g);
        requestFocusInWindow();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setContentPane(new Forest());
        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Point nextPos = new Point(nephi.getLocation());
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if(nextPos.y - 1 >= 0 ) {
                nextPos.setLocation(nextPos.x, nextPos.y - 1);
            }
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(nextPos.y + 1 < numRows ) {
                nextPos.setLocation(nextPos.x, nextPos.y + 1);
            }
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(nextPos.x - 1 >= 0 ) {
                nextPos.setLocation(nextPos.x - 1, nextPos.y);
            }
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(nextPos.x + 1 <= numCols ) {
                nextPos.setLocation(nextPos.x + 1, nextPos.y);
            }
        }

        for(int i = 0; i < trees.size(); i++) {
            if(trees.get(i).getLocation().equals(nextPos)) {
                return;
            }
        }

        nephi.setLocation(nextPos);
        if(nephi.overlaps(bow)) {
        	nephi.pickUpBow();
        	bow.setLocation(null);

        }
        else if(nephi.overlaps(arrow)) {
        	nephi.pickUpArrow();
        	arrow.setLocation(null);
        }
        else {

        }

        if(e.getKeyCode() == KeyEvent.VK_N) {
        	shoot(e.getKeyCode());
        }

        if(e.getKeyCode() == KeyEvent.VK_S) {
        	shoot(e.getKeyCode());
        }

        if(e.getKeyCode() == KeyEvent.VK_E) {
        	shoot(e.getKeyCode());
        }

        if(e.getKeyCode() == KeyEvent.VK_W) {
        	shoot(e.getKeyCode());
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }
}
