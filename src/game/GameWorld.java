package game;


import city.cs.engine.*;
import game.character.Character;
import game.entities.koopa.Koopa;
import game.entities.mushrooms.GoodMushroom;
import game.entities.goomba.Goomba;
import game.entities.mushrooms.Mushroom;
import game.items.Coin;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.IOException;

import static game.GameSaverLoader.*;


public class GameWorld extends World {

    private static Character character;

    private SoundClip gameMusic;
    public static float x;
    public static float y;


    public GameWorld() {
        super();
        new GameTimer();


        // make an empty game world
        World world = new World();

        try {
            gameMusic = new SoundClip("data/backgroundMusic.wav");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }


        // make the character
        Shape characterShape = new BoxShape(1, 2);
        character = new Character(this, characterShape);

        if(GameSaverLoader.loadedGame){
            character.setPosition(new Vec2(loadedX,loadedY));
        }
        else{
            character.setPosition(new Vec2(5, 25));
        }



        // make the ground
        Shape shape = new BoxShape(500, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, 23.25f));
        ground.addImage(new BodyImage("data/transparent.png"));

        //make wall
        Platform wall = new Platform(22, 200, this);
        wall.getPlatform().setPosition(new Vec2(-22, 10));

        Platform wall2 = new Platform(22, 200, this);
        wall2.addImage(new BodyImage("data/transparent.png"));
        wall2.getPlatform().setPosition(new Vec2(300, 10));


        // make a suspended platform
        Platform platform1 = new Platform(5, 1, this);
        platform1.getPlatform().setPosition(new Vec2(30, 29.75f));
        platform1.getPlatform().addImage(new BodyImage("data/platformtexture.jpg", 2));


        Platform platform2 = new Platform(5, 1, this);
        platform2.getPlatform().setPosition(new Vec2(70, 32f));
        platform2.getPlatform().addImage(new BodyImage("data/platformtexture.jpg", 2));

        Platform platform3 = new Platform(5, 1, this);
        platform3.getPlatform().setPosition(new Vec2(120, 35f));
        platform3.getPlatform().addImage(new BodyImage("data/platformtexture.jpg", 2));

        Platform platform4 = new Platform(5, 1, this);
        platform4.getPlatform().setPosition(new Vec2(166, 33.5f));
        platform4.getPlatform().addImage(new BodyImage("data/platformtexture.jpg", 2));

        Platform platform5 = new Platform(5, 1, this);
        platform5.getPlatform().setPosition(new Vec2(156, 33.5f));
        platform5.getPlatform().addImage(new BodyImage("data/platformtexture.jpg", 2));

        Platform platform6 = new Platform(5, 1, this);
        platform6.getPlatform().setPosition(new Vec2(179, 40.5f));
        platform6.getPlatform().addImage(new BodyImage("data/platformtexture.jpg", 2));

        Platform platform7 = new Platform(5, 1, this);
        platform7.getPlatform().setPosition(new Vec2(181, 40.5f));
        platform7.getPlatform().addImage(new BodyImage("data/platformtexture.jpg", 2));

        Platform platform8 = new Platform(5, 1, this);
        platform8.getPlatform().setPosition(new Vec2(240, 40.5f));
        platform8.getPlatform().addImage(new BodyImage("data/platformtexture.jpg", 2));

        Platform platform9 = new Platform(5, 1, this);
        platform9.getPlatform().setPosition(new Vec2(255, 30));
        platform9.getPlatform().addImage(new BodyImage("data/platformtexture.jpg", 2));


        // make tunnel platform

        Shape tunnel = new BoxShape(2.5f, 2.5f);
        StaticBody platform100 = new StaticBody(this, tunnel);
        platform100.setPosition(new Vec2(55, 26.25f));
        platform100.addImage(new BodyImage("data/tunnel.png", 5));

        tunnel = new BoxShape(2.5f, 2.5f);
        StaticBody platform101 = new StaticBody(this, tunnel);
        platform101.setPosition(new Vec2(100, 26.25f));
        platform101.addImage(new BodyImage("data/tunnel.png", 5));

