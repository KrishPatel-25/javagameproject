package game.enemies;
import city.cs.engine.*;
import city.cs.engine.Shape;
import game.items.CoinCollisionDetector;
import org.jbox2d.common.Vec2;

public class Goomba extends Walker implements StepListener{

    private int sensorContacts;
    private final int SPEED = 4;

    private float left, right;
    private final int RANGE = 6;
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
        Shape shape = new PolygonShape(-1.94f,0.24f, 1.88f,0.22f, 1.88f,-1.93f, -1.94f,-1.94f);
        Sensor sensor = new Sensor(this, shape);

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




    }
