package game;

import actions.Action;

import javax.swing.*;
import java.awt.*;

public abstract class GameObject {
    public Point location;
    public Dimension dimension;
    public String imagePath;
    public Action currentAction;

    public GameObject(double x, double y, int width, int height){
        location = new Point(x, y);
        dimension = new Dimension(width, height);
    }

    public GameObject(GameObject other){
        location = new Point(other.location.x, other.location.y);
        dimension = new Dimension(other.dimension.width, other.dimension.height);
    }

    public void move(double dx, double dy){location.move(dx, dy);}

    public void loadNewAction(Action action){
        if(currentAction != null)
            currentAction.stop();
        currentAction = action;
        currentAction.start();
    }

    public abstract void draw(Graphics g);

    public abstract void eraseFromScreen();

    public Image getImage(){
        ImageIcon icon = new ImageIcon(this.getClass().getResource(this.imagePath));
        return icon.getImage();
    }
}
