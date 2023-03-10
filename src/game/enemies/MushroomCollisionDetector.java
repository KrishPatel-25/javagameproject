package game.enemies;
import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.character.Character;

import java.io.ObjectInputStream;

public class MushroomCollisionDetector implements CollisionListener {

    @Override
    public void collide(CollisionEvent collisionEvent) {
        Body body = collisionEvent.getOtherBody();
        if (body instanceof Character) {

            {

                ((Character) body).jumpingSpeed = 18;
                mushroom.destroy();



            }

        }
    }

    private Mushroom mushroom;

    public MushroomCollisionDetector(Mushroom mushroom) {
        this.mushroom = mushroom;
    }

}