package game;


import city.cs.engine.*;
import game.character.Character;
import game.items.Coin;
import org.jbox2d.common.Vec2;


public class GameWorld extends World {

    private Character character;
    public GameWorld() {
        super();




        //1. make an empty game world
        World world = new World();

        // make the ground
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -100));

        // make a suspended platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -4f));

        // make the character
       Shape characterShape = new BoxShape(1, 2);
        character = new Character(this, characterShape);
        character.setPosition(new Vec2(7, -100));
        character.setCredits(15);
        float coinRadius = 0.75f;
        Shape coinShape = new CircleShape(coinRadius);

        Coin coin = new Coin(this,coinShape,character,5,-2,coinRadius);



        // start our game world simulation!
        world.start();

    }

    public Character getCharacter(){
        return character;
    }
}
