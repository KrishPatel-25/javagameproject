package game.entities.goomba;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;

/**
 * @author      Krish, Patel, Krish.Patel.2@city.ac.uk
 * @version     v1
 * @since       v1
 *
 *  Goomba Class is the main class for the enemy Goomba, which includes the speed of goomba, how far he patrols and his hitbox
 *
 */


public class Goomba extends Walker implements StepListener{

    private int sensorContacts;
    private final int SPEED = 4;

    private float left, right;
    private final int RANGE = 6;

    private Timer collisionTimer;
    private static final BodyImage image =
            new BodyImage("data/goomba right.png", 2f);


    public int getSensorContacts() {
        return sensorContacts;
    }

    public void setSensorContacts(int sensorContacts) {
        this.sensorContacts = sensorContacts;
    }


    public Goomba(World world, Shape goomba) {
        super(world, goomba);
        addImage(image);
        world.addStepListener(this);
        startWalking(SPEED);
        Shape shape = new PolygonShape(-0.868f,1.1f, -0.872f,0.7f, 0.84f,0.7f, 0.844f,1.1f);
        Sensor sensor = new Sensor(this, shape);
        sensor.addSensorListener(new GoombaSensorListener(this));
        collisionTimer = new Timer();
        this.addCollisionListener(new GoombaCollisionDetector(this));

    }

    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x - RANGE;
        right = position.x + RANGE;

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right){
            startWalking(-SPEED);
        }
        if (getPosition().x < left){
            startWalking(SPEED);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }

    public Timer getCollisionTimer() {
        return collisionTimer;
    }
}
