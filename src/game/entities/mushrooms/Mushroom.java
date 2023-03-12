package game.entities.mushrooms;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Mushroom extends Walker implements StepListener {

    private int sensorContacts;
    private final int SPEED = 4;

    private float left, right;
    private final int RANGE = 6;
    private static final BodyImage image =
            new BodyImage("data/mushroombad.png", 3f);

    public int getSensorContacts() {
        return sensorContacts;
    }

    public void setSensorContacts(int sensorContacts) {
        this.sensorContacts = sensorContacts;
    }

    public Mushroom(World world, Shape mushroom) {
        super(world, mushroom);
        addImage(image);
        world.addStepListener(this);
        startWalking(SPEED);
        Shape shape = new PolygonShape(-1.01f,1.1f, 1.01f,1.13f, 0.99f,-0.86f, -1.08f,-0.89f);
        Sensor sensor = new Sensor(this, shape);

        this.addCollisionListener(new MushroomCollisionDetector(this));



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
