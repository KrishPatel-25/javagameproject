package game.enemies;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.character.Character;

import java.io.ObjectInputStream;

public class GoombaCollisionDetector implements CollisionListener {

    @Override
    public void collide(CollisionEvent collisionEvent) {
        Body body = collisionEvent.getOtherBody();
        if (body instanceof Character) {
            {
                Character.lives--;

                goomba.destroy();


            }

        }
    }

    private Goomba goomba;

    public GoombaCollisionDetector(Goomba goomba) {
        this.goomba = goomba;
    }

}


