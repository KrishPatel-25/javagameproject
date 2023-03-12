package game.entities.koopa;

import city.cs.engine.*;
import game.character.CharacterFacing;
import org.jbox2d.common.Timer;

public class Koopa extends Walker implements StepListener {

    private Timer collisionTimer;

    private Timer nextImageTimer;

    private float speed = 5;
    private boolean isInShell;
    private int walkingCounter;

    private int shellCounter;
    private final int NUMBER_OF_WALKING_IMAGES = 8;

    private final int NUMBER_OF_SHELL_IMAGES = 6;

    private CharacterFacing direction;


    public Koopa(World world, Shape shape) {
        super(world, shape);
        this.startWalking(speed);
        world.addStepListener(this);
        Shape sensorShape = new PolygonShape(-0.436f,1.4f, -0.432f,0.8f, 0.68f,0.8f, 0.684f,1.4f);
        Sensor sensor = new Sensor(this,sensorShape);
        sensor.addSensorListener(new KoopaSensorListener(this));
        isInShell = false;
        walkingCounter = 0;
        this.addCollisionListener(new KoopaCollisionDetector(this));
        collisionTimer = new Timer();
        nextImageTimer = new Timer();
        direction = CharacterFacing.RIGHT;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

        if(!isInShell && nextImageTimer.getMilliseconds() > 100){
            int imageNumber = walkingCounter % NUMBER_OF_WALKING_IMAGES + 1;
            String facing = direction == CharacterFacing.RIGHT ? "R" : "L" ;
            this.removeAllImages();
            this.addImage(new BodyImage("data/"+facing + "koopa"+imageNumber+".png",2f));
            walkingCounter += 1;
            nextImageTimer.reset();
        }
        if(isInShell && nextImageTimer.getMilliseconds() > 200){
            int imageNumber = shellCounter % NUMBER_OF_SHELL_IMAGES + 1;
            this.removeAllImages();
            this.addImage(new BodyImage("data/shell"+imageNumber+".png",2f));
            shellCounter +=1;
            nextImageTimer.reset();
        }

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }

    public boolean isInShell() {
        return isInShell;
    }

    public void setInShell(boolean inShell) {
        isInShell = inShell;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Timer getCollisionTimer() {
        return collisionTimer;
    }

    public CharacterFacing getDirection() {
        return direction;
    }

    public void setDirection(CharacterFacing direction) {
        this.direction = direction;
    }
}



