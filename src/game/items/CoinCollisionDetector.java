package game.items;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.character.Character;
import game.items.Coin;



public class CoinCollisionDetector implements CollisionListener{





    @Override
    public void collide(CollisionEvent collisionEvent) {


        Body body = collisionEvent.getOtherBody();
        if (body instanceof Character) {
//            character.setCoins(character.getCoins()+1);
            Character.coins++;
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

