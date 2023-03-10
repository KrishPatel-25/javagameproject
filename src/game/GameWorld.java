package game;


import city.cs.engine.*;
import game.character.Character;
import game.enemies.Goomba;
import game.items.Coin;
import org.jbox2d.common.Vec2;


public class GameWorld extends World {

    private Character character;
    public GameWorld() {
        super();




        //1. make an empty game world
        World world = new World();

        // make the ground
        Shape shape = new BoxShape(1000, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, 19.75f));
        ground.addImage(new BodyImage("data/transparent.png"));



//        ground.addImage(new BodyImage("data/ground.png"));

        // make a suspended platform
        Shape platformShape = new BoxShape(5, 1);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(30, 30f));
        platform1.addImage(new BodyImage("data/platformtexture.jpg", 2));

        Shape wall1 = new BoxShape(22, 200);
        StaticBody platform2 = new StaticBody(this, wall1);
        platform2.setPosition(new Vec2(-22, 10));
//        platform2.addImage(new BodyImage("data/noentry.gif"));

        Shape tunnel = new BoxShape(2.5f, 2.5f);
        StaticBody platform3 = new StaticBody(this, tunnel);
        platform3.setPosition(new Vec2(35, 20));
        platform3.addImage(new BodyImage("data/tunnel.png", 5));





        // make the character
       Shape characterShape = new BoxShape(1, 2);
        character = new Character(this, characterShape);
        character.setPosition(new Vec2(5, 25));
        character.setCoins(0);

        //make goomba

        Shape goombaShape = new BoxShape(1,1f);
        Goomba goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(25,25));


        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(45,25));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(65,25));



        //make coin
        float coinRadius = 0.75f;
        Shape coinShape = new CircleShape(coinRadius);
        Coin coin = new Coin(this,coinShape,character,20,28,coinRadius);



        // start our game world simulation!
        world.start();

    }

    public Character getCharacter(){
        return character;
    }
}
