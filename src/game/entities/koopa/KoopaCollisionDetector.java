package game.entities.koopa;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.character.Character;
import game.character.CharacterFacing;
import game.entities.goomba.Goomba;

public class KoopaCollisionDetector implements CollisionListener {

    private Koopa koopa;

    public KoopaCollisionDetector(Koopa koopa) {
        this.koopa = koopa;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        Body body = collisionEvent.getOtherBody();

        if (body instanceof Character character && !koopa.isInShell()) {
            character.setLives(character.getLives() - 1);
            return;

        }
        if (body instanceof Goomba goomba && koopa.isInShell()) {
            goomba.destroy();
            return;
        }
        if (body instanceof Character character && koopa.isInShell() && koopa.getCollisionTimer().getMilliseconds() < 2000) {
            koopa.startWalking(koopa.getSpeed() * 2);
            return;
        }
        koopa.setSpeed(-koopa.getSpeed());
        koopa.startWalking(koopa.getSpeed());
        koopa.setDirection(koopa.getDirection() == CharacterFacing.LEFT ? CharacterFacing.RIGHT : CharacterFacing.LEFT);


    }
}
