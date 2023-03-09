package game;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.character.Character;
import game.items.Coin;

public class CoinCollisionDetector implements CollisionListener{


    @Override
    public void collide(CollisionEvent collisionEvent) {

        Body body = collisionEvent.getOtherBody();
        if (body instanceof Character) {
            character.setCredits(character.getCredits()+1);
            coin.destroy();
        }

    }

    private Coin coin;
    private Character character;

    public CoinCollisionDetector(Coin coin, Character character) {
        this.coin = coin;
        this.character = character;

    }

}
