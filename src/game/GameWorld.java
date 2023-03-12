package game;


import city.cs.engine.*;
import game.character.Character;
import game.entities.koopa.Koopa;
import game.entities.mushrooms.GoodMushroom;
import game.entities.goomba.Goomba;
import game.entities.mushrooms.Mushroom;
import game.items.Coin;
import org.jbox2d.common.Vec2;


public class GameWorld extends World {

    private Character character;
    public GameWorld() {
        super();




        //1. make an empty game world
        World world = new World();

        // make the ground
        Shape shape = new BoxShape(500, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, 23.25f));
        ground.addImage(new BodyImage("data/transparent.png"));

        //make wall
        Platform wall = new Platform(22, 200,this);
        wall.getPlatform().setPosition(new Vec2(-22, 10));
//        wall.addImage(new BodyImage("data/noentry.gif",40));




        // make a suspended platform
        Platform platform1 = new Platform(5,1,this);
        platform1.getPlatform().setPosition(new Vec2(30, 29.75f));
        platform1.getPlatform().addImage(new BodyImage("data/platformtexture.jpg", 2));


        Platform platform2 = new Platform(5,1,this);
        platform2.getPlatform().setPosition(new Vec2(70,32f));
        platform2.getPlatform().addImage(new BodyImage("data/platformtexture.jpg", 2));




        Shape tunnel = new BoxShape(2.5f, 2.5f);
        StaticBody platform3 = new StaticBody(this, tunnel);
        platform3.setPosition(new Vec2(55, 26.25f));
        platform3.addImage(new BodyImage("data/tunnel.png", 5));

        tunnel = new BoxShape(2.5f, 2.5f);
        platform3 = new StaticBody(this, tunnel);
        platform3.setPosition(new Vec2(100, 26.25f));
        platform3.addImage(new BodyImage("data/tunnel.png", 5));





        // make the character
       Shape characterShape = new BoxShape(1, 2);
        character = new Character(this, characterShape);
        character.setPosition(new Vec2(5, 25));
        character.setCoins(0);

        //make koopa

        Shape koopaShape = new BoxShape(1,1f);
        Koopa koopa = new Koopa(this,koopaShape);
        koopa.setPosition(new Vec2(10,25));


        //make goomba

        Shape goombaShape = new BoxShape(1,1f);
        Goomba goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(45,25));


//        goombaShape = new BoxShape(1, 1f);
//        goomba = new Goomba(this, goombaShape);
//        goomba.setPosition(new Vec2(45,25));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(65,25));


        //make bad mushroom

        Shape mushroomShape = new BoxShape(1,0.50f);
        Mushroom mushroom = new Mushroom(this,mushroomShape);
        mushroom.setPosition(new Vec2(110,25));


        mushroomShape = new BoxShape(1, 0.50f);
        mushroom = new Mushroom(this, mushroomShape);
        mushroom.setPosition(new Vec2(80,25));


        //make good mushroom

        Shape goodMushroomShape = new BoxShape(1,0.50f);
        GoodMushroom goodMushroom = new GoodMushroom(this,goodMushroomShape);
        goodMushroom.setPosition(new Vec2(130,25));

//        goodMushroomShape = new BoxShape(1, 0.50f);
//        goodMushroom = new GoodMushroom(this, goodMushroomShape);
//        goodMushroom.setPosition(new Vec2(10,25));



        //make coin
        float coinRadius = 0.75f;
        Shape coinShape = new CircleShape(coinRadius);
        Coin coin = new Coin(this,coinShape,character,20,28,coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 30, 28, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 68, 35 , coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 72, 35 , coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 70, 28 , coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 28, 35 , coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 30, 38 , coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 32, 35 , coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 105, 35 , coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 115, 35 , coinRadius);




        // start our game world simulation!
        world.start();

    }

    public Character getCharacter(){
        return character;
    }
}
