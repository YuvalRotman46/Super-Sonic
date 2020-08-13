package actions;

import game.GameConstants;
import game.Sonic;

public class SonicStanding extends Action implements Animatable{

    Sonic sonic;
    int spriteNum;

    public static final int NANO_SEC_DELAY = 150;
    public static final int SPRITES_NUMBER = 4;
    private static final String STANDING_DIR = "\\standing";

    public SonicStanding(Sonic sonic){
        super();
        this.sonic = sonic;
        spriteNum = 0;
    }

    @Override
    public void execute() {

        long lastTime = System.currentTimeMillis();
        while (isActive){
            if (lastTime+NANO_SEC_DELAY <= System.currentTimeMillis()){
                promoteAnimation();
                lastTime = System.currentTimeMillis();
            }
        }

        System.out.println("stop");

    }

    @Override
    public String getActionName() {
        return "Sonic Standing";
    }

    @Override
    public void promoteAnimation() {
        if(spriteNum == SPRITES_NUMBER-1){
            spriteNum = 0;
        }else{
            spriteNum++;
        }
        sonic.imagePath = GameConstants.SONIC_SPRITES_DIR+STANDING_DIR+"/"+spriteNum+".png";
    }
}
