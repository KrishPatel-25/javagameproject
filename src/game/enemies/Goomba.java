package game.enemies;
import city.cs.engine.*;
import city.cs.engine.Shape;
import game.items.CoinCollisionDetector;

public class Goomba extends Walker{

    private int sensorContacts;


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
        Shape shape = new PolygonShape(-1.94f,-0.76f, 1.92f,-0.76f, 1.92f,1.97f, -1.94f,1.97f);
        Sensor sensor = new Sensor(this, shape);

        this.addCollisionListener(new GoombaCollisionDetector(this));



    }






    }
