package game.entities.mushrooms;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GoodMushroom extends Walker implements StepListener {

    private int sensorContacts;

    /**

     A constant integer value representing the speed of movement for the mushroom
     The value is set to 4
     */
    private final int SPEED = 4;

    private float left, right;

    /**

     A final integer variable that stores the range of the patrol the mushroom does
     */
    private final int RANGE = 6;
    private static final BodyImage image =
            new BodyImage("data/mushroomgood.png", 3f);

    public int getSensorContacts() {
        return sensorContacts;
    }

    public void setSensorContacts(int sensorContacts) {
        this.sensorContacts = sensorContacts;
    }

    public GoodMushroom(World world, Shape mushroomGood){
        super(world, mushroomGood);
        addImage(image);
        world.addStepListener(this);
        startWalking(SPEED);
        Shape shape = new PolygonShape(-1.01f,1.1f, 1.01f,1.13f, 0.99f,-0.86f, -1.08f,-0.89f);
        Sensor sensor = new Sensor(this, shape);

        this.addCollisionListener(new GoodMushroomCollisionDetector(this));

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





}