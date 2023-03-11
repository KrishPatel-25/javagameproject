package game.enemies;
import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.character.Character;

public class GoodMushroomCollisionDetector implements CollisionListener{

    @Override
    public void collide(CollisionEvent collisionEvent) {
        Body body = collisionEvent.getOtherBody();
        if (body instanceof Character character) {

            {

                goodMushroom.destroy();
                character.setJumpBoost(true);
                character.getBoostTimer().reset();






            }

        }
    }


    private GoodMushroom goodMushroom;

    public GoodMushroomCollisionDetector(GoodMushroom goodMushroom){
        this.goodMushroom = goodMushroom;
    }

}
