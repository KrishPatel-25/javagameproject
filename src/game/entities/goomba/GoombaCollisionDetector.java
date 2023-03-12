package game.entities.goomba;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.character.Character;

public class GoombaCollisionDetector implements CollisionListener {

    @Override
    public void collide(CollisionEvent collisionEvent) {
        Body body = collisionEvent.getOtherBody();
        if (body instanceof Character character && goomba.getCollisionTimer().getMilliseconds() >= 1000) {
            {
                character.setLives(character.getLives()-1);
                goomba.destroy();


            }

        }
    }

    private final Goomba goomba;

    public GoombaCollisionDetector(Goomba goomba) {
        this.goomba = goomba;
    }

}


