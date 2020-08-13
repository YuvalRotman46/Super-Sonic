package actions;

import game.GameConstants;
import game.Sonic;

public class SonicStarting extends Action implements Animatable {
    Sonic sonic;
    int spriteNum;

    public static final int NANO_SEC_DELAY = 150;
    public static final int SPRITES_NUMBER = 4;
    private static final String STARTING_DIR = "\\starting";

    public SonicStarting(Sonic sonic){
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

    }

    @Override
    public String getActionName() {
        return "Sonic Starting";
    }

    @Override
    public void promoteAnimation() {
        if(spriteNum == SPRITES_NUMBER-1){
            stop();
        }else{
            spriteNum++;
        }
        sonic.imagePath = GameConstants.SONIC_SPRITES_DIR+STARTING_DIR+"/"+spriteNum+".png";
    }
}
