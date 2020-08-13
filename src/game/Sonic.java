package game;

import actions.Action;
import actions.SonicStanding;

import java.awt.*;

public class Sonic extends GameObject {

    public static final String SONIC_DEFAULT_IMAGE = GameConstants.SONIC_SPRITES_DIR+"\\standing\\0.png";
    public static final Point INITIAL_LOCATION = new Point(200, 200);
    public static final Dimension SONIC_DIMENSION = new Dimension(35, 46);

    public Sonic(double x, double y, int width, int height){
        super(x, y, width, height);
        imagePath = SONIC_DEFAULT_IMAGE;
        currentAction = null;
    }
    public Sonic(){
        super(INITIAL_LOCATION.x, INITIAL_LOCATION.y, SONIC_DIMENSION.width, SONIC_DIMENSION.height);
        imagePath = SONIC_DEFAULT_IMAGE;
        currentAction = null;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        graphics.drawImage(getImage(), (int)location.x, (int)location.y, dimension.width, dimension.height,null);
    }

    @Override
    public void eraseFromScreen() {
        this.imagePath = GameConstants.BLANK_IMAGE;
    }

}