        tunnel = new BoxShape(2.5f, 2.5f);
        StaticBody platform102 = new StaticBody(this, tunnel);
        platform102.setPosition(new Vec2(135, 26.25f));
        platform102.addImage(new BodyImage("data/tunnel.png", 5));

        tunnel = new BoxShape(2.5f, 2.5f);
        StaticBody platform103 = new StaticBody(this, tunnel);
        platform103.setPosition(new Vec2(180, 26.25f));
        platform103.addImage(new BodyImage("data/tunnel.png", 5));

        tunnel = new BoxShape(2.5f, 2.5f);
        StaticBody platform104 = new StaticBody(this, tunnel);
        platform104.setPosition(new Vec2(230, 26.25f));
        platform104.addImage(new BodyImage("data/tunnel.png", 5));




//        character.setCoins(0);

//        make koopa

        Shape koopaShape = new BoxShape(1, 1f);
        Koopa koopa = new Koopa(this, koopaShape);
        koopa.setPosition(new Vec2(145, 25));

        koopaShape = new BoxShape(1, 1f);
        koopa = new Koopa(this, koopaShape);
        koopa.setPosition(new Vec2(188, 25));


        //make goomba

        Shape goombaShape = new BoxShape(1, 1f);
        Goomba goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(20, 25));


        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(45, 25));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(65, 25));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(155, 25));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(160, 25));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(165, 25));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(180, 42));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(192, 25));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(198, 25));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(204, 25));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(210, 25));

        goombaShape = new BoxShape(1, 1f);
        goomba = new Goomba(this, goombaShape);
        goomba.setPosition(new Vec2(216, 25));


        //make bad mushroom

        Shape mushroomShape = new BoxShape(1, 0.50f);
        Mushroom mushroom = new Mushroom(this, mushroomShape);
        mushroom.setPosition(new Vec2(80, 25));


        mushroomShape = new BoxShape(1, 0.50f);
        mushroom = new Mushroom(this, mushroomShape);
        mushroom.setPosition(new Vec2(110, 25));

        mushroomShape = new BoxShape(1, 0.50f);
        mushroom = new Mushroom(this, mushroomShape);
        mushroom.setPosition(new Vec2(118, 25));

        mushroomShape = new BoxShape(1, 0.50f);
        mushroom = new Mushroom(this, mushroomShape);
        mushroom.setPosition(new Vec2(170, 25));


        //make good mushroom

        Shape goodMushroomShape = new BoxShape(1, 0.50f);
        GoodMushroom goodMushroom = new GoodMushroom(this, goodMushroomShape);
        goodMushroom.setPosition(new Vec2(125, 25));

        goodMushroomShape = new BoxShape(1, 0.50f);
        goodMushroom = new GoodMushroom(this, goodMushroomShape);
        goodMushroom.setPosition(new Vec2(218, 25));


        //make coin
        float coinRadius = 0.75f;
        Shape coinShape = new CircleShape(coinRadius);
        Coin coin = new Coin(this, coinShape, character, 20, 28, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 30, 28, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 68, 35, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 72, 35, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 70, 28, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 28, 35, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 30, 38, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 32, 35, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 105, 35, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 120, 42, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 118, 38, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 122, 38, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 160, 28, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 165, 28, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 162.5f, 28, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 152, 37, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 154, 41, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 156, 45, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 158, 41, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 160, 37, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 162, 41, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 164, 45, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 166, 41, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 168, 37, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 179, 45, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 181, 45, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 181, 45, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 240, 45, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 247.5f, 40, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 252, 35, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 255, 35, coinRadius);

        coinRadius = 0.75f;
        coinShape = new CircleShape(coinRadius);
        coin = new Coin(this, coinShape, character, 258, 35, coinRadius);


        // start our game world simulation!
        world.start();

    }

    public Character getCharacter() {
        return character;
    }

    public static void getCharacterPosition() {
        Vec2 characterPosition = character.getPosition();
         x = characterPosition.x;
         y = characterPosition.y;
    }



}
